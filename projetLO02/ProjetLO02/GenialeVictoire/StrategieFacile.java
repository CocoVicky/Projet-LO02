package fr.utt.projetLO02.GenialeVictoire;

import java.util.ArrayList;

import java.util.Random;

/*public class Facile implements Strategy{

	/*public Carte prendreCarte (Joueur j , int numCarte) {
		this.jest.add(j.main.get(numCarte));
		j.main.remove(numCarte); 
	}*/
	
 public class StrategieFacile extends Strategy{


	/* public int choisirJoueur(int borneInf, int borneSup , ArrayList<Carte>listeOffres ,  ArrayList<Joueur> listeJoueurs , ArrayList<Joueur> ontJoue) {
		Random random = new Random();
		int numJoueur;
		numJoueur = borneInf + random.nextInt(borneSup - borneInf);
		return numJoueur;
	}*/
	 
	 public int choisirJoueur(int borneInf, int borneSup , ArrayList<Carte>listeOffres ,  ArrayList<Joueur> listeJoueurs , ArrayList<Joueur> ontJoue) {
	 int numJoueur = (int)(Math.random()*listeJoueurs.size());
	 while (numJoueur == 0)
		 numJoueur = (int)(Math.random()*listeJoueurs.size());
	return numJoueur;
			 
	 }
	 public int choisirCarte(int borneInf, int borneSup , Joueur victime) {
		Random random = new Random();
		int numCarte;
		numCarte = borneInf + random.nextInt(borneSup - borneInf);
		return numCarte;
	}


	
	public int faireOffre(int borneInf, int borneSup) {
		Random random = new Random();
		int numOffre;
		numOffre = borneInf + random.nextInt(borneSup - borneInf);
		return numOffre;
	}
	 
 }
  
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
