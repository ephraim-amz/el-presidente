package markers;

import exceptions.AccumulationException;
import island.Island;

public abstract class Marker {
	private float markerRate;

	public Marker(float markerRate) {
		this.markerRate = markerRate;
	}

	public float getMarkerRate() {
		return markerRate;
	}

	public float markerAccumulation(Marker m2) throws AccumulationException {
		float aggregation = this.markerRate + m2.markerRate;
		if (aggregation > 1.) {
			throw new AccumulationException("The aggregation between the marker " + this + " and the marker " +
		 m2 + " is not possible.");
		}
		
		return aggregation;
	}
	
	public abstract double moneyGenerator(Island island);
}
