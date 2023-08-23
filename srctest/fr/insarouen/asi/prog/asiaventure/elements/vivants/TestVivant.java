package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.util.*;
import java.util.Map;

public class TestVivant{

    public Vivant vivant;
    private Objet obj;
    private Objet obj2;
    private Monde monde1;
    private String nom;
    private int pDV;
    private int pDF;
    private Piece piece1;
    private Piece piece2;
    private Piece piece3;
    private Porte porte1;

    @Before
    public void avantTest(){
        try{
            monde1=new Monde("Monde");
            nom="nom";
            pDV=50;
            pDF=50;
            piece1 = new Piece("piece1",monde1){};
            piece2 = new Piece("piece2",monde1){};
            piece3 = new Piece("piece3",monde1){};
            obj = new Objet("objet1",monde1){
                public boolean estDeplacable(){
                    return true;
                }
            };
            obj2 = new Objet("objet2",monde1){
                public boolean estDeplacable(){
                    return false;
                }
            };
            vivant=new Vivant(nom,monde1,pDV,pDF,piece1,obj){};
            porte1 = new Porte("porte1",monde1,piece1,piece2);
        }catch(NomDEntiteDejaUtiliseDansLeMondeException e){}
        catch(PieceException e2){}
    }

    @Test(expected=ObjetNonPossedeParLeVivantException.class)
    public void testExceptionObjetNonPossede() throws ObjetNonPossedeParLeVivantException{
        vivant.deposer("objet2");
    }

    @Test
    public void testGetObjets(){
        Map<String,Objet> objets=new HashMap<String,Objet>();
        objets.put(obj.getNom(),obj);
        assertTrue(this.vivant.getObjets().equals(objets));
        objets=new HashMap<String,Objet>();
        objets.put(obj.getNom(),obj2);
        assertFalse(this.vivant.getObjets().equals(objets));
    }

    @Test
    public void testGetPiece(){
        assertTrue(this.vivant.getPiece().equals(piece1));
        assertFalse(this.vivant.getPiece().equals(piece2));
    }

    @Test
    public void testGetPointForce(){
        assertTrue(this.vivant.getPointForce()==50);
        assertFalse(this.vivant.getPointForce()==52);
    }

    @Test
    public void testGetPointVie(){
        assertTrue(this.vivant.getPointVie()==50);
        assertFalse(this.vivant.getPointVie()==52);
    }

    @Test
    public void testPossede(){
        assertTrue(this.vivant.possede(obj));
        assertFalse(this.vivant.possede(obj2));
    }

    @Test
    public void testFranchirPorte(){
        try{
            porte1.activer();
            assertTrue(this.vivant.getPiece().equals(piece1));
            assertFalse(this.vivant.getPiece().equals(piece2));
            assertTrue(this.piece1.contientVivant(this.vivant));
            assertFalse(this.piece2.contientVivant(this.vivant));
            this.vivant.franchir(porte1);
            assertTrue(this.vivant.getPiece().equals(piece2));
            assertFalse(this.vivant.getPiece().equals(piece1));
            assertTrue(this.piece2.contientVivant(this.vivant));
            assertFalse(this.piece1.contientVivant(this.vivant));

        }catch(PorteInexistanteDansLaPieceException e1){}
        catch(PorteFermeException e2){}
        catch(PieceException e3){}
        catch(ActivationImpossibleException e4){}
    }

    @Test
    public void testFranchirNomPorte(){
        try{
            assertTrue(this.vivant.getPiece().equals(piece1));
            assertFalse(this.vivant.getPiece().equals(piece2));
            assertTrue(this.piece1.contientVivant(this.vivant));
            assertFalse(this.piece2.contientVivant(this.vivant));
            this.vivant.franchir("porte1");
            assertTrue(this.vivant.getPiece().equals(piece2));
            assertFalse(this.vivant.getPiece().equals(piece1));
            assertTrue(this.piece2.contientVivant(this.vivant));
            assertFalse(this.piece1.contientVivant(this.vivant));

        }catch(PorteInexistanteDansLaPieceException e1){}
        catch(PorteFermeException e2){}
        catch(PieceException e3){}
    }

    @Test(expected=PorteFermeException.class)
    public void testExceptionPorteFerme() throws PorteFermeException{
        try{
            this.vivant.franchir(porte1);
        }catch(PorteInexistanteDansLaPieceException e1){}
        catch(PieceException e2){}
    }
    
/**
    @Test(expected=PorteInexistanteDansLaPieceException.class)
    public void testExceptionPorteInexistante()throws PorteInexistanteDansLaPieceException{
        try{
            Porte porte4 = new Porte("porte4",monde1,piece2,piece3);
            this.vivant.franchir(porte4);
        }catch(PorteFermeException e1){}
        catch(PieceException e2){}
        catch(NomDEntiteDejaUtiliseDansLeMondeException e3){}
    }
**/

    @Test(expected=ObjetNonDeplacableException.class)
    public void testExceptionObjetNonDeplacable() throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException{
        piece1.deposer(obj2);
        vivant.prendre(obj2);
    }

    @Test(expected=ObjetAbsentDeLaPieceException.class)
    public void testExceptionObjetAbsentDeLaPiece() throws ObjetNonDeplacableException,ObjetAbsentDeLaPieceException{
        vivant.prendre(obj2);
    }
}
