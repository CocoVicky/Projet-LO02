package fr.utt.projetLO02.GenialeVictoire;
import java.util.ArrayList;

public class StrategieJoueur implements Strategy {

	public void JoueurVirtuelJoue(JoueurVirtuel JoueuVirtuel) {
		JoueuVirtuel.faireOffre(0);
		
	}

	public int prendreCarte(Joueur JoueurVirtuel, ArrayList<Joueur> TabJoueur) {
		if ((JoueurVirtuel==TabJoueur.get(0)&& TabJoueur.size()>1)) {
			JoueurVirtuel.prendreCarte(TabJoueur.get(1),0);
		return 1;
		}
	else {
		JoueurVirtuel.prendreCarte(TabJoueur.get(1),0);
		return 0;
	}
	
}
}
