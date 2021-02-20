package markers;

import exceptions.AccumulationException;
import island.Island;

public interface Marker {

	float markerAccumulation(DefaultMarker m2) throws AccumulationException;
	
	double moneyGenerator(Island island);
}
