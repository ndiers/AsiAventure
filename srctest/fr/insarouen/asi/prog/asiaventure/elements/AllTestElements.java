package fr.insarouen.asi.prog.asiaventure.elements;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import fr.insarouen.asi.prog.asiaventure.elements.TestEntite;
import fr.insarouen.asi.prog.asiaventure.elements.objets.AllTestObjets;
import fr.insarouen.asi.prog.asiaventure.elements.structure.AllTestStructure;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.AllTestVivants;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestEntite.class,
  AllTestObjets.class,
  AllTestStructure.class,
  AllTestVivants.class
})

public class AllTestElements {}
