package markers;

import island.Island;

public class Industry extends DefaultMarker{
	
	public Industry(float industryRate) {
		super(industryRate);
	}
	
	@Override
	public double moneyGenerator(Island island) {
		return island.getIndustryRate() * 10.;
	}
	
	
	
}
