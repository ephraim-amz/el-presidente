package marqueurs;

import exceptions.CumulException;

public abstract class Marqueur {
	private float tauxMarqueur;

	public Marqueur(float tauxMarqueur) {
		this.tauxMarqueur = tauxMarqueur;
	}

	public float getTauxMarqueur() {
		return tauxMarqueur;
	}

	public float cumul(Marqueur m2) throws CumulException {
		float cumul = this.tauxMarqueur + m2.tauxMarqueur;
		if (cumul > 100.) {
			throw new CumulException("Le cumul entre le marqueur " + this + " et le marqueur " +
		 m2 + " n'est pas possible.");
		}
		
		return cumul;
	}

}
