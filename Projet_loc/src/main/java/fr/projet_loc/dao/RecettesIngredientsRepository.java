package fr.projet_loc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import fr.projet_loc.entity.RecettesIngredients;

public interface RecettesIngredientsRepository extends JpaRepository<RecettesIngredients, Integer> {

	public List<RecettesIngredients> findAllByRecettesId(final Integer RecettesId);

	@Transactional
	public void deleteByRecettesId(final Integer RecettesId);
}
