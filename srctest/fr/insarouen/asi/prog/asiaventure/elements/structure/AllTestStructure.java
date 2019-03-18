package fr.insarouen.asi.prog.asiaventure.elements.structure;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import fr.insarouen.asi.prog.asiaventure.elements.structure.TestElementStructurel;
import fr.insarouen.asi.prog.asiaventure.elements.structure.TestPiece;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestElementStructurel.class,
  TestPiece.class
})

public class AllTestStructure {}
