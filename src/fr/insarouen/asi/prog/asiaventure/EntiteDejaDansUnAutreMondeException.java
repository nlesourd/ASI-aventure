package fr.insarouen.asi.prog.asiaventure;

public class EntiteDejaDansUnAutreMondeException extends MondeException{
	/**
	 * Classe EntiteDejaDansUnAutreMondeException hérite de MondeException
	 * @author Nathan et Yazide
	 * @version 1.0
	 */

	/**
	 * Constructeur d'exception
	 * @return exception
	 */
	public EntiteDejaDansUnAutreMondeException(){
	}

	/**
   * Constructeur d'exception avec la possibilité d'ajouter un message
	 * @param msg message de l'erreur
	 * @return exception
   */
	public EntiteDejaDansUnAutreMondeException(java.lang.String msg){
		super(msg);
	}

}
