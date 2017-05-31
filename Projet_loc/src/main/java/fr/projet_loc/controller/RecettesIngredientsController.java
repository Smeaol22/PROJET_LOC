package fr.projet_loc.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.projet_loc.dao.RecettesRepository;
import fr.projet_loc.dao.IngredientsRepository;
import fr.projet_loc.dao.RecettesIngredientsRepository;
import fr.projet_loc.entity.Recettes;
import fr.projet_loc.entity.Ingredients;
import fr.projet_loc.entity.RecettesIngredients;

@Controller
@RequestMapping("/RecettesIngredients")
@SessionAttributes({ "RecettesIngredientsList", "IngredientsList", "Recettes" })
public class RecettesIngredientsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RecettesIngredientsController.class);

	@Autowired
	private RecettesRepository recettesRepository;

	@Autowired
	private IngredientsRepository ingredientsRepository;

	@Autowired
	private RecettesIngredientsRepository recettesIngredientsRepository;

	@ModelAttribute
	public List<RecettesIngredients> RecettesIngredientsList() {
		return new ArrayList<>();
	};

	@ModelAttribute
	public List<Ingredients> IngredientsList() {
		return new ArrayList<>();
	}

	@RequestMapping("/index")
	public ModelAndView index(@RequestParam final Integer RecettesId) {
		final ModelAndView mav = new ModelAndView("/RecettesIngredients/list");
		mav.getModel().put("RecettesIngredientsList", this.recettesIngredientsRepository.findAllByRecettesId(RecettesId));
		return mav;
	}

	@RequestMapping("/edit")
	public ModelAndView showEdit(@RequestParam final Integer RecettesId,
			@ModelAttribute final List<RecettesIngredients> RecettesIngredientsList, @ModelAttribute final List<Ingredients> IngredientsList) {
		ModelAndView mav = new ModelAndView("RecettesIngredients/edit");
		mav.getModel().put("Recettes", this.recettesRepository.findOne(RecettesId));

		IngredientsList.clear();
		IngredientsList.addAll(this.ingredientsRepository.findAll());
		final List<RecettesIngredients> currentRecettesIngredientsList = this.recettesIngredientsRepository.findAllByRecettesId(RecettesId);
		// FIXME: Can the result from repo be null when using findAll ?
		if (currentRecettesIngredientsList != null) {
			RecettesIngredientsList.clear();
			RecettesIngredientsList.addAll(currentRecettesIngredientsList);
			for (final RecettesIngredients RecettesIngredients : currentRecettesIngredientsList) {
				IngredientsList.remove(RecettesIngredients.getIngredients());
			}
		}
		return mav;
	}

	
	@RequestMapping(path = "/edit/add")
	public String addRecettesIngredients(@RequestParam final Integer IngredientsId, @RequestParam final Float quantity,
			@ModelAttribute List<RecettesIngredients> RecettesIngredientsList, @ModelAttribute final Recettes recettes,
			@ModelAttribute List<Ingredients> ingredientsList) {
		final RecettesIngredients RecettesIngredients = new RecettesIngredients();
		RecettesIngredients.setRecettes(recettes);
		RecettesIngredients.setIngredients(this.ingredientsRepository.findOne(IngredientsId));
		RecettesIngredients.setQuantity(quantity);
		RecettesIngredientsList.add(RecettesIngredients);
		ingredientsList.remove(RecettesIngredients.getIngredients());
		return "RecettesIngredients/edit";
	}	
	
	@RequestMapping("/edit/remove")
	public String removeRecettesIngredients(@RequestParam final Integer IngredientsId, @ModelAttribute final Recettes recettes,
			@ModelAttribute List<RecettesIngredients> RecettesIngredientsList, @ModelAttribute List<Ingredients> ingredientsList) {
		if (RecettesIngredientsList.remove(new RecettesIngredients(recettes, this.ingredientsRepository.findOne(IngredientsId)))) {
			ingredientsList.add(this.ingredientsRepository.findOne(IngredientsId));
			
		}
		return "/RecettesIngredients/edit";
	}

	@RequestMapping("/edit/validate")
	public String validateAndPersist(@ModelAttribute List<RecettesIngredients> RecettesIngredientsList,
			@ModelAttribute final Recettes recettes) {
		LOGGER.debug("Validating list of ingredient in RecettesIngredients with RecettesId={} and Ingredients={}", recettes.getId(),
				RecettesIngredientsList);
		// Dans un premier temps il faut supprimer les éventuels ingrédients déjà existant et associés à ce cocktail.
		this.recettesIngredientsRepository.deleteByRecettesId(recettes.getId());
		// Et la magie de Spring nous permet de passer en paramètre toute notre liste d'un coup grâce à l'interface
		// Iterable<Ingredient> implémentée par List<Ingrédient> !
		this.recettesIngredientsRepository.save(RecettesIngredientsList);
		// TODO: end session scope.
		return "redirect:/Recettes/";
	}
}
