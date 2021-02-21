package markers;

import island.Island;

/**
 * Treasury class, subclass of DefaultMarker
 * 
 * @see DefaultMarker
 */
public class Treasury extends DefaultMarker{
	private float currentTreasury;

	/**
	 * Constructor of the treasury of an island
	 * @param markerRate
	 * @param currentTreasury
	 */
	public Treasury(float markerRate,float currentTreasury) {
		super(markerRate);
		this.currentTreasury = currentTreasury;
	}

	/**
	 * Getter for the currentTreasury
	 * @return currentTreasury
	 */
	public float getTreasury() {
		return currentTreasury;
	}

	@Override
	public double moneyGenerator(Island island) {
		return 0;
	}
	
}
