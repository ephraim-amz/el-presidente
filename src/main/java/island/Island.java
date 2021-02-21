package island;

import java.util.ArrayList;
import factions.Faction;

/**
 * The island where the game is played
 *
 */
public class Island extends ArrayList<Faction> {
	private static final long serialVersionUID = 1L;
	private double industryRate;
	private double agricultureRate;

	/**
	 * Constructor of an island
	 * 
	 * @param industryRate    The industry rate of the island
	 * @param agricultureRate The agriculture rate of the island
	 */
	public Island(double industryRate, double agricultureRate) {
		this.industryRate = industryRate;
		this.agricultureRate = agricultureRate;
	}

	/**
	 * Getter for the agriculture rate of an island.
	 * 
	 * @return agricultureRate
	 */
	public double getAgricultureRate() {
		return agricultureRate;
	}

	/**
	 * Getter for the industry rate of an island.
	 * 
	 * @return industryRate
	 */
	public double getIndustryRate() {
		return industryRate;
	}

}