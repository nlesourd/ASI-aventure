package fr.insarouen.asi.prog.asiaventure;

public class ASIAventureException extends java.lang.Exception{
	/**
   * Classe ASIAventureException hérite de java.lang.Exception
   * @author Nathan et Yazide
   * @version 1.0
   */

  /**
   * Constructeur d'exception
   * @return exception
   */
	public ASIAventureException(){
	}

	/**
   * Constructeur d'exception avec la possibilité d'ajouter un message
	 * @param msg message de l'erreur
	 * @return exception
	 */
	public ASIAventureException(java.lang.String msg){
		super(msg);
	}

}
