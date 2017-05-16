#!/usr/bin/env python
# -*- coding: utf-8 -*-
import mysql.connector 
path='~/Bureau/PROJET_LOC/CREATION_DB/'  #lieu ou ce trouve nos bdd
conn = mysql.connector.connect(host="localhost",user="root",password="110987rR+", database="Recettes")
mon_fichier= open("CUISINE/BONBONS.DOC","r")
lignes =mon_fichier.readlines()
cursor = conn.cursor(buffered=True)
for i in range(len(lignes)):
	if lignes[i][0]=="-":
		line=(str(lignes[i].replace('- ','').replace('\n','').replace('\r','').replace('\x82','é').replace('\x83','â').replace('\x85','à')),)
		cursor.execute("""SELECT noms FROM Ingredients WHERE noms=(%s)""",line)
		retour = cursor.fetchone()
		if (str(retour)=='None'):
			cursor.execute("""INSERT INTO Ingredients (noms)  VALUES (%s)""",line)
			conn.commit()


mon_fichier.close()
conn.close()

