package fr.utt.projetLO02.GenialeVictoire;

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
 