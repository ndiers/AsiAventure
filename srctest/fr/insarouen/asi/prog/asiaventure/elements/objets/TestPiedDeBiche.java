package fr.insarouen.asi.prog.asiaventure.elements.objets;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class TestPiedDeBiche {
  public Monde monde;
  public PiedDeBiche pied;

  @Before
  public void preTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    monde = new Monde("monde");
    pied = new PiedDeBiche("piedDeBiche",monde);
  }

  @Test
  public void testConstructeur() throws NomDEntiteDejaUtiliseDansLeMondeException{
    assertThat(pied.getNom(), is("piedDeBiche"));
    assertThat(pied.getMonde(), is(monde));
  }

  @Test
  public void testEstDeplacable(){
    assertThat(pied.estDeplacable(), is(true));
  }
}
