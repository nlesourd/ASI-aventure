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

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.util.*;
import java.util.Map;

public class TestSerrure{

    private Monde monde1;
    private Serrure serrure1;
    private Serrure serrure2;
    private Clef clef1;
    private Objet objet1;

    @Before
    public void avantTest() throws Exception{
        monde1 = new Monde("monde1");
        serrure1 = new Serrure("serrure1",monde1);
        serrure2 = new Serrure(monde1);
        clef1 = new Clef("clef1",monde1);
        objet1 = new Objet("objet1",monde1){
            public boolean estDeplacable(){
                return true;
            }
        };
    }

    @Test
    public void testPremierConstructeur(){
        assertTrue(this.serrure1.getNom().equals("serrure1"));
        assertTrue(this.serrure1.getMonde().equals(monde1));
    }

    @Test
    public void testDeuxiemeConstructeur(){
        assertTrue(this.serrure2.getMonde().equals(monde1));
    }

    @Test
    public void testCreerClef(){
        try{
            assertTrue(this.serrure1.creerClef() instanceof Clef);
            assertTrue(this.serrure1.creerClef() == null);
        }catch(ActivationImpossibleAvecObjetException e1){}
        catch(NomDEntiteDejaUtiliseDansLeMondeException e2){}
    }

    @Test
    public void testEstDeplacable(){
        assertFalse(this.serrure1.estDeplacable());
    }

    @Test
    public void testActivableAvec(){
        try{
            assertTrue(this.serrure1.activableAvec(this.serrure1.creerClef()));
            assertFalse(this.serrure1.activableAvec(clef1));
            assertFalse(this.serrure1.activableAvec(objet1));
        }catch(ActivationImpossibleAvecObjetException e1){}
        catch(NomDEntiteDejaUtiliseDansLeMondeException e2){}
    }

    @Test
    public void testActiverAvec(){
        try{
            this.serrure1.activerAvec(this.serrure1.creerClef());
        }catch(ActivationException e1){}
        catch(NomDEntiteDejaUtiliseDansLeMondeException e2){}
    }

    @Test
    public void testActiver(){
        assertTrue(this.serrure1.getEtat().equals(Etat.VERROUILLE));
        assertFalse(this.serrure1.getEtat().equals(Etat.DEVERROUILLE));
        try{
            this.serrure1.activer();
        }catch(ActivationException e1){}
        assertTrue(this.serrure1.getEtat().equals(Etat.DEVERROUILLE));
        assertFalse(this.serrure1.getEtat().equals(Etat.VERROUILLE));
    }

    @Test(expected=ActivationImpossibleAvecObjetException.class)
    public void testActivationImpossibleAvecObjet() throws ActivationImpossibleAvecObjetException{
        try{
            this.serrure1.activerAvec(objet1);
        }catch(ActivationException e1){}
    }

}
