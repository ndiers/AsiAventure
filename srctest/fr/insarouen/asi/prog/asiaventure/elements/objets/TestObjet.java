package fr.insarouen.asi.prog.asiaventure.elements.objets;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

public class TestObjet {
  public Monde monde;
  public Objet obj;

  @Before
  public void preTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    monde = new Monde("monde");
  }

  @Test
  public void testConstructeur() throws NomDEntiteDejaUtiliseDansLeMondeException{
    obj = new Objet("objet",monde){
      public boolean estDeplacable(){
        return(false);
      }
    };
    assertThat(obj.getNom(), is("objet"));
    assertThat(obj.getMonde(), is(monde));
  }
}
