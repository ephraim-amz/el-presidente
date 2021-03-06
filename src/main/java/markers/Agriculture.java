package markers;

import island.Island;

/**
 * Agriculture class, subclass of DefaultMarker
 * 
 * @see DefaultMarker
 */
public class Agriculture extends DefaultMarker {
	private int foodUnits;

	/**
	 * Agriculture constructor, based on the superclass constructor
	 * 
	 * @param agricultureRate
	 * @param foodUnits
	 * @see DefaultMarker
	 */
	public Agriculture(float agricultureRate, int foodUnits) {
		super(agricultureRate);
		this.foodUnits = foodUnits;
	}

	/**
	 * This method generate the number of food units at the end of each year
	 * 
	 * @param island
	 * @return The number of food units generated
	 * @author Ephraim
	 */
	@Override
	public double moneyGenerator(Island island) {
		return island.getAgricultureRate() * 40.;
	}

	/**
	 * Getter for the foods units
	 * 
	 * @return foodUnits
	 */
	public int getFoodUnits() {
		return foodUnits;
	}
}
