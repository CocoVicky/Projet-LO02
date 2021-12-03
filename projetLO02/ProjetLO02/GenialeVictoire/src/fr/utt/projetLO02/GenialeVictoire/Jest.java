package fr.utt.projetLO02.GenialeVictoire;

import java.util.ArrayList;

public class Jest {
	/**
	 * <p>
	 * Le nombre de points associés au jest d'un joueur permettra a la fin de la partie
 de déterminer le vainqueur.
	 * </p>
	 * @see Jest#getPointsJest()
	 */
	private int pointsJest ;
	/**
	 * Liste des cartes qui constitueront le jest de chaque joueur.
	 */
	private ArrayList<Carte> cartesJest;

	 
	/**
	 * <p>
	 * Constructeur d'un jest.
	 * On instancie la liste des cartes du jest.
	 *</p> 
	 */
	public Jest() {
		this.cartesJest = new ArrayList<Carte> () ;
	}
 
	public int getPointsJest() {
		return pointsJest;
	}

	public ArrayList<Carte> getCartesJest() {
		return cartesJest;
	}

	public void setCartesJest(ArrayList<Carte> cartesJest) {
		this.cartesJest = cartesJest;
	}

	public void setPointsJest(int pointsJest) {
		this.pointsJest = pointsJest;
	}
   /*public ArrayList<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}*/
/**
 * Donne la permission au visiteur passé en paramètre de visiter le jest d'un joueur.
 * @param v
 */
public void accept(Visitor v) {
	 v.visit(this, null);
 }
 
} 
 