#!/usr/bin/env python
# -*- coding: utf-8 -*-
import mysql.connector 
path='~/Bureau/PROJET_LOC/CREATION_DB/'  #lieu ou ce trouve nos bdd
conn = mysql.connector.connect(host="localhost",user="root",password="110987rR+", database="Ingredients")
mon_fichier= open("BONBONS.DOC","r")
lignes =mon_fichier.readlines()
cursor = conn.cursor()
for i in range(len(lignes)):
	if lignes[i][0]=="-":
		line=(str(lignes[i].replace('- ','').replace('\n','').replace('\r','').replace('\xe9','é').replace('\xe0','â')),)
		print(lignes[i])
		cursor.execute("""INSERT INTO NOMS (noms) VALUES (%s)""",line)	
	conn.commit()


mon_fichier.close()
conn.close()
