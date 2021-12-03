package fr.utt.projetLO02.GenialeVictoire;

/**
 * <b>Carte est la classe qui permet de créer des cartes du jeu.</b>
 * <p>
 * Chaque carte est caractérisée par les informations suivantes:
 * <ul>
 * <li> Une valeur qui peut aller de l'as au quatre</li>
 * <li> une famille qui peut être trèfle, pique, carreau ou coeur </li> 
 * <li> une condition: best_Jest, majority3, joker, etc</li>
 * </ul>
 * </p>
 * 
 * @author vicky
 * @version 1.0
 */
 public class Carte {
	 /**
	  * La valeur d'une carte est représentée par un élément de l'énumération Valeur
	  * @see Valeur  
	  * @see Carte#getValue()
	  * @see Carte#setValue(Valeur)
	  */
 private Valeur value;
 	 /**
 	  * La condition d'une carte est représentée par un élément de l'énumération OrangeBand
 	  * @see OrangeBand 
 	  * @see Carte#getCondition()
 	  * @see Carte#setCondition(OrangeBand)
 	  */
 private OrangeBand condition;
 	/**
 	  * La suit d'une carte est représentée par un élément de l'énumération Famille
 	  * @see Famille
 	  * @see Carte#getSuit()
 	  * @see Carte#setValue(Valeur)
 	  */
 private Famille suit;
 
 public Carte ( Famille pSuit, Valeur pValeur) {
	 this.suit = pSuit;
	 this.value = pValeur;
	
 }
 /**
  * Constructeur de Carte.
  * 
  * @param suit
  * 		La famille de la carte.
  * @param value
  * 		La valeur de la carte.
  * @param condition
  * 		La condition de la carte.
  * 
  *  @see Carte#condition
  *  @see Carte#suit
  *  @see Carte#value
  * 
  */

public Carte(Valeur value, OrangeBand condition, Famille suit) {
	this.value = value;
	this.condition = condition;
	this.suit = suit;
}

public int getChiffre (Valeur value) {
	int chiffre = 0;
	switch (value)
	{
	case Joker:
		chiffre = 0;
		break;	
	case As:
		chiffre = 1;
		break;
	case Deux:
		chiffre = 2;
		break;	 
	case Trois:
		chiffre = 3;
		break;
	case Quatre:
		chiffre = 4;
		break;	
	}
	return chiffre;
}

public int setChiffre(Valeur value) {
	int chiffre = 0;
	if (value.equals(Valeur.As))
		chiffre = 5;
	return chiffre;
}
 
public Valeur getValue() {
	return value;
}

public void setValue(Valeur value) {
	this.value = value;
}
 
public OrangeBand getCondition() {
	return condition;
} 

public void setCondition(OrangeBand condition) {
	this.condition = condition;
}

public Famille getSuit() {
	return suit;
}

public void setSuit(Famille suit) {
	this.suit = suit;
}


	protected Carte clone() 
	{
	Carte cloneCarte =  new Carte(null, null);
	
	cloneCarte.condition=this.condition;
	cloneCarte.suit=this.suit;
	cloneCarte.value=this.value;
		return cloneCarte ; //à redéfinir
	}


 
/**
 * <p>
 * La méthode equals a été redéfinie pour seoir aux conditions d'égalité 
entre deux objets Carte, à savoir l'égalité entre chacun de leurs attributs
 *</p>
 */

@Override
public boolean equals(Object obj) {
	boolean flag=true ;
	if ( (obj instanceof Carte)==false ) {
		return false ;
	}else {
		Carte tmpCarte = (Carte)obj;
		if(tmpCarte.value.equals(this.getValue())==false) flag=false;
		if(tmpCarte.suit.equals(this.suit)==false) flag=false;
		return flag ;
	}
	/*
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Carte other = (Carte) obj;
	if (condition != other.condition)
		return false;
	if (suit != other.suit)
		return false;
	if (value != other.value)
		return false;
	return true;*/
}

public String toString() {
	 StringBuffer sb = new StringBuffer();
		sb.append(this.value.toString());
		sb.append(" de ");
		sb.append(this.suit.toString());
		sb.append(" : ");
		sb.append(this.condition.toString());
		return sb.toString();
 }
}
