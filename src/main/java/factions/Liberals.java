package factions;

/**
 * Liberals faction, subclass of Faction
 * 
 * @see Faction
 */
public class Liberals extends Faction {

	/**
	 * Liberals constructor, based on the superclass constructor
	 * 
	 * @param approvalRate
	 * @param factionSupporters
	 * @see Faction
	 */
	public Liberals(double approvalRate, int factionSupporters) {
		super(approvalRate, factionSupporters);
	}

}