<h1>Introduction</h1>
Le But de ce projet c'est de créer une application respectant le modèle Rendu HTML coté Client en utilisant Spring côté Backend et Angular côté front End.
Dans ce projet, nous allons tenter de respecter un maximum de bonne pratique de l'ingénierie logicielle :

<li>Création des entités JPA avec des relations et héritage</li>
<li>Utilisation des énumérateurs</li>
<li>Interfaces JPA Repository basées sur Spring Data</li>
<li>Création des DTOs</li>
<li>Création des Mappers entre Entités et DTOs</li>
<li>Création des exceptions métiers</li>
<li>Création de la couche service : interface et implémentation</li>
<li>Création des REST API (Web services Restful)</li>
<li>Test des API Restful avec Postman</li>
<li>Génération de la documentation Swagger (OPen API) des API REST</li>
<li>Création de la partie Frontend avec Angular</li>
<li>Sécurité avec Spring Security et Json Web Token</li>

<h1>Pratique :</h1>
Dans cette Activité pratique nous allons mettre en oeuvre tous ces notions :
<h3>Architecture Web Rendu HTML Coté Client</h3>
<img src="Captures\img.png">
Un client web (Browser) communique avec le serveur web (Apache) en utilisant le
protocole HTTP
 Une application web se compose de deux parties:
<li> La partie Backend : S’occupe des traitements effectués coté serveur </li>
<li> Technologies utilisées : PHP, JEE, .Net, Node JS</li> 
<li>La partie Frontend : S’occupe de la présentations des IHM coté Client </li>
<li> Langages utilisés : HTML, CSS, Java Script</li>

<li> La communication entre la partie Frontend et la partie backend se fait en utilisant le
protocole HTTP</li>
<h3>La structure du projet :</h3>
<h3>Partie backend:</h3>
<img src="Captures\img_1.png">
<img src="Captures\img_2.png">
<h3>Partie front-end:</h3>
<img src="Captures\img_3.png">
<img src="Captures\img_4.png">

application.properties :

<img src="Captures\img_5.png">
Dans ce fichier en mets notre configuration :
<li>Définir le port</li>
<li>Définir le url de la base de données</li>

<img src="Captures\img_6.png">

<h1>Conclusion :</h1>
Cette application pratique a pour but de mettre en pratiques:
Créer une application web rendu HTML coté client qui permet:
<li>Gérer les clients de la banque</li>
<li>Gérer les comptes bancaires appartenant à des cliants</li>
<li>Gérer les opérations sur les comptes: Versement,Retrait,Virement</li>
