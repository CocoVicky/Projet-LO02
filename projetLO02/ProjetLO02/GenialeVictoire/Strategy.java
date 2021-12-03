package fr.utt.projetLO02.GenialeVictoire;

import java.util.ArrayList;

//import java.util.ArrayList;

public abstract class Strategy {
	/*public Carte joueurVirtuelJoue(JoueurVirtuel joueurVirtuel);
	public int prendreCarte(Joueur joueurVirtuel,  ArrayList<Joueur> tabJoueur);*/
	public abstract int faireOffre (int borneInf, int borneSup);
	public abstract int choisirJoueur(int borneInf, int borneSup , ArrayList<Carte>listeOffres ,  ArrayList<Joueur> listeJoueurs ,  ArrayList<Joueur> ontJoue);
	public abstract int choisirCarte(int borneInf, int borneSup , Joueur victime);
	
}
 