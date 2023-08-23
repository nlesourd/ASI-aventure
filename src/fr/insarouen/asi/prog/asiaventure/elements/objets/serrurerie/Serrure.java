package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import java.util.*;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;

public class Serrure extends Objet implements Activable{

    /**
   * Classe Serrure hérite de Objet et qui implémente Activable
   * @author Nathan et Yazide
   * @version 1.0
   */
    private Clef clef=null;
    private static int compteurSerrure=1;
    private Etat etat;

    /**
     * Constructeur Serrure
     * @param  nom nom de la serrure
     * @param  monde monde de la serrure
     * @throws NomDEntiteDejaUtiliseDansLeMondeException Nom d'entite déjà utilisé dans le monde
     */
    public Serrure(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
        super(nom,monde);
        compteurSerrure++;
        this.etat=Etat.VERROUILLE;
    }

    /**
     * Constructeur Serrure
     * @param  monde monde de la serrure
     * @throws NomDEntiteDejaUtiliseDansLeMondeException Nom d'entite déjà utilisé dans le monde
     */
    public Serrure(Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
        super("serrure"+String.valueOf(compteurSerrure),monde);
        compteurSerrure++;
        this.etat=Etat.VERROUILLE;
    }

    /**
     * Création d'une clef
     * @return la nouvelle clef créée
     * @throws ActivationImpossibleAvecObjetException Activation impossible avec l'objet
     * @throws NomDEntiteDejaUtiliseDansLeMondeException Nom d'entité déjà utilisé dans le monde
     */
    public final Clef creerClef() throws ActivationImpossibleAvecObjetException,NomDEntiteDejaUtiliseDansLeMondeException{
        if (this.clef==null) {
            String nomC="clef"+String.valueOf(compteurSerrure);
            Clef newClef= new Clef(nomC,this.getMonde());
            this.clef=newClef;

            return newClef;
        }else{
            return null;
        }
    }

    /**
     * Indique si une serrurerie est deplacable ou non
     * @return faux, valeur par défault
     */
    public boolean estDeplacable(){
		return false;
	}

    /**
     * Active la serrure à partir d'un objet
     * @param  obj                               [description]
     * @throws ActivationException [description]
     */
    public void activerAvec(Objet obj) throws ActivationException{
        if(this.activableAvec(obj)){
            this.activer();
        }else{
            throw new ActivationImpossibleAvecObjetException();
        }
    }

    /**
     * Indique si un objet permet d'activer la porte
     * @param  obj objet servant pour l'activation
     * @return boolean
     */
    public boolean activableAvec (Objet obj){
        return (obj.getNom()==this.clef.getNom());
    }

    /**
     * Permet de changer l'état de la serrure
     * @throws ActivationException Activation impossible
     */
    public void activer() throws ActivationException{
        if (this.getEtat()!=Etat.CASSE) {
            if (this.getEtat() == Etat.VERROUILLE) {
                this.etat = Etat.DEVERROUILLE;
            }
            else{
                this.etat = Etat.VERROUILLE;
            }
        }
        else {
            throw new ActivationImpossibleException();
        }
    }

    /**
     * Accesseur de Etat
     * @return Etat de la serrure
     */
    public Etat getEtat(){
        return this.etat;
    }

}
