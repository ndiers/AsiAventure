package fr.insarouen.asi.prog.asiaventure.elements;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;

public class TestEntite {

  public Monde monde;
  public Entite entite;
  public Entite entite2;

  @Before
  public void preTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    monde = new Monde("monde");
    entite = new Entite("nom",monde){};
  }

  @Test
  public void testConstructeurEtGetNomEtGetMonde(){
    assertThat(entite.getNom(), is("nom"));
    assertThat(entite.getMonde(), is(monde));
  }

  @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void testNomDEntiteDejaUtiliseDansLeMondeEcxeption () throws NomDEntiteDejaUtiliseDansLeMondeException{
    entite2 = new Entite("nom",monde){};
  }

  @Test
  public void testToString(){
    assertThat(entite.toString(), is("nom,monde"));
  }

  @Test
  public void testHashCode() throws NomDEntiteDejaUtiliseDansLeMondeException{
    entite2 = new Entite("nom1",monde){};
    assertThat(entite.hashCode(), is(entite.hashCode()));
    assertThat(entite.hashCode(), not(entite2.hashCode()));
  }

  @Test
  public void testEquals() throws NomDEntiteDejaUtiliseDansLeMondeException{
    entite2 = new Entite("nom1",monde){};
    assertThat(entite.equals(entite), is(true));
    assertThat(entite.equals(entite2), is(false));
  }
}
