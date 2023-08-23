package fr.insarouen.asi.prog.asiaventure.elements;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class TestEntite{

    public Entite entite;
    private Monde monde1;

    @Before
    public void avantTest(){
      try{
        monde1=new Monde("Monde");
        entite=new Entite("nom",monde1){};
      }catch(NomDEntiteDejaUtiliseDansLeMondeException e){}

    }

    @Test
    public void testGetNom(){
      assertTrue(this.entite.getNom().equals("nom"));
      assertFalse(this.entite.getNom().equals("Noatzftm"));
    }

    @Test
    public void testGetMonde(){
      assertTrue(this.entite.getMonde().equals(monde1));
      Monde monde2=new Monde("Monde");
      assertFalse(this.entite.getMonde().equals(monde2));
    }

    @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
    public void testExceptionNomEntite() throws NomDEntiteDejaUtiliseDansLeMondeException{
        Entite entite2=new Entite("nom",monde1){};
    }
}
