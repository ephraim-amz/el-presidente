package game;

import factions.Capitalists;
import factions.Communists;
import factions.Ecologists;
import factions.Faction;
import factions.Liberals;
import factions.Loyalists;
import factions.Militarists;
import factions.Nationalists;
import factions.Religious;
import island.Island;
import menu.Menu;

/**
 * Game class, subclass of Island
 * 
 * @see Island
 */
public class Game extends Island {
	private static final long serialVersionUID = 1L;
	private static final int SPRING = 1;
	private static final int SUMMER = 2;
	private static final int AUTUMN = 3;
	private static final int BASE_APPROVAL = 50;
	private static final int BASE_SUPPORTERS = 15;
	private static final double BASE_INDUSTRY = 0.15;
	private static final double BASE_AGRICULTURE = 0.15;

	private double difficulty;
	private int year;
	private int season;
	private int treasure;
	private int stockedFood;

	/**
	 * Game constructor, set the automatically the defaults values of the Game
	 * fields except the difficulty
	 * 
	 * @param difficulty
	 */
	public Game(double difficulty) {
		super(BASE_INDUSTRY, BASE_AGRICULTURE);
		this.difficulty = difficulty;
		this.year = 1;
		this.season = SPRING;
		this.treasure = 200;
		this.stockedFood = 0;
		addAllFactions();
	}

	/**
	 * Add all the factions in the list of the factions of the game
	 */
	private void addAllFactions() {
		this.add(new Loyalists(BASE_APPROVAL * 2., BASE_SUPPORTERS));
		this.add(new Capitalists(BASE_APPROVAL, BASE_SUPPORTERS));
		this.add(new Communists(BASE_APPROVAL, BASE_SUPPORTERS));
		this.add(new Ecologists(BASE_APPROVAL, BASE_SUPPORTERS));
		this.add(new Liberals(BASE_APPROVAL, BASE_SUPPORTERS));
		this.add(new Militarists(BASE_APPROVAL, BASE_SUPPORTERS));
		this.add(new Nationalists(BASE_APPROVAL, BASE_SUPPORTERS));
		this.add(new Religious(BASE_APPROVAL, BASE_SUPPORTERS));
	}

	/**
	 * Knowing if El Presidente has lost the game or not
	 */
	public boolean isLost() {
		return getGeneralApprovalRate() < getLostRate();
	}

	/**
	 * Set all factions approval rate to 0 if El Presidente renounce at the year
	 */
	public void renounce() {
		for (Faction faction : this) {
			faction.setApprovalRate(0);
		}
	}

	/**
	 * Move to the next season
	 * 
	 * @param menu
	 */
	public void nextSeason(Menu menu) {
		if (season < 4) {
			this.season++;
		} else {
			this.year++;
			this.season = SPRING;
			menu.loadEndOfYearMenu();
			this.endOfYear();
		}
	}

	/**
	 * Buy food if possible
	 * 
	 * @return true or false if the operation is possible
	 */
	public boolean buyFood() {
		if (treasure < 8) {
			return false;
		}
		stockedFood++;
		treasure -= 8;
		return true;
	}

	/**
	 * Bribe a specific faction based on the number of the faction
	 * 
	 * @param factionNumber
	 */
	public void bribeFaction(int factionNumber) {
		int bribePrice = this.getFactionBribePrice(factionNumber);
		treasure -= bribePrice;
		this.get(factionNumber - 1).setApprovalRate(this.get(factionNumber - 1).getApprovalRate() + 10);
		this.get(0).setApprovalRate(this.get(0).getApprovalRate() - bribePrice / 10.);
		if (this.get(factionNumber - 1).getApprovalRate() > 100) {
			this.get(factionNumber - 1).setApprovalRate(100);
		}
	}

	/**
	 * Generate what happens at the end of the year
	 */
	private void endOfYear() {
		int generatedFood = getGeneratedFood();
		int neededFood = getNeededFood();

		if (generatedFood > neededFood) {
			giveBirthPartisants();
		} else if (generatedFood + stockedFood > neededFood) {
			stockedFood -= neededFood - generatedFood;
		} else {
			famishedPartisants(generatedFood + stockedFood, neededFood);
			stockedFood = 0;
		}
		treasure += getGeneratedTreasure();
	}

	/**
	 * Create new partisans
	 */
	private void giveBirthPartisants() {
		int bornedPartisants = getBornPartisants();
		int randomFaction;

		for (int i = 0; i != bornedPartisants; i++) {
			randomFaction = randomFactionPicker();
			this.get(randomFaction).addFactionSupporter();
		}
	}

	/**
	 * Famish partisans based on the food and neededFood parameters
	 * 
	 * @param food
	 * @param neededFood
	 */
	private void famishedPartisants(int food, int neededFood) {
		int famishedPartisants = getFamishedPartisants(food, neededFood);
		int randomFaction;

		for (int i = 0; i != famishedPartisants; i++) {
			randomFaction = randomFactionPicker();
			if (this.get(randomFaction).getFactionSupporters() == 0) {
				i--;
			} else {
				this.get(randomFactionPicker()).removeFactionSupporter();
				deathEffect();
			}
		}
	}

	/**
	 * Apply the death effect on the El Presidente factions
	 */
	private void deathEffect() {
		for (Faction faction : this) {
			if (faction.getApprovalRate() > 0) {
				faction.setApprovalRate(faction.getApprovalRate() - 2);
			}
			if (faction.getApprovalRate() < 0) {
				faction.setApprovalRate(0);
			}
		}
	}

	/**
	 * Select a random faction
	 * 
	 * @return The faction selected
	 */
	private int randomFactionPicker() {
		return (int) ((Math.random() * (7 + 0)) + 0);
	}

	/**
	 * Calculate the number of born patisans
	 * 
	 * @return the number of the born partisans
	 */
	private int getBornPartisants() {
		return (int) ((Math.random() * (this.getTotalSupporters() * 0.1 - this.getTotalSupporters() * 0.01))
				+ this.getTotalSupporters() * 0.01);
	}

	/**
	 * Calculate the number of the famished partisans
	 * 
	 * @param food
	 * @param neededFood
	 * @return the number of the famished partisans
	 */
	private int getFamishedPartisants(int food, int neededFood) {
		return (neededFood - food) / 4;
	}

	/**
	 * Generate the treasure the end of year
	 * 
	 * @return generatedTreasure
	 */
	public int getGeneratedTreasure() {
		double generatedTreasure = 10 * 100 * this.getIndustryRate();
		return (int) generatedTreasure;
	}

	/**
	 * Get the bribe price of a specific faction
	 * 
	 * @param factionNumber
	 * @returnThe bribe price of the faction selected
	 */
	public int getFactionBribePrice(int factionNumber) {
		return this.get(factionNumber - 1).getBribePrice();
	}

	/**
	 * Calculate the generated food at the end the year
	 * 
	 * @return The generated food
	 */
	public int getGeneratedFood() {
		double generatedFood = 40 * 100 * this.getAgricultureRate();
		return (int) generatedFood;
	}

	/**
	 * Get the needed food
	 * 
	 * @return The needed food
	 */
	public int getNeededFood() {
		return this.getTotalSupporters() * 4;
	}

	/**
	 * Calculate the approval rate of all the factions
	 * 
	 * @return the ratio of all approval rate
	 */
	public double getGeneralApprovalRate() {
		double generalApprovalRate = 1;

		for (Faction faction : this) {
			generalApprovalRate = generalApprovalRate + faction.getApprovalRate() * faction.getFactionSupporters();
		}
		return generalApprovalRate / this.getTotalSupporters();
	}

	/**
	 * Get the sum of all El Presidente supporters in all factions
	 * 
	 * @return totalSupporters
	 */
	private int getTotalSupporters() {
		int totalSupporters = 0;

		for (Faction faction : this) {
			totalSupporters += faction.getFactionSupporters();
		}
		return totalSupporters;
	}

	/**
	 * Getter for the year
	 * 
	 * @return year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Getter for the difficulty of the game
	 * 
	 * @return difficulty
	 */
	public double getDifficulty() {
		return difficulty;
	}

	/**
	 * Getter for the lost rate based on the difficulty of the game
	 */
	public double getLostRate() {
		return 25. * difficulty;
	}

	/**
	 * Getter for the treasure
	 * 
	 * @return treasure
	 */
	public int getTreasure() {
		return treasure;
	}

	/**
	 * Getter for the stocked food
	 * 
	 * @return
	 */
	public int getStockedFood() {
		return stockedFood;
	}

	/**
	 * Getter for the season name
	 * 
	 * @return the season name
	 */
	public String getSeasonName() {
		if (season == SPRING) {
			return "Printemps";
		} else if (season == SUMMER) {
			return "Été";
		} else if (season == AUTUMN) {
			return "Automne";
		} else {
			return "Hiver";
		}
	}
}
