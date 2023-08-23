package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestPiedDeBiche{

  public Monde m1;
  public PiedDeBiche pdb1;

  @Before
  public void avantTest(){
    try{
      m1 = new Monde("Monde");
      pdb1 = new PiedDeBiche("pdb1",m1);
    }catch(NomDEntiteDejaUtiliseDansLeMondeException e){}
  }

  @Test
  public void testConstructeur(){
    assertTrue(this.pdb1.getNom().equals("pdb1"));
    assertFalse(this.pdb1.getNom().equals("pdb2"));
    assertTrue(this.pdb1.getMonde().equals(m1));
    Monde m2 = new Monde("m2");
    assertFalse(this.pdb1.getMonde().equals(m2));
  }

  @Test
  public void testEstDeplacable(){
    assertTrue(this.pdb1.estDeplacable());
  }
  @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void testExceptionNomEntite() throws NomDEntiteDejaUtiliseDansLeMondeException{
    PiedDeBiche pdb2 = new PiedDeBiche("pdb1",m1);
  }
}
