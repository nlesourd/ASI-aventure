package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.util.*;
import java.util.Map;

public class TestClef{

    private Clef clef1;
    private Monde monde1;

    @Before
    public void avantTest(){
        try{
            monde1 = new Monde("monde1");
            clef1 = new Clef("clef1",monde1);
        }catch(NomDEntiteDejaUtiliseDansLeMondeException e1){}
    }

    @Test
    public void testConstructeur(){
        assertTrue(this.clef1.getNom().equals("clef1"));
        assertTrue(this.clef1.getMonde().equals(monde1));
    }

    @Test
    public void testEstDeplacable(){
        assertTrue(this.clef1.estDeplacable());
    }
}
