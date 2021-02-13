package markers;

public class Industry extends Marker{
	
	public Industry(float industryRate) {
		super(industryRate);
	}
	
	public float moneyGenerator() {
		return super.getMarkerRate() * 40;
	}
	
}
