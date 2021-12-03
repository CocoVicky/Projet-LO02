package fr.utt.projetLO02.GenialeVictoire;

import java.util.ArrayList;
import java.util.Random;


/**
 * <b>StrategieFacile est une classe qui d�finit la strat�gie d'un joueur irr�fl�chi.</b>
 * <p>
 * Une strategieFacile est caract�ris�e par le joueur virtuel qui l'impl�mente.
Celui ci doit savoir choisir un joueur cible et une carte compl�tement au hasard.
 * </p>
 * 
 * @see JoueurVirtuel
 * @author vicky
 *@version 1.0
 */
 public class StrategieFacile extends Strategy{

	 /**
	  * D�termine un joueur cible de fa�on al�atoire.
	  * @return l'indice du joueur choisi.
	  */
	 public int choisirJoueur(int borneInf, int borneSup , ArrayList<Carte>listeOffres ,  ArrayList<Joueur> listeJoueurs , ArrayList<Joueur> ontJoue , Partie partieEnCours) {
		Random random = new Random();
		int numJoueur;
		numJoueur = borneInf + random.nextInt(borneSup - borneInf + 1);
		return numJoueur;
	}

	 /**
	  * D�termine une carte cible de fa�on al�atoire.
	  * @return le num�ro de la carte choisie.
	  */
	 public int choisirCarte(int borneInf, int borneSup , Joueur victime) {
		Random random = new Random();
		int numCarte;
		numCarte = borneInf + random.nextInt(borneSup - borneInf + 1);
		return numCarte;
	}
 

	/**
	 * D�termine quelle carte le joueur virtuel souhaite d�couvrir.
	 * @return le num�ro de la carte choisie.
	 */
	public int faireOffre(int borneInf, int borneSup) {
		Random random = new Random();
		int numOffre;
		numOffre = borneInf + random.nextInt(borneSup - borneInf + 1);
		return numOffre;
	}
	 
 }
  
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
