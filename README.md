## EL PRESIDENTE

-  Choix d'implémentation

Tout d'abord, les classes ont été réparties par packages. Ces packages ont réparties selon les spécifications du projet.

- Architecture des classes et des packages du projet

```
src/java/main
 ┣ exceptions
 ┃ ┗ AccumulationException.java
 ┣ factions
 ┃ ┣ Capitalists.java
 ┃ ┣ Communists.java
 ┃ ┣ Ecologists.java
 ┃ ┣ Faction.java
 ┃ ┣ Liberals.java
 ┃ ┣ Loyalists.java
 ┃ ┣ Militarists.java
 ┃ ┣ Nationalists.java
 ┃ ┗ Religious.java
 ┣ game
 ┃ ┗ Game.java
 ┣ island
 ┃ ┗ Island.java
 ┣ main
 ┃ ┗ Application.java
 ┣ markers
 ┃ ┣ Agriculture.java
 ┃ ┣ DefaultMarker.java
 ┃ ┣ Industry.java
 ┃ ┣ Marker.java
 ┃ ┗ Treasury.java
 ┣ menu
 ┃ ┗ Menu.java   
```

Le package `exceptions` contient la classe `AccumulationException` qui est genéré lorsque le calcul entre deux marqueurs est impossible.

Le package `factions` contient les factions présentes sur l'île lors d'une partie

Le package `game` contient la classe `Game` qui implémente les règles du jeu et gère les conditions de défaite lors d'une partie.

Le package `island` contient la classe `Island` qui hérite d'une ArrayList de factions.

Le package `main` contient la classe `Application`, classe permettant de lancer une partie

Le package `markers` contient les marqueurs permettant par example d'obtenir le taux d'instrualisation ou d'agriculture d'une île.

Le package `menu` contient la classe `Menu`, classe permettant de gérer les divers choix du joueur durant la partie.


- Test unitaires

Organistation des tests unitaires

```
test
 ┣ java
 ┃ ┣ factions
 ┃ ┃ ┗ FactionTest.java
 ┃ ┗ markers
 ┃   ┗ MarkerTest.java
 ┗ 
```

Le package `factions` contient la classe `FactionTest` où sont testés les fonctionnalités développés dans la classe `Faction`.

Le package `markers` contient la classe `MarkerTest` où sont testés les fonctionnalités développés dans la classe `DefaultMarker` et ses sous-classes.

- Architecture du projet :

Ce projet via Maven, outil de gestion et d'automatisation de projets Java.


