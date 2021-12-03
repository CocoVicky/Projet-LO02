package fr.utt.projetLO02.GenialeVictoire;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * <b>StrategieMoyenne est une classe qui d�finit la strat�gie d'un joueur r�fl�chi.</b>
 * <p>
 * Une strategieMoyenne est caract�ris�e par le joueur virtuel qui l'impl�mente.
Celui ci doit savoir choisir un joueur cible et une carte selon une certaine logique.
 * </p>
 * 
 * @see JoueurVirtuel
 * @author vicky
 *@version 1.0
 */
public class StrategieMoyenne extends Strategy {
	/**
	 * Joueur qui applique la strat�gie moyenne.
	 */
	private JoueurVirtuel boss; 
	public StrategieMoyenne(JoueurVirtuel pJoueur) {
		this.boss = pJoueur; 
	}  
 
	/**
	 * D�termine le joueur cible selon une logique d�finie.
	 * @return un entier repr�sentant l'indice du joueur choisi.
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
				System.out.println("Vous avez choisi le joueur n� " + numVictime + " et le numero du boss est: " + boss.getIndiceJoueur());
			} 
		}
		while (PartieEnCours.verifierValiditeChoix(numVictime, ontJoue, boss)  == false) {
			numVictime = choisirAleatoirement(1, listeJoueurs.size());
		}
		return numVictime;
	}
		

	 /**
	  * D�termine la carte souhait�e selon une certaine logique.
	  * @return le num�ro de la carte.
	  * 
	  */
	public int choisirCarte(int borneInf, int borneSup , Joueur victime) {
		int numCarte = 0;
		if (victime.getOffre().get(0).getSuit().equals(Famille.Pique) || victime.getOffre().get(0).getSuit().equals(Famille.Tr�fle)) {
			numCarte = 0;
		}else {
			numCarte = 1;
		}
		return numCarte;
	} 
 


	/**
	 * D�termine quelle carte le joueur virtuel oveut d�couvrir.
	 * @return le num�ro de la carte correspondante.
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
	 *<p> Est appel�e lorsque l'une des conditions fix�es par les r�gles du jeu
 en terme de choix de joueur cible n'est pas respect�e par le joueur virtuel.
 Il choisit un autre joueur , cette fois de fa�on al�atoire.
     *</p>
	 * @param borneInf
	 * @param borneSup
	 * @return le nouvel indice de joueur choisi al�atoirement.
	 */
	public int choisirAleatoirement (int borneInf , int borneSup) {
		int numVictime = 0;
		Random random = new Random();
		numVictime =  borneInf + random.nextInt(borneSup - borneInf + 1);
		return numVictime;
	} 
	
	

}

























