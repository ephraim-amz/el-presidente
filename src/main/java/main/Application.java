package main;

import menus.Menu;

public class Application {
	public static void main(String[] args) {
		Menu m = new Menu();
		System.out.println("Bienvenue Presidente!");
		m.chargerMenuPrincipal();
	}
}
