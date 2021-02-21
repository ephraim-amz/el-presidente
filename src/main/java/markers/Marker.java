package markers;

import exceptions.AccumulationException;
import island.Island;

/**
 * Marker interface, contains the methods needed in each marker
 *
 */
public interface Marker {

	/**
	 * This method calculate the sum between two markers
	 * 
	 * @param m2
	 * @return The sum between two markers
	 * @throws AccumulationException
	 */
	float markerAccumulation(DefaultMarker m2) throws AccumulationException;

	double moneyGenerator(Island island);
}
