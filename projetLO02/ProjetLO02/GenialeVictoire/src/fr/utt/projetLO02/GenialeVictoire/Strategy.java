package fr.utt.projetLO02.GenialeVictoire;

import java.util.ArrayList;
/**
 * <p>
 * Classe abstraite qui détermine ce que les joueurs virtuels doivent être capables de faire, à savoir:
 * <ul>
 * <li>Faire une offre, c'est à dire déterminer quelle carte il souhaite découvrir.</li>
 * <li>Choisir le joueur chez qui il souhaite prendre une carte.</li>
 * <li>Choisir une carte parmi l'offre du joueur qu'il aura choisi.</li>
 * </ul>
 * </p>
 * @see StrategieMoyenne
 * @see StrategieFacile
 * @author vicky
 *
 */
public abstract class Strategy {
	
	public abstract int faireOffre (int borneInf, int borneSup);
	public abstract int choisirJoueur(int borneInf, int borneSup , ArrayList<Carte>listeOffres ,  ArrayList<Joueur> listeJoueurs ,  ArrayList<Joueur> ontJoue , Partie partieEnCours);
	public abstract int choisirCarte(int borneInf, int borneSup , Joueur victime);
	
}
 