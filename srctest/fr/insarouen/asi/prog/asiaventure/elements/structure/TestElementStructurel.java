package fr.insarouen.asi.prog.asiaventure.elements.structure;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;

public class TestElementStructurel {
  public Monde monde;
  public ElementStructurel eleStr;

  @Before
  public void preTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    monde = new Monde("monde");
  }

  @Test
  public void testConstructeur() throws NomDEntiteDejaUtiliseDansLeMondeException{
    eleStr = new ElementStructurel("elementStructurel", monde);
    assertThat(eleStr.getNom(), is("elementStructurel"));
    assertThat(eleStr.getMonde(), is(monde));
  }
}
