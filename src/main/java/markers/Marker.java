package markers;

import exceptions.CumulException;
import island.Island;

public abstract class Marker {
	private float markerRate;

	public Marker(float markerRate) {
		this.markerRate = markerRate;
	}

	public float getMarkerRate() {
		return markerRate;
	}

	public float markerAggregation(Marker m2) throws CumulException {
		float aggregation = this.markerRate + m2.markerRate;
		if (aggregation > 100.) {
			throw new CumulException("The aggregation between the marker " + this + " and the marker " +
		 m2 + " is not possible.");
		}
		
		return aggregation;
	}
	
	public abstract double moneyGenerator(Island island);
}
