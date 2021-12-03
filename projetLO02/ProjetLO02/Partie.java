package fr.utt.projetLO02.GenialeVictoire;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Partie {

	private ArrayList<Joueur> listeJoueurs;
	private JeuDeCartes banque;
	private boolean partieEnCours;
	private Joueur prioritaire = null;
	
	

	public Partie() {
		this.banque = new JeuDeCartes();
		this.listeJoueurs = new ArrayList<Joueur>();
		this.partieEnCours = false;
	}
	

	public void ajouterJoueur (Joueur pjoueur) {
		if (partieEnCours == false) {
		this.listeJoueurs.add(pjoueur);	
		}	
		} 
	
	
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
	
	
	 public void configurer() {
	    	System.out.println("Combien de joueurs voulez-vous pour cette partie?");
	    	System.out.println("Vous avez le choix entre 3 et 4 joueurs");
	    	int nombreJoueurs = verifier(3 , 4); //v�rifier que les valeurs entr�es sont celles demand�e
	    
	    	if (nombreJoueurs == 3) {
	    		
	    		System.out.println("Combien de joueurs virtuels souhaitez-vous affronter?");
	    		int nombreJoueursVirtuels = verifier(0 , 2);
	    		switch (nombreJoueursVirtuels)
	    		{
	    		case 0:
		    		Joueur j1 = new Joueur( 1 , "Mimi");
		    		Joueur j2 = new Joueur(2 , "Aim�");
		    		Joueur j3 = new Joueur(3 , "Franck");
		    		ajouterJoueur(j1);
		    		ajouterJoueur(j2);
		    		ajouterJoueur(j3);
	    			break;
	    			
	    		case 1:
	    			JoueurVirtuel j11 = new JoueurVirtuel( 1 , "MimiBot");
		    		Joueur j21 = new Joueur(2 , "Aim�");
		    		Joueur j31 = new Joueur(3 , "Franck");
		    		ajouterJoueur(j11);
		    		ajouterJoueur(j21);
		    		ajouterJoueur(j31);
		    		break;
		    	
	    		case 2:
	    			JoueurVirtuel j111 = new JoueurVirtuel( 1 , "MimiBot");
		    		JoueurVirtuel j211 = new JoueurVirtuel(2 , "Aim�Bot");
		    		Joueur j311 = new Joueur(3 , "Franck");
		    		ajouterJoueur(j111);
		    		ajouterJoueur(j211);
		    		ajouterJoueur(j311);
	    			break;
	    		default:
	    			System.out.println("Entrez un bon nombre de joueurs virtuels");
	    			break;
	    		}
	    	}
	    	else if (nombreJoueurs == 4) {
	    		
	    		System.out.println("Combien de joueurs virtuels souhaitez-vous affronter?");
	    		int nombreJoueursVirtuels = verifier(0 , 3);
	    		switch (nombreJoueursVirtuels) 
	    		{
	    		case 0:
	    			Joueur j1 = new Joueur(1 , "Mimi");
		    		Joueur j2 = new Joueur(2 , "Aim�");
		    		Joueur j3 = new Joueur(3 , "Franck");
		    		Joueur j4 = new Joueur(4 , "Landry");
		    		ajouterJoueur(j1);
		    		ajouterJoueur(j2);
		    		ajouterJoueur(j3);
		    		ajouterJoueur(j4);
		    		break;
		    		
	    		case 1:
	    			JoueurVirtuel j11 = new JoueurVirtuel(1 , "MimiBot");
		    		Joueur j21 = new Joueur(2 , "Aim�");
		    		Joueur j31 = new Joueur(3 , "Franck");
		    		Joueur j41 = new Joueur(4 , "Landry");
		    		ajouterJoueur(j11);
		    		ajouterJoueur(j21);
		    		ajouterJoueur(j31);
		    		ajouterJoueur(j41);
		    		break;
		    		
	    		case 2:
	    			JoueurVirtuel j111 = new JoueurVirtuel(1 , "MimiBot");
		    		JoueurVirtuel j211 = new JoueurVirtuel(2 , "Aim�Bot");
		    		Joueur j311 = new Joueur(3 , "Franck");
		    		Joueur j411 = new Joueur(4 , "Landry");
		    		ajouterJoueur(j111);
		    		ajouterJoueur(j211);
		    		ajouterJoueur(j311);
		    		ajouterJoueur(j411);
		    		break;
		    		
	    		case 3:
	    			JoueurVirtuel j1111 = new JoueurVirtuel(1 , "MimiBot");
		    		JoueurVirtuel j2111 = new JoueurVirtuel(2 , "Aim�Bot");
		    		JoueurVirtuel j3111 = new JoueurVirtuel(3 , "FranckyBot");
		    		Joueur j4111 = new Joueur(4 , "Landry");
		    		ajouterJoueur(j1111);
		    		ajouterJoueur(j2111);
		    		ajouterJoueur(j3111);
		    		ajouterJoueur(j4111);
		    		break;
	    		default:
	    			System.out.println("Entrez un bon nombre de joueurs virtuels");
	    			break;
	    		}
	    		
	    		
	   }
	    	
	    	
	    	}
	    
	 

	public void retirerJoueur (Joueur pjoueur) {
		this.listeJoueurs.remove(pjoueur);
	}
	
	
	public void distribuerCartes () {
		//this.partieEnCours = true;
		this.banque.melanger();
	 	Iterator<Joueur> it = listeJoueurs.iterator();
		while (it.hasNext()) {
		 	Joueur j = (Joueur) it.next();
			for (int i = 0 ; i < 2 ; i++) {
				j.getMain().add(this.banque.donnerCarte());
				
			}
					}
	}

   
    
    public String presenterTrophees(){
    	ArrayList<Carte> listeTrophees = new ArrayList<Carte>();
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
  
  
// ALGORITHME DE TRI POUR RANGER LES CARTES DE LA LISTE DE CARTES ET POUR CHAQUE CARTE DE LA LISTE TRIEE? REGARDER SI SON PROPRIETAIRE A DEJA JOUE , SI NON C'EST A LUI DE JOUER? SI OUI? ON PASSE A LA DEUXIME CARTE DE  
  //LA LISTE 
  
  
    public ArrayList<Carte> rangerCartes (ArrayList<Carte> plisteCartes) {
    	Carte inter;
    	int etape = 0; int i;
    	for ( etape = 0 ; etape <= plisteCartes.size() - 1 ; etape++) { 
    		int posMax = etape;
    		
    		for ( i = etape + 1 ; i < plisteCartes.size() ; i++) {
    			
    					if (plisteCartes.get(i).getValue().ordinal() > plisteCartes.get(posMax).getValue().ordinal()) { 
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
 
    
 public Joueur choisirPrioritaire(ArrayList<Carte> plisteCartes) {
    	
    	Iterator<Joueur> it = listeJoueurs.iterator();
        System.out.println( "Offres : " + rangerCartes(plisteCartes));	
    	//for (int i = 0 ; i < plisteCartes.size() ; i++) {
    	while (it.hasNext()) {
    		Joueur j = (Joueur)it.next();
    		if (j.MainContient(rangerCartes(plisteCartes).get(0)) && j.isaJoue() == false) {
    			prioritaire = j;
    		}
    	} 
    	//}
		return prioritaire;
 } 
    
 
 

	//faire une grande boucle qui fait jouer plusieurs fois ou faire une m�thode qui r�p�te la m�thode jouer le nombre de fois �gal au nombre de tours
// plutot un while qui s'arrete quand la partie est finie et la partie finit quan il n'ya plus de cartes dans la banque 
	// pr�ciser que pour le round d'apr�s il faut ramasser les cartes non prises et les m�langer a la banque et redistribuer ainsi de suite 
 
 
    public void jouer() {
    	
    	ArrayList<Joueur> ontJoue = new ArrayList<Joueur>();
    	this.setPartieEnCours(true);
    	System.out.println("Troph�es: " + presenterTrophees());
    	
    	while (this.partieEnCours) {
    	int numJoueur = 0;
    	distribuerCartes();
    	
     //pr�senter les offres de chaque joueur 
    	ArrayList <Carte> listeOffres = new ArrayList <Carte>();
    	Iterator<Joueur> it = this.listeJoueurs.iterator(); 
    	while (it.hasNext()) {
    		Joueur j = (Joueur)it.next();
    		j.ConsulterMain();
    		System.out.println(" Quelle carte voulez vous d�couvrir?");
    		System.out.println("Entrez 0 pour la premi�re carte et 1 pour la deuxi�me");
    		int index = verifier(0 , 1);
    		Carte offre = j.faireOffre(index);
    		 System.out.println("Offre de " + j.getNom() + ":" + offre.toString());
    		listeOffres.add(j.getIndiceJoueur() - 1, offre);
    		
    	 }
    	
    	// appeler la m�thode choisir prioritaire et lui demander le num�ro du victime
    	prioritaire = choisirPrioritaire(listeOffres);
    	  	while ((prioritaire != null) && prioritaire.isaJoue() == false){
    		System.out.println(prioritaire.getNom() + " A vous de jouer");
    		System.out.println (" Entrez le num�ro du joueur cible");
    		 numJoueur = verifier(1, listeJoueurs.size());
    		 
    		 //pr�ciser qu'il peut prendre chez lui si dans une partie de 3 les deux autres ont pioch� l'un dans l'offre de l'autre
    		while (numJoueur == prioritaire.getIndiceJoueur()) {
    			if( prioritaire.getMain().size() == 2) {
    			    	if (ontJoue.size() == listeJoueurs.size() - 1){ 
    			    		System.out.println("Vous avez le droit pour cette fois");
    			    		break;
    			    	}
    			    	else{
    		    			System.out.println("Vous ne pouvez pas piocher dans votre propre main");
    		    			System.out.println("Entrez un autre num�ro de joueur");
    		    			numJoueur = verifier(1, listeJoueurs.size());
    		    		}
    			    		}
    		else{
    			System.out.println("Impossible!!!!!");
    			System.out.println("Entrez un autre num�ro de cible");
    			numJoueur = verifier(1, listeJoueurs.size());
    		}
    		}
    		//v�rifier qu'un joueur ne peut pas prendre dans sa propre main
    		if (listeJoueurs.get(numJoueur - 1).getMain().size() == 1) {//!!!! pourquoi au tour du deuxi�me joueur il permet qu'on prenne dans la main d'un joueur qui n'a qu'une carte dans sa main??
        		System.out.println("Vous ne pouvez pas piocher chez ce joueur");
        		System.out.println("Entrer un autre num�ro de cible");
        		 numJoueur = verifier(1, listeJoueurs.size());
        		
        	}
    		//indiquer la carte � prendre
    			System.out.println("Quelle carte souhaitez-vous prendre?");
        		System.out.println("Entrez 0 ou 1");
        		int numCarte = verifier(0, 1);
        		prioritaire.prendreCarte(listeJoueurs.get(numJoueur - 1) , numCarte);
        		
        		//r�cup�rer la seule carte restant dans la main du joueur victime
        		this.banque.ajouterCarte(listeJoueurs.get(numJoueur - 1).getMain().get(0));
        		
        		prioritaire.setaJoue(true); 
        		ontJoue.add(prioritaire);
        		
        		//retirer l'offre du joueur qui vient de jouer de la liste des offres 
        		Iterator<Carte> it3 = prioritaire.getMain().iterator();//!!!!pourquoi au tour du deuxieme joueur il ne supprime pas son offre de la liste des offres,
        		 while (it3.hasNext()) {
        			 Carte c = it3.next();
        			//for (int k = 0 ; k < listeOffres.size() ; k++) {
        				if (c.equals(rangerCartes(listeOffres).get(0))) {
        					listeOffres.remove(c);
        				}
        			//}  
        		 }
        		 
        		// v�rifier que le joueur chez qui on vient de piocher n'a pas encore jou�.
        		 //Dans ce cas c'est lui le prochain joueur 
        		if (listeJoueurs.get(numJoueur - 1).isaJoue() == false) {
        		prioritaire = listeJoueurs.get(numJoueur - 1); // 
        		}else {
        			//ranger les offres restantes dans le tableau et d�signer celui a qui appartient la plus grande carte comme premier joueur 
        			//appeler la m�thode choisir prioritaire qui prend un tableau d'offres en param�tre et renvoie un joueur, celui � qui appartient la premi�re carte
        		prioritaire = choisirPrioritaire(listeOffres); 
        		}
        		System.out.println("Banque: " + this.getBanque().toString());
        		System.out.println(this.getBanque().tailleBanque());
        		
    	}
    	if (this.banque.estvide()) {
    		this.setPartieEnCours(false);
    	}
    	}
    }
    	
    	//}
    	  
    // Int�grer les joueurs virtuels et compter les points, d�signer le gagnant.
    
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
    
    
    

}









