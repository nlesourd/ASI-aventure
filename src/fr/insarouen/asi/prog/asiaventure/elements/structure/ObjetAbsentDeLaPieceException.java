package fr.insarouen.asi.prog.asiaventure.elements.structure;

public class ObjetAbsentDeLaPieceException extends PieceException{

  /**
   * Classe ObjetAbsentDeLaPieceException hérite de PieceException
   * @author Nathan et Yazide
   * @version 1.0
   */

  /**
   * Constructeur d'exception
   * @return exception
   */
  public ObjetAbsentDeLaPieceException(){

  }

  /**
   * Constructeur d'exception avec la possibilité d'ajouter un message
   * @param msg message de l'erreur
   * @return exception
   */
  public ObjetAbsentDeLaPieceException(java.lang.String msg){
    super(msg);
  }

}
