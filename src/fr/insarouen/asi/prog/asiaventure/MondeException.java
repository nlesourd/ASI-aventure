package fr.insarouen.asi.prog.asiaventure;

public class MondeException extends ASIAventureException{
	/**
   * Classe MondeException hérite de ASIAventureException
   * @author Nathan et Yazide
   * @version 1.0
   */

  /**
   * Constructeur d'exception
	 * @return exception
   */
	public MondeException(){
	}

	/**
   * Constructeur d'exception avec la possibilité d'ajouter un message
	 * @param msg message décrivant l'erreur
	 * @return exception
   */
	public MondeException(java.lang.String msg){
		super(msg);
	}

}
