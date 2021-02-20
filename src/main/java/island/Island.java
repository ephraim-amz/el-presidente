package island;

import java.util.ArrayList;
import factions.Faction;

public class Island extends ArrayList<Faction> {
	private static final long serialVersionUID = 1L;
	private double industryRate;
	private double agricultureRate;

	public Island(double industryRate, double agricultureRate) {
		this.industryRate = industryRate;
		this.agricultureRate = agricultureRate;
	}

	public double getAgricultureRate() {
		return agricultureRate;
	}

	public double getIndustryRate() {
		return industryRate;
	}

	public void setIndustryRate(double industryRate) {
		this.industryRate = industryRate;
	}

	public void setAgricultureRate(double agricultureRate) {
		this.agricultureRate = agricultureRate;
	}
}
