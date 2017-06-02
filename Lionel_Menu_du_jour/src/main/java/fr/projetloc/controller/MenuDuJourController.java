package fr.projetloc.controller;

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

import java.util.concurrent.ThreadLocalRandom;
import fr.projetloc.dao.MenuDuJourRepository;
import fr.projetloc.entity.MenuDuJour;

@Controller
@RequestMapping("/MenuDuJour")
public class MenuDuJourController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuDuJourController.class);
	
	@Autowired
	private MenuDuJourRepository repository;

	@RequestMapping("/index")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("MenuDuJour/list");
		mav.getModel().put("menuDuJourList", this.repository.findByTypes(2));
		/*mav.getModel().put("menuDuJourList",
				this.repository.findById(ThreadLocalRandom.current().nextInt(1, 3 + 1), null));*/
		return mav;
	}
	
/* delete methode */
	@RequestMapping("/delete")
	public String delete(@RequestParam final Integer id) {
		if (this.repository.exists(id)) {
			this.repository.delete(id);
		} else {
			MenuDuJourController.LOGGER.warn("Cannot delete Recette, id={} does not exists in database.", id);
		}
		return "redirect:/MenuDuJour/";
	}
	
	
	/* add method */
	@RequestMapping(path = "/MenuDuJour/add", method = RequestMethod.GET)
	public String newMenuDuJour(final Model model) {
		model.addAttribute("newMenuDuJour", new MenuDuJour());
		return "MenuDuJour/createMenuDuJour"; /*envoi en bas sur le post via createMenuDuJour.jsp */
	}

	@RequestMapping(path = "/MenuDuJour/add", method = RequestMethod.POST)
	public String createMenuDuJour(@ModelAttribute("newMenuDuJour") final MenuDuJour menuDuJour) {

		this.repository.save(menuDuJour);
		return "redirect:/MenuDuJour/";
	}
	
	
	/* update method */
	@RequestMapping(path = "/MenuDuJour/update/{id}")
	public String showUpdate(final Model model, @PathVariable final Integer id) {
		if (this.repository.exists(id)) {
			model.addAttribute("majMenuDuJour", this.repository.findOne(id));
			return "/MenuDuJour/updateMenuDuJour";
		} else {
			MenuDuJourController.LOGGER
					.warn("Trying to update a recette with a unknown id '{}' in database. Switching to creation.", id);
			return this.showUpdateRecette(model);
		}
	}
	@RequestMapping(path = "/MenuDuJour/update", method = RequestMethod.GET)
	public String showUpdateRecette(final Model model) {
		model.addAttribute("majMenuDuJour", new MenuDuJour());
		return "MenuDuJour/updateMenuDuJour";
	}

	@RequestMapping(path = "/MenuDuJour/update", method = RequestMethod.POST)
	public String Update(@ModelAttribute final MenuDuJour menuDuJour) {
		this.repository.save(menuDuJour);
		return "redirect:/MenuDuJour/";
	}
	
	
}
