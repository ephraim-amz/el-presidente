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
		int factionSupporters;
		double approvalRate;
		double loyalistsApprovalRate;
		if (mode.equals("bac à sable")) {
			factionSupporters = 15;
			approvalRate = 0.5;
			loyalistsApprovalRate = 1.;
			Treasury treasury = new Treasury(200,100);
			
			Island island = new Island(15., 15.);
			island.add(new Capitalists(approvalRate, factionSupporters));
			island.add(new Communists(approvalRate, factionSupporters));
			island.add(new Ecologists(approvalRate, factionSupporters));
			island.add(new Liberals(approvalRate, factionSupporters));
			island.add(new Loyalists(loyalistsApprovalRate, factionSupporters));
			island.add(new Militarists(approvalRate, factionSupporters));
			island.add(new Nationalists(approvalRate, factionSupporters));
			island.add(new Religious(approvalRate, factionSupporters));
		}
	}

}
