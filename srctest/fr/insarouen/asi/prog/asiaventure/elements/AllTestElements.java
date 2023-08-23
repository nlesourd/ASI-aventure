package fr.insarouen.asi.prog.asiaventure.elements;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import fr.insarouen.asi.prog.asiaventure.elements.objets.TestObjet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.TestPiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.structure.TestElementStructurel;
import fr.insarouen.asi.prog.asiaventure.elements.structure.TestPiece;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.TestVivant;
import fr.insarouen.asi.prog.asiaventure.elements.structure.TestPorte;
import fr.insarouen.asi.prog.asiaventure.elements.objets.TestCoffre;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.TestClef;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.TestSerrure;

@RunWith(Suite.class)
@SuiteClasses({
  TestEntite.class,
  TestObjet.class,
  TestPiedDeBiche.class,
  TestElementStructurel.class,
  TestPiece.class,
  TestVivant.class,
  TestPorte.class,
  TestCoffre.class,
  TestClef.class,
  TestSerrure.class
})

public class AllTestElements {}
