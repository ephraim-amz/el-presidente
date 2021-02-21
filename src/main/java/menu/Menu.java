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
	private static final String END_OF_YEAR_MENU = MENU_FOLDER + "endofyearmenu.txt";
	private static final String GAME_OVER = MENU_FOLDER + "gameover.txt";
	private static final String INVALID_CHOICE = "\tLe numéro choisi ne fait pas partie des choix possibles!\n";
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
				System.out.println("\tScénarios pas encore disponibles.");
			} else if (choice != 3) {
				System.out.println(INVALID_CHOICE);
			}
		}
		quit();
	}
	
	private void quit() {
		System.out.println("\tA bientôt Presidente!");
		System.exit(0);
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
			} else if (choice != 4) {
				System.out.println(INVALID_CHOICE);
			}
		}
	}
	
	public void loadGameMenu() {
		int choice = 0;

		while (!game.isLost()) {
			printGameMenu();
			System.out.println("\tIl n'y a pas d'event pour l'instant appuyer sur 1/2/3/4");
			choice = menuChoiceScanner(GAME_MENU);
//			loadEvent();
			game.nextSeason(this);
		}
		try {
			printMenu(GAME_OVER);
		} catch (IOException e) {
			e.printStackTrace();
		}
		printGameMenu();
	}
	
	public void loadEndOfYearMenu() {
		int choice = 0;

		while (choice != 3 && choice != -1) {
			printGameStats();
			choice = menuChoiceScanner(END_OF_YEAR_MENU);
			if (choice == 1) {
				loadBribeMenu();
			} else if (choice == 2) {
				if (!game.buyFood()) {
					System.out.println("\tNous n'avons pas de quoi acheter de la nourriture, Presidente!");
				}
			} else if (choice == -1) {
				game.renounce();
			} else if (choice != 3) {
				System.out.println(INVALID_CHOICE);
			}
		}
	}
	
	public void loadBribeMenu() {
		int choice = 0;

		while (choice != 9) {
			System.out.println("\tQuelle faction voulez vous \"Soutenir\", Presidente? (9 pour annuler)");
			choice = numericScanner();
			if (choice > 0 && choice < 9) {
				if (game.getFactionBribePrice(choice) <= game.getTreasure()) {
					game.bribeFaction(choice);
					choice = 9;
				} else {
					System.out.println("\tNous ne pouvons rien leur offrir à part des pots en argile, Presidente...\n");
					choice = 9;
				}
			} else if (choice != 9){
				System.out.println(INVALID_CHOICE);
			}
		}
	}
	
	private void printGameMenu() {
		System.out.println("\t\t\tAnnée " + game.getYear() + " Saison " + game.getSeasonName() + "\n");
		printGameStats();
	}
	
	private void printGameStats() {
		String gameStats = "\tTrésorerie : " + game.getTreasure() + "$\t\tGains prévus : " + game.getGeneratedTreasure() + "$"
				+ "\tSatisfaction limite : " + game.getLostRate() + "%\n"
				+ "\tTaux d'industrie : " + game.getIndustryRate() * 100 + "%\tNourriture en stock : " + game.getStockedFood() + "\n"
				+ "\tTaux d'agriculture : " + game.getAgricultureRate() * 100 + "%\tNourriture produite : " + game.getGeneratedFood() + "\n"
				+ "\tSatisfaction globale : " + DECIMAL_FORMAT.format(game.getGeneralApprovalRate()) + "%" 
				+ "\tNourriture requise en fin d'année : " + game.getNeededFood() + "\n";
		System.out.println(gameStats);
		printFactions();
	}
	
	private void printFactions() {
		String factions = "";
		int factionNumber = 1;

		for (Faction faction : game) {
			factions += "\t" + factionNumber + " - Faction " + faction.getClass().getSimpleName();
			if (!faction.getClass().getSimpleName().equals("Nationalists")) {
				factions += "\t";
			}
			factions += "\tSatisfaction : " + DECIMAL_FORMAT.format(faction.getApprovalRate()) + "%"
					+ "\tNombre de partisans : " + faction.getFactionSupporters()
					+ "\tPrix du pot de vin : " + faction.getBribePrice() + "$\n";
			factionNumber++;
		}
		System.out.println(factions);
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
				System.out.println("\tPresidente ce n'est pas un nombre!");
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
