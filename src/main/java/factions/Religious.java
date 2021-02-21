package factions;

/**
 * Religious faction, subclass of Faction 
 * @see Faction
 */
public class Religious extends Faction {

	/**
	 * Religious constructor, based on the superclass constructor
	 * 
	 * @param approvalRate
	 * @param factionSupporters
	 * @see Faction
	 */
	public Religious(double approvalRate, int factionSupporters) {
		super(approvalRate, factionSupporters);
	}

}