package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

public class ActivationException extends ASIAventureException{
  /**
   * Classe ActivationException hérite de ASIAventureException
   * @author Nathan et Yazide
   * @version 1.0
   */

  /**
   * Constructeur d'exception
   * @return exception
   */
	public ActivationException(){
	}

	/**
   * Constructeur d'exception avec la possibilité d'ajouter un message
	 * @param msg message de l'erreur
	 * @return exception
	 */
	public ActivationException(java.lang.String msg){
		super(msg);
	}

}
