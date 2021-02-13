package markers;

import island.Island;

public class Treasury extends Marker{
	private float currentTreasury;

	public Treasury(float markerRate,float currentTreasury) {
		super(markerRate);
		this.currentTreasury = currentTreasury;
	}

	public float getTreasury() {
		return currentTreasury;
	}

	@Override
	public double moneyGenerator(Island island) {
		return 0;
	}
	
}
