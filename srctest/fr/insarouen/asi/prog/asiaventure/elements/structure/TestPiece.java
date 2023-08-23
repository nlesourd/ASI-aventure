package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.hamcrest.core.IsEqual;
import java.util.*;

public class TestPiece{

  public Monde m1;
  public Monde m2;
  public Piece p1;
  public Piece p2;
  public Piece p3;
  public Objet obj1;
  public Objet obj2;
  public Vivant v1;
  public Vivant v2;
  public Porte porte1;
  public Porte porte2;

  @Before
  public void avantTest(){
    try{
      m1 = new Monde("m1");
      m2 = new Monde("m2");
      p1 = new Piece("p1",m1);
      p2 = new Piece("p2",m1);
      p3 = new Piece("p3",m1);
      obj1 = new Objet("obj1",m1){
        public boolean estDeplacable(){
					return true;
				}
      };
      obj2 = new Objet("obj2",m1){
        public boolean estDeplacable(){
					return false;
				}
      };
      v1 = new Vivant("v1",m1,100,100,p1){};
      v2 = new Vivant("v2",m1,100,100,p1){};
      porte1 = new Porte("porte1",m1,p1,p2);
      porte2 = new Porte("porte2",m1,p2,p3);
    }catch(PieceException e1){}
    catch(NomDEntiteDejaUtiliseDansLeMondeException e2){}
  }

  @Test
  public void testConstructeurEtGetters(){
    assertTrue(this.p1.getNom().equals("p1"));
    assertFalse(this.p1.getNom().equals("p2"));
    assertTrue(this.p1.getMonde().equals(m1));
    assertFalse(this.p1.getMonde().equals(m2));
    Map<String,Objet> objets = new HashMap<>();
    //assertThat(this.p1.getObjets(),IsEqual.equalTo(objets));
    assertFalse(this.p1.getObjets().equals(obj1));
    Map<String,Vivant> vivants = new HashMap<>();
    //assertThat(this.p1.getVivants(),IsEqual.equalTo(vivants));
    assertFalse(this.p1.getVivants().equals(v1));

  }

  @Test
  public void testContientObjetEtDeposer(){
    assertFalse(this.p1.contientObjet("obj1"));
    this.p1.deposer(this.obj1);
    assertTrue(this.p1.contientObjet("obj1"));
    assertFalse(this.p1.contientObjet("obj2"));
  }

  @Test
  public void testContientVivantEtEntrer(){
    assertTrue(this.p1.contientVivant("v1"));
    assertTrue(this.p1.contientVivant("v2"));
  }

  @Test
  public void testRetirer(){
    this.p1.deposer(this.obj1);
    assertTrue(this.p1.contientObjet("obj1"));
    try{
      this.p1.retirer(this.obj1);
    }catch(ObjetNonDeplacableException e1){
    }catch(ObjetAbsentDeLaPieceException e2){}
    assertFalse(this.p1.contientObjet("obj1"));
    assertFalse(this.p1.contientObjet("obj2"));
  }

  @Test
  public void testSortirVivant(){
    try {
      this.p1.sortirVivant(this.v1);
      assertFalse(this.p1.contientVivant("v1"));
      assertTrue(this.p1.contientVivant("v2"));
    } catch (PieceException e) {
      //TODO: handle exception
    }
  }

  @Test
  public void testAddPorte(){
    assertTrue(this.p1.getPorte("porte1").equals(porte1));
    assertFalse(this.p1.getPorte("porte1").equals(porte2));
  }

  @Test
  public void testALaPorte(){
    assertTrue(this.p1.aLaPorte(porte1));
    assertFalse(this.p1.aLaPorte(porte2));
    assertTrue(this.p1.aLaPorte("porte1"));
    assertFalse(this.p1.aLaPorte("porte2"));
  }

  @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void testExceptionNomEntite() throws NomDEntiteDejaUtiliseDansLeMondeException{
    Piece p2 = new Piece("p1",m1);
  }

  @Test(expected=ObjetNonDeplacableException.class)
  public void testExceptionObjetNonDeplacable() throws ObjetNonDeplacableException{
    this.p1.deposer(obj2);
    try{
      this.p1.retirer(obj2);
    }catch(ObjetAbsentDeLaPieceException e){}
  }

  @Test(expected=ObjetAbsentDeLaPieceException.class)
  public void testExceptionObjetAbsentPiece() throws ObjetAbsentDeLaPieceException{
    try{
      this.p1.retirer(obj1);
    }catch(ObjetNonDeplacableException e){}
  }
}
