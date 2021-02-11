package marqueurs;

public class Industrie extends Marqueur{
	
	public Industrie(float tauxIndustrie) {
		super(tauxIndustrie);
	}
	
	public float genererArgent() {
		return super.getTauxMarqueur() * 40;
	}
	
}
