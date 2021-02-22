package events;
import game.Game;

public class ApplyEffect {
	/**
	 * Applying effect on factions and treasury
	 */
	public ApplyEffect(int choice, Game game)
    {
		if (choice == 1) {
			game.get(7).setApprovalRate(game.get(7).getApprovalRate()*(0.75));
			game.get(4).setApprovalRate(game.get(4).getApprovalRate()*(0.75));
			game.get(1).setApprovalRate(game.get(1).getApprovalRate()*(0.75));
			game.get(0).setApprovalRate(game.get(0).getApprovalRate()+(game.get(0).getApprovalRate()*(0.10)));
			game.get(2).setApprovalRate(game.get(2).getApprovalRate()+(game.get(2).getApprovalRate()*(0.10)));
		}
		if (choice == 2) {
			game.get(7).setApprovalRate(game.get(7).getApprovalRate()+(game.get(7).getApprovalRate()*(0.10)));
			game.get(4).setApprovalRate(game.get(4).getApprovalRate()*(0.70));
			game.get(1).setApprovalRate(game.get(1).getApprovalRate()*(0.70));
			game.get(0).setApprovalRate(game.get(0).getApprovalRate()+(game.get(0).getApprovalRate()*(0.10)));
			game.get(2).setApprovalRate(game.get(2).getApprovalRate()+(game.get(2).getApprovalRate()*(0.10)));
			game.get(6).setApprovalRate(game.get(6).getApprovalRate()+(game.get(6).getApprovalRate()*(0.10)));
			
		}
		if (choice == 3) {
			game.get(4).setApprovalRate(game.get(4).getApprovalRate()+(game.get(4).getApprovalRate()*(0.10)));
			game.get(1).setApprovalRate(game.get(1).getApprovalRate()+(game.get(1).getApprovalRate()*(0.10)));
			game.get(0).setApprovalRate(game.get(0).getApprovalRate()*(0.60));
			game.get(2).setApprovalRate(game.get(2).getApprovalRate()*(0.60));
			game.get(6).setApprovalRate(game.get(6).getApprovalRate()+(game.get(6).getApprovalRate()*(0.10)));
			game.get(3).setApprovalRate(game.get(3).getApprovalRate()*(0.60));
			game.get(7).setApprovalRate(game.get(7).getApprovalRate()*(0.60));
			game.get(5).setApprovalRate(game.get(5).getApprovalRate()*(0.60));
			game.setTreasure(game.getTreasure()+100);
		}
		if (choice == 4) {
			game.get(7).setApprovalRate(game.get(7).getApprovalRate()*(0.65));
			game.get(3).setApprovalRate(game.get(3).getApprovalRate()*(0.65));
			game.get(5).setApprovalRate(game.get(5).getApprovalRate()*(0.65));
			game.get(4).setApprovalRate(game.get(4).getApprovalRate()+(game.get(0).getApprovalRate()*(0.10)));
			game.get(1).setApprovalRate(game.get(1).getApprovalRate()+(game.get(0).getApprovalRate()*(0.10)));
			game.setTreasure(game.getTreasure()+100);
		}
    }
}
