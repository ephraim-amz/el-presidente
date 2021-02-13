package factions;

public abstract class Faction {
	private float approvalRate;
	
	public Faction(float approvalRate) {
		this.approvalRate = approvalRate;
		
	}
	
	public float getTauxApprobation() {
		return approvalRate;
	}

}
