package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;
import fr.insarouen.asi.prog.asiaventure.MondeException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurelException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.VivantException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;


/**
 * Main permettant les tests initiales des différentes classes du projet asiaventure
 */

public class Main {
	public static void main(String[] args) {
		/**
	   * Classe Main
	   * @author Nathan et Yazide
	   * @version 1.0
	   */
		try{
			//TESTS MONDE
			System.out.println("TESTS MONDE");
			Monde m1 = new Monde("m1");
			Monde m2 = new Monde("m2");
			Entite e1 = new Entite("e1",m1){}; // classes anonymes
			System.out.println(m1.getNom());
			//m2.ajouter(e1);
			System.out.println(m1.getEntite("e1"));
			System.out.println("----------------------------");

			// TESTS ENTITE
			System.out.println("TESTS ENTITE");
			System.out.println(e1.toString());
			Entite e2 = new Entite("e2",m2){}; // classe anonyme
			System.out.println(e2.toString());
			Entite e3 = new Entite("e1",m2){}; // classe anonyme
			System.out.println(e3.toString());
			System.out.println(e1.equals(e1));
			System.out.println(e1.equals(e2));
			System.out.println(e1.equals(e3));
			System.out.println("----------------------------");

			// TESTS OBJETS
			System.out.println("TESTS OBJETS");
			Objet o1 = new Objet("gourde",m1){
				public boolean estDeplacable(){
					return false;
				}
			}; // classe anonyme
			System.out.println(o1.toString());
			Objet o2 = new Objet("chargeur",m1){
				public boolean estDeplacable(){
					return false;
				}
			}; // classe anonyme
			System.out.println(o2.toString());
			Objet o3 = new Objet("bonnet",m2){
				public boolean estDeplacable(){
					return false;
				}
			}; // classe anonyme
			System.out.println(o3.toString());
			System.out.println("----------------------------");

			// TESTS PIED DE BICHE
			System.out.println("TESTS PIED DE BICHE");
			PiedDeBiche pdb1 = new PiedDeBiche("pdb1",m1);
			System.out.println(pdb1.toString());
			System.out.println("----------------------------");

		  // TESTS ELEMENT STRUCTUREL
			System.out.println("TESTS ELEMENT STRUCTUREL");
			ElementStructurel es1 = new ElementStructurel("es1",m1){}; // classe anonyme
			System.out.println(es1.toString());
			System.out.println("----------------------------");

			// TESTS PIECE
			System.out.println("TESTS PIECE");
			Piece p1 = new Piece("p1",m1);
			System.out.println(p1.contientObjet(o1));
			System.out.println(p1.toString());
			p1.deposer(o1);
			System.out.println("Contient objet ?");
			System.out.println(p1.contientObjet(o1));
			p1.deposer(o2);
			System.out.println(p1.contientObjet("chargeur"));
			p1.deposer(o3);
			System.out.println(p1.toString());
			p1.retirer(o3);
			System.out.println(p1.toString());
			p1.retirer("gourde");
			System.out.println(p1.toString());
			System.out.println("----------------------------");

			// TESTS VIVANT X PIECE
			System.out.println("TESTS VIVANT X PIECE");
			Vivant v1 = new Vivant("chat",m1,100,1000,p1,o1,o2){};
			System.out.println(v1.toString());
			v1.prendre(o2);
			System.out.println("Possede?");
			System.out.println(v1.possede(o2));
			System.out.println(v1.possede("chargeur"));
			System.out.println(v1.toString());
			System.out.println(p1.toString());
			p1.deposer(o3);
			System.out.println(p1.toString());
			v1.prendre("bonnet");
			System.out.println(v1.toString());
			System.out.println(p1.toString());
			System.out.println("----------------------------");
			v1.deposer("bonnet");

			p1.entrer(v1);
			System.out.println(p1.toString());
			System.out.println(p1.contientVivant(v1));
			System.out.println(p1.contientVivant("chat"));
			p1.sortirVivant(v1);
			System.out.println(p1.contientVivant(v1));
			System.out.println(p1.toString());

		}catch(NomDEntiteDejaUtiliseDansLeMondeException e1){
			System.out.println("Le Nom d'Entité est deja utilisé dans le Monde");
		}catch(ObjetNonPossedeParLeVivantException e2){
			System.out.println("Le Vivant ne possède pas l'objet selectionné");
		}catch(ObjetNonDeplacableException e3){
			System.out.println("L'objet n'est pas déplaçable");
		}catch(ObjetAbsentDeLaPieceException e4){
			System.out.println("L'objet n'est pas dans la pièce");
		//}catch(EntiteDejaDansUnAutreMondeException e5){
		//	System.out.println("L'entité est déjà dans un autre monde");
		}catch(PieceException e6){
			System.out.println("Le vivant est deja dans la piece");
		}

	}
}
