package menus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private static final String DOSSIER_MENU = "textes/menus/";
	private static final String MENU_PRINCIPAL = DOSSIER_MENU.concat("menuprincipal.txt");

	private Scanner scanner;
	
	public Menu() {
		this.scanner = new Scanner(System.in);
	}
	
	public void chargerMenuPrincipal() {
		int choix = 0;

		while (choix < 1 || choix > 3) {
			choix = scannerChoixMenu(MENU_PRINCIPAL);
			if (choix == 1) {
				System.out.println("Choix 1");
				quitterPartie();
			} else if (choix == 2) {
				System.out.println("Choix 2");
				quitterPartie();
			} else if (choix == 3) {
				quitterPartie();
			} else {
				System.out.println("Le numéro choisi ne fait pas partie des choix possibles!");
			}
		}
	}
	
	private void quitterPartie() {
		System.out.println("A bientôt Presidente!");
		System.exit(0);
	}

	private void lireMenu(String nomFichier) throws IOException {
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(nomFichier, StandardCharsets.ISO_8859_1));
			String line;
			while ((line = bf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("Le fichier " + nomFichier + " n'a pas pu être lu car " + e.getCause());
		} finally {
			if (bf != null) {
				bf.close();
			}
		}
	}

	private String scannerString(String question) {
		System.out.println(question);
		return scanner.nextLine();
	}
	
	private int scannerChoixMenu(String menu) {
		int choix = 0;
		
		try {
			lireMenu(menu);
			choix = scannerNumerique();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return choix;
	}
	
	private int scannerNumerique() {
		String choix = "";
		int numChoix = 0;
		
		while (!this.isNumeric(choix)) {
			choix = scanner.nextLine();
			if (!this.isNumeric(choix)) {
				System.out.println("Ce choix n'est pas un nombre!");
			} else {
				numChoix = Integer.parseInt(choix);
			}
		}
		return numChoix;
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
