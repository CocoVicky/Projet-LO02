package fr.utt.projetLO02.GenialeVictoire;

import java.util.ArrayList;
import java.util.Iterator;


public class Joueur {
private String nom;
private int indiceJoueur;
private int points;
private ArrayList<Carte> main;
private ArrayList<Carte> jest;
private boolean aJoue;

public Joueur(int pIndice , String pnom) {
	this.nom = pnom;
	this.indiceJoueur = pIndice;
	this.main = new ArrayList<Carte>();
	this.jest = new ArrayList<Carte>();
	this.aJoue = false;
}


public boolean isaJoue() {
	return aJoue;
}


public void setaJoue(boolean aJoue) {
	this.aJoue = aJoue;
}


public void prendreCarte(Joueur victime , int pnumCarte) {
	//il faut alors remove la carte choisie de l'offre correspondante.
	this.jest.add(victime.main.get(pnumCarte));
	victime.main.remove(pnumCarte);
	
}
//supprimer la carte qu'il vient de prendre de l'offre
public ArrayList<Carte> getMain() {
	return main;
}


public void setMain(ArrayList<Carte> main) {
	this.main = main;
}
 

public ArrayList<Carte> getJest() {
	return jest;
}


public void setJest(ArrayList<Carte> jest) {
	this.jest = jest;
}


public void ConsulterMain() {
		System.out.println(this.getIndiceJoueur() + "-" + this.getNom() +": votre Main : " + this.getMain());
	}

public boolean MainContient(Carte pCarte) {
	boolean contient = false;
	Iterator<Carte> it = this.main.iterator();
	while (it.hasNext()) {
		Carte c = (Carte) it.next();
		if (c.equals(pCarte)) {
			contient = true;
		}
	}
	return contient; 
}

public Carte faireOffre(int index) {
	//il choisit une carte parmi les cartes de sa main 
	return this.main.get(index);
}




public int getIndiceJoueur() {
	return indiceJoueur;
}



public void setIndiceJoueur(int indiceJoueur) {
	this.indiceJoueur = indiceJoueur;
}


public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
}


public int getPoints() {
	return points;
}


public void setPoints(int points) {
	this.points = points;
}

public String toString() {
	StringBuffer sb = new StringBuffer();
	sb.append(this.indiceJoueur);
	sb.append("-");
	sb.append(this.nom);
	sb.append(":");
	sb.append(this.main);
	sb.append("\n");
	return sb.toString();
}



 





}