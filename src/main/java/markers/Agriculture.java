package markers;

import island.Island;

public class Agriculture extends Marker{
	private int foodUnits;
	
	public Agriculture(float markerRate,int foodUnits) {
		super(markerRate);
		this.foodUnits = foodUnits;
	}

	@Override
	public double moneyGenerator(Island island) {
		return island.getAgricultureRate() * 40.;
	}
	
	public int getFoodUnits() {
		return foodUnits;
	}
}
