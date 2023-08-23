package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

public class ElementStructurelException extends ASIAventureException{

  /**
   * Classe ElementStructurelException hérite de ASIAventureException
   * @author Nathan et Yazide
   * @version 1.0
   */

  /**
   * Constructeur d'exception
   * @return exception
   */
  public ElementStructurelException(){

  }

  /**
   * Constructeur d'exception avec la possibilité d'ajouter un message
   * @param msg message de l'erreur
   * @return exception
   */
  public ElementStructurelException(java.lang.String msg){
    super(msg);
  }

}
