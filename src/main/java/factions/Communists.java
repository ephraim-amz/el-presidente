package factions;

/**
 * Communists faction, subclass of Faction
 * 
 * @see Faction
 */
public class Communists extends Faction {

	/**
	 * Communists faction constructor, based on the superclass constructor.
	 * 
	 * @param approvalRate
	 * @param factionSupporters
	 * @see Faction
	 */
	public Communists(double approvalRate, int factionSupporters) {
		super(approvalRate, factionSupporters);
	}

}