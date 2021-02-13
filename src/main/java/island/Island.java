package island;
import java.util.ArrayList;

import factions.Faction;
import markers.Marker;

public class Island {
	private ArrayList<Faction> factions;
	private Marker industry;
	private Marker agriculture;
	
	public Island(ArrayList<Faction> factions, Marker industrie, Marker agriculture) {
		this.factions = factions;
		this.industry = industrie;
		this.agriculture = agriculture;
	}
	
	
	
	
}
