package fr.utt.projetLO02.GenialeVictoire;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * <b>Partie est une classe centrale qui dirige le déroulement d'une partie de Jest</b>
 * <p>
 * Une partie est caractérisée par les informations suivantes:
 * <ul>
 * <li>Une liste de joueurs qui seront des concurrents au fil du jeu.</li>
 * <li>Un jeu de cartes qui représentera la banque.</li>
 * <li>Un booléen qui indique si la partie est en cours ou pas.</li>
 * <li>Un joueur prioritaire qui détient la main pour chaque tour de jeu.</li>
 * </ul>
 * </p>
 * <p>
 * Une partie est capable d'ajouter et retirer des joueurs, vérifier qu'une valeur 
entrée par un joueur est valide, configurer le jeu, distribuer les cartes, présenter les trophées, ranger les cartes d'une liste de cartes et
choisir un joueur prioritaire.
 * </p>
 * 
 * @see Joueur 
 * @see Carte
 * @see JeuDeCartes
 * @see Famille
 * @see Valeur
 * @see OrangeBand
 * 
 * @author vicky
 *@version 1.0
 */

public class Partie {
	
	/**
	 * La liste des joueurs. Il est possible d'ajouter et de retirer des joueurs 
	 * <p>
	 * Pour de plus amples informations sur les joueurs regardez la
 documentation de la classe Joueur.
	 * </p>
	 * @see Partie#Partie()
	 * @see Partie#getListJoueurs()
	 * @see Partie#ajouterJoueur(Joueur)
	 * @see Partie#retirerJoueur(Joueur)
	 */
	private ArrayList<Joueur> listeJoueurs;
	

	/**
	 * Le jeu de cartes qui sera distribué au cours de la partie.
	 * @see Partie#getBanque() 
	 */
	private JeuDeCartes banque;
	
	/**
	 * Le booléen qui indique si la partie est en cours ou pas
	 * @see Partie#isPartieEnCours()
	 * @see Partie#setPartieEnCours(boolean)
	 */
	private boolean partieEnCours;
	
	/**
	 * Le joueur qui a le droit de jouer à chaque tour
	 * @see Partie#getPrioritaire()
	 * @see Partie#setPrioritaire(Joueur)
	 */
	private Joueur prioritaire = null;
	
	/**
	 * La pile de cartes qu'on constitue à la fin de chaque tour et qu'on redistribue.
	 * @see Partie#getStack()
	 * @see Partie#setStack(ArrayList)
	 */
	private LinkedList<Carte> stack;
	
	private ArrayList<Carte> listeJest; 
	private ArrayList<Carte> listeTrophees;
	
	/**
	 * Constructeur Partie.
	 * <p>
	 * A la construction d'un objet Partie, le booléen partieEnCours est
initialisé à false.
	 * </p>
	 * 
	 * @see Partie#banque
	 * @see Partie#listeJoueurs
	 * @see Partie#partieEnCours
	 */
	
	public Partie() {
		this.banque = new JeuDeCartes();
		this.stack = new LinkedList<Carte>();
		this.listeJoueurs = new ArrayList<Joueur>();
		this.listeJest  = new ArrayList<Carte>();
		this.listeTrophees = new ArrayList<Carte>();
		this.partieEnCours = false;
	}

	/**
	 * Ajoute un joueur à la liste des joueurs.
	 * 
	 * @param pjoueur
	 * 		Le nouveau joueur de la partie.
	 * @see Partie#listeJoueurs
	 */
	public void ajouterJoueur (Joueur pjoueur) {
		if (partieEnCours == false) {
			this.listeJoueurs.add(pjoueur);	
		}	
	} 
	
	/**
	 * Supprime un joueur de la liste de joueurs.
	 * 
	 * @param pjoueur
	 * @See Partie#listeJoueurs
	 */
	public void retirerJoueur (Joueur pjoueur) {
		this.listeJoueurs.remove(pjoueur);
	}


	/**
	 * Vérifie la validité d'une valeur entrée par un joueur.
	 * @param borneInf
	 * @param borneSup
	 * @return la valeur correcte du caractère
	 */
	public int verifier(int borneInf , int borneSup) {
		Scanner sc = new Scanner(System.in);
		String choix= "";
		int nombreConverti = -1;

		while ((nombreConverti < borneInf) || (nombreConverti> borneSup)) {
			try {
				choix = sc.nextLine();
				nombreConverti = Integer.parseInt(choix);
				if ((nombreConverti < borneInf) || (nombreConverti > borneSup)) {
					System.out.println("Entrer un nombre entier entre " + borneInf + " et " + borneSup);
					nombreConverti = -1;
				}
			}		
			catch (NumberFormatException e) {
				System.out.println("Entrer un nombre entier entre " + borneInf + " et " + borneSup);
				nombreConverti = -1;
			}
		}

		return nombreConverti;
	}

	/**
	 * Paramètre les modalités de la partie
	 * <p>
	 * <ul>
	 * <li>Enregistre les joueurs de la partie.</li>
	 * </ul>
	 * </p>
	 * @see Joueur
	 */
	
	public void configurer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Combien de joueurs voulez-vous pour cette partie?");
		System.out.println("Vous avez le choix entre 3 et 4 joueurs");
		int nombreJoueurs = verifier(3 , 4);
		for (int i = 1 ; i <= nombreJoueurs ; i++) {
			System.out.println("Entrez le nom du joueur " + i );
			String nomJoueur = sc.nextLine();
			System.out.println("Vous le voulez réel ou virtuel?");
			System.out.println("Vous devez entrer 0 pour réel et 1 pour virtuel");
			int typeJoueur = verifier(0 , 1);
			if (typeJoueur == 0) {
				Joueur j = new Joueur (i , nomJoueur);
				j.setNiveau(0);
				ajouterJoueur(j); 
				
			}else {
				System.out.println("Vous le voulez virtuel facile ou virtuel moyen?");
				System.out.println("Vous devez entrer 0 pour facile et 1 pour moyen");
				int niveauJoueur = verifier(0 , 1);
				if (niveauJoueur == 1) {
					JoueurVirtuel j = new JoueurVirtuel(i , nomJoueur);
					Strategy jStrat = new StrategieMoyenne(j);
					j.setStrategie(jStrat);
					j.setNiveau(2);
					ajouterJoueur(j);
				}else {
					JoueurVirtuel j = new JoueurVirtuel(i , nomJoueur);
					StrategieFacile jStrat = new StrategieFacile();
					j.setStrategie(jStrat);
					j.setNiveau(1);
					ajouterJoueur(j);
				}
			}
		}
		for (int i = 0 ; i < listeJoueurs.size() ; i++) {
			System.out.println("Joueur " + listeJoueurs.get(i).getIndiceJoueur() + " : " + listeJoueurs.get(i).getNom());
		}
	}

	/**
	 * Distribue deux cartes à chaque joueur.
	 * @see Carte
	 */
	public void distribuerBanque () {
		//this.partieEnCours = true;
		this.banque.melanger();
		Iterator<Joueur> it = listeJoueurs.iterator();
		while (it.hasNext()) {
			Joueur j = (Joueur) it.next();
			for (int i = 0 ; i < 2 ; i++) {
				j.getMain().add(this.banque.donnerCarte());
				j.setCopieMain(j.cloneMain());
			}
		}
	}

	public void distribuerStack () {
		
		Collections.shuffle(getStack());
		Iterator<Joueur> it = listeJoueurs.iterator();
		while (it.hasNext()) {
			Joueur j = (Joueur) it.next();
			for (int i = 0 ; i < 2 ; i++) {
				j.getMain().add(this.stack.pop());
				j.setCopieMain(j.cloneMain());
			}
		}
	}

	/**
	 * Affiche les trophées qui seront attribués aux joueurs correspondants en fin de partie.
	 * 
	 * @return les cartes constituant les trophées.
	 */
	public String presenterTrophees(){
		if (this.listeJoueurs.size() == 3) {
			for (int i = 0; i < 2; i++) {
				Carte trophee = this.banque.donnerCarte(); 
				while (trophee.getValue() == Valeur.Joker) {
					this.banque.melanger();
				}
				listeTrophees.add(trophee);	
			}
		}else if(this.listeJoueurs.size() == 4) {
			Carte trophee  = this.banque.donnerCarte();
			while (trophee.getValue() == Valeur.Joker) {
				this.banque.melanger(); 
			}
			listeTrophees.add(trophee);
		}
		return listeTrophees.toString();
	}

	
	/*
	Majority3,
	Majority4,
     */
	 public void attribuerTrophees () {
	
		 
		 for (Carte c : listeTrophees) {
			switch(c.getCondition())
			{
			case Highest_pique:
				 Carte highestPique = new Carte(Famille.Pique, Valeur.As);
				for (Carte carteActuelle : listeJest) {
					if (carteActuelle.getSuit().equals(Famille.Pique) && carteActuelle.getValue().ordinal() >= highestPique.getValue().ordinal()) {
						highestPique = carteActuelle;
					}
				}
				Iterator<Joueur> itPique = listeJoueurs.iterator();
				while (itPique.hasNext()) {
					Joueur j = itPique.next();
					if (j.jestContient(highestPique)) {
						j.getJest().getCartesJest().add(c);
						listeTrophees.remove(c);
					}
				}
				break;
				
			case Highest_trèfle:
				 Carte highestTrefle = new Carte(Famille.Trèfle, Valeur.As);
					for (Carte carteActuelle : listeJest) {
						if (carteActuelle.getSuit().equals(Famille.Trèfle) && carteActuelle.getValue().ordinal() >= highestTrefle.getValue().ordinal()) {
							highestTrefle = carteActuelle;
						}
					}
					Iterator<Joueur> itTrefle = listeJoueurs.iterator();
					while (itTrefle.hasNext()) {
						Joueur j = itTrefle.next();
						if (j.jestContient(highestTrefle)) {
							j.getJest().getCartesJest().add(c);
							listeTrophees.remove(c);
						}
					}
					break;
					
			case Highest_carreau:
				Carte highestCarreau = new Carte(Famille.Carreau, Valeur.As);
				for (Carte carteActuelle : listeJest) {
					if (carteActuelle.getSuit().equals(Famille.Carreau) && carteActuelle.getValue().ordinal() >= highestCarreau.getValue().ordinal()) {
						highestCarreau = carteActuelle;
					}
				}
				Iterator<Joueur> itCarreau = listeJoueurs.iterator();
				while (itCarreau.hasNext()) {
					Joueur j = itCarreau.next();
					if (j.jestContient(highestCarreau)) {
						j.getJest().getCartesJest().add(c);
						listeTrophees.remove(c);
					}
				}
				break;
			
			case Highest_coeur:
				Carte highestCoeur = new Carte(Famille.Coeur, Valeur.As);
				for (Carte carteActuelle : listeJest) {
					if (carteActuelle.getSuit().equals(Famille.Coeur) && carteActuelle.getValue().ordinal() >= highestCoeur.getValue().ordinal()) {
						highestCoeur = carteActuelle;
					}
				}
				Iterator<Joueur> itCoeur = listeJoueurs.iterator();
				while (itCoeur.hasNext()) {
					Joueur j = itCoeur.next();
					if (j.jestContient(highestCoeur)) {
						j.getJest().getCartesJest().add(c);
						listeTrophees.remove(c);
					}
				}
				break;
			
			case Lowest_pique:
				 Carte lowestPique = new Carte(Famille.Pique, Valeur.Quatre);
					for (Carte carteActuelle : listeJest) {
						if (carteActuelle.getSuit().equals(Famille.Pique) && carteActuelle.getValue().ordinal() <= lowestPique.getValue().ordinal()) {
							lowestPique = carteActuelle;
						}
					}
					Iterator<Joueur> itPique2 = listeJoueurs.iterator();
					while (itPique2.hasNext()) {
						Joueur j = itPique2.next();
						if (j.jestContient(lowestPique)) {
							j.getJest().getCartesJest().add(c);
							listeTrophees.remove(c);
						}
					}
					break;
					
			case Lowest_trèfle:
				Carte lowestTrefle = new Carte(Famille.Trèfle, Valeur.Quatre);
				for (Carte carteActuelle : listeJest) {
					if (carteActuelle.getSuit().equals(Famille.Trèfle) && carteActuelle.getValue().ordinal() <= lowestTrefle.getValue().ordinal()) {
						lowestTrefle = carteActuelle;
					}
				}
				Iterator<Joueur> itTrefle2 = listeJoueurs.iterator();
				while (itTrefle2.hasNext()) {
					Joueur j = itTrefle2.next();
					if (j.jestContient(lowestTrefle)) {
						j.getJest().getCartesJest().add(c);
						listeTrophees.remove(c);
					}
				}
				break;
				
			case Lowest_carreau:
				Carte lowestCarreau = new Carte(Famille.Carreau, Valeur.Quatre);
				for (Carte carteActuelle : listeJest) {
					if (carteActuelle.getSuit().equals(Famille.Carreau) && carteActuelle.getValue().ordinal() <= lowestCarreau.getValue().ordinal()) {
						lowestCarreau = carteActuelle;
					}
				}
				Iterator<Joueur> itCarreau2 = listeJoueurs.iterator();
				while (itCarreau2.hasNext()) {
					Joueur j = itCarreau2.next();
					if (j.jestContient(lowestCarreau)) {
						j.getJest().getCartesJest().add(c);
						listeTrophees.remove(c);
					}
				}
				break;
				
			case Lowest_coeur:
				Carte lowestCoeur = new Carte(Famille.Coeur, Valeur.Quatre);
				for (Carte carteActuelle : listeJest) {
					if (carteActuelle.getSuit().equals(Famille.Coeur) && carteActuelle.getValue().ordinal() <= lowestCoeur.getValue().ordinal()) {
						lowestCoeur = carteActuelle;
					}
				}
				Iterator<Joueur> itCoeur2 = listeJoueurs.iterator();
				while (itCoeur2.hasNext()) {
					Joueur j = itCoeur2.next();
					if (j.jestContient(lowestCoeur)) {
						j.getJest().getCartesJest().add(c);
						listeTrophees.remove(c);
					}
				}
				break;
				
			case Majority2:
				int compteur2 = 0;
				int[] tabNombreDe2 = new int[4];
				int iJoueur = 0;
				int etape = 0;
					int	icherch ;
				for (iJoueur = 0 ; iJoueur < listeJoueurs.size() ; iJoueur++) {
					for (Carte carte : listeJoueurs.get(iJoueur).getJest().getCartesJest()) {
						if (carte.getValue().equals(Valeur.Deux)) {
							compteur2++ ;
						}	
					}
					tabNombreDe2[iJoueur] = compteur2;
					compteur2 = 0;
				}
				int posMax = etape;
				for (etape = 0 ; etape <= listeJoueurs.size() ; etape++) {
					
					for (icherch = etape + 1 ; icherch <= listeJoueurs.size() ; icherch++) {
						if (tabNombreDe2[icherch] > tabNombreDe2[posMax]) {
							posMax = icherch;
						}
					}
				}
				listeJoueurs.get(posMax).getJest().getCartesJest().add(c);
				listeTrophees.remove(c);
				break;
				
			case Majority3:
				int compteur3 = 0;
				int[] tabNombreDe3 = new int[4];
				int iJoueur3 = 0;
				int etape3 = 0;
					int	icherch3 ;
				for (iJoueur3 = 0 ; iJoueur3 < listeJoueurs.size() ; iJoueur3++) {
					for (Carte carte : listeJoueurs.get(iJoueur3).getJest().getCartesJest()) {
						if (carte.getValue().equals(Valeur.Trois)) {
							compteur3++ ;
						}	
					}
					tabNombreDe3 [iJoueur3] = compteur3;
					compteur3 = 0;
				}
				int posMax3 = etape3;
				for (etape3 = 0 ; etape3 <= listeJoueurs.size() ; etape3++) {
					
					for (icherch3 = etape3 + 1 ; icherch3 <= listeJoueurs.size() ; icherch3++) {
						if (tabNombreDe3[icherch3] > tabNombreDe3[posMax3]) {
							posMax3 = icherch3;
						}
					}
				}
				listeJoueurs.get(posMax3).getJest().getCartesJest().add(c);
				listeTrophees.remove(c);
				break;
			
			case Joker:
				Carte joker = new Carte (Famille.Joker , Valeur.Joker);
				for (Joueur j : listeJoueurs) {
					if (j.jestContient(joker)) {
						j.getJest().getCartesJest().add(c);
						listeTrophees.remove(c);
					}
				}
				break;
				
			case Best_jest:
				for (Joueur j : listeJoueurs) {
					if (j.jestContient(rangerCartes(listeJest).get(0))) {
						j.getJest().getCartesJest().add(c);
						listeTrophees.remove(c);
					}
				}
				break;
				
			case Best_jest_no_joke:
				Carte newJoker = new Carte (Famille.Joker , Valeur.Joker);
				for (Joueur j : listeJoueurs) {
					if ((j.jestContient(rangerCartes(listeJest).get(0))) && (j.jestContient(newJoker)) == false) {
						j.getJest().getCartesJest().add(c);
						listeTrophees.remove(c);
					}
				}
				break;
				default:
					System.out.println("Cette condition n'existe pas");
					break;
	 }
		 }
		 }
	 
		 
	 
	 
	/**
	 * Range dans l'ordre décroissant la liste des cartes entrée en paramètre.
	 * @param plisteCartes
	 * @return la liste entrée en paramètre rangée dans l'ordre 
	 * 
	 */
	public ArrayList<Carte> rangerCartes (ArrayList<Carte> plisteCartes) {
		Carte inter;
		int etape = 0; int i;
		for ( etape = 0 ; etape <= plisteCartes.size() - 1 ; etape++) { 
			int posMax = etape;

			for ( i = etape + 1 ; i < plisteCartes.size() ; i++) {

				if (plisteCartes.get(i).getValue().ordinal() > plisteCartes.get(posMax).getValue().ordinal()  ) { 
					posMax = i;
				}else if (plisteCartes.get(i).getValue().ordinal() == plisteCartes.get(posMax).getValue().ordinal()) {
					if (plisteCartes.get(i).getSuit().ordinal() > plisteCartes.get(posMax).getSuit().ordinal()) {
						posMax = i; 
					}
				}
			}
			inter = plisteCartes.get(posMax);
			plisteCartes.set(posMax, plisteCartes.get(etape));
			plisteCartes.set(etape, inter);
		}

		return plisteCartes; 
	}

	/**
	 * <p>
	 * Parcourt la liste des joueurs et choisit le joueur prioritaire en comparant 
la liste de cartes entrée en paramètre.
	 * </p>
	 * @param plisteCartes
	 * 		La liste des cartes qui va permettre de déterminer qui est le prioritaire
	 * @return le joueur prioritaire 
	 * @see Partie#prioritaire
	 */
	public Joueur choisirPrioritaire(ArrayList<Carte> plisteCartes) {

		rangerCartes(plisteCartes);	
		Iterator<Joueur> it = listeJoueurs.iterator();
		System.out.println( "Offres : " +plisteCartes);	

		//for (int i = 0 ; i < plisteCartes.size() ; i++) {
		while (it.hasNext()) {
			Joueur j = it.next();
			if (j.mainContient(plisteCartes.get(0)) && j.isaJoue() == false) {
				prioritaire = j;
				break;
			}
		} 
		//}
		return prioritaire;
	}
	
	
//  désigner le gagnant.

	public Joueur designerGagnant(ArrayList<Integer> listePoints) {
		Joueur gagnant = null;
		int etape , icherch, posMax , inter;
		for (etape = 1 ; etape < listePoints.size() ; etape++) {
			posMax = etape;
			for (icherch = etape + 1 ; icherch <= listePoints.size() ; icherch++) {
				if (listePoints.get(icherch) > listePoints.get(posMax)) {
					posMax = icherch;
				}
			}
			inter =  listePoints.get(posMax);
			listePoints.set(posMax, listePoints.get(etape));
			listePoints.set(etape, inter);
		}
		Iterator<Joueur> itgagnant = listeJoueurs.iterator();
		while (itgagnant.hasNext()) {
			Joueur j = itgagnant.next();
			if(j.getJest().getPointsJest() == listePoints.get(0)) {
				gagnant = j;
			}
		}
		
		return gagnant;
	}
	/*public void verifierValiditeChoix() {
		//le joueur victime choisi a déja été choisi donc il n'a plus deux cartes dans sa main 
		//le joueur prioritaire a rentré son propre numéro: il n'a pas le  droit s'il reste des joueurs qui n'ont 
	}*/
	
	
	/**
	 * Déroule les tours successifs d'une partie.
	 * 
	 * @see Joueur 
	 * @see Partie#getListJoueurs()
	 * @see Partie#banque
	 *
	 */
	public void jouer() {

		ArrayList<Integer> listePoints = new ArrayList<Integer>();
		ArrayList<Joueur> ontJoue = new ArrayList<Joueur>();
		this.setPartieEnCours(true);
		System.out.println("Trophées: " + presenterTrophees());
		distribuerBanque();

		while (this.partieEnCours) {
			int numJoueur = 0;
			int numCarte = 0;
			
			//présenter les offres de chaque joueur 
			ArrayList <Carte> listeOffres = new ArrayList <Carte>();
			Iterator<Joueur> it = this.listeJoueurs.iterator(); 
			while (it.hasNext()) {
				Joueur j = (Joueur)it.next();
				if(j.getNiveau() == 0) {
				j.consulterMain();
				System.out.println(" Quelle carte voulez vous découvrir?");
				System.out.println("Entrez 0 pour la première carte et 1 pour la deuxième");
				int index = verifier(0 , 1);
				j.construireOffre(index);
				Carte offre = j.faireOffre(index);
				System.out.println("Offre complète de " + j.getNom() + ":" +j.getOffre());
				listeOffres.add(j.getIndiceJoueur() - 1, offre);
				}else {//if (j instanceof JoueurVirtuel) {//faire une offre pour un joueur virtuel
			 		int index = ((JoueurVirtuel) j).getStrategie().faireOffre(0, 1);
					j.construireOffre(index);
					System.out.println("Offre complète de " + j.getNom() + ":" +j.getOffre());
					//System.out.println("Numéro d'offre choisi par le bot: " + index);
					//System.out.println("Carte découverte du bot: " + j.getCopieMain().get(index));
					Carte offre = j.faireOffre(index); 
					System.out.println("Offre de " + j.getNom() + ":" + offre.toString());
					listeOffres.add(j.getIndiceJoueur() - 1, offre);
				}
			} 
 
			prioritaire = choisirPrioritaire(listeOffres);
			
			for(Joueur j : this.getListJoueurs()) {
				j.setaJoue(false);
			}
			while ((prioritaire != null) && prioritaire.isaJoue() == false){
				System.out.println(prioritaire.getNom() + " A vous de jouer");
				if(prioritaire.getNiveau() == 0) {
				System.out.println (" Entrez le numéro du joueur cible"); 
				numJoueur = verifier(1, listeJoueurs.size());
				}else {
					numJoueur = ((JoueurVirtuel)prioritaire).getStrategie().choisirJoueur(1, listeJoueurs.size(), listeOffres, listeJoueurs , ontJoue);//choisir un joueur cible pour un joueur virtuel
					System.out.println("Vous avez choisi le joueur n° " + listeJoueurs.get(numJoueur - 1).getIndiceJoueur() + ", " + listeJoueurs.get(numJoueur - 1).getNom() );
				}

				//préciser qu'il peut prendre chez lui si dans une partie de 3 les deux autres ont pioché l'un dans l'offre de l'autre
				while (numJoueur == prioritaire.getIndiceJoueur()) {
					//System.out.println("Le prioritaire est " + prioritaire.getNom());
					//System.out.println("Le joueur victime est " + listeJoueurs.get(numJoueur -1).getNom());
					if( listeJoueurs.get(numJoueur -1).getMain().size() == 2) {
						if (ontJoue.size() == listeJoueurs.size() - 1){ 
							System.out.println("Vous avez le droit pour cette fois");
							break;
						} 
						else{
							System.out.println("Vous ne pouvez pas piocher dans votre propre main car vous n'êtes pas le seul à ne pas avoir encore joué");
							if (prioritaire.getNiveau() == 0) {
							System.out.println("Entrez un autre numéro de joueur");
							numJoueur = verifier(1, listeJoueurs.size());
							}else {
								numJoueur = ((JoueurVirtuel)prioritaire).getStrategie().choisirJoueur(1, listeJoueurs.size(), listeOffres, listeJoueurs , ontJoue);//pour un joueur virtuel
							}
						}
					} 
					else{
						System.out.println("Vous ne pouvez pas piocher dans votre main incomplète");
						if (prioritaire.getNiveau() == 0) {
							System.out.println("Entrez un autre numéro de cible");
							numJoueur = verifier(1, listeJoueurs.size());
							}else {
								numJoueur = ((JoueurVirtuel)prioritaire).getStrategie().choisirJoueur(1, listeJoueurs.size(), listeOffres, listeJoueurs , ontJoue);//pour un joueur virtuel		
					}
				} 
				}
				//Ne pas permettre qu'on prenne chez un joueur qui n'a qu'une carte dans sa main
				if (listeJoueurs.get(numJoueur - 1).getMain().size() != 2) {//!!!! pourquoi au tour du deuxième joueur il permet qu'on prenne dans la main d'un joueur qui n'a qu'une carte dans sa main??
					if (prioritaire.getNiveau() == 0) {
			 			System.out.println("Vous ne pouvez pas piocher chez ce joueur car sa main est incomplète");
						System.out.println("Entrez un autre numéro de cible");
						numJoueur = verifier(1, listeJoueurs.size());
						System.out.println(listeJoueurs.get(numJoueur - 1).getMain().size() != 2);
						}else {
							int numjoueur1 ;
							//while (listeJoueurs.get(numJoueur - 1).getMain().size() != 2) {
							System.out.println("Vous ne pouvez pas piocher chez ce joueur car sa main est incomplète, BOT!!");
							numjoueur1=numJoueur;
							numJoueur = ((JoueurVirtuel)prioritaire).getStrategie().choisirJoueur(1, listeJoueurs.size(), listeOffres, listeJoueurs , ontJoue);//pour un joueur virtuel
							if(numjoueur1==numJoueur)
								System.out.println("C'est la même chose");
							System.out.println(listeJoueurs.get(numJoueur - 1).getMain().size() != 2);
							
							//}
				}  
				} 
				//indiquer la carte à prendre
				if (prioritaire.getNiveau() == 0) {
				System.out.println("Quelle carte souhaitez-vous prendre?");
				System.out.println("Entrez 0 ou 1");
				     numCarte = verifier(0, 1);
				}else {
					//System.out.println("Offre complète de la victime "+ listeJoueurs.get(numJoueur - 1).getNom() + " avant d'avoir été touchée :" + listeJoueurs.get(numJoueur - 1).getOffre());
					 numCarte = ((JoueurVirtuel)prioritaire).getStrategie().choisirCarte(0, 1, listeJoueurs.get(numJoueur - 1));
					 System.out.println("Vous avez choisi la carte n°" + numCarte);
					 System.out.println("Il s'agit de " + listeJoueurs.get(numJoueur - 1).getCopieMain().get(numCarte));
				}

				//Afficher les jest des joueurs avant d'avoir jouer
				System.out.println("Jest de " + prioritaire.getNom() + " avant d'avoir joué:" + prioritaire.getJest().getCartesJest());
				System.out.println("Main de la victime "+ listeJoueurs.get(numJoueur - 1).getNom() + " avant d'avoir été touchée :" + listeJoueurs.get(numJoueur - 1).getMain());
			 	
				
				prioritaire.prendreCarte(listeJoueurs.get(numJoueur - 1) , numCarte);
				

				//récupérer la seule carte restant dans la main du joueur victime
				if(this.banque.tailleBanque() != 0 ) { 
				this.stack.add(listeJoueurs.get(numJoueur - 1).getMain().get(0));
				listeJoueurs.get(numJoueur - 1).getMain().remove(0);
				} else {
					listeJoueurs.get(numJoueur - 1).getJest().getCartesJest().add(listeJoueurs.get(numJoueur - 1).getMain().get(0));
					listeJoueurs.get(numJoueur - 1).getMain().remove(0);
				}
				
				//this.banque.ajouterCarte(listeJoueurs.get(numJoueur - 1).getMain().get(0));
				//Afficher les jest des joueurs après avoir jouer
				System.out.println("Jest de "+ prioritaire.getNom() + " après avoir joué:" + prioritaire.getJest().getCartesJest());
				System.out.println("Etat du stack: " + stack);
				System.out.println("Main de la victime "+ listeJoueurs.get(numJoueur - 1).getNom() + " après avoir été touchée :" + listeJoueurs.get(numJoueur - 1).getMain());
				
				prioritaire.setaJoue(true); 
				ontJoue.add(prioritaire);
 
				//retirer l'offre du joueur qui vient de jouer de la liste des offres 
				/*Iterator<Carte> it3 = prioritaire.getMain().iterator();//!!!!pourquoi au tour du deuxieme joueur il ne supprime pas son offre de la liste des offres,
				int comptIterateur = 0;
				while (it3.hasNext() && comptIterateur < 2) {
					Carte c = it3.next();
					//it3 = prioritaire.getMain().iterator();
					System.out.println(c);
					for (int k = 0 ; k < listeOffres.size() ; k++) {
						if (c.equals(listeOffres.get(k))) { 
							listeOffres.remove(c);
							System.out.println(listeOffres);
						}else
							{
							System.out.println("il n'y a pas");
							}
					}  
					comptIterateur++;
				}*/
				 
				//ArrayList<Carte> copieMainPrioritaire = prioritaire.cloneMain();
				System.out.println("Copie de la main de " + prioritaire.getNom()+ " : " + prioritaire.getCopieMain());
				System.out.println(prioritaire.getCopieMain().get(0));
				if (listeOffres.size() != 0) {
				for (int k = 0 ; k < listeOffres.size() ; k++) {
					if (prioritaire.getCopieMain().get(0).equals(listeOffres.get(k))) { 
						listeOffres.remove(prioritaire.getCopieMain().get(0));
						System.out.println(listeOffres);
					}/*else
						{
						System.out.println("il n'y a pas");
						}*/
				}
				System.out.println(prioritaire.getCopieMain().get(1));
				for (int k = 0 ; k < listeOffres.size() ; k++) {
					if (prioritaire.getCopieMain().get(1).equals(listeOffres.get(k))) { 
						listeOffres.remove(prioritaire.getCopieMain().get(1));
						System.out.println(listeOffres);
					}/*else
						{
						System.out.println("il n'y a pas");
						}*/
				}
				}else {
					System.out.println("Il n'y a plus d'offre");
				}
				

				// vérifier que le joueur chez qui on vient de piocher n'a pas encore joué.
				//Dans ce cas c'est lui le prochain joueur 
				if (listeJoueurs.get(numJoueur - 1).isaJoue() == false) {
					prioritaire = listeJoueurs.get(numJoueur - 1); 
					System.out.println("Le nouveau prioritaire est : " + prioritaire.getNom() + " ligne 503");
																		}
						else {
					//ranger les offres restantes dans le tableau et désigner celui a qui appartient la plus grande carte comme premier joueur 
					//appeler la méthode choisir prioritaire qui prend un tableau d'offres en paramètre et renvoie un joueur, celui à qui appartient la première carte
								if (listeOffres.size() != 0) {
					prioritaire = choisirPrioritaire(listeOffres); 
					System.out.println("Le nouveau prioritaire est : " + prioritaire.getNom() + " ligne 508");
												}else {
													
													System.out.println("La round est terminé");
													System.out.println("**********************ETAT DES LIEUX**********************");
													ontJoue.removeAll(ontJoue);
													
													
													System.out.println("Stack avant ajout: " + this.getStack());
													if (banque.tailleBanque() != 0) {
														if (listeJoueurs.size() == 3) {
	 												this.stack.add(this.banque.donnerCarte());
													this.stack.add(this.banque.donnerCarte());
													this.stack.add(this.banque.donnerCarte());
														}else {
															this.stack.add(this.banque.donnerCarte());
															this.stack.add(this.banque.donnerCarte());
															this.stack.add(this.banque.donnerCarte());
															this.stack.add(this.banque.donnerCarte());
														}
													}else {
														System.out.println("*****************FIN DE LA PARTIE****************");
														
													}
													System.out.println("Stack après ajout: " + this.getStack());
													Iterator<Joueur> itTest = this.listeJoueurs.iterator();
													while(itTest.hasNext()) {
														Joueur j = itTest.next();
														j.getOffre().clear();
														System.out.println("Main de " + j.getNom() + " : " + j.getMain());
							 							System.out.println("Jest de " + j.getNom() + " : " + j.getJest().getCartesJest());
														
													}
													System.out.println("Liste des joueurs ayant joué" + ontJoue);
													
												}
					}
				
					
				System.out.println("Banque: " + this.getBanque().toString());
				System.out.println(this.getBanque().tailleBanque());

			}
			if (this.stack.size() == 0) {
				this.setPartieEnCours(false);
			} 
			if (stack.size() != 0) {
	      distribuerStack();
			}else {
				System.out.println("**********************NOUS ALLONS PROCEDER AU COMPTAGE DES POINTS*************************");
				//Mettre toutes les cartes de tous les jest dans une liste 
				for (Joueur j : listeJoueurs) {
					for ( Carte c : j.getJest().getCartesJest()) {
						listeJest.add(c);
					}
				
				}
				System.out.println("Liste des cartes de tous les jests confondus: " + listeJest);
				attribuerTrophees();
				//Appeler la méthode de comptage de points 
				CompteurPointsVisitor compteurVisitor = new CompteurPointsVisitor();
				Iterator<Joueur> itPts = listeJoueurs.iterator();
				while (itPts.hasNext()) {
					Joueur j = itPts.next();
					compteurVisitor.visit(j.getJest());	
				System.out.println("Total des points de " + j.getNom() + ": " +  j.getJest().getPointsJest());
				listePoints.add(j.getJest().getPointsJest());
				}
				System.out.println("Liste des points" + listePoints);
				System.out.println("AND THE WINNER IS....................: " + designerGagnant(listePoints).getNom());
			}
		} 
	}
	
	
	public LinkedList<Carte> getStack() {
		return stack;
	}

	public void setStack(LinkedList<Carte> stack) {
		this.stack = stack;
	}
	
	public ArrayList<Joueur> getListJoueurs() {
		return listeJoueurs;
	}

	public void setListJoueurs(ArrayList<Joueur> listJoueurs) {
		this.listeJoueurs = listJoueurs;
	}

	public JeuDeCartes getBanque() {
		return banque;
	}

	public void setBanque(JeuDeCartes banque) {
		this.banque = banque;
	}

	public boolean isPartieEnCours() {
		return partieEnCours;
	}

	public void setPartieEnCours(boolean partieEnCours) {
		this.partieEnCours = partieEnCours;
	}


	public Joueur getPrioritaire() {
		return prioritaire;
	}


	public void setPrioritaire(Joueur prioritaire) {
		this.prioritaire = prioritaire;
	}




}









