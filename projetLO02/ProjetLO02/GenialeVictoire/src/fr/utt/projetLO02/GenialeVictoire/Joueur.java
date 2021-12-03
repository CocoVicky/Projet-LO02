package fr.utt.projetLO02.GenialeVictoire;
/**
 * <b> La classe Joueur permet de créer les joueurs, qu'ils soient réels ou virtuels.</b>
 * <p>
 * Un joueur est caractérisé par les informations suivantes  : 
 * <ul>
 * <li>Son nom attribué arbitrairement</li>
 * <li>Son indice attribué définitivement</li>
 * <li>Son nombre de points</li>
 * <li>Sa main</li>
 * <li>Son jest</li>
 * <li> Le fait qu'il ait joué ou pas</li>
 * </ul>
 * </p>
 * <p>
 * De plus, un joueur pourra prendre une carte de la main d'un joueur concurrent.
 * </p>
 * @see  prendreCarte
 * <p>
 * Il pourra consulter sa main, c'est à dire afficher les cartes contenues dans sa main.
 * </p>
 * @see consulterMain
 * <p>
 * Il pourra également renseigner si main contient une carte en particulier.
 * </p>
 * @see mainContient 
 * <p>
 * Il sera enfin capable de faire une offre, en retournant une carte de sa main. 
 * </p>
 * @see faireOffre
 * @author vicky
 * @version 1.0
 *
 */
import java.util.ArrayList;

import java.util.Iterator;

public class Joueur {
	/**
	 * <p>
	 * Le nom du joueur, attribué arbitrairement au moment de la configuration de la partie.
 Il n'est pas modifiable.
 	 *</p>
	 * @see Joueur#Joueur(int, String)
	 * @see Joueur#getNom()
	 */
private String nom;
	/**
	 * <p>
	 * L'indice permet au joueur d'être identifiable à partir d'un entier.
	 * Lui non plus n'est pas modifiable et attribué arbitrairement. 
	 * </p>
	 * @see Joueur#getIndiceJoueur()
	 */
private int indiceJoueur;

	/**
	 * <p>
	 * La main est une liste de cartes appartenenant a chaque joueur 
après que l'on ait distribué les cartes de la banque.
Le joueur n'a pas d'incidence sur sa propre main. Il ne peut ni ajouter des cartes ni en retirer.
     * </p>
     * @see Joueur#getMain()
	 */
private ArrayList<Carte> main;

/**
 * <p>
 * Il s'agit de la performance de chaque joueur: un joueur peut être réel, virtuel facile ou virtuel moyen.
Ces niveaux sont représentés par les entiers 0 , 1 ou 2.
 * </p>
 * @see Joueur#getNiveau()
 */
private int niveau;
	/**
	 * <p>
	 * Le jest est une liste de cartes que le joueur constitue au fil 
de la partie en prenant des cartes dans les mains des autres joueurs.
	 *</p>
	 *@see Joueur#getJest()
	 */
private  Jest jest;
	/**
	 * <p>
	 * aJoue est un booleen qui signifie si le joueur a joué ou pas.
	 * </p>
	 * @see Joueur#isaJoue()
	 */
private boolean aJoue;

/**
 * <p>
 * Elle est constituée de la carte que le joueur a décidé de retourner et de celle qu'il garde 
face cachée.
 * </p>
 * @see Joueur#getOffre()
 */
private ArrayList<Carte> offre;

/**
 * <p>Il s'agit d'un clone de la main du joueur qui permettra d'effectuer des opérations sans incidence 
sur la main originale.
 *</p>
 *@see Joueur#getCopieMain()
 */
private ArrayList<Carte> copieMain;

/**
 * Crée une copie de la main du joueur pour qu'on puisse y faire des opérations sans modifier la main.
 * @return la copie de la main du joueur 
 */
public ArrayList<Carte> cloneMain(){
	ArrayList<Carte> clone = new ArrayList<Carte>();
	for (Carte c : this.getMain()) {
		clone.add(c.clone());
	}
	return clone;
}

public Joueur(int pIndice , String pnom) {
	/**
	 * Constructeur Joueur.
	 * <p>
	 * A la conctruction d'un objet Joueur, le boolean aJoue est initialisé 
à false, et le nombre de points à 0.
	 * </p>
	 * @param pIndice
	 * 		L'indice du Joueur.
	 * @param pnom
	 * 		Le nom du joueur.
	 * @see Joueur#nom
	 * @see Joueur#indiceJoueur
	 * @see Joueur#main
	 * @see Joueur#Jest
	 * @see Joueur#aJoue
	 * @see Joueur#points
	 */
	this.nom = pnom;
	this.indiceJoueur = pIndice;
	this.main = new ArrayList<Carte>();
	//this.jest = new ArrayList<Carte>();
	this.jest = new Jest();
	
	this.offre = new ArrayList<Carte>();
	this.aJoue = false;
	this.copieMain = this.cloneMain();
}


public ArrayList<Carte> getMain() {
	return main;
}

public ArrayList<Carte> getCopieMain() {
	return copieMain;
} 
public void setCopieMain(ArrayList<Carte> copieMain) {
	this.copieMain = copieMain;
}

public boolean isaJoue() {
	return aJoue;
}


public void setaJoue(boolean aJoue) {
	this.aJoue = aJoue;
}


/**
 * Permet au joueur de prendre une carte dans la main d'un joueur victime et de la mettre dans son propre Jest.
 * @param victime
 * @param pnumCarte
 */
public void prendreCarte(Joueur victime , int pnumCarte) {
	//il faut alors remove la carte choisie de l'offre correspondante.
	this.jest.getCartesJest().add(victime.getMain().get(pnumCarte));
	victime.main.remove(pnumCarte);
	 
} 
 


public int getNiveau() {
	return niveau;
}

public void setNiveau(int niveau) {
	this.niveau = niveau;
}

public void setMain(ArrayList<Carte> main) {
	this.main = main;
}
 
public void consulterMain() {
		System.out.println(this.getIndiceJoueur() + "-" + this.getNom() +": votre Main : " + this.getMain());
	}

public Jest getJest() {
	return jest;
}
public void setJest(Jest jest) {
	this.jest = jest;
}
/**
 * Recherche dans la main d'un joueur une carte passée en paramètre.
 *
 * @param pCarte 
 * @return un booléen en fonction de si oui ou non la main de ce joueur contient la carte passée en paramètre
 * 
 */
public boolean mainContient(Carte pCarte) {
	boolean contient = false;
	Iterator<Carte> it = this.copieMain.iterator();
	while (it.hasNext()) {
		Carte c = (Carte) it.next();
		if (c.equals(pCarte)) { 
			contient = true;
		}
	}
	return contient; 
}

/**
 * Recherche dans le jest d'un joueur une carte passée en paramètre.
 *
 * @param pCarte 
 * @return un booléen en fonction de si oui ou non le jest de ce joueur contient la carte passée en paramètre.
 * 
 */
public boolean jestContient(Carte pCarte) {
	boolean contient = false;
	Iterator<Carte> it = this.jest.getCartesJest().iterator();
	while (it.hasNext()) {
		Carte c = (Carte) it.next();
		if (c.equals(pCarte)) { 
			contient = true;
		}
	}
	return contient; 
}

/**
 * Permet au joueur de retourner la carte qu'il souhaite découvrir 
 * 
 * @param index
 * @return l'offre du joueur 
 */
public Carte faireOffre(int index) {
	//il choisit une carte parmi les cartes de sa main 
	
	return this.main.get(index);
}
 

/**
 * <p>
 * Ajoute à la première position de l'offre du joueur la carte qu'il a
décidé de découvrir et à la deuxième position celle qu'il souhaite garder cachée.
 * </p>
 * @param numOffre
 */
public void construireOffre(int numOffre) {
	this.offre.add(0, this.copieMain.get(numOffre)) ;
	this.offre.add(1, this.copieMain.get(Math.abs(numOffre - 1)));
}


public int getIndiceJoueur() {
	return indiceJoueur;
}



public void setIndiceJoueur(int indiceJoueur) {
	this.indiceJoueur = indiceJoueur;
}
 
public ArrayList<Carte> getOffre() {
	return offre;
}
public void setOffre(ArrayList<Carte> offre) {
	this.offre = offre;
}

public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
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