#!/usr/bin/env python
# -*- coding: utf-8 -*-
import mysql.connector 
import time
path='~/Bureau/PROJET_LOC/CREATION_DB/'  #lieu ou ce trouve nos bdd


def ___init___bdd():
	conn = mysql.connector.connect(host="localhost",user="root",password="110987rR+")
	cursor = conn.cursor(buffered=True)
	print "------------------------------------------------"
	print "--------- initialisation de la bdd ----------"
	print "------------------------------------------------"
	mon_fichier= open("create_db.sql","r")
	lignes =mon_fichier.readlines()
	for i in range(len(lignes)):
		if lignes[i]!='\n':
			print lignes[i].replace(';\n','')
			cursor.execute(lignes[i].replace(';\n',''))
			conn.commit()
	conn.close()
	time.sleep(4)
	print "------------------------------------------------"
	print "--------- initialisation de la bdd effectuée ----------"
	print "------------------------------------------------"
		

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
	line=str(lignes_temp.replace('$','').replace('\x87','ç').replace('- ','').replace('\x96','û').replace('\x8b','ï').replace('\n','').replace('\r','').replace('\x82','é').replace('\x88','è').replace('\x83','â').replace('\x85','à').replace('\x8a','ê').replace('\x8c','î')).replace('\xf8','oo').replace('\x93','"')
	return line

def function_unite(lignes_temp):
	line=lignes_temp.replace(' Litres ','').replace(' litres ','').replace(' L ','').replace(' l ','').replace(' dl ','').replace(' dcl ','').replace(' cl ','').replace(' ml ','').replace(' Kg ','').replace(' kg ','').replace(' g ','').replace(' cm ','').replace(' mm ','')
	return line

def function_nombre(lignes_temp):
	line=lignes_temp.replace('0','').replace('1','').replace('2','').replace('3','').replace('4','').replace('5','').replace('6','').replace('7','').replace('8','').replace('9','')
	return line
def function_special_chiffre(lignes_temp):
	chiffres=["1","2","3","4","5","6","7","8","9","0"]
	special=[",",".","/"]
	lignes_temp=lignes_temp.replace('c \x85 soupe','CS').replace('c \x85 caf\x82','CC').replace('Litres','l').replace('litres','l')
	temp=""
	
	for i in range(len(lignes_temp)-1):
		if lignes_temp[i] in chiffres or lignes_temp[i] in special:
			temp=temp.replace(",,",",-1,")+lignes_temp[i]
			
	temp="["+temp.replace(",,",",-1,")+"]"
	temp=temp.replace(",]",",-1]")
	return temp

def function_special_Unit(lignes_temp):
	lignes_temp=lignes_temp.replace('c à soupe','CS').replace('c à café','CC').replace('Litres','L').replace('litres','L').replace('litre','L').replace("gouttes",'GT').replace("cuillerée à soupe de", "CS").replace("cuillerée à café de", "CC")
	Unit=["L","l","dl","dcl","cl","ml","Kg","kg","g","mg","CS","CC","GT","mm","cm"]
	special=[","]
	temp2=""
	for i in range(len(lignes_temp)):
		if lignes_temp[i]==",":
			temp2=temp2+","
		for u in range(len(Unit)):
			if lignes_temp[i:i+3]==" "+Unit[u]+" ":
				temp2=temp2+'"'+Unit[u]+'"'
				break
			
			elif lignes_temp[i:i+4]==" "+Unit[u]+" ":
				temp2=temp2+'"'+Unit[u]+'"'
				break
	temp2='['+temp2+']'
	temp2=temp2.replace('[,','["no_unit",').replace(',]',',"no_unit"]')
	temp=""
	for i in range(len(temp2)):
		if temp2[i:i+2]==',,':
			temp=temp+',"no_unit"'
		else:
			temp=temp+temp2[i]
	return temp
		
def function_lettre(lignes_temp):
	line=lignes_temp.replace('a','').replace('b','').replace('c','').replace('d','').replace('e','').replace('f','').replace('g','').replace('h','').replace('i','').replace('j','').replace('k','').replace('l','').replace('m','').replace('n','').replace('o','').replace('p','').replace('q','').replace('r','').replace('s','').replace('t','').replace('u','').replace('v','').replace('w','').replace('x','').replace('y','').replace('z','')
	return line

def function_blanc(lignes_temp):
	return lignes_temp.replace('" ','"').replace('"  ','"').replace('"   ','"').replace('"    ','"').replace('"     ','"').replace('"      ','"').replace('"       ','"').replace('"        ','"').replace('"         ','"').replace('" ','"').replace('"  ','"').replace('"   ','"').replace(' "','"').replace('  "','"')

def function_nbpers(lignes_temp):
	for i in range(50):
		lignes_temp.replace("Pour "+str(i)+" personnes." ,"").replace("Pour "+str(i)+" personnes:" ,"")
	return lignes_temp

def fun_delete_m1(lignes_temp):
	balise=0
	lignes_t=[]
	for i in range(len(lignes_temp)):
		if '-1' not in lignes_temp[i]:
			if len(lignes_temp[i]) !=0:
				lignes_t.append(lignes_temp[i])
	return lignes_t


def function_autre_lignes_recettes(lignes_temp,index):
	toto=0
	while toto==0:
		index=index+1
		if lignes[index][0]=="$" and lignes[index][len(lignes[index])-3:len(lignes[index])-2]=="@": 
			toto=1



	return index-1
	
def insert_titre(temp_line):
	cursor.execute("""SELECT titre FROM RECETTES WHERE titre=(%s)""",temp_line)
	retour = cursor.fetchone()
	if (str(retour)=='None'):
		cursor.execute("""INSERT INTO RECETTES (titre)  VALUES (%s)""",temp_line)
		conn.commit()
		cursor.execute("""SELECT ID FROM RECETTES WHERE titre=(%s)""",temp_line)
		return cursor.fetchone()
	return "no"


def insert_recette(temp_line,ID):
	temp_line=function_convert(temp_line[0])
	cursor.execute(""" UPDATE RECETTES set recettes=(%s) WHERE ID=(%s)""",(temp_line,ID[0]))
	conn.commit()


def insert_ingredients_unit(line_ingredients,line_Unit_ingredients,line_quantity_ingredients,line,ID):
	liste_ing="["
	line_Unit_ingredients=eval(line_Unit_ingredients)
	#avoir
	for i in range(len(line_ingredients)):
		
		cursor.execute("""SELECT ID FROM Ingredients WHERE noms=(%s)""",(line_ingredients[i],))
		retour = cursor.fetchone()
		if (str(retour)=='None'):
			cursor.execute("""INSERT INTO Ingredients (noms,Unit)  VALUES (%s, %s)""",(line_ingredients[i],line_Unit_ingredients[i]))
			conn.commit()
			cursor.execute("""SELECT ID FROM Ingredients WHERE noms=(%s)""",(line_ingredients[i],))
			retour=cursor.fetchone()
			liste_ing = liste_ing+ str(retour[0])+","
		else:
			liste_ing =liste_ing+str(retour[0])+","

	liste_ing=liste_ing+"]"
	liste_ing=liste_ing.replace(",]","]")
	print "----------"
	print liste_ing
	print line_quantity_ingredients
	cursor.execute(""" UPDATE RECETTES set ingredients=(%s) , quantitees=(%s) WHERE ID=(%s)""",(liste_ing,line_quantity_ingredients,ID[0]))
	conn.commit()


# partie transfert titre


################# Main ##########################################


___init___bdd()

conn = mysql.connector.connect(host="localhost",user="root",password="110987rR+", database="Recettes")
cursor = conn.cursor(buffered=True)

mon_fichier= open("CUISINE/BONBONS.DOC","r")
lignes =mon_fichier.readlines()

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
			line_recettes=lignes[i+2:function_autre_lignes_recettes(lignes,i+1)]
			while ":" in line2:
				pos=line2.index(":")
				incr=0
				for aaa in range(pos-1):
					if line2[pos-aaa] != '.':
						line2=function_delete_string(line2, pos-aaa)
					else:
						line2=function_replace_string(line2, pos-aaa,',')
						break
					



			
			line_quantity_ingredients=function_special_chiffre(line2)
			line_Unit_ingredients=function_special_Unit(line2.lower())
			#print line_quantity_ingredients

			# recuperation des ingredients
			line2=function_nbpers(line2)
			line_ingredients=function_nombre(function_unite(line2))
			line_ingredients=line_ingredients.replace('(pharmacie)','').replace('/','').replace('d\'eau',"eau").replace('verre eau',"eau").replace(', de',',').replace('(herboriste)','').replace('(herboristerie)','').replace('.','"]').replace(',','","').replace("c à soupe de ","").replace("c à café de ","").replace("gouttes de ","")
			line_ingredients=line_ingredients.replace(' ou ','\",\"-1 ').replace('\"de ','')
			line_ingredients="[\""+line_ingredients
			line_ingredients=line_ingredients.replace('\"de ','\"')
			line_ingredients=eval(function_blanc(line_ingredients))
			line_ingredients=fun_delete_m1(line_ingredients)



			
			
			#ecriture dans  la bdd
			ID=insert_titre(line)
			if ID!="no":
				insert_recette(line_recettes,ID)
				insert_ingredients_unit(line_ingredients,line_Unit_ingredients,line_quantity_ingredients,line,ID)



			
			#cursor.execute("""SELECT titre FROM RECETTES WHERE titre=(%s)""",line)
			#retour = cursor.fetchone()
			#if (str(retour)=='None'):
				#cursor.execute("""INSERT INTO RECETTES (titre)  VALUES (%s)""",line)
				#conn.commit()
				#for iii in range(len(line_ingredients)):
				#	cursor.execute("""SELECT ID FROM Ingredients WHERE noms=(%s)""",(line_ingredients[iii],))
				#	retour = cursor.fetchone()
				#	if (str(retour)=='None'):
				#		cursor.execute("""INSERT INTO Ingredients (noms)  VALUES (%s)""",(line_ingredients[iii],))
				#		conn.commit()
				#	else:
				#		cursor.execute("""SELECT ingredients FROM RECETTES WHERE noms=(%s)""",line)
				#		retour = cursor.fetchone()
				#		if (str(retour)=='None'): 
				#			cursor.execute("""INSERT INTO Ingredients (noms)  VALUES (%s)""",('['+line_ingredients[iii]+']',))
				#			conn.commit()
				#		else:
				#			retour=retour.replace(']',line_ingredients[iii]+']')
				#			cursor.execute("""INSERT INTO Ingredients (noms)  VALUES (%s)""",(retour,))
				#			conn.commit()
				





				#reste a ajouter les lignes de recettes
			#print line
			








mon_fichier.close()
conn.close()

# partie transfert Ingredients

