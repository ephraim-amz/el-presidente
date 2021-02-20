package menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.Scanner;

import factions.Faction;
import game.Game;

public class Menu {
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
	private static final String MENU_FOLDER = "texts/menus/";
	private static final String MAIN_MENU = MENU_FOLDER + "mainmenu.txt";
	private static final String SANDBOX_MENU = MENU_FOLDER + "sandboxmenu.txt";
	private static final String GAME_MENU = MENU_FOLDER + "gamemenu.txt";
	private static final String INVALID_CHOICE = "Le numéro choisi ne fait pas partie des choix possibles!";
		private static final double EASY = 0.5;
	private static final double MEDIUM = 1;
	private static final double HARD = 1.5;

	private Scanner scanner;
	private Game game;
	
	public Menu() {
		this.scanner = new Scanner(System.in);
	}
	
	public void loadMainMenu() {
		int choice = 0;

		while (choice != 3) {
			choice = menuChoiceScanner(MAIN_MENU);
			if (choice == 1) {
				loadSandboxMenu();
			} else if (choice == 2) {
				System.out.println("Scénarios pas encore disponibles.");
			} else if (choice == 3) {
				break;
			} else {
				System.out.println(INVALID_CHOICE);
			}
		}
		quitGame();
	}
	
	
	private void loadSandboxMenu() {
		int choice = 0;

		while (choice < 1 || choice > 4) {
			choice = menuChoiceScanner(SANDBOX_MENU);
			if (choice == 1) {
				game = new Game(EASY);
				loadGameMenu();
			} else if (choice == 2) {
				game = new Game(MEDIUM);
				loadGameMenu();
			} else if (choice == 3) {
				game = new Game(HARD);
				loadGameMenu();
			} else if (choice == 4) {
				break;
			} else {
				System.out.println(INVALID_CHOICE);
			}
		}
	}
	
	public void loadGameMenu() {
		int choice = 0;

		while (choice < 1 || choice > 4) {
			printGameMenu();
			System.out.println("Il n'y a rien à voir pour l'instant appuyer sur 1/2/3/4");
			choice = menuChoiceScanner(GAME_MENU);
//			loadEvent();
			if (choice == 1) {
				game.nextSeason();
			} else if (choice == 2) {
				game.nextSeason();
			} else if (choice == 3) {
				game.nextSeason();
			} else if (choice == 4) {
				game.nextSeason();
			} else {
				System.out.println(INVALID_CHOICE);
			}
		}
	}
	
	private void quitGame() {
		System.out.println("A bientôt Presidente!");
		System.exit(0);
	}
	
	private void printGameMenu() {
		String gameMenu = "\t\t\t\t\t\t\t\tEL PRESIDENTE\n";
		gameMenu = gameMenu + "\tAnnée " + game.getYear() + " Saison " + game.getSeasonName() + "\n"
		+ "\tSatisfaction globale : " + DECIMAL_FORMAT.format(game.getGeneralApprovalRate()) + "%\n\n";
		for (Faction faction : game) {
			gameMenu = gameMenu + "\tFaction " + faction.getClass().getSimpleName()
					+ "\tSatisfaction : " + DECIMAL_FORMAT.format(faction.getApprovalRate()) + "%"
					+ "\tNombre de partisans : " + faction.getFactionSupporters() + "\n";
		}
		System.out.println(gameMenu);
	}

	private int menuChoiceScanner(String menu) {
		int choice = 0;
		
		try {
			if (!menu.equals(GAME_MENU))
			printMenu(menu);
			choice = numericScanner();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return choice;
	}
	
	private void printMenu(String fileName) throws IOException {
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(fileName, StandardCharsets.ISO_8859_1));
			String line;
			while ((line = bf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("Le fichier " + fileName + " n'a pas pu être lu car " + e.getCause());
		} finally {
			if (bf != null) {
				bf.close();
			}
		}
	}
	
	private int numericScanner() {
		String choice = "";
		int choiceNum = 0;
		
		while (!this.isNumeric(choice)) {
			choice = scanner.nextLine();
			if (!this.isNumeric(choice)) {
				System.out.println("Ce choix n'est pas un nombre!");
			} else {
				choiceNum = Integer.parseInt(choice);
			}
		}
		return choiceNum;
	}
	
	private boolean isNumeric(String str) { 
		try {  
			Double.parseDouble(str);  
			return true;
		} catch (NumberFormatException e) {  
			return false;  
		}  
	}
}
