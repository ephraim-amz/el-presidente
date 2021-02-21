package main;

import menu.Menu;

/**
 * The main class where the game is launched
 *
 */
public class Application {
	public static void main(String[] args) {
		Menu m = new Menu();
		System.out.println("Bienvenue Presidente!");
		m.loadMainMenu();
	}
}
