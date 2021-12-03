package fr.utt.projetLO02.GenialeVictoire;
import java.util.Collections; 
import java.util.Iterator;
import java.util.LinkedList;

/**
 * <b>JeuDeCartes est la classe représentant une banque de cartes.</b>
 * <p>
 * Un jeu de cartes n'est caractérisé que par une liste de cartes.
 * Un jeu de cartes doit être capable de se mélanger pouvoir être distribué ensuite, 
de donner une carte, de renseigner s'il est vide ou pas, d'ajouter une carte, et de renseigner la taille du jeu de cartes.
 * </p>
 * @author vicky
 * @version 1.0
 * 
 */
public class JeuDeCartes {
	public final static int nombre_de_cartes = (Famille.values().length-1) * (Valeur.values().length -1);
	/**
	 * La liste des cartes constituant le jeu de cartes.
	 * @see JeuDeCartes#JeuDeCartes()
	 * @see JeuDeCartes#jeu
	 */
	private LinkedList<Carte> jeu;
	/**
	 * Constructeur d'un jeu de cartes.
	 * <p>
	 * A la construction d'un objet JeuDeCartes, une liste de cartes est instanciée 
	 </p>
	 * @see JeuDeCartes#jeu
	 * 
	 */
	public JeuDeCartes() {
		this.jeu = new LinkedList<Carte>();
		Valeur[] tabValeurs = Valeur.values();
		Famille[] tabFamilles = Famille.values();
		for (int j = 0 ; j < 5 ; j++ ) {
			for (int i = 0 ; i < 5 ; i++ ) {
				if ((tabFamilles[j] == Famille.Joker) || (tabValeurs[i] == Valeur.Joker) || (tabFamilles[j] == Famille.Bonus) || (tabValeurs[i] == Valeur.Bonus));
				else {
					Carte carte = new Carte (tabFamilles[j] , tabValeurs[i]);
					this.jeu.add(carte);		
				}
			
			}  
		}
		Carte joker = new Carte (Famille.Joker , Valeur.Joker);
		this.jeu.add(joker);
		Carte carteBonus = new Carte(Famille.Bonus , Valeur.Bonus);
		this.jeu.add(carteBonus);
		
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
			}else if (pcarte.getValue() == Valeur.Bonus) {
				pcarte.setCondition(OrangeBand.Bonus);
			}
		}

	} 
	/**
	 * Mélange les cartes du jeu.
	 * 
	 * @see JeuDeCartes#jeu
	 */
	
	public void melanger() {
		Collections.shuffle(jeu); 
	}
	public LinkedList<Carte> getJeu() {
		return jeu;
	}
	public void setJeu(LinkedList<Carte> jeu) {
		this.jeu = jeu;
	}
	/**
	 * Permet de distribuer les cartes du jeu.
	 * @return une carte  à la fois.
	 * @see JeuDeCartes#jeu
	 */
	public Carte donnerCarte() {
		return this.jeu.pop(); 
	}
	/**
	 * Renseigne si le jeu ne contient plus de cartes.
	 * @return false si le jeu contient encore des cartes et true si non.
	 * @see JeuDeCartes#jeu
	 */
	public boolean estvide() {
		return jeu.isEmpty();
	}
	
	public String toString() {
		return this.jeu.toString();
	}
	/**
	 * Ajoute une carte au jeu de cartes.
	 * @param c
	 * @see JeuDeCartes#jeu
	 */
	public void ajouterCarte(Carte c) {
	this.jeu.add(c);	
	}
	/**
	 * Indique la taille du jeu de cartes.
	 * @return un entier qui représente cette taille.
	 * @see JeuDeCartes#jeu
	 */
	public int tailleBanque() {
		return this.jeu.size();
	}
	
	
	
}
