package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

public class ObjetException extends ASIAventureException{
	/**
   * Classe ObjetException hérite de ASIAventureException
   * @author Nathan et Yazide
   * @version 1.0
   */

  /**
   * Constructeur d'exception
   * @return exception
   */
	public ObjetException(){
	}

	/**
   * Constructeur d'exception avec la possibilité d'ajouter un message
   * @param msg message de l'erreur
   * @return exception
   */
	public ObjetException(java.lang.String msg){
		super(msg);
	}

}
