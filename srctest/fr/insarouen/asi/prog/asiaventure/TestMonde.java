package fr.insarouen.asi.prog.asiaventure;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;

public class TestMonde{

    public Monde monde;
    public Entite entite1;
    public Entite entite2;

    @Before
    public void preTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
      monde = new Monde("monde");
    }

    @Test
    public void testConstructeurEtGetNom(){
      assertThat(monde.getNom(), is("monde"));
    }

    @Test
    public void testAjouterEtGetEntite()throws NomDEntiteDejaUtiliseDansLeMondeException{
      entite1 = new Entite("nom",monde){};
      assertThat(monde.getEntite("nom"), is(entite1));
    }

    @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
    public void testNomDEntiteDejaUtiliseDansLeMondeEcxeption () throws NomDEntiteDejaUtiliseDansLeMondeException{
      entite1 = new Entite("nom",monde){};
      entite2 = new Entite("nom",monde){};
    }

    @Test
    public void testToString() throws NomDEntiteDejaUtiliseDansLeMondeException{
      entite1 = new Entite("nom",monde){};
      assertThat(monde.toString(), is("monde,nom"));
    }
}
