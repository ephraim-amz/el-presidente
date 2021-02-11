package marqueurs;

public class Agriculture extends Marqueur{
	private int unitesNourriture;
	
	public Agriculture(float tauxMarqueur,int unitesNourriture) {
		super(tauxMarqueur);
		this.unitesNourriture = unitesNourriture;
	}
}
