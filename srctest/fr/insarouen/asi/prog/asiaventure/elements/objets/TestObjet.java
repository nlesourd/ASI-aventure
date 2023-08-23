package fr.insarouen.asi.prog.asiaventure.elements.objets;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class TestObjet{

  public Monde m1;
  public Objet obj1;

  @Before
  public void avantTest(){
    try{
      m1 = new Monde("Monde");
      obj1 = new Objet("obj1",m1){
        public boolean estDeplacable(){
					return false;
				}
      };
    }catch(NomDEntiteDejaUtiliseDansLeMondeException e){}
  }

  @Test
  public void testConstructeur(){
    assertTrue(this.obj1.getNom().equals("obj1"));
    assertFalse(this.obj1.getNom().equals("obj2"));
    assertTrue(this.obj1.getMonde().equals(m1));
    Monde m2 = new Monde("m2");
    assertFalse(this.obj1.getMonde().equals(m2));
  }

  @Test
  public void testEstDeplacable(){
    assertFalse(this.obj1.estDeplacable());
  }

  @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void testExceptionNomEntite() throws NomDEntiteDejaUtiliseDansLeMondeException{
    Objet obj2 = new Objet("obj1",m1){
      public boolean estDeplacable(){
        return false;
      }
    };
  }


}
