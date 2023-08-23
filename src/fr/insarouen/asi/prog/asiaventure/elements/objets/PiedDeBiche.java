package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class PiedDeBiche extends Objet{
	/**
	 * Classe PiedDeBiche hérite de Objet
	 * @author Nathan et Yazide
	 * @version 1.0
	 */

	/**
   * Constructeur de la classe PiedDeBiche
   * @param monde monde
   * @return pied de biche créé
   * @throw NomDEntiteDejaUtiliseDansLeMondeException nom déjà utilisé dans le monde
	 */
	public PiedDeBiche(String nom,Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom, monde);
	}

	/**
	 * Indique que le pied de biche est déplaçable
	 * @return vrai
	 */
	public boolean estDeplacable(){
		return true;
	}
}
