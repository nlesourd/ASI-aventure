package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public abstract class Objet extends Entite{
	/**
	 * Classe abstraite Objet hérite de Entite
	 * @author Nathan et Yazide
	 * @version 1.0
	 */

	/**
	 * Classe Objet qui hérite de la classe Entite. Elle possède comme attributs un nom et un monde.
	 *<\br>
	 *Exemple d'instanciation d'Objet ayant comme nom "lampe" et comme monde "aventure"
	 *<code>
	 * Monde aventure = new Monde("aventure");
	 * Objet monPremierObjet = new Objet("lampe",aventure);
	 *<\code>
	 */

	/**
	 * Constructeur de la classe Objet
	 * @param nom nom de l'objet
	 * @param monde monde de l'objet
	 * @return objet créé
	 * @throw NomDEntiteDejaUtiliseDansLeMondeException nom d'entité déjà utilisé dans le monde
	 */
	public Objet(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom, monde);
	}

	/**
	 * méthode abstract permettant de savoir si un objet est déplacable ou non
	 * @return boolean
	 */
	public abstract boolean estDeplacable();

}
