package island;

import java.util.ArrayList;
import java.util.List;

import factions.Faction;

public class Island extends ArrayList<Faction> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double industryRate;
	private double agricultureRate;

	public Island(double industrie, double agriculture) {
		this.industryRate = industrie;
		this.agricultureRate = agriculture;
	}

	public double getAgricultureRate() {
		return agricultureRate;
	}

	public double getIndustryRate() {
		return industryRate;
	}

}
