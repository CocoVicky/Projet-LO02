package fr.utt.projetLO02.GenialeVictoire;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * <b>StrategieMoyenne est une classe qui définit la stratégie d'un joueur réfléchi.</b>
 * <p>
 * Une strategieMoyenne est caractérisée par le joueur virtuel qui l'implémente.
Celui ci doit savoir choisir un joueur cible et une carte selon une certaine logique.
 * </p>
 * 
 * @see JoueurVirtuel
 * @author vicky
 *@version 1.0
 */
public class StrategieMoyenne extends Strategy {
	/**
	 * Joueur qui applique la stratégie moyenne.
	 */
	private JoueurVirtuel boss; 
	public StrategieMoyenne(JoueurVirtuel pJoueur) {
		this.boss = pJoueur; 
	}  
 
	/**
	 * Détermine le joueur cible selon une logique définie.
	 * @return un entier représentant l'indice du joueur choisi.
	 * @see Partie#getListeJoueurs()
	 * 
	 */
	public int choisirJoueur(int borneInf, int borneSup , ArrayList<Carte>listeOffres ,  ArrayList<Joueur> listeJoueurs , ArrayList<Joueur> ontJoue , Partie PartieEnCours) {
		Iterator<Joueur> itrech = listeJoueurs.iterator(); 
		int numVictime = 0;
		while (itrech.hasNext()) {
			System.out.println("Liste des offres: " + listeOffres);
			Joueur j = (Joueur)itrech.next();
			System.out.println("Scan de la main de: " + j.getNom());
			if (j.mainContient(listeOffres.get(0))) {
				System.out.println("Main de " + j.getNom() + " contient: " + j.mainContient(listeOffres.get(0)));
				numVictime = j.getIndiceJoueur();
				System.out.println("Vous avez choisi le joueur n° " + numVictime + " et le numero du boss est: " + boss.getIndiceJoueur());
			} 
		}
		while (PartieEnCours.verifierValiditeChoix(numVictime, ontJoue, boss)  == false) {
			numVictime = choisirAleatoirement(1, listeJoueurs.size());
		}
		return numVictime;
	}
		

	 /**
	  * Détermine la carte souhaitée selon une certaine logique.
	  * @return le numéro de la carte.
	  * 
	  */
	public int choisirCarte(int borneInf, int borneSup , Joueur victime) {
		int numCarte = 0;
		if (victime.getOffre().get(0).getSuit().equals(Famille.Pique) || victime.getOffre().get(0).getSuit().equals(Famille.Trèfle)) {
			numCarte = 0;
		}else {
			numCarte = 1;
		}
		return numCarte;
	} 
 


	/**
	 * Détermine quelle carte le joueur virtuel oveut découvrir.
	 * @return le numéro de la carte correspondante.
	 */
	public int faireOffre( int borneInf, int borneSup) {
		int numOffre = 0;
		if (this.boss.getCopieMain().get(0).getSuit().ordinal() > this.boss.getCopieMain().get(1).getSuit().ordinal()) {
			numOffre = 0;
		}else {
			numOffre = 1;
		}
		return numOffre;
	}
	
	/**
	 *<p> Est appelée lorsque l'une des conditions fixées par les règles du jeu
 en terme de choix de joueur cible n'est pas respectée par le joueur virtuel.
 Il choisit un autre joueur , cette fois de façon aléatoire.
     *</p>
	 * @param borneInf
	 * @param borneSup
	 * @return le nouvel indice de joueur choisi aléatoirement.
	 */
	public int choisirAleatoirement (int borneInf , int borneSup) {
		int numVictime = 0;
		Random random = new Random();
		numVictime =  borneInf + random.nextInt(borneSup - borneInf + 1);
		return numVictime;
	} 
	
	

}

























