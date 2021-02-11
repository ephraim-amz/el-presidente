package factions;

public abstract class Faction {
	private float tauxApprobation;
	
	public Faction(float tauxApprobation) {
		this.tauxApprobation = tauxApprobation;
		
	}
	
	public float getTauxApprobation() {
		return tauxApprobation;
	}
}
