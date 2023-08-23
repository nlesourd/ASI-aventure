package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;
import java.util.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;

public class Piece extends ElementStructurel{
  /**
   * Classe Piece hérite de ElementStructurel
   * @author Nathan et Yazide
   * @version 1.0
   */

 	 /**
  	 * Classe Piece qui décrit une pièce de ASIAventure avec 4 attributs
  	 */
  private Map<String,Objet> objets;
  private Map<String,Vivant> vivants;
  private Map<String,Porte> portes;

  /**
   * Constructeur de la classe Piece
   * @param  nom nom de la pièce
   * @param  monde monde dans lequel est la pièce
   * @throws NomDEntiteDejaUtiliseDansLeMondeException nom d'Entité déjà utilisé dans un autre monde
   */
  public Piece(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
    this.objets = new HashMap<>();
    this.vivants = new HashMap<>();
    this.portes = new HashMap<>();
  }

  /**
   * Indique si un objet est dans la pièce ou non
   * @param  nomObjet nom de l'objet
   * @return booleen
   */
  public boolean contientObjet(String nomObjet){
    return this.objets.containsKey(nomObjet);
  }

  /**
   * Indique si un objet est dans la pièce ou non
   * @param  objet objet
   * @return booleen
   */
  public boolean contientObjet(Objet objet){
    return contientObjet(objet.getNom());
  }

  /**
   * Indique si un vivant est dans la pièce ou non
   * @param  nomVivant nom du vivant
   * @return booleen
   */
  public boolean contientVivant(String nomVivant){
    return this.vivants.containsKey(nomVivant);
  }

  /**
   * Indique si un vivant est dans la pièce ou non
   * @param  vivant vivant
   * @return booleen
   */
  public boolean contientVivant(Vivant vivant){
    return contientVivant(vivant.getNom());
  }

  /**
   * Dépose un objet dans une pièce
   * @param nouvelleObjet objet à déposer
   */
  public void deposer(Objet nouvelleObjet){
    this.objets.put(nouvelleObjet.getNom(),nouvelleObjet);
  }

  /**
   * Entre un vivant dans une pièce
   * @param nouveauVivant vivant à entrer
   */
  public void entrer(Vivant nouveauVivant) throws PieceException{
    if(this.contientVivant(nouveauVivant)){
      throw new PieceException();
    }
    this.vivants.put(nouveauVivant.getNom(),nouveauVivant);
  }

  /**
   * Accesseur objets
   * @return objets
   */
  public Map<String,Objet> getObjets(){
    return this.objets;
  }

  /**
   * Accesseur vivants
   * @return vivants
   */
  public Map<String,Vivant> getVivants(){
    return this.vivants;
  }

  /**
   * Retire un objet de la pièce
   * @param  nomObjetAEnlever nom de l'objet
   * @return objet à retirer
   * @throws ObjetNonDeplacableException objet non déplaçable
   * @throws ObjetAbsentDeLaPieceException objet absent de la pièce
   */
  public Objet retirer(String nomObjetAEnlever) throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException{
    if(!this.contientObjet(nomObjetAEnlever)){
			throw new ObjetAbsentDeLaPieceException();
		}
    if (!this.getObjets().get(nomObjetAEnlever).estDeplacable()){
      throw new ObjetNonDeplacableException();
    }
    return this.objets.remove(nomObjetAEnlever);
  }

  /**
   * Retire un objet de la pièce
   * @param  objetAEnlever objet à enlever
   * @return objet à retirer
   * @throws ObjetNonDeplacableException objet non déplaçable
   * @throws ObjetAbsentDeLaPieceException objet absent de la pièce
   */
  public Objet retirer(Objet objetAEnlever) throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException{
    return retirer(objetAEnlever.getNom());
  }

  /**
   * Sortir vivant de la pièce
   * @param  vivantARetirer vivant à retirer
   * @return vivant sorti
   */
  public Vivant sortirVivant(Vivant vivantARetirer) throws PieceException{
    return this.getVivants().remove(vivantARetirer.getNom());
  }

  /**
   * Permet d'ajouter une porte à la collection des portes de la pièce
   * @param porte porte que l'on veut ajouter
   */
  protected void addPorte(Porte porte){
      this.portes.put(porte.getNom(),porte);
  }

  /**
   * Indique si une pièce possède la porte ou non
   * @param  nomPorte nom de la porte à étudier
   * @return boolean
   */
  public boolean aLaPorte(String nomPorte){
      return this.portes.containsKey(nomPorte);
  }

  /**
   * Indique si une pièce possède la porte ou non
   * @param  porte porte à éttudier
   * @return boolean
   */
  public boolean aLaPorte(Porte porte){
      return this.portes.containsKey(porte.getNom());
  }

  /**
   * Permet d'obtenir une porte à partir de son nom
   * @return la porte voulue
   */
  public Porte getPorte(String nomPorte){
      return this.portes.get(nomPorte);
  }

  public Map<String,Porte> getPortes(){
      return this.portes;
  }

  /**
   * Description de la Piece
   * @return description
   */
  public String toString(){
		String chaineObjets = "";
		for(String nomO:objets.keySet()){
			chaineObjets = chaineObjets + nomO + "	";
		}
    String chaineVivants = "";
		for(String nomV:vivants.keySet()){
			chaineVivants = chaineVivants + nomV + "	";
		}
		return String.format("La pièce %s contient les objets suivants : %s \n et les vivants suivants : %s",this.getNom(),chaineObjets,chaineVivants);
	}

}
