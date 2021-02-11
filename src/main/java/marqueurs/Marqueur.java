package marqueurs;

public abstract class Marqueur {
	private float tauxMarqueur;
	
	public Marqueur(float tauxMarqueur) {
		this.tauxMarqueur = tauxMarqueur;
	}
	
	public float getTauxMarqueur() {
		return tauxMarqueur;
	}
	
}
