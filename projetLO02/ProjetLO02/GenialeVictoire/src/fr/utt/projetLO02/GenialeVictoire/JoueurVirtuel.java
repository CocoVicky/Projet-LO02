package fr.utt.projetLO02.GenialeVictoire;
/**
 * <b>Joueur virtuel est une classe qui repr�sente les bots et impl�mente l'interface Strategy.</b>
 * <p>
 *Une partie est caract�ris�e par une strategie qu'il adopte pour suivre automatiquement 
les �tapes du jeu.
 * </p>
 * @see Joueur 
 * @see Strategy
 * @author vicky 
 *@version 1.0
 */
public class JoueurVirtuel extends Joueur {
	private Strategy strategie;
	public JoueurVirtuel(int pnum , String pnom) {
		super(pnum, pnom);
		// TODO Auto-generated constructor stub
	}
	public JoueurVirtuel(int pIndice, String pnom, Strategy stategie) {
		super(pIndice, pnom);
		this.strategie = stategie;
	}
	public Strategy getStrategie() {
		return strategie;
	}
	public void setStrategie(Strategy stategie) {
		this.strategie = stategie;
	}
	
	

}
 