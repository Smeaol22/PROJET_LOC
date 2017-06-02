package fr.projetloc.dao;



import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.projetloc.entity.MenuDuJour;


public interface MenuDuJourRepository extends JpaRepository<MenuDuJour, Integer> {
	
	 Iterable<MenuDuJour> findById(int i, Sort sort);
	 List <MenuDuJour> findByTypes(int types);

}
