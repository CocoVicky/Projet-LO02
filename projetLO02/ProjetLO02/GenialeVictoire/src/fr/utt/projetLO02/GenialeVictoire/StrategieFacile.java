package fr.utt.projetLO02.GenialeVictoire;

import java.util.ArrayList;
import java.util.Random;


/**
 * <b>StrategieFacile est une classe qui définit la stratégie d'un joueur irréfléchi.</b>
 * <p>
 * Une strategieFacile est caractérisée par le joueur virtuel qui l'implémente.
Celui ci doit savoir choisir un joueur cible et une carte complètement au hasard.
 * </p>
 * 
 * @see JoueurVirtuel
 * @author vicky
 *@version 1.0
 */
 public class StrategieFacile extends Strategy{

	 /**
	  * Détermine un joueur cible de façon aléatoire.
	  * @return l'indice du joueur choisi.
	  */
	 public int choisirJoueur(int borneInf, int borneSup , ArrayList<Carte>listeOffres ,  ArrayList<Joueur> listeJoueurs , ArrayList<Joueur> ontJoue , Partie partieEnCours) {
		Random random = new Random();
		int numJoueur;
		numJoueur = borneInf + random.nextInt(borneSup - borneInf + 1);
		return numJoueur;
	}

	 /**
	  * Détermine une carte cible de façon aléatoire.
	  * @return le numéro de la carte choisie.
	  */
	 public int choisirCarte(int borneInf, int borneSup , Joueur victime) {
		Random random = new Random();
		int numCarte;
		numCarte = borneInf + random.nextInt(borneSup - borneInf + 1);
		return numCarte;
	}
 

	/**
	 * Détermine quelle carte le joueur virtuel souhaite découvrir.
	 * @return le numéro de la carte choisie.
	 */
	public int faireOffre(int borneInf, int borneSup) {
		Random random = new Random();
		int numOffre;
		numOffre = borneInf + random.nextInt(borneSup - borneInf + 1);
		return numOffre;
	}
	 
 }
  
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
