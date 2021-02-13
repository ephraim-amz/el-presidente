package main;

import java.util.ArrayList;
import java.util.List;

import factions.Capitalists;
import factions.Communists;
import factions.Ecologists;
import factions.Faction;
import factions.Liberals;
import factions.Loyalists;
import factions.Militarists;
import factions.Nationalists;
import factions.Religious;
import island.Island;
import markers.Treasury;

public class Application {

	public static void main(String[] args) {
		String mode = args[0];
		String dificulty = args[1];
		List<Faction> factions = new ArrayList<>();
		int factionSupporters;
		double approvalRate;
		double loyalistsApprovalRate;
		if (mode.equals("bac à sable")) {
			factionSupporters = 15;
			approvalRate = 0.5;
			loyalistsApprovalRate = 1.;
			factions.add(new Capitalists(approvalRate, factionSupporters));
			factions.add(new Communists(approvalRate, factionSupporters));
			factions.add(new Ecologists(approvalRate, factionSupporters));
			factions.add(new Liberals(approvalRate, factionSupporters));
			factions.add(new Loyalists(loyalistsApprovalRate, factionSupporters));
			factions.add(new Militarists(approvalRate, factionSupporters));
			factions.add(new Nationalists(approvalRate, factionSupporters));
			factions.add(new Religious(approvalRate, factionSupporters));
			Treasury treasury = new Treasury(200,100);
			Island island = new Island(factions, 15., 15.);
		}
	}

}
