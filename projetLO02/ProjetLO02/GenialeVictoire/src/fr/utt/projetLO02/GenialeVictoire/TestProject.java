package fr.utt.projetLO02.GenialeVictoire;
/**
 * Classe contenant la méthode main, qui permet d'exécuter le programme.
 * @author vicky
 *
 */
public class TestProject {

	public static void main(String[] args) { 
		// TODO Auto-generated method stub

		
		Partie partie1 = new Partie();
		
		//Carte testCarte01 = new Carte(Famille.Carreau, Valeur.As);
		//Carte testCarte02 = new Carte(Famille.Carreau, Valeur.Deux);
		
		//System.out.println("Test Equals ::"+testCarte01.equals(testCarte02));
		
		
		partie1.configurer();
		partie1.jouer();
		
		 
	}
	 
 
}
