
Conception
==========

Objectifs:
----------

 - Pouvoir modéliser un circuit avec des I/O
 - Pouvoir ajouter des dépendances entre les I/O (conditions)
 - Pouvoir sauvegarder un circuit et reprendre la modification plus tard
 - Pouvoir ressortir le fichier en fichier de traitement exécutable sur une machine test

Réussi :
--------

 - Modélisation du circuit (placement des I/O)
 - Nœuds re-nommable
 - Ajout des conditions (en fonction des nœuds déjà présent sur le circuit)
 - Création de groupes (fichier .xml facilement modifiable / compréhensible)
 - Création de nouveau item/modification des anciens (fichier .xml)
 - Nœuds déplaçable
 - Nœuds supprimable

Spécification :
-------------

 - Langages utilisés : Java, xml
 - Librairie utilisée : Java-Swing
 - composition des dossiers :
	 - src : ensemble des fichier .java (source) du projet
	 - items : ensemble des composant pour le circuit
	 - groups : ensemble des groupes de composants pré-établis

Utilisation :
-------------

 - Placer un composant ou un groupe de composant :
	 - Sélectionner l'item a gauche à l'aide d'un clic gauche.
	 - Poser l'item à l'aide d'un clic gauche sur le circuit.
 - Déplacer un composant :
	 - maintenir un clic gauche enfoncé avec le curseur sur un composant puis déplacer la souris jusqu'à la position souhaité du composant.
 - Configurer un composant :
	 - faite clic droit sur un composant, les configurations disponible s'afficheront alors sous forme d'une nouvelle fenêtre.
 - Supprimer un composant :
	 - faite clic droit sur un composant, les configurations disponible s'afficheront alors sous forme d'une nouvelle fenêtre.
	 - Utiliser alors le bouton supprimer de cette nouvelle fenêtre.
 - Relier deux composant :
	 - Placer la souris sur un composant
	 - Maintenant le clic droit en déplaçant la souris jusqu'à un autre composant
	 - relâcher ensuite le clic de la souris 
	 - ATTENTION :
		 - Cette fonctionnalité n'a aucun effet sur le circuit, elle est simplement visuelle.

Auteur :
---------
 - Marchand Charles


