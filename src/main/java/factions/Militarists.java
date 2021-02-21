package factions;

/**
 * Militarists faction, subclass of Faction
 * 
 * @see Faction
 */
public class Militarists extends Faction {

	/**
	 * Militarists constructor, based on the superclass constructor
	 * 
	 * @param approvalRate
	 * @param factionSupporters
	 * @see Faction
	 */
	public Militarists(double approvalRate, int factionSupporters) {
		super(approvalRate, factionSupporters);
	}

}