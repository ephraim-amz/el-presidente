package factions;

/**
 * Capitalists faction, subclass of Faction
 * 
 * @see Faction
 */
public class Capitalists extends Faction {

	/**
	 * Capitalists faction constructor, based on the superclass constructor.
	 * 
	 * @param approvalRate
	 * @param factionSupporters
	 * @see Faction
	 */
	public Capitalists(double approvalRate, int factionSupporters) {
		super(approvalRate, factionSupporters);
	}

}