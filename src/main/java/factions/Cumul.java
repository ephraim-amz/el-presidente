package factions;

public class Cumul {
	private Faction f1;
	private Faction f2;
	
	public Cumul(Faction f1,Faction f2) {
		this.f1 = f1;
		this.f2 = f2;
	}
	
	public boolean cumul(Faction f1,Faction f2) {
		return f1.getTauxApprobation() + f2.getTauxApprobation() <= 100.;
	}
}
