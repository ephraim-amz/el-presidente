package menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.Scanner;

import events.*;
import factions.Faction;
import game.Game;

/**
 * Load the game menu and handle the inputs and the outputs of the player
 *
 */
public class Menu {
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
	private static final String MENU_FOLDER = "texts/menus/";
	private static final String MAIN_MENU = MENU_FOLDER + "mainmenu.txt";
	private static final String SANDBOX_MENU = MENU_FOLDER + "sandboxmenu.txt";
	//private static final String SCENARIOS_MENU = MENU_FOLDER + "scenarios.txt";
	private static final String GAME_MENU = MENU_FOLDER + "gamemenu.txt";
	private static final String END_OF_YEAR_MENU = MENU_FOLDER + "endofyearmenu.txt";
	private static final String GAME_OVER = MENU_FOLDER + "gameover.txt";
	private static final String INVALID_CHOICE = "\tLe numéro choisi ne fait pas partie des choix possibles!\n";
	private static final double EASY = 0.5;
	private static final double MEDIUM = 1;
	private static final double HARD = 1.5;

	private Scanner scanner;
	private Game game;

	/**
	 * Menu constructor, generate a new Scanner
	 */
	public Menu() {
		this.scanner = new Scanner(System.in);
	}

	/**
	 * Load the main menu and handle the choices of the main menu
	 */
	public void loadMainMenu() {
		int choice = 0;

		while (choice != 3) {
			choice = menuChoiceScanner(MAIN_MENU);
			if (choice == 1) {
				loadSandboxMenu();
			} else if (choice == 2) {
				//loadScenarios();
				System.out.println("En cours de développement");
			} else if (choice != 3) {
				System.out.println(INVALID_CHOICE);
			}
		}
		quit();
	}

	/**
	 * Quit the game
	 */
	private void quit() {
		System.out.println("\tA bientôt Presidente!");
		System.exit(0);
	}

	/**
	 * Load the menu when the game is in sandbox mode
	 */
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

	/**
	 * Load the menu when the game is played
	 */
	public void loadGameMenu() {
		while (!game.isLost()) {
			printGameMenu();
			loadEvents();
			game.nextSeason(this);
		}
		try {
			printMenu(GAME_OVER);
		} catch (IOException e) {
			e.printStackTrace();
		}
		printGameMenu();
	}
	
	/**
	 * Event loader after scan of user type
	 */
	public void loadEvents() {
		int choice = 0;
		
		new Events();
		while (choice < 1 || choice > 4) {
			choice = numericScanner();
			if (choice == 1) {
				new ApplyEffect(1, this.game);
			} 
			else if (choice == 2) {
				new ApplyEffect(2, this.game);
			} 
			else if (choice == 3) {
				new ApplyEffect(3, this.game);
			} 
			else if (choice == 4) {
				new ApplyEffect(4, this.game);
			} else {
				System.out.println(INVALID_CHOICE);
			}
		}
	}

	/**
	 * Load the menu when the year is over 
	 */
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

	/**
	 * Load the bribe menu
	 */
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
			} else if (choice != 9) {
				System.out.println(INVALID_CHOICE);
			}
		}
	}

	/**
	 * Print on the console the year and the season of the game
	 */
	private void printGameMenu() {
		System.out.println("\t\t\tAnnée " + game.getYear() + " Saison " + game.getSeasonName() + "\n");
		printGameStats();
	}

	/**
	 * Print on the console the stats related to the game
	 */
	private void printGameStats() {
		String gameStats = "\tTrésorerie : " + game.getTreasure() + "$\t\tGains prévus : " + game.getGeneratedTreasure()
				+ "$" + "\tSatisfaction limite : " + game.getLostRate() + "%\n" + "\tTaux d'industrie : "
				+ game.getIndustryRate() * 100 + "%\tNourriture en stock : " + game.getStockedFood() + "\n"
				+ "\tTaux d'agriculture : " + game.getAgricultureRate() * 100 + "%\tNourriture produite : "
				+ game.getGeneratedFood() + "\n" + "\tSatisfaction globale : "
				+ DECIMAL_FORMAT.format(game.getGeneralApprovalRate()) + "%" + "\tNourriture requise en fin d'année : "
				+ game.getNeededFood() + "\n";
		System.out.println(gameStats);
		printFactions();
	}

	/**
	 * Print on the console the informations related to all factions
	 */
	private void printFactions() {
		StringBuilder factions = new StringBuilder();
		int factionNumber = 1;

		for (Faction faction : game) {
			factions.append("\t" + factionNumber + " - Faction " + faction.getClass().getSimpleName());
			if (!faction.getClass().getSimpleName().equals("Nationalists")) {
				factions.append("\t");
			}
			factions.append("\tSatisfaction : " + DECIMAL_FORMAT.format(faction.getApprovalRate()) + "%"
					+ "\tNombre de partisans : " + faction.getFactionSupporters() + "\tPrix du pot de vin : "
					+ faction.getBribePrice() + "$\n");
			factionNumber++;
		}
		System.out.println(factions.toString());
	}

	/**
	 * Handle the choice of a menu specified by name
	 * @param menu
	 */
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

	/**
	 * Print a menu file
	 * @param fileName
	 * @throws IOException
	 */
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

	/**
	 * Check if the input in the scanner is a numeric value
	 * @return choiceNum 
	 */
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

	/**
	 * Check if the str parameter is numeric
	 * @param str
	 * @return true or false
	 */
	private boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
	

