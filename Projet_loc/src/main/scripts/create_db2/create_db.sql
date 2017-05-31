DROP DATABASE IF EXISTS Recettes2;

CREATE DATABASE IF NOT EXISTS `Recettes2`;


USE `Recettes2`;

DROP TABLE IF EXISTS `Recettes`;

CREATE TABLE `Recettes` (
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`titre` VARCHAR(255),
	`recettes` TEXT,
	`difficultes` INT(1),
	`types` INT(2),
	`veg` INT(1))ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Ingredients`;

CREATE TABLE Ingredients (`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`noms` VARCHAR(255),
	`Unit` INT(10))
	ENGINE=InnoDB DEFAULT CHARSET=utf8;




DROP TABLE IF EXISTS `RecettesIngredients`;

CREATE TABLE `RecettesIngredients` (
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`id_recettes` INT NOT NULL,
	`id_ingredients` INT NOT NULL,
	`quantity` float NOT NULL,
	`Unit` int(10),
	

	KEY `FK_RecettesIngredients_Recettes_index` (`id_recettes`),
	KEY `FK_RecettesIngredients_Ingredients_index` (`id_ingredients`),


	CONSTRAINT `FK_RecettesIngredients_Recettes` FOREIGN KEY (`id_recettes`) REFERENCES `Recettes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,


	
	CONSTRAINT  `FK_RecettesIngredients_Ingredients` FOREIGN KEY (`id_ingredients`) REFERENCES `Ingredients` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION)
	ENGINE=InnoDB DEFAULT CHARSET=utf8;



