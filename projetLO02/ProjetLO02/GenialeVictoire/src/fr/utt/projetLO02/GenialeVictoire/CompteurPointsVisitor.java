package fr.utt.projetLO02.GenialeVictoire;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * <p>
 * CompteurPointsVisitor est une classe qui impl�mente l'interface Visitor.
 * Elle permet � la partie de faire le d�compte des points de chaque joueur en visitant leurs jests respectifs.
 *</p>
 * @author vicky
 *
 */
public class CompteurPointsVisitor implements Visitor {
	
	/**
	 * Compte le nombre de Joker dans le jest d'un joueur.
	 * @param listeJest
	 * @return le r�sultat
	 */
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
		
		/**
		 * Compte le nombre de cartes de la famille Coeur dans le jest d'un joueur.
		 * @param listeJest
		 * @return le r�sultat
		 */
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

		/**
		 * Compte le nombre de cartes de la famille Pique dans le jest d'un joueur.
		 * @param listeJest
		 * @return le r�sultat
		 */
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
		

		/**
		 * Compte le nombre de cartes de la famille Tr�fle dans le jest d'un joueur.
		 * @param listeJest
		 * @return le r�sultat
		 */
		public int compterNbTrefles(ArrayList<Carte> listeJest) {
			int nbTrefles = 0;
			Iterator<Carte> itCompte = listeJest.iterator(); 
			while (itCompte.hasNext()) {
				Carte c = (Carte)itCompte.next();
				if (c.getSuit().equals(Famille.Tr�fle)) {
					nbTrefles ++ ;
				}
			}
			return nbTrefles;
		}
		

		/**
		 * Compte le nombre de cartes de la famille Carreau dans le jest d'un joueur.
		 * @param listeJest
		 * @return le r�sultat
		 */
		public int compterNbCarreaux(ArrayList<Carte> listeJest) {
			int nbCarreaux = 0;
			Iterator<Carte> itCompte = listeJest.iterator(); 
			while (itCompte.hasNext()) {
				Carte c = (Carte)itCompte.next();
				if (c.getSuit().equals(Famille.Carreau)) {
					nbCarreaux ++ ;
				}
			}
			return nbCarreaux;
		} 
		
	/**
	 * Compte le nombre de points g�n�r�s par chaque carte de la famille Pique.	
	 * @param listeJest
	 * @return le nombre de points
	 */
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
	 
	/**
	 * Compte le nombre de points g�n�r�s par chaque carte de la famille Tr�fle.	
	 * @param listeJest
	 * @return le nombre de points
	 */
	public int compterPtsTrefle(ArrayList<Carte> listeJest) {
		int ptsTrefle = 0;
		int nbTrefles = compterNbTrefles(listeJest);
		Iterator<Carte> itTrefle = listeJest.iterator(); 
		while (itTrefle.hasNext()) {
			Carte c = (Carte)itTrefle.next();
			if (c.getSuit().equals(Famille.Tr�fle)) {
				if (c.getValue().equals(Valeur.As) && nbTrefles == 1) {
					ptsTrefle += c.setChiffre(c.getValue());
				}
				ptsTrefle+= c.getChiffre(c.getValue());
			}
		}
		return ptsTrefle;
	}
	
	/**
	 * Compte le nombre de points g�n�r�s par chaque carte de la famille Coeur.	
	 * @param listeJest
	 * @return le nombre de points
	 */
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
	
	/**
	 * Compte le nombre de points g�n�r�s par chaque carte de la famille Carreau.	
	 * @param listeJest
	 * @return le nombre de points
	 */
	public int compterPtsCarreau(ArrayList<Carte> listeJest) {
		int ptsCarreau= 0;
		int nbCarreaux = compterNbCarreaux(listeJest);
		Iterator<Carte> itCarreau = listeJest.iterator(); 
		while (itCarreau.hasNext()) {
			Carte c = (Carte)itCarreau.next();
			if (c.getSuit().equals(Famille.Carreau)) {
				if (c.getValue().equals(Valeur.As) && nbCarreaux == 1) { // cas ou l'as se transforme en 5
					ptsCarreau += c.setChiffre(c.getValue());
				} 
				ptsCarreau += c.getChiffre(c.getValue());
			}
		}
		return ptsCarreau;
	}
	
	/**
	 * <p>
	 * D�termine si dans le jest d'un joueur il existe un couple de cartes de famille T�fle/Pique 
qui poss�dent la m�me valeur.
     *</p>
	 * @param listeJest
	 * @return un boole�n
	 */
	public boolean blackPair(ArrayList<Carte> listeJest) {
		boolean found = false;
		Carte firstBlack = null;
		int irech = 0;
		while (firstBlack == null) {
			if (listeJest.get(irech).getSuit().equals(Famille.Pique) || listeJest.get(irech).getSuit().equals(Famille.Tr�fle)) {
				firstBlack = listeJest.get(irech);
			}else {
				irech++;
			}
		}
		for ( Carte c : listeJest) {
			if (c.getValue().equals(firstBlack.getValue())) {
				if(c.getSuit().equals(Famille.Tr�fle) || c.getSuit().equals(Famille.Pique)) {
					found = true;
					break;
				}
			}
		}
		return found;
		
	}
	/**
	 * <p>
	 * M�thode qui visite chacun des jests et proc�de au comptage de points � proprement parler 
en se basant sur les m�thodes d�finies pr�c�demment.
	 * </p>
	 */
	public void visit(Jest jest , Partie partieEnCours) {
		//******diff�rents cas pour compter les points********
		int totalJest = 0;
		int compteurJoker = compterNbJoker(jest.getCartesJest());
		int compteurCoeurs = compterNbCoeurs(jest.getCartesJest());
		// 1 joker et pas de coeurs: joker vaut 4 points 
		if (partieEnCours.getMode() == 1) {// partie normale, les points sont compt�s selon les r�gles fix�es par le jeu.
		if ((compteurJoker == 1) && (compteurCoeurs == 0)) {
			totalJest += 4;
		}else if ((compteurJoker == 1) && (compteurCoeurs != 0)) { // 1 joker et au moins 1 coeur : joker vaut 0 et chaque coeur est compt� n�gativement 
			totalJest += (-1)* compterPtsCoeur(jest.getCartesJest());
		}else if ((compteurJoker == 1) && (compteurCoeurs == 4)) { // 1 joker et les 4 coeurs : joker vaut 0 et chaque coeur est compt� positivement (dans un jeu a 4 joueurs ce n'est possible que si le troph�e est soit le joker soit un coeur)
			totalJest += compterPtsCoeur(jest.getCartesJest());
		}else if (blackPair(jest.getCartesJest())) {// une paire noire ajoute 2 points aux points.
			totalJest += 2;
		}
		totalJest += compterPtsTrefle(jest.getCartesJest()) - compterPtsCarreau(jest.getCartesJest()) + compterPtsPique(jest.getCartesJest());
		Carte carteBonus = new Carte (Famille.Bonus , Valeur.Bonus);
		if (jest.getCartesJest().contains(carteBonus)) {
			System.out.println("Bravo vous d�tenez la carte bonus, vous gagnez deux points!!!");
			totalJest += 2;
		} 
			
		jest.setPointsJest(totalJest);
		}else {//Variante: toutes les cartes sont compt�es positivement et le joker ne vaut rien.
			totalJest +=  compterPtsTrefle(jest.getCartesJest()) + compterPtsCarreau(jest.getCartesJest()) + compterPtsPique(jest.getCartesJest()) + compterPtsCoeur(jest.getCartesJest());
			jest.setPointsJest(totalJest);
		}
	}    
 
}
