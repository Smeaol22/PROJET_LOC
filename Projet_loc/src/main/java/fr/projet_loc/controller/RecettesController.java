package fr.projet_loc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.projet_loc.dao.RecettesRepository;
import fr.projet_loc.entity.Recettes;

@Controller
@RequestMapping("/Recettes")
public class RecettesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RecettesController.class);

	@Autowired
	private RecettesRepository repository;

	@RequestMapping("/index")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("Recettes/list");
		mav.getModel().put("RecettesList", this.repository.findAll());
		return mav;
	}

	@RequestMapping(path = "/edit/{id}")
	public String showUpdate(final Model model, @PathVariable final Integer id) {
		if (this.repository.exists(id)) {
			model.addAttribute("Recettes", this.repository.findOne(id));
			return "/Recettes/edit";
		} else {
			RecettesController.LOGGER
					.warn("Trying to update a Recettes with a unknown id '{}' in database. Switching to creation.", id);
			return this.showCreate(model);
		}
	}

	@RequestMapping(path = "/edit", method = RequestMethod.GET)
	public String showCreate(final Model model) {
		model.addAttribute("Recettes", new Recettes());
		return "Recettes/edit";
	}

	@RequestMapping(path = "/edit", method = RequestMethod.POST)
	public String createOrUpdate(@ModelAttribute final Recettes recettes) {
		// L'identifiant étant déjà pré-rempli par Spring si il était présent dans la page, aucune condition à gérer
		// pour distinguer la création de la mise à jour.
		this.repository.save(recettes);
		return "redirect:/Recettes/";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam final Integer id) {
		if (this.repository.exists(id)) {
			this.repository.delete(id);
		} else {
			RecettesController.LOGGER.warn("Cannot delete Recettes, id={} does not exists in database.", id);
		}
		return "redirect:/Recettes/";
	}
}
