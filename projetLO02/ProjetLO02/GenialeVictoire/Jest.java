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
	//private ArrayList<Joueur> listeJoueurs;
	private ArrayList<Carte> cartesJest;

	 
 
	public Jest() {// à l'instanciation d'un jest, mettre en paramètre un joueur
		//this.listeJoueurs = p.getListJoueurs();
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

public void accept(Visitor v) {
	 v.visit(this);
 }
 
}
 