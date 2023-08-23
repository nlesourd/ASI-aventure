package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

public class ObjetNonDeplacableException extends ObjetException{
	/**
	 * Classe ObjetNonDeplacableException hérite de ObjetException
	 * @author Nathan et Yazide
	 * @version 1.0
	 */

	/**
	 * Constructeur d'exception
	 * @return exception
	 */
	public ObjetNonDeplacableException(){
	}

	/**
   * Constructeur d'exception avec la possibilité d'ajouter un message
	 * @param msg message de l'erreur
	 * @return exception
	 */
	public ObjetNonDeplacableException(java.lang.String msg){
		super(msg);
	}

}
