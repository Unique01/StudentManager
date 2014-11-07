Le projet :
-----------
L'objectif du projet est de réaliser une application web qui permet de gérer les étudiants d'un enseignant.


Les choix : 
-----------
Nous avons programmé l'application en Java avec le framework Spring MVC. Les dépendances sont gérées à l'aide de Maven, et la persistance est controllée par Hibernate accompagnée d'une base de données embarquée H2.


Les fonctionalités :
--------------------

	- Connection à l'aide d'un identifiant et d'un mot de passe inséré préalablement.
	- Ajout, Suppression, Modification, Lecture d'un Etudiant, d'une Classe, et d'une Epreuve.
	- Tri et selection par critère.
	

Les problemes rencontrés :
--------------------------

Nous n'avons pas reussi à associer des étudiants à des classes, des epreuves à des étudiants, des classes à des epreuves, ainsi qu'à affecter
des notes aux épreuves des étudiants. Nous avons cependant créé les différentes pages impliquées et précisé l'algorithme des différentes méthodes 
appelés lors du submit. Nous reussisons à envoyer les elements selectionnés dans une liste (des étudiants par exemple), mais nous ne recupérons pas 
la classe associé pourtant envoyé en tant qu'attribut dans le formulaire. Les méthodes Ajax et Json ont été envisagées mais sans succès.