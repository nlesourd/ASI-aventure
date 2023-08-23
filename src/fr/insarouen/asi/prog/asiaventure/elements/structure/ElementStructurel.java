package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public abstract class ElementStructurel extends Entite{
/**
 * Classe abstraite ElementStructurel hérite de Entite
 * @author Nathan et Yazide
 * @version 1.0
 */

/**
 * Classe ElementStructurel qui hérite de la classe Entite avec deux attributs: nom et monde
 */

/**
 * Constructeur de la classe ElementStructurel
 * @param nom nom de l'element structurel
 * @param monde monde
 * @return element structurel créé
 * @throw NomDEntiteDejaUtiliseDansLeMondeException nom d'Entité déjà utilisé dans le monde
 */
	public ElementStructurel(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde);
	}

}
