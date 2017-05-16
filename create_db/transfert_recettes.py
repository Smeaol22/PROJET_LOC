#!/usr/bin/env python
# -*- coding: utf-8 -*-
import mysql.connector 
path='~/Bureau/PROJET_LOC/CREATION_DB/'  #lieu ou ce trouve nos bdd
conn = mysql.connector.connect(host="localhost",user="root",password="110987rR+", database="Recettes")
mon_fichier= open("CUISINE/BONBONS.DOC","r")
lignes =mon_fichier.readlines()


def function_delete_string(liste, index):
	liste_temp=''
	for i in range(len(liste)):
		if i !=index:
			liste_temp=liste_temp+str(liste[i])
	return liste_temp

def function_replace_string(liste, index,motif):
	liste_temp=''
	for i in range(len(liste)):
		if i !=index:
			liste_temp=liste_temp+str(liste[i])
		else:
			liste_temp=liste_temp+motif
	return liste_temp

def function_convert(lignes_temp):
	line=str(lignes_temp.replace('$','').replace('\x87','ç').replace('- ','').replace('\x96','û').replace('\x8b','ï').replace('\n','').replace('\r','').replace('\x82','é').replace('\x88','è').replace('\x83','â').replace('\x85','à').replace('\x8a','ê').replace('\x8c','î'))
	return line

def function_unite(lignes_temp):
	line=lignes_temp.replace(' Litres ','').replace(' litres ','').replace(' L ','').replace(' l ','').replace(' dl ','').replace(' dcl ','').replace(' cl ','').replace(' ml ','').replace(' Kg ','').replace(' kg ','').replace(' g ','')
	return line

def function_nombre(lignes_temp):
	line=lignes_temp.replace('0','').replace('1','').replace('2','').replace('3','').replace('4','').replace('5','').replace('6','').replace('7','').replace('8','').replace('9','')
	return line

def function_lettre(lignes_temp):
	line=lignes_temp.replace('a','').replace('b','').replace('c','').replace('d','').replace('e','').replace('f','').replace('g','').replace('h','').replace('i','').replace('j','').replace('k','').replace('l','').replace('m','').replace('n','').replace('o','').replace('p','').replace('q','').replace('r','').replace('s','').replace('t','').replace('u','').replace('v','').replace('w','').replace('x','').replace('y','').replace('z','')
	return line

def function_blanc(lignes_temp):
	return lignes_temp.replace('" ','"').replace('"  ','"').replace('"   ','"').replace('"    ','"').replace('"     ','"').replace('"      ','"').replace('"       ','"').replace('"        ','"').replace('"         ','"').replace('" ','"').replace('"  ','"').replace('"   ','"').replace(' "','"').replace('  "','"')


def fun_delete_m1(lignes_temp):
	balise=0
	lignes_t=[]
	for i in range(len(lignes_temp)):
		if '-1' not in lignes_temp[i]:
			if len(lignes_temp[i]) !=0:
				lignes_t.append(lignes_temp[i])
		else:
			balise=1
	if balise==1:
		print lignes_t
	return lignes_t




# partie transfert titre
cursor = conn.cursor(buffered=True)
lenlignes=len(lignes)
for i in range(lenlignes):
	if i+3<lenlignes:
		if lignes[i][0]=="$" and lignes[i][len(lignes[i])-3:len(lignes[i])-2]=="@" and lignes[i+3][len(lignes[i+3])-3:len(lignes[i+3])-2] != "@":
			incr=0
			for ii in range(len(lignes[i])):
				if lignes[i][ii] != "@":
					incr=incr+1
				else:	
					break
			line=(function_convert(lignes[i][2:incr-2]),)
			line2=function_convert(lignes[i+1])
			while ":" in line2:
				pos=line2.index(":")
				incr=0
				for aaa in range(pos-1):
					if line2[pos-aaa] != '.':
						line2=function_delete_string(line2, pos-aaa)
					else:
						line2=function_replace_string(line2, pos-aaa,',')
						break
					







			line_ingredients=function_nombre(function_unite(line2))
			line_ingredients=line_ingredients.replace('(pharmacie)','').replace('/','').replace('d\'eau',"eau").replace('verre eau',"eau").replace(', de',',').replace('(herboriste)','').replace('(herboristerie)','').replace('.','"]').replace(',','","')
			line_ingredients=line_ingredients.replace(' ou ','\",\"-1 ').replace('\"de ','')
			line_ingredients="[\""+line_ingredients
			line_ingredients=line_ingredients.replace('\"de ','\"')
			line_ingredients=eval(function_blanc(line_ingredients))
			line_ingredients=fun_delete_m1(line_ingredients)



			
			
			cursor.execute("""SELECT titre FROM RECETTES WHERE titre=(%s)""",line)
			retour = cursor.fetchone()
			#if (str(retour)=='None'):
				#cursor.execute("""INSERT INTO RECETTES (titre)  VALUES (%s)""",line)
				#conn.commit()
				#for iii in range(len(line_ingredients)):
				#	cursor.execute("""SELECT noms FROM Ingredients WHERE noms=(%s)""",(line_ingredients[iii],))
				#	retour = cursor.fetchone()
				#	if (str(retour)=='None'):
				#		cursor.execute("""INSERT INTO Ingredients (noms)  VALUES (%s)""",(line_ingredients[iii],))
				#		conn.commit()
			print line
			








mon_fichier.close()
conn.close()

# partie transfert Ingredients

