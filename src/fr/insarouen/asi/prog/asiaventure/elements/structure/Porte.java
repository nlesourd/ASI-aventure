package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

public class Porte extends ElementStructurel implements Activable{

  /**
   * Classe Porte hérite de ElementStructurel implémente Activable
   * @author Nathan et Yazide
   * @version 1.0
   */

  private Piece pieceA;
  private Piece pieceB;
  private Etat etat = Etat.FERME;

  public Porte(String nom, Monde monde, Piece pieceA, Piece pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
    this.pieceA = pieceA;
    this.pieceB = pieceB;
    this.pieceA.addPorte(this);
    this.pieceB.addPorte(this);
  }

  /**
   * Active une porte afin de l'ouvrir ou de la fermer
   * @throws ActivationImpossibleException la porte n'est pas activable
   */
  public void activer() throws ActivationImpossibleException{
    if (this.etat.equals(Etat.FERME)){
      this.etat = Etat.OUVERT;
    }
    else{
      if (this.etat.equals(Etat.OUVERT)){
        this.etat = Etat.FERME;
      }
      else{
        throw new ActivationImpossibleException();
      }
    }

  }

  /**
   * Grâce à un objet correspondant à une clé, permet de déverouiller ou verrouiller une porte
   * @param obj clé permettant d'interagir avec une porte
   * @throws ActivationImpossibleAvecObjetException la clé n'est pas la bonne
   * @throws ActivationImpossibleException la porte n'est pas activable
   */
  public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException,ActivationImpossibleException{

  }

  /**
   * Indique si c'est la bonne clé
   * @param  obj clé à inspecter avec la porte en question
   * @return boolean
   */
  public boolean activableAvec(Objet obj){
    return true;
  }

  /**
   * Accesseur de l'Etat
   * @return etat de la porte
   */
  public Etat getEtat(){
    return this.etat;
  }

  /**
   * Obtient la pièce qui se situe de l'autre coté de la porte
   * @param piece piece initiale
   * @return piece se situant de l'autre côté
   */
  public Piece getPieceAutreCote(Piece piece){
    if (piece.equals(this.pieceA)){
      return this.pieceB;
    }else{
      return this.pieceA;
    }
  }

  /**
   * Description de la porte
   * @return description
   */
  @Override
  public String toString(){
    String msg = super.toString();
    return msg + String.format(" entre les pièces %s et %s",this.pieceA.getNom(),this.pieceA.getNom());
  }

}
