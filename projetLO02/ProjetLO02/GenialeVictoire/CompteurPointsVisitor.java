package fr.utt.projetLO02.GenialeVictoire;

import java.util.ArrayList;
import java.util.Iterator;

public class CompteurPointsVisitor implements Visitor {

	public int compterNbJoker(ArrayList<Carte> listeJest) {
		int nbJoker = 0;
		Iterator<Carte> itCompte = listeJest.iterator(); 
		while (itCompte.hasNext()) {
			Carte c = (Carte)itCompte.next();
			if (c.getSuit().equals(Famille.Joker)) {
				nbJoker ++ ;
			}
		}
		return nbJoker;
	}
		
		public int compterNbCoeurs(ArrayList<Carte> listeJest) {
			int nbCoeurs = 0;
			Iterator<Carte> itCompte = listeJest.iterator(); 
			while (itCompte.hasNext()) {
				Carte c = (Carte)itCompte.next();
				if (c.getSuit().equals(Famille.Coeur)) {
					nbCoeurs ++ ;
				}
			}
			return nbCoeurs;
		
	}
		
		public int compterNbPiques(ArrayList<Carte> listeJest) {
			int nbPiques = 0;
			Iterator<Carte> itCompte = listeJest.iterator(); 
			while (itCompte.hasNext()) {
				Carte c = (Carte)itCompte.next();
				if (c.getSuit().equals(Famille.Pique)) {
					nbPiques ++ ;
				}
			}
			return nbPiques;
		}
		
		
		public int compterNbTrefles(ArrayList<Carte> listeJest) {
			int nbTrefles = 0;
			Iterator<Carte> itCompte = listeJest.iterator(); 
			while (itCompte.hasNext()) {
				Carte c = (Carte)itCompte.next();
				if (c.getSuit().equals(Famille.Pique)) {
					nbTrefles ++ ;
				}
			}
			return nbTrefles;
		}
		
		public int compterNbCarreaux(ArrayList<Carte> listeJest) {
			int nbCarreaux = 0;
			Iterator<Carte> itCompte = listeJest.iterator(); 
			while (itCompte.hasNext()) {
				Carte c = (Carte)itCompte.next();
				if (c.getSuit().equals(Famille.Pique)) {
					nbCarreaux ++ ;
				}
			}
			return nbCarreaux;
		} 
		
		
	public int compterPtsPique(ArrayList<Carte> listeJest) {
		int ptsPique = 0;
		int nbPiques = compterNbPiques(listeJest);
		Iterator<Carte> itPique = listeJest.iterator(); 
		while (itPique.hasNext()) {
			Carte c = (Carte)itPique.next();
			if (c.getSuit().equals(Famille.Pique)) {
				if (c.getValue().equals(Valeur.As) && nbPiques == 1) {
					ptsPique += c.setChiffre(c.getValue());
				}
				ptsPique += c.getChiffre(c.getValue());
			}
		}
		return ptsPique;
		
	}
	
	
	public int compterPtsTrefle(ArrayList<Carte> listeJest) {
		int ptsTrefle = 0;
		int nbTrefles = compterNbTrefles(listeJest);
		Iterator<Carte> itTrefle = listeJest.iterator(); 
		while (itTrefle.hasNext()) {
			Carte c = (Carte)itTrefle.next();
			if (c.getSuit().equals(Famille.Trèfle)) {
				if (c.getValue().equals(Valeur.As) && nbTrefles == 1) {
					ptsTrefle += c.setChiffre(c.getValue());
				}
				ptsTrefle+= c.getChiffre(c.getValue());
			}
		}
		return ptsTrefle;
	}
	
	public int compterPtsCoeur(ArrayList<Carte> listeJest) {
		int ptsCoeur= 0;
		int nbCoeurs = compterNbCoeurs(listeJest);
		Iterator<Carte> itCoeur = listeJest.iterator(); 
		while (itCoeur.hasNext()) {
			Carte c = (Carte)itCoeur.next();
			if (c.getSuit().equals(Famille.Coeur)) {
				if (c.getValue().equals(Valeur.As) && nbCoeurs == 1) {
					ptsCoeur += c.setChiffre(c.getValue());
				}
				ptsCoeur += c.getChiffre(c.getValue());
			}
		}
		return ptsCoeur;
	}
	
	public int compterPtsCarreau(ArrayList<Carte> listeJest) {
		int ptsCarreau= 0;
		int nbCarreaux = compterNbCarreaux(listeJest);
		Iterator<Carte> itCarreau = listeJest.iterator(); 
		while (itCarreau.hasNext()) {
			Carte c = (Carte)itCarreau.next();
			if (c.getSuit().equals(Famille.Coeur)) {
				if (c.getValue().equals(Valeur.As) && nbCarreaux == 1) { // cas ou l'as se transforme en 5
					ptsCarreau += c.setChiffre(c.getValue());
				} 
				ptsCarreau += c.getChiffre(c.getValue());
			}
		}
		return ptsCarreau;
	}
	
	public boolean blackPair(ArrayList<Carte> listeJest) {
		boolean found = false;
		Carte firstBlack = null;
		int irech = 0;
		while (firstBlack == null) {
			if (listeJest.get(irech).getSuit().equals(Famille.Pique) || listeJest.get(irech).getSuit().equals(Famille.Trèfle)) {
				firstBlack = listeJest.get(irech);
			}else {
				irech++;
			}
		}
		for ( Carte c : listeJest) {
			if (c.getValue().equals(firstBlack.getValue())) {
				if(c.getSuit().equals(Famille.Trèfle) || c.getSuit().equals(Famille.Pique)) {
					found = true;
					break;
				}
			}
		}
		return found;
		
	}

	public void visit(Jest jest) {
		//******différents cas pour compter les points********
		int totalJest = 0;
		int compteurJoker = compterNbJoker(jest.getCartesJest());
		int compteurCoeurs = compterNbCoeurs(jest.getCartesJest());
		// 1 joker et pas de coeurs: joker vaut 4 points 
		
		if ((compteurJoker == 1) && (compteurCoeurs == 0)) {
			totalJest += 4;
		}else if ((compteurJoker == 1) && (compteurCoeurs != 0)) { // 1 joker et au moins 1 coeur : joker vaut 0 et chaque coeur est compté négativement 
			totalJest += (-1)* compterPtsCoeur(jest.getCartesJest());
		}else if ((compteurJoker == 1) && (compteurCoeurs == 4)) { // 1 joker et les 4 coeurs : joker vaut 0 et chaque coeur est compté positivement (dans un jeu a 4 joueurs ce n'est possible que si le trophée est soit le joker soit un coeur)
			totalJest += compterPtsCoeur(jest.getCartesJest());
		}else if (blackPair(jest.getCartesJest())) {// une paire noire ajoute 2 points aux points.
			totalJest += 2;
		}
		jest.setPointsJest(totalJest);
	}   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@SuppressWarnings("null")
	public void visit(Jest jest) {
		ArrayList<Joueur> tabJoueur = null;
		for(int i=0 ; i<tabJoueur.size(); i++) {
			((Jest) tabJoueur.get(i).getJest()).accept((Visitor)this);}
		}
	
	
		public float compterPoint(ArrayList<Carte> jest) { 
			float point=0;
			Famille[] tabFamilles = Famille.values(); 
			Valeur[] tabValeurs = Valeur.values();//Pique, trefle , Carreau, Coeur , joker
			for(int j=0; j<4; j++){

				if((tabValeurs[j]==Valeur.Joker) && (tabFamilles[j]==Famille.Carreau || tabFamilles[j]==Famille.Coeur)) {
					//point+=	j'aimerai faire integrer l'iterator mais je sais trop comment appliquer  sa
				}

				if(tabValeurs[j]==Valeur.As && tabFamilles[j]==Famille.Trèfle || tabFamilles[j]==Famille.Pique) {
					point+=1;
					return point;
				}

				else if(tabValeurs[j]==Valeur.Deux &&    tabFamilles[j]==Famille.Trèfle || tabFamilles[j]==Famille.Pique) {
					point+=2;
					return point;
				}

				else if(tabValeurs[j]==Valeur.Trois &&    tabFamilles[j]==Famille.Trèfle || tabFamilles[j]==Famille.Pique) {
					point+=3;
					return point;
				}
				else if(tabValeurs[j]==Valeur.Quatre &&    tabFamilles[j]==Famille.Trèfle || tabFamilles[j]==Famille.Pique) {
					point+=4;
					return point;

				}
				else if(tabValeurs[j]==Valeur.As &&    tabFamilles[j]==Famille.Coeur || tabFamilles[j]==Famille.Carreau) {
					point-=1;
					return point;

				}
				else if(tabValeurs[j]==Valeur.As &&    tabFamilles[j]==Famille.Coeur || tabFamilles[j]==Famille.Carreau) {
					point-=2;
					return point;
				}

				else if(tabValeurs[j]==Valeur.As &&    tabFamilles[j]==Famille.Coeur || tabFamilles[j]==Famille.Carreau) {
					point-=3;
					return point;
				}

				else if(tabValeurs[j]==Valeur.As &&    tabFamilles[j]==Famille.Coeur || tabFamilles[j]==Famille.Carreau) {
					point-=4;
					return point;
				}
			}
			return point;
		}*/


}
