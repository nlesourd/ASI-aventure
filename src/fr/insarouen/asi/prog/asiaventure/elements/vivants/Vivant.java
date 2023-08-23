package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;
import java.util.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;

public abstract class Vivant extends Entite{
	/**
   * Classe Vivant hérite de Entite
   * @author Nathan et Yazide
   * @version 1.0
   */

 	 /**
  	 * Classe Vivant qui décrit un vivant de ASIAventure avec 6 attributs
  	 */
	public Map<String,Objet> objets;
	private int pointDeVie;
	private int pointDeForce;
	private Piece piece;

	/**
	 * Constructeur de la classe Vivant
	 * @param nom nom du vivant
	 * @param monde dans lequel est le vivant
	 * @param pDV point de vie
	 * @param pDF point de force
	 * @param p pièce courante du vivant
	 * @param obj ses objets
	 * @return monde créé
	 * @throw NomDEntiteDejaUtiliseDansLeMondeException nom d'Entité déjà utilisé dans le monde
	 */
	public Vivant(String nom,Monde monde,int pDV,int pDF,Piece p,Objet... obj) throws NomDEntiteDejaUtiliseDansLeMondeException,PieceException{
		super(nom,monde);
		this.pointDeVie=pDV;
		this.pointDeForce=pDF;
		this.piece=p;
		this.piece.entrer(this);
		this.objets=new HashMap<String,Objet>();
		for(Objet o : obj){
			this.objets.put(o.getNom(),o);
		}
	}

	/**
	 * Depose un objet du vivant dans la pièce
	 * @param  nom nom de l'objet à déposer
	 * @throws ObjetNonPossedeParLeVivantException objet non possédé par le vivant
	 */
	public void deposer(String nom) throws ObjetNonPossedeParLeVivantException{
		if (!(this.possede(nom))){
			throw new ObjetNonPossedeParLeVivantException();
		}
		this.piece.deposer(this.objets.get(nom));
		this.getObjets().remove(nom);
	}

	/**
	 * Depose un objet du vivant dans la pièce
	 * @param  obj objet à déposer
	 * @throws ObjetNonPossedeParLeVivantException objet non possédé par le vivant
	 */
	public void deposer(Objet obj) throws ObjetNonPossedeParLeVivantException{
		deposer(obj.getNom());
	}

	/**
	 * Accesseur des objets du vivant
	 * @return objets
	 */
	public Map<String,Objet> getObjets(){
		return this.objets;
	}

	/**
	 * Accesseur de la pièce du vivant
	 * @return pièces
	 */
	public Piece getPiece(){
		return this.piece;
	}

	/**
	 * Accesseur des points de force du vivant
	 * @return points de force
	 */
	public int getPointForce(){
		return this.pointDeForce;
	}

	/**
	 * Accesseur des points de vie
	 * @return points de vie
	 */
	public int getPointVie(){
		return this.pointDeVie;
	}

	/**
	 * Indique si un objet est possédé par le vivant ou non
	 * @param  nom nom de l'objet
	 * @return booleen
	 */
	public boolean possede(String nom){
		return objets.containsKey(nom);
	}

	/**
	 * Indique si un objet est possédé par le vivant ou non
	 * @param obj objet
	 * @return booleen
	 */
	public boolean possede(Objet obj){
		return possede(obj.getNom());
	}

	/**
	 * Retire un objet de la pièce pour l'ajouter à l'inventaire du vivant
	 * @param nom nom de l'objet
	 * @throws ObjetNonDeplacableException objet non déplaçable
	 * @throws ObjetAbsentDeLaPieceException objet absent de la pièce
	 * @throws ObjetNonPossedeParLeVivantException objet non possédé par le vivant
	 */
	public void prendre(String chaineObjet) throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException{
		if(!this.piece.contientObjet(chaineObjet)){
			throw new ObjetAbsentDeLaPieceException();
		}
		Objet obj = this.piece.retirer(chaineObjet);
		this.objets.put(obj.getNom(),obj);

	}

	/**
	 * Retire un objet de la pièce pour l'ajouter à l'inventaire du vivant
	 * @param objetAEnlever objet
	 * @throws ObjetNonDeplacableException objet non déplaçable
	 * @throws ObjetAbsentDeLaPieceException objet absent de la pièce
	 * @throws ObjetNonPossedeParLeVivantException objet non possédé par le vivant
	 */
	public void prendre(Objet objetAEnlever) throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException{
		prendre(objetAEnlever.getNom());
	}

	/**
	 * Permet au vivant de franchir une porte pour passer à la pièce d'à côté
	 * si celle est ouverte
	 * @param  porte porte à franchir
	 * @throws PorteInexistanteDansLaPieceException porte inexistante
	 * @throws PorteFermeException porte fermee
	 * @throws PieceException piece exception
	 */
	public void franchir(Porte porte) throws PorteInexistanteDansLaPieceException,PorteFermeException,PieceException{
		this.franchir(porte.getNom());
	}

	/**
	 * Permet au vivant de franchir une porte pour passer à la pièce d'à côté
	 * si celle est ouverte
	 * @param  nomPorte nom de la porte à franchir
	 * @throws PorteInexistanteDansLaPieceException porte inexistante
	 * @throws PorteFermeException porte fermee
	 * @throws PieceException piece exception
	 */
	public void franchir(String nomPorte) throws PorteInexistanteDansLaPieceException,PorteFermeException,PieceException{
		if (!this.piece.getPortes().containsKey(nomPorte)){
            throw new PorteInexistanteDansLaPieceException();
        }
        else{
            if (this.getPiece().getPorte(nomPorte).getEtat()==Etat.FERME){
                throw new PorteFermeException();
            }
            else{
                this.piece.getPorte(nomPorte).getPieceAutreCote(this.piece).entrer(this.piece.sortirVivant(this));
                this.piece=this.piece.getPorte(nomPorte).getPieceAutreCote(this.piece);
            }
        }
	}

	/**
	 * Active l'activable
	 * @param  activable activable
	 * @throws ActivationException impossible d'activer
	 */
	public void activerActivable(Activable activable) throws ActivationException{
		activable.activer();
	}

	/**
	 * Active l'activable à l'aide d'un objet
	 * @param  activable activable
	 * @param  objet objet utilisé pour l'activation
	 * @throws ActivationException impossible d'activiter
	 */
	public void activerActivableAvecObjet(Activable activable, Objet objet) throws ActivationException{
		activable.activerAvec(objet);
	}

	/**
	 * Description du vivant
	 * @return description
	 */
	public String toString(){
		String chaine = "";
		for(String nomO:objets.keySet()){
			chaine = chaine + nomO + "	";
		}
		return String.format("Le vivant s'appelle %s avec %d points de vie, %d point de force dans la pièce %s et avec les objets suivants %s",this.getNom(),this.pointDeVie,this.pointDeForce,this.piece.getNom(),chaine);
	}
}
