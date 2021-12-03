package fr.utt.projetLO02.GenialeVictoire;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class StrategieMoyenne extends Strategy {

	private JoueurVirtuel boss; 
	public StrategieMoyenne(JoueurVirtuel pJoueur) {
		this.boss = pJoueur;
		
	} 
 

	public int choisirAleatoirement (int borneInf , int borneSup) {
		int numVictime = 0;
		Random random = new Random();
		numVictime =  borneInf + random.nextInt(borneSup - borneInf);
		return numVictime;
	} 
	
	/*public void verifierValiditeChoix (int borneInf, int borneSup , int numVictime , ArrayList<Joueur> ontJoue , ArrayList<Carte> listeOffres , ArrayList<Joueur> listeJoueurs) {
		//le joueur prioritaire a rentré son propre numéro: il n'a pas le  droit s'il reste des joueurs qui n'ont pas encore joué
		//													il a le droit s'il est le seul a ne pas avoir joué
		while (numVictime  == boss.getIndiceJoueur()) {
			
			if( listeJoueurs.get(numVictime  -1).getMain().size() == 2) {
				if (ontJoue.size() == listeJoueurs.size() - 1){ 
					System.out.println("Vous avez le droit pour cette fois , BOT!!!");
					break;
				} 
				else{
					System.out.println("Vous ne pouvez pas piocher dans votre propre main car vous n'êtes pas le seul à ne pas avoir encore joué, BOT!!!");
				 	numVictime = choisirAleatoirement(borneInf, borneSup);
					//verifierValiditeChoix(borneInf, borneSup, numVictime, ontJoue, listeOffres, listeJoueurs);
					break;
						
					}
				}
			else{
				System.out.println("Vous ne pouvez pas piocher dans votre main incomplète , BOT!!!!");
	            numVictime = choisirAleatoirement(borneInf, borneSup);	
	            //verifierValiditeChoix(borneInf, borneSup, numVictime, ontJoue, listeOffres, listeJoueurs);
	            break;
			}
		}
		
		
		//le joueur victime choisi a déja été choisi donc il n'a plus deux cartes dans sa main: le prioritaire ne peut pas piocher dans sa main
		if (listeJoueurs.get(numVictime - 1).getMain().size() != 2) {
			System.out.println("Vous ne pouvez pas piocher chez ce joueur car sa main est incomplète, BOT!!!!");
			numVictime = choisirAleatoirement(borneInf, borneSup);
			verifierValiditeChoix(borneInf, borneSup, numVictime, ontJoue, listeOffres, listeJoueurs);
		}  
		} */
		
		
	
	
	public int choisirJoueur(int borneInf, int borneSup , ArrayList<Carte>listeOffres ,  ArrayList<Joueur> listeJoueurs , ArrayList<Joueur> ontJoue ) {
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
				//verifierValiditeChoix(borneInf, borneSup, numVictime, ontJoue, listeOffres, listeJoueurs);
				while (numVictime == boss.getIndiceJoueur()){
 					if( boss.getMain().size() == 2) {
						System.out.println("Les joueurs ayant joué: " + ontJoue);
						if (ontJoue.size() == listeJoueurs.size() - 1){ 
					System.out.println("Vous avez le droit pour cette fois, Joueur virtuel");
					break;
										}else {
											System.out.println("Vous ne pouvez pas piocher dans votre propre main car vous n'êtes pas le seul à ne pas avoir joué.");
											numVictime = choisirAleatoirement(borneInf, borneSup);
											//break;
										}
					}else {
						System.out.println("Vous ne pouvez pas piocher dans votre main incomplète, joueur virtuel");
						numVictime = choisirAleatoirement(borneInf, borneSup);
						//break;
					}
				} 
				if(listeJoueurs.get(numVictime - 1).getMain().size() != 2) {
					System.out.println("Vous ne pouvez pas piocher chez ce joueur, Bot!");
					numVictime = choisirAleatoirement(borneInf, borneSup);
					System.out.println("Le nouveau numero choisi est: " + numVictime);
				}
			} 
		} 
		return numVictime;
	}
		

	 
	public int choisirCarte(int borneInf, int borneSup , Joueur victime) {
		int numCarte = 0;
		if (victime.getOffre().get(0).getSuit().equals(Famille.Pique) || victime.getOffre().get(0).getSuit().equals(Famille.Trèfle)) {
			numCarte = 0;
		}else {
			numCarte = 1;
		}
		return numCarte;
	}
 


	
	public int faireOffre( int borneInf, int borneSup) {
		int numOffre = 0;
		if (this.boss.getCopieMain().get(0).getSuit().ordinal() > this.boss.getCopieMain().get(1).getSuit().ordinal()) {
			numOffre = 0;
		}else {
			numOffre = 1;
		}
		return numOffre;
	}

}

























