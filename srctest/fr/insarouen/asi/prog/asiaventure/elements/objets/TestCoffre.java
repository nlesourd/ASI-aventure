package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.util.*;
import java.util.Map;

public class TestCoffre{

    private Monde monde1;
    private Coffre coffre1;
    private Objet objet1;

    @Before
    public void avantTest(){
        try{
            monde1 = new Monde("monde1");
            coffre1 = new Coffre("coffre1",monde1);
            objet1 = new Objet("objet1",monde1){
                public boolean estDeplacable(){
                    return true;
                }
            };
        }catch(NomDEntiteDejaUtiliseDansLeMondeException e1){}
    }

    @Test
    public void testCoffre(){
        assertTrue(this.coffre1.getNom().equals("coffre1"));
        assertTrue(this.coffre1.getMonde().equals(monde1));
    }

    @Test
    public void testEstDeplacable(){
        assertFalse(this.coffre1.estDeplacable());
    }

    @Test
    public void testActivableAvec(){
        assertTrue(this.coffre1.activableAvec(objet1));
    }

    @Test
    public void testActiverAvec(){
        try{
            assertTrue(this.coffre1.getEtat().equals(Etat.FERME));
            this.coffre1.activerAvec(objet1);
            assertTrue(this.coffre1.getEtat().equals(Etat.OUVERT));
        }catch(ActivationException e1){}
    }




}
