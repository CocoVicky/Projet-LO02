package fr.utt.projetLO02.GenialeVictoire;

import java.util.ArrayList;

public interface Strategy {
	public void JoueurVirtuelJoue(JoueurVirtuel JoueuVirtuel);
	public int prendreCarte(Joueur JoueurVirtuel,  ArrayList<Joueur> TabJoueur);
	
}
