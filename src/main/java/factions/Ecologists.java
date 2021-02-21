package factions;

/**
 * Ecologists faction, subclass of Faction
 * 
 * @see Faction
 */
public class Ecologists extends Faction {

	/**
	 * Ecologists constructor, based on the superclass constructor
	 * 
	 * @param approvalRate
	 * @param factionSupporters
	 * @see Faction
	 */
	public Ecologists(double approvalRate, int factionSupporters) {
		super(approvalRate, factionSupporters);
	}

}