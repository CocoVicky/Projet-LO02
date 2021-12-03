package fr.utt.projetLO02.GenialeVictoire;
/**
 * Interface qui permettra la visite de tous les jests des joueurs afin de compter leurs points.
 * @author vicky
 *
 */
public interface Visitor {
	public void visit(Jest jest , Partie partieEnCours);

}
