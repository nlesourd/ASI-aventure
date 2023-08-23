package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;
import fr.insarouen.asi.prog.asiaventure.Monde;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestMonde{

  public Monde m1;
  public Entite e1;
  public Entite e2;

  @Before
  public void avantTest(){
    try{
      m1 = new Monde("m1");
      e1 = new Entite("e1",m1){};
      e2 = new Entite("e2",m1){};
      this.m1.ajouter(this.e1);
    }catch(NomDEntiteDejaUtiliseDansLeMondeException e1){}
    catch(EntiteDejaDansUnAutreMondeException e2){}
  }

  @Test
  public void testGetNom(){
    assertTrue(this.m1.getNom().equals("m1"));
    assertFalse(this.m1.getNom().equals("m2"));
  }

  @Test
  public void testGetEntite(){
    assertTrue(this.m1.getEntite("e1").equals(e1));
    assertFalse(this.m1.getEntite("e1").equals(e2));
  }

  @Test
  public void testAjouter(){
    try{
      this.m1.ajouter(this.e2);
    }catch(NomDEntiteDejaUtiliseDansLeMondeException e1){}
    catch(EntiteDejaDansUnAutreMondeException e2){}
    assertTrue(this.m1.getEntite("e2").equals(e2));
    assertFalse(this.m1.getEntite("e2").equals(e1));
  }

  @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void testExceptionNomEntite() throws NomDEntiteDejaUtiliseDansLeMondeException{
    try{
      this.m1.ajouter(e1);
    }catch(EntiteDejaDansUnAutreMondeException e){}
  }

  @Test(expected=EntiteDejaDansUnAutreMondeException.class)
  public void testExceptionEntiteDejaDansUnAutreMonde() throws EntiteDejaDansUnAutreMondeException{
    Monde m2 = new Monde("m2");
    try{
      Entite e3 = new Entite("e3",m2){};
      this.m1.ajouter(e3);
    }catch(NomDEntiteDejaUtiliseDansLeMondeException e){}
  }
}
