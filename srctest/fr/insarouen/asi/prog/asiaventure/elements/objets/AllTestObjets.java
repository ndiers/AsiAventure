package fr.insarouen.asi.prog.asiaventure.elements.objets;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import fr.insarouen.asi.prog.asiaventure.elements.objets.TestObjet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.TestPiedDeBiche;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestObjet.class,
  TestPiedDeBiche.class,
})

public class AllTestObjets {}
