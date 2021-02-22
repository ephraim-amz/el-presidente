package factions;

/**
 * Faction class, superclass of all the factions present on the island
 *
 */
public abstract class Faction {
	private double approvalRate;
	private int factionSupporters;

	/**
	 * Constructor of a faction, initialize the approval and the number of
	 * supporters of this faction
	 * 
	 * @param approvalRate
	 * @param factionSupporters
	 */
	public Faction(double approvalRate, int factionSupporters) {
		this.approvalRate = approvalRate;
		this.factionSupporters = factionSupporters;
	}

	/**
	 * Getter for the approval rate of the faction
	 * @return approvalRate
	 */
	public double getApprovalRate() {
		return approvalRate;
	}

	/**
	 * Getter for the faction supporters of the faction
	 * @return factionSupporters
	 */
	public int getFactionSupporters() {
		return factionSupporters;
	}

	/**
	 * Getter for the bribe price of the faction
	 * @return the bribe price
	 */
	public int getBribePrice() {
		return factionSupporters * 15;
	}

	/**
	 * Setter for the approval rate of the faction
	 */
	public void setApprovalRate(double approvalRate) {
		if (this.approvalRate != 0) {
			this.approvalRate = approvalRate;
			if (this.approvalRate > 100) {
				this.setApprovalRate(100);
			}
		}
		
	}

	/**
	 * Setter for the faction supporters of the faction
	 */
	public void setFactionSupporters(int factionSupporters) {
		this.factionSupporters = factionSupporters;
	}

	/**
	 * Increment the current faction supporters
	 */
	public void addFactionSupporter() {
		this.factionSupporters += 1;
	}

	/**
	 * Decrement the current faction supporters
	 */
	public void removeFactionSupporter() {
		this.factionSupporters -= 1;
	}
}