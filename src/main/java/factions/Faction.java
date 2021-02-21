package factions;

public abstract class Faction {
	private double approvalRate;
	private int factionSupporters;
	
	public Faction(double approvalRate,int factionSupporters) {
		this.approvalRate = approvalRate;
		this.factionSupporters = factionSupporters;
	}
	
	public double getApprovalRate() {
		return approvalRate;
	}
	
	public int getFactionSupporters() {
		return factionSupporters;
	}
	
	public int getBribePrice() {
		return factionSupporters * 15;
	}

	public void setApprovalRate(double approvalRate) {
		if (this.approvalRate != 0) {
			this.approvalRate = approvalRate;
		}
	}

	public void setFactionSupporters(int factionSupporters) {
		this.factionSupporters = factionSupporters;
	}
	
	public void addFactionSupporter() {
		this.factionSupporters += 1;
	}
	
	public void removeFactionSupporter() {
		this.factionSupporters -= 1;
	}
}