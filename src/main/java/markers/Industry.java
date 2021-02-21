package markers;

import island.Island;

/**
 * Industry class, subclass of DefaultMarker
 * 
 * @see DefaultMarker
 */
public class Industry extends DefaultMarker {

	/**
	 * Industry constructor, based on the superclass constructor
	 * 
	 * @param industryRate
	 * @see DefaultMarker
	 */
	public Industry(float industryRate) {
		super(industryRate);
	}

	@Override
	public double moneyGenerator(Island island) {
		return island.getIndustryRate() * 10.;
	}

}
