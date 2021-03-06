DROP DATABASE IF EXISTS Recettes;
DROP DATABASE IF EXISTS Identifiants;

CREATE DATABASE IF NOT EXISTS Recettes;
CREATE DATABASE IF NOT EXISTS Identifiants;


USE Recettes;

DROP TABLE IF EXISTS RECETTES;

CREATE TABLE RECETTES (ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,titre VARCHAR(255),recettes TEXT,ingredients TEXT,quantitees TEXT,difficultes INT,temps TIME);


DROP TABLE IF EXISTS Ingredients;

CREATE TABLE Ingredients (ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,noms VARCHAR(255),Unit VARCHAR(255));



USE Identifiants;
DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,users VARCHAR(255),passwd VARCHAR(255),difficultes INT);



