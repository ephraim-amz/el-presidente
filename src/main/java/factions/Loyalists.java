package factions;

/**
 * Loyalists faction, subclass of Faction
 * 
 * @see Faction
 */
public class Loyalists extends Faction {

	/**
	 * Loyalists constructor, based on the superclass constructor
	 * 
	 * @param approvalRate
	 * @param factionSupporters
	 * @see Faction
	 */
	public Loyalists(double approvalRate, int factionSupporters) {
		super(approvalRate, factionSupporters);
	}

}