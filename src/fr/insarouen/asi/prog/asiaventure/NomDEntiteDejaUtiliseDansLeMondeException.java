package fr.insarouen.asi.prog.asiaventure;

public class NomDEntiteDejaUtiliseDansLeMondeException extends MondeException{
	/**
	 * Classe NomDEntiteDejaUtiliseDansLeMondeException hérite de MondeException
	 * @author Nathan et Yazide
	 * @version 1.0
	 */

	/**
	 * Constructeur d'exception
	 * @return exception
	 */
	public NomDEntiteDejaUtiliseDansLeMondeException(){
	}

	/**
   * Constructeur d'exception avec la possibilité d'ajouter un message
	 * @param msg message décrivant l'erreur
	 * @return exception
   */
	public NomDEntiteDejaUtiliseDansLeMondeException(java.lang.String msg){
		super(msg);
	}

}
