package fr.insarouen.asi.prog.asiaventure.elements.vivants;

public class ObjetNonPossedeParLeVivantException extends VivantException{

  /**
   * Classe ObjetNonPossedeParLeVivantException hérite de VivantException
   * @author Nathan et Yazide
   * @version 1.0
   */

  /**
   * Constructeur d'exception
   * @return exception
   */
  public ObjetNonPossedeParLeVivantException(){
  }

  /**
   * Constructeur d'exception avec la possibilité d'ajouter un message
   * @param msg message de l'erreur
   * @return exception
   */
  public ObjetNonPossedeParLeVivantException(java.lang.String msg){
    super(msg);
  }

}
