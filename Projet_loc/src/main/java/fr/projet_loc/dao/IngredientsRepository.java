package fr.projet_loc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.projet_loc.entity.Ingredients;

public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {

}
