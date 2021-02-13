package markers;

public class Agriculture extends Marker{
	private int foodUnits;
	
	public Agriculture(float markerRate,int foodUnits) {
		super(markerRate);
		this.foodUnits = foodUnits;
	}
}
