package fr.utt.projetLO02.GenialeVictoire;

import java.util.ArrayList;

public class CompterPoints {
	
	public void Visit(Visitable jest) {
		ArrayList<Joueur> TabJoueur = null;
		for(int i=0 ; i<TabJoueur.size(); i++) {
			((Visitable) TabJoueur.get(i).getJest()).accept((Visitor)this);}
		}
	
	
		public float CompterPoint(ArrayList<Carte> jest) {
			float point=0;
			Famille[] tabFamilles = Famille.values(); 
			Valeur[] tabValeurs = Valeur.values();//Pique, trefle , Carreau, Coeur , joker
			for(int j=0; j<4; j++){

				if((tabValeurs[j]==Valeur.Joker) && (tabFamilles[j]==Famille.Carreau || tabFamilles[j]==Famille.Coeur)) {
					//point+=	j'aimerai faire integrer l'iterator mais je sais trop comment appliquer  sa
				}

				if(tabValeurs[j]==Valeur.As && tabFamilles[j]==Famille.Trèfle || tabFamilles[j]==Famille.Pique) {
					point+=1;
					return point;
				}

				else if(tabValeurs[j]==Valeur.Deux &&    tabFamilles[j]==Famille.Trèfle || tabFamilles[j]==Famille.Pique) {
					point+=2;
					return point;
				}

				else if(tabValeurs[j]==Valeur.Trois &&    tabFamilles[j]==Famille.Trèfle || tabFamilles[j]==Famille.Pique) {
					point+=3;
					return point;
				}
				else if(tabValeurs[j]==Valeur.Quatre &&    tabFamilles[j]==Famille.Trèfle || tabFamilles[j]==Famille.Pique) {
					point+=4;
					return point;

				}
				else if(tabValeurs[j]==Valeur.As &&    tabFamilles[j]==Famille.Coeur || tabFamilles[j]==Famille.Carreau) {
					point-=1;
					return point;

				}
				else if(tabValeurs[j]==Valeur.As &&    tabFamilles[j]==Famille.Coeur || tabFamilles[j]==Famille.Carreau) {
					point-=2;
					return point;
				}

				else if(tabValeurs[j]==Valeur.As &&    tabFamilles[j]==Famille.Coeur || tabFamilles[j]==Famille.Carreau) {
					point-=3;
					return point;
				}

				else if(tabValeurs[j]==Valeur.As &&    tabFamilles[j]==Famille.Coeur || tabFamilles[j]==Famille.Carreau) {
					point-=4;
					return point;
				}
			}
			return point;
		}


}
