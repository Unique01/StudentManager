Le projet :
-----------
L'objectif du projet est de r�aliser une application web qui permet de g�rer les �tudiants d'un enseignant.


Les choix : 
-----------
Nous avons programm� l'application en Java avec le framework Spring MVC. Les d�pendances sont g�r�es � l'aide de Maven, et la persistance est controll�e par Hibernate accompagn�e d'une base de donn�es embarqu�e H2.


Les fonctionalit�s :
--------------------

	- Connection � l'aide d'un identifiant et d'un mot de passe ins�r� pr�alablement.
	- Ajout, Suppression, Modification, Lecture d'un Etudiant, d'une Classe, et d'une Epreuve.
	- Tri et selection par crit�re.
	

Les problemes rencontr�s :
--------------------------

Nous n'avons pas reussi � associer des �tudiants � des classes, des epreuves � des �tudiants, des classes � des epreuves, ainsi qu'� affecter
des notes aux �preuves des �tudiants. Nous avons cependant cr�� les diff�rentes pages impliqu�es et pr�cis� l'algorithme des diff�rentes m�thodes 
appel�s lors du submit. Nous reussisons � envoyer les elements selectionn�s dans une liste (des �tudiants par exemple), mais nous ne recup�rons pas 
la classe associ� pourtant envoy� en tant qu'attribut dans le formulaire. Les m�thodes Ajax et Json ont �t� envisag�es mais sans succ�s.