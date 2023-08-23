package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestElementStructurel{

  public ElementStructurel es1;
  public Monde m1;

  @Before
  public void avantTest(){
    try{
      m1 = new Monde("Monde");
      es1 = new ElementStructurel("es1",m1){};
    }catch(NomDEntiteDejaUtiliseDansLeMondeException e){}
  }

  @Test
  public void testConstructeur(){
    assertTrue(this.es1.getNom().equals("es1"));
    assertFalse(this.es1.getNom().equals("es2"));
    assertTrue(this.es1.getMonde().equals(m1));
    Monde m2 = new Monde("m2");
    assertFalse(this.es1.getMonde().equals(m2));
  }

  @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void testExceptionNomEntite() throws NomDEntiteDejaUtiliseDansLeMondeException{
    ElementStructurel es2 = new ElementStructurel("es1",m1){};
  }
}
