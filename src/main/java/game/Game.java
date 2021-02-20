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
	
	public Game(double difficulty) {
		super(BASE_INDUSTRY, BASE_AGRICULTURE);
		this.difficulty = difficulty;
		this.year = 1;
		this.season = SPRING;
		this.treasure = 50;
		addAllFactions();
	}
	
	private void addAllFactions() {
		this.add(new Loyalists(BASE_APPROVAL * 2, BASE_SUPPORTERS));
		this.add(new Capitalists(BASE_APPROVAL, BASE_SUPPORTERS));
		this.add(new Communists(BASE_APPROVAL, BASE_SUPPORTERS));
		this.add(new Ecologists(BASE_APPROVAL, BASE_SUPPORTERS));
		this.add(new Liberals(BASE_APPROVAL, BASE_SUPPORTERS));
		this.add(new Militarists(BASE_APPROVAL, BASE_SUPPORTERS));
		this.add(new Nationalists(BASE_APPROVAL, BASE_SUPPORTERS));
		this.add(new Religious(BASE_APPROVAL, BASE_SUPPORTERS));
	}
	
	public int getYear() {
		return year;
	}
	
	public double getDifficulty() {
		return difficulty;
	}
	
	public int getTreasure() {
		return treasure;
	}

	public void setTreasure(int treasure) {
		this.treasure = treasure;
	}
	
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
	
	public void nextSeason() {
		if (season < 4) {
			this.season = season + 1;
		} else {
			this.year = this.year + 1;
			this.season = SPRING;
		}
	}
	
	public boolean isLost() {
		return getGeneralApprovalRate() < 0.25;
	}
	
	public double getGeneralApprovalRate() {
		double generalApprovalRate = 1;
		double totalSupporters = 0;

		for (Faction faction : this) {
			generalApprovalRate = generalApprovalRate + faction.getApprovalRate() * faction.getFactionSupporters();
			totalSupporters += faction.getFactionSupporters();
		}
		return generalApprovalRate / totalSupporters;
	}
}
