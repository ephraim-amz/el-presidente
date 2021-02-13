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

}