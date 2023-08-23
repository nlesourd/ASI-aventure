package fr.insarouen.asi.prog.asiaventure.elements.structure;

public class PieceException extends ElementStructurelException{

  /**
   * Classe PieceException hérite de ElementStructurelException
   * @author Nathan et Yazide
   * @version 1.0
   */

  /**
   * Constructeur d'exception
   * @return exception
   */
  public PieceException(){

  }

  /**
   * Constructeur d'exception avec la possibilité d'ajouter un message
   * @param msg message de l'erreur
   * @return exception
   */
  public PieceException(java.lang.String msg){
    super(msg);
  }

}
