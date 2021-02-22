package events;

import java.util.Arrays;
import java.util.Random;

public class Events {
	private String[] events = { "L�URSS fait une demande d�alliance, que r�pondez-vous ?\n",
			"Un ouragan va frapper l��le ! Sauvons El Presidente !\n",
			"Une p�riode de s�cheresse frappe l��le, que comptez-vous faire El Presidente ?\n",
			"L�Organisation des Cara�bes-Unies souhaite que vous accueilliez des r�fugi�s climatiques suite aux r�centes inondations dans la r�gion\n",
			"Pas de chance, le froid polaire touche l��le, la population souffre.\n",
			"Vous avez d�couvert un gisement d�or ! Que faire ?\n",
			"Urgence ! Des ennemis sont entr�s dans votre �le !\n",
			"Un conflit �clate entre les religieux et les capitalistes, comment comptez-vous agir ?\n"};
	private String[] choice1 = {
			"1 � D�cliner poliment au motif que vous n�avez pas les infrastructures pour eux. Effets : +10% de satisfaction des loyalistes, +10% de satisfaction des communistes,-25% de satisfaction des religieux, -25% de satisfaction des lib�raux, -25% de satisfaction des capitalistes",
			"1 � Laisser le temps faire. Effets : +10% de satisfaction des loyalistes, +10% de satisfaction des communistes,-25% de satisfaction des religieux, -25% de satisfaction des lib�raux, -25% de satisfaction des capitalistes",
			"1 � Laisser le temps faire. Effets : +10% de satisfaction des loyalistes, +10% de satisfaction des communistes,-25% de satisfaction des religieux, -25% de satisfaction des lib�raux, -25% de satisfaction des capitalistes",
			"1 � D�cliner poliment au motif que vous n�avez pas les ressources n�cessaires. Effets : +10% de satisfaction des loyalistes, +10% de satisfaction des communistes,-25% de satisfaction des religieux, -25% de satisfaction des lib�raux, -25% de satisfaction des capitalistes",
			"1 � Laisser le temps faire. Effets : +10% de satisfaction des loyalistes, +10% de satisfaction des communistes,-25% de satisfaction des religieux, -25% de satisfaction des lib�raux, -25% de satisfaction des capitalistes",
			"1 � R�quisitionner les extractions. Effets : +10% de satisfaction des loyalistes, +10% de satisfaction des communistes,-25% de satisfaction des religieux, -25% de satisfaction des lib�raux, -25% de satisfaction des capitalistes",
			"1 � Se r�fugier et attendre que �a ce calme. Effets : +10% de satisfaction des loyalistes, +10% de satisfaction des communistes,-25% de satisfaction des religieux, -25% de satisfaction des lib�raux, -25% de satisfaction des capitalistes",
			"1 � Vous avez d'autres affaires � mener, laisser passer. Effets : +10% de satisfaction des loyalistes, +10% de satisfaction des communistes,-25% de satisfaction des religieux, -25% de satisfaction des lib�raux, -25% de satisfaction des capitalistes"};
	private String[] choice2 = {
			"2 � D�cliner au motif qu�ils ne sont pas du m�me culte que vous. Effets : +10% de satisfaction des religieux, +10% de satisfaction des loyalistes, +10% de satisfaction des communistes, +10% de satisfaction des nationalistes,-30% de satisfaction des lib�raux, -30% de satisfaction des capitalistes",
			"2 � Mettre en place un plan d��vacuation. Effets : +10% de satisfaction des religieux, +10% de satisfaction des loyalistes, +10% de satisfaction des communistes, +10% de satisfaction des nationalistes,-30% de satisfaction des lib�raux, -30% de satisfaction des capitalistes",
			"2 � Aidez les agriculteurs. Effets : +10% de satisfaction des religieux, +10% de satisfaction des loyalistes, +10% de satisfaction des communistes, +10% de satisfaction des nationalistes,-30% de satisfaction des lib�raux, -30% de satisfaction des capitalistes",
			"2 � D�cliner au motif qu�ils ne sont pas du m�me culte que vous. Effets : +10% de satisfaction des religieux, +10% de satisfaction des loyalistes, +10% de satisfaction des communistes, +10% de satisfaction des nationalistes,-30% de satisfaction des lib�raux, -30% de satisfaction des capitalistes",
			"2 � Faire des offrandes, et rassurer le peuple. Effets : +10% de satisfaction des religieux, +10% de satisfaction des loyalistes, +10% de satisfaction des communistes, +10% de satisfaction des nationalistes,-30% de satisfaction des lib�raux, -30% de satisfaction des capitalistes",
			"2 � Utilisons-le pour am�liorer le bien-�tre des citoyens ! Effets : +10% de satisfaction des religieux, +10% de satisfaction des loyalistes, +10% de satisfaction des communistes, +10% de satisfaction des nationalistes,-30% de satisfaction des lib�raux, -30% de satisfaction des capitalistes",
			"2 � Prot�ger le peuple et les cultes. Effets : +10% de satisfaction des religieux, +10% de satisfaction des loyalistes, +10% de satisfaction des communistes, +10% de satisfaction des nationalistes,-30% de satisfaction des lib�raux, -30% de satisfaction des capitalistes",
			"2 � Faire un discours de tr�ve. Effets : +10% de satisfaction des religieux, +10% de satisfaction des loyalistes, +10% de satisfaction des communistes, +10% de satisfaction des nationalistes,-30% de satisfaction des lib�raux, -30% de satisfaction des capitalistes"};
	private String[] choice3 = {
			"3 � Accepter sans condition. Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des communistes, -40% de satisfaction des loyalistes, -40% de satisfaction des militaristes, -40% de satisfaction des �cologistes, -40% de satisfaction des religieux",
			"3 � Demander de l�aide aux pays voisins. Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des communistes, -40% de satisfaction des loyalistes, -40% de satisfaction des militaristes, -40% de satisfaction des �cologistes, -40% de satisfaction des religieux",
			"3 � Augmenter le prix des cultures. Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des communistes, -40% de satisfaction des loyalistes, -40% de satisfaction des militaristes, -40% de satisfaction des �cologistes, -40% de satisfaction des religieux",
			"3 � Accepter sans condition. Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des communistes, -40% de satisfaction des loyalistes, -40% de satisfaction des militaristes, -40% de satisfaction des �cologistes, -40% de satisfaction des religieux",
			"3 � Demander de l'aider et r�fugier les plus vuln�rables dans les pays voisins. Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des communistes, -40% de satisfaction des loyalistes, -40% de satisfaction des militaristes, -40% de satisfaction des �cologistes, -40% de satisfaction des religieux",
			"3 � Exploitons-le au maximum pour moderniser le pays ! Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des communistes, -40% de satisfaction des loyalistes, -40% de satisfaction des militaristes, -40% de satisfaction des �cologistes, -40% de satisfaction des religieux",
			"3 � Attaquer et piller les ennemies. Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des communistes, -40% de satisfaction des loyalistes, -40% de satisfaction des militaristes, -40% de satisfaction des �cologistes, -40% de satisfaction des religieux",
			"3 � Faire un discour de terreur. Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des communistes, -40% de satisfaction des loyalistes, -40% de satisfaction des militaristes, -40% de satisfaction des �cologistes, -40% de satisfaction des religieux"};
	private String[] choice4 = {
			"4 � Accepter sous condition d�aide financi�re de la part de l�OCU. Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des militaristes, -35% de satisfaction des �cologistes, -35% de satisfaction des religieux",
			"4 � Evacuer ceux qui payent. Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des militaristes, -35% de satisfaction des �cologistes, -35% de satisfaction des religieux",
			"4 � S'approvisionner pour sa r�s�rve personnelle. Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des militaristes, -35% de satisfaction des �cologistes, -35% de satisfaction des religieux",
			"4 � Accepter sous condition d�aide financi�re de la part de l�URSS. Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des militaristes, -35% de satisfaction des �cologistes, -35% de satisfaction des religieux",
			"4 � Demander de l'aide et se soumettre aux contraintes. Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des militaristes, -35% de satisfaction des �cologistes, -35% de satisfaction des religieux",
			"4 � Exploiter et d�velopper un march� d'or. Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des militaristes, -35% de satisfaction des �cologistes, -35% de satisfaction des religieux",
			"4 � Les prendre en guet-apens et pillez. Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des militaristes, -35% de satisfaction des �cologistes, -35% de satisfaction des religieux",
			"4 � Les rappeler � l'ordre et demander un d�domagement. Effets : +100$, +10% de satisfaction des lib�raux, +10% de satisfaction des capitalistes, +10% de satisfaction des nationalistes, -35% de satisfaction des militaristes, -35% de satisfaction des �cologistes, -35% de satisfaction des religieux"};

	/**
	 * Event loader
	 */
	public Events() {
		/*
		 * for (int i=0; i<size; i++) { System.out.println(events[i]); }
		 */
		Random rand = new Random();

		String currentEvents = events[rand.nextInt(events.length)];

		System.out.println(currentEvents);
		
		for (int i = 0; i < events.length; i++) {
			if (currentEvents == events[i]) {
				System.out.println(choice1[i]);
				System.out.println(choice2[i]);
				System.out.println(choice3[i]);
				System.out.println(choice4[i]);
				events[i] = null;
			}
		}
	}

}
