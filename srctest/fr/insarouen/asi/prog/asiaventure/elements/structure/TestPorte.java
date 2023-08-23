package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.hamcrest.core.IsEqual;
import java.util.*;

public class TestPorte{

  public Monde m1;
  public Monde m2;
  public Piece pA;
  public Piece pB;
  public Porte porte1;


  @Before
  public void avantTest(){
    try{
      m1 = new Monde("m1");
      m2 = new Monde("m2");
      pA = new Piece("pA",m1);
      pB = new Piece("pB",m1);
      porte1 = new Porte("p1",m1,pA,pB);
    }catch(NomDEntiteDejaUtiliseDansLeMondeException e1){}
  }

  @Test
  public void testConstructeur(){
    assertTrue(this.porte1.getNom().equals("p1"));
    assertFalse(this.porte1.getNom().equals("p2"));
    assertTrue(this.porte1.getMonde().equals(m1));
    assertFalse(this.porte1.getMonde().equals(m2));
  }

  @Test
  public void testGetPieceAutreCote(){
    assertTrue(this.porte1.getPieceAutreCote(pA).equals(pB));
    assertFalse(this.porte1.getPieceAutreCote(pA).equals(pA));
    assertTrue(this.porte1.getPieceAutreCote(pB).equals(pA));
    assertFalse(this.porte1.getPieceAutreCote(pB).equals(pB));
  }

  @Test
  public void testActiver(){
    try{
      assertTrue(this.porte1.getEtat().equals(Etat.FERME));
      this.porte1.activer();
      assertTrue(this.porte1.getEtat().equals(Etat.OUVERT));
      assertFalse(this.porte1.getEtat().equals(Etat.FERME));
      this.porte1.activer();
      assertTrue(this.porte1.getEtat().equals(Etat.FERME));
      assertFalse(this.porte1.getEtat().equals(Etat.OUVERT));
    }catch(ActivationImpossibleException e1){}
  }



}
