package factions;

/**
 * Nationalists faction, subclass of Faction
 * 
 * @see Faction
 */
public class Nationalists extends Faction {

	/**
	 * Nationalists constructor, based on the superclass constructor
	 * 
	 * @param approvalRate
	 * @param factionSupporters
	 * @see Faction
	 */
	public Nationalists(double approvalRate, int factionSupporters) {
		super(approvalRate, factionSupporters);
	}

}