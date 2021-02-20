package markers;

import island.Island;

public class Agriculture extends DefaultMarker{
	private int foodUnits;
	
	public Agriculture(float agricultureRate,int foodUnits) {
		super(agricultureRate);
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
