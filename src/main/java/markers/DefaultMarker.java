package markers;

import exceptions.AccumulationException;

/**
 * DefaultMarker, superclass of all markers
 */
public abstract class DefaultMarker implements Marker{
	private float markerRate;

	/**
	 * Constructor of the default marker 
	 * @param markerRate
	 */
	public DefaultMarker(float markerRate) {
		this.markerRate = markerRate;
	}

	/**
	 * Getter for the marker rate
	 * @return markerRate
	 */
	public float getMarkerRate() {
		return markerRate;
	}

	@Override
	public float markerAccumulation(DefaultMarker m2) throws AccumulationException {
		float aggregation = this.markerRate + m2.markerRate;
		if (aggregation > 1.) {
			throw new AccumulationException("The aggregation between the marker " + this + " and the marker " +
		 m2 + " is not possible.");
		}
		
		return aggregation;
	}
	
}
