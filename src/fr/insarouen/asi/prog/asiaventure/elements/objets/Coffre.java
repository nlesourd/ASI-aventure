// @u:start Coffre

// Le coffre est un simple objet non déplaçable, c'est juste pour créer un nouveau type d'objet
// il ne contient pas d'objet
// il n'a pas de serrure
package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;

public class Coffre extends Objet implements Activable{
	/**
	 * Classe Coffre hérite de Objet implémente de Activable
	 * @author Nathan et Yazide
	 * @version 1.0
	 */
     private Etat etat;
	/**
   * Constructeur de la classe Coffre
   * @param monde monde
   * @return Coffre créé
   * @throw NomDEntiteDejaUtiliseDansLeMondeException nom déjà utilisé dans le monde
	 */
	public Coffre(String nom,Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom, monde);
        this.etat=Etat.FERME;
	}

	/**
	 * Indique que le coffre n'est pas déplaçable
	 * @return vrai
	 */
	public boolean estDeplacable(){
		return false;
	}

    /**
     * Indique si le coffre est activable avec un objet
     * @param  obj objet en question
     * @return par défaut Vrai car le coffre s'ouvre avec n'importe quel objet
     */
    public boolean activableAvec (Objet obj){
        return true;
    }

    /**
     * Utilisé dans activiterAvec, permet de changer l'état du coffre
     * @throws ActivationException Activation impossible
     */
    public void activer() throws ActivationException{
        if (this.getEtat()!=Etat.CASSE) {
            if (this.getEtat() == Etat.FERME) {
                this.etat = Etat.OUVERT;
            }
            else{
                this.etat = Etat.FERME;
            }
        }
        else {
            throw new ActivationImpossibleException();
        }
    }

    /**
     * Activer le coffre avec un objet
     * @param  obj objet pour l'ouverture de la porte
     * @throws ActivationException Activation impossible
     */
    public void activerAvec(Objet obj) throws ActivationException{
        if(this.activableAvec(obj)){
            this.activer();
        }else{
            throw new ActivationImpossibleAvecObjetException();
        }
    }

    /**
     * Accesseur de l'Etat du coffre
     * @return etat du coffre
     */
    public Etat getEtat(){
        return this.etat;
    }

    /**
     * Description du coffre
     * @return description
     */
    @Override
    public String toString(){
        return "";
    }
}
// @u:end Coffre
