package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurelException;

public class PorteFermeException extends ElementStructurelException{
	/**
	 * Classe PorteFermeException hérite de ElementStructurelException
	 * @author Nathan et Yazide
	 * @version 1.0
	 */

	/**
	 * Constructeur d'exception
	 * @return exception
	 */
	public PorteFermeException(){
	}

	/**
   * Constructeur d'exception avec la possibilité d'ajouter un message
	 * @param msg message de l'erreur
	 * @return exception
	 */
	public PorteFermeException(java.lang.String msg){
		super(msg);
	}

}
