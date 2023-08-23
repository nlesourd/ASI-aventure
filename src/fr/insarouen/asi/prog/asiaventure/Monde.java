package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;
import java.util.*;

public class Monde{
	/**
   * Classe Monde
   * @author Nathan et Yazide
   * @version 1.0
   */

	 /**
 	 * Classe Monde qui décrit un monde avec deux attributs: son nom et une liste d'Entite qu'il possède
 	 */
	private String nom;
	private Map<String,Entite> entites;

	/**
	 * Constructeur de la classe Monde, la liste d'entité est initialisée vide.
	 * @param nom nom du monde
	 * @return monde créé
	 */
	public Monde(String nom){
		this.nom = nom;
		this.entites = new HashMap<String,Entite>();
	}

	/**
	 * Accesseur de l'attribut nom
	 * @return nom du monde
	 */
	public String getNom(){
		return this.nom;
	}

	/**
	 * Accesseur de l'attribut entites
	 * @return Entités du monde
	 */
	public Entite getEntite(String nomEntite){
		return this.entites.get(nomEntite);
	}

	/**
	 * Procédure permettant d'ajouter une nouvelle entité à l'attribut entites
	 * @param nouvelleEntite Entité à ajouter
	 * @throws NomDEntiteDejaUtiliseDansLeMondeException Nom d'entité déjà utilisé dans le monde
	 * @throws EntiteDejaDansUnAutreMondeException Entite déjà dans un autre monde excpetion
	 */
	public void ajouter(Entite nouvelleEntite) throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException{
		if(!(nouvelleEntite.getMonde().getNom().equals(this.nom))){
			throw new EntiteDejaDansUnAutreMondeException();
		}
		if(!(this.getEntite(nouvelleEntite.getNom())==null)){
			throw new NomDEntiteDejaUtiliseDansLeMondeException();
		}
		this.entites.put(nouvelleEntite.getNom(),nouvelleEntite);

	}

	/**
	 * Description de l'objet monde
	 * @return Description de l'objet monde
	 */

	public String toString(){
		String chaine = "";
		for(String nomE:entites.keySet()){
			chaine = chaine + nomE + "	";
		}
		return String.format("L'objet %s contient les entités suivantes : %s",this.nom,chaine);
	}


}
