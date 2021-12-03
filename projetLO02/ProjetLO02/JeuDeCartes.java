package fr.utt.projetLO02.GenialeVictoire;


import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class JeuDeCartes {
	public final static int nombre_de_cartes = (Famille.values().length-1) * (Valeur.values().length -1);
	private LinkedList<Carte> jeu;
	
	public JeuDeCartes() {
		this.jeu = new LinkedList<Carte>();
		Valeur[] tabValeurs = Valeur.values();
		Famille[] tabFamilles = Famille.values();
		for (int j = 0 ; j < 5 ; j++ ) {
			for (int i = 0 ; i < 5 ; i++ ) {
				if ((tabFamilles[j] == Famille.Joker) || (tabValeurs[i] == Valeur.Joker));
				else {
					Carte carte = new Carte (tabFamilles[j] , tabValeurs[i]);
					this.jeu.add(carte);
				}
			
			} 
		}
		Carte joker = new Carte (Famille.Joker , Valeur.Joker);
		this.jeu.add(joker);
		
		Iterator<Carte> it = jeu.iterator();
		while (it.hasNext()) {
			Carte pcarte = (Carte)it.next();
			if (pcarte.getValue() == Valeur.Joker) {
				pcarte.setCondition(OrangeBand.Best_jest);
			}else if(pcarte.getSuit() == Famille.Coeur) {
				pcarte.setCondition(OrangeBand.Joker);
			}else if((pcarte.getValue() == Valeur.Quatre) && (pcarte.getSuit() == Famille.Trèfle)) {
				pcarte.setCondition(OrangeBand.Lowest_pique);
			}else if((pcarte.getValue() == Valeur.Quatre) && (pcarte.getSuit() == Famille.Pique)) {
				pcarte.setCondition(OrangeBand.Lowest_trèfle);
			}else if((pcarte.getValue() == Valeur.As) && (pcarte.getSuit() == Famille.Pique)) {
				pcarte.setCondition(OrangeBand.Highest_trèfle);
			}else if((pcarte.getValue() == Valeur.As) && (pcarte.getSuit() == Famille.Trèfle)) {
				pcarte.setCondition(OrangeBand.Highest_pique);
			}else if((pcarte.getValue() == Valeur.Deux) && (pcarte.getSuit() == Famille.Trèfle)) {
				pcarte.setCondition(OrangeBand.Lowest_coeur);
			}else if((pcarte.getValue() == Valeur.Deux) && (pcarte.getSuit() == Famille.Carreau)) {
				pcarte.setCondition(OrangeBand.Highest_carreau);
			}else if((pcarte.getValue() == Valeur.Trois) && (pcarte.getSuit() == Famille.Carreau)) {
				pcarte.setCondition(OrangeBand.Lowest_carreau);
			}else if((pcarte.getValue() == Valeur.Trois) && (pcarte.getSuit() == Famille.Trèfle)) {
				pcarte.setCondition(OrangeBand.Highest_coeur);
			}else if((pcarte.getValue() == Valeur.As) && (pcarte.getSuit() == Famille.Carreau)) {
				pcarte.setCondition(OrangeBand.Majority4);
			}else if((pcarte.getValue() == Valeur.Deux) && (pcarte.getSuit() == Famille.Pique)) {
				pcarte.setCondition(OrangeBand.Majority3);
			}else if((pcarte.getValue() == Valeur.Trois) && (pcarte.getSuit() == Famille.Pique)) {
				pcarte.setCondition(OrangeBand.Majority2);
			}else if((pcarte.getValue() == Valeur.Quatre) && (pcarte.getSuit() == Famille.Carreau)) {
				pcarte.setCondition(OrangeBand.Best_jest_no_joke);
			}
		}

	} 
	
	public void melanger() {
		Collections.shuffle(jeu);
	}
	
	public Carte donnerCarte() {
		return this.jeu.pop();
	}
	
	public boolean estvide() {
		return jeu.isEmpty();
	}
	
	public String toString() {
		return this.jeu.toString();
	}
	
	public void ajouterCarte(Carte c) {
	this.jeu.add(c);	
	}
	
	public int tailleBanque() {
		return this.jeu.size();
	}
	
	
	
}
