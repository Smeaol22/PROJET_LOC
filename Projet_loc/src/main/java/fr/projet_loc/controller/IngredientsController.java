package fr.projet_loc.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.projet_loc.dao.IngredientsRepository;
import fr.projet_loc.entity.Ingredients;

@Controller
@RequestMapping("/Ingredients")
public class IngredientsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IngredientsController.class);

	/**
	 * Bean singleton injecté via le context Spring.
	 */
	@Autowired
	private IngredientsRepository repository;

	/**
	 * Méthode liée à l'affichage de la liste des Ingredients.
	 * 
	 * @return Vue Ingredients/list.jsp, Model avec liste des Ingredients.
	 */
	@RequestMapping("/index")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("Ingredients/list");
		mav.getModel().put("IngredientsList", this.repository.findAll());
		return mav;
	}

	@RequestMapping(path = "/edit", method = RequestMethod.GET)
	public ModelAndView showCreate() {
		return new ModelAndView("Ingredients/edit");
	}

	/**
	 * Méthode liée à une url paramétrée. Cette méthode n'est déclenchée que lorsque l'URL comporte une valeur numérique
	 * (car le type du paramètre est Integer). Ex : '/Ingredients/edit/3.html'.
	 * 
	 * @param id
	 *            l'identifiant du produit à mettre à jour.
	 * @return Vue product/edit.jsp, Model avec informations du produit à modifier.
	 */
	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView showUpdate(@PathVariable("id") final Integer id) {
		if (this.repository.exists(id)) {
			final ModelAndView mav = new ModelAndView("Ingredients/edit");
			mav.getModel().put("Ingredients", this.repository.findOne(id));
			return mav;
		} else {
			IngredientsController.LOGGER
					.warn("Product with id={} does not exists in database. Switching to Ingredients creation.", id);
			return this.showCreate();
		}
	}

	@RequestMapping(path = "/edit", method = RequestMethod.POST)
	public String createOrUpdate(final HttpServletRequest request) {
		final String noms = request.getParameter("noms");
		final Integer unit = Integer.parseInt(request.getParameter("unit"));
		final Ingredients ingredients = new Ingredients();
		if (request.getParameterMap().containsKey("id")) {
			ingredients.setId(Integer.parseInt(request.getParameter("id")));
		}
		ingredients.setNoms(noms);
		ingredients.setUnit(unit);
		// Si l'identifiant du produit est rempli, alors l'update se fera automatiquement à la place de l'insert.
		this.repository.save(ingredients);
		return "redirect:/Ingredients/";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam final Integer id) {
		if (this.repository.exists(id)) {
			this.repository.delete(id);
		} else {
			IngredientsController.LOGGER.warn("Cannot delete ingredients, id={} does not exists in database.", id);
		}
		return "redirect:/Ingredients/";
	}
}
