package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public final class Clef extends Objet{

    /**
	 * Classe Clef hérite de Objet
	 * @author Nathan et Yazide
	 * @version 1.0
	 */

    /**
     * Constructeur de Clef
     * @param  nom nom de la clef
     * @param  monde monde de la clef
     * @throws NomDEntiteDejaUtiliseDansLeMondeException Nom d'Entite déjà utilisé dans le monde
     */
    protected Clef(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
        super(nom,monde);
    }

    /**
     * Indique si une clé est déplacable ou non
     * @return par défaut, initialisé à Vrai
     */
    public boolean estDeplacable(){
        return true;
    }

}
