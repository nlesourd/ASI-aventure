package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;


public abstract class Entite{
	/**
   * Classe abstraite Entite
   * @author Nathan et Yazide
   * @version 1.0
   */

	 /**
 	 * Classe Entite qui définit ce qu'est une entité dans notre jeu d'aventure. Elle possède deux attributs: un nom et un monde
 	 */

	private String nom;
	private Monde monde;

	/**
	 * Constructeur de la classe Entite avec deux attributs: nom et monde
	 * @param nom nom de l'Entité
	 * @param monde monde dans lequel est l'Entité
	 * @return Entité créée
	 * @throw NomDEntiteDejaUtiliseDansLeMondeException Nom d'entité déjà utilisé dans le monde
	 */

	public Entite(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		try{
			this.nom = nom;
			this.monde = monde;
			monde.ajouter(this);
		}catch (EntiteDejaDansUnAutreMondeException e){
		}

	}

	/**
	 * Accesseur de l'attribut nom
	 * @return nom de l'entite
	 */
	public String getNom(){
		return this.nom;
	}

	/**
	 * Accesseur de l'attribut monde
	 * @return monde de l'entite
	 */
	public Monde getMonde(){
		return this.monde;
	}

	/**
	 * Description de l'entite
	 * @return description de l'entite
	 */
	public String toString(){
		return String.format("%s",this.nom);
	}

	/**
	 * Indique si deux entités sont égales ou non
	 * @param o objet à comparer
	 * @return un booleen pour savoir si les entités sont égales ou non
	 */
	public boolean equals(Object o){
		if (o==this){
			return true;
		}
		if (o==null || this.getClass() != o.getClass()){
			return false;
		}
		Entite entite = (Entite)o;
		if (entite.nom == this.nom && entite.monde == this.monde){
			return true;
		}else{
			return false;
		}
	}
}
