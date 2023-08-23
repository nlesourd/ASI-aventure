package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;

public class ActivationImpossibleAvecObjetException extends ActivationImpossibleException{
	/**
   * Classe ActivationImpossibleAvecObjetException hérite de ActivationImpossibleException
   * @author Nathan et Yazide
   * @version 1.0
   */

  /**
   * Constructeur d'exception
   * @return exception
   */
	public ActivationImpossibleAvecObjetException(){
	}

	/**
   * Constructeur d'exception avec la possibilité d'ajouter un message
	 * @param msg message de l'erreur
	 * @return exception
	 */
	public ActivationImpossibleAvecObjetException(java.lang.String msg){
		super(msg);
	}

}
