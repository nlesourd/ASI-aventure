package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

public class VivantException extends ASIAventureException{

  /**
   * Classe VivantException hérite de ASIAventureException
   * @author Nathan et Yazide
   * @version 1.0
   */

  /**
   * Constructeur d'exception
   * @return exception
   */
  public VivantException(){

  }

  /**
   * Constructeur d'exception avec la possibilité d'ajouter un message
   * @param msg message de l'erreur
   * @return exception
   */
  public VivantException(java.lang.String msg){
    super(msg);
  }

}
