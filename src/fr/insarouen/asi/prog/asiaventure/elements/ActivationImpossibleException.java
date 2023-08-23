package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;

public class ActivationImpossibleException extends ActivationException{
	/**
   * Classe ActivationImpossibleException hérite de ActivationException
   * @author Nathan et Yazide
   * @version 1.0
   */

  /**
   * Constructeur d'exception
   * @return exception
   */
	public ActivationImpossibleException(){
	}

	/**
   * Constructeur d'exception avec la possibilité d'ajouter un message
	 * @param msg message de l'erreur
	 * @return exception
	 */
	public ActivationImpossibleException(java.lang.String msg){
		super(msg);
	}

}
