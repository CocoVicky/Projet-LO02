package fr.utt.projetLO02.GenialeVictoire;

public class Jest implements Visitable {

	private int pointsJest ;

	public Jest(int pointsJest) {
		this.pointsJest = pointsJest;
	}

	public int getPointsJest() {
		return pointsJest;
	}

	public void setPointsJest(int pointsJest) {
		this.pointsJest = pointsJest;
	}
 public void accept(Visitor v) {
	 v.Visit(this);
 }
}
