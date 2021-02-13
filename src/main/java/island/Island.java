package island;

import java.util.List;

import factions.Faction;

public class Island {
	private List<Faction> factions;
	private double industryRate;
	private double agricultureRate;

	public Island(List<Faction> factions, double industrie, double agriculture) {
		this.factions = factions;
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
