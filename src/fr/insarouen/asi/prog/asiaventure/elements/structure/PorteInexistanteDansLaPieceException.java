package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;

public class PorteInexistanteDansLaPieceException extends PieceException{
	/**
	 * Classe PorteInexistanteDansLaPieceException hérite de PieceException
	 * @author Nathan et Yazide
	 * @version 1.0
	 */

	/**
	 * Constructeur d'exception
	 * @return exception
	 */
	public PorteInexistanteDansLaPieceException(){
	}

	/**
   * Constructeur d'exception avec la possibilité d'ajouter un message
	 * @param msg message de l'erreur
	 * @return exception
	 */
	public PorteInexistanteDansLaPieceException(java.lang.String msg){
		super(msg);
	}

}
