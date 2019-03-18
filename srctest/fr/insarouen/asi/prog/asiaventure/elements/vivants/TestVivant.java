package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;

public class TestVivant {
  public Monde monde;
  public PiedDeBiche pied;
  public PiedDeBiche pied2;
  public PiedDeBiche pied3;
  public Piece piece;
  public Vivant vivant;
  public Vivant vivant2;
  public Objet obj;

  @Before
  public void preTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    monde = new Monde("monde");
    pied = new PiedDeBiche("pied",monde);
    piece = new Piece("piece",monde);
    vivant = new Vivant("nom",monde,10,20,piece,pied){};
  }


  @Test
  public void testConstructeurEtGet(){
    assertThat(vivant.getNom(), is("nom"));
    assertThat(vivant.getMonde(), is(monde));
    assertThat(vivant.getPointVie(), is(10));
    assertThat(vivant.getPointForce(), is(20));
    assertThat(vivant.getPiece(), is(piece));
  }

  @Test
  public void testPossede(){
  assertThat(vivant.possede(pied), is(true));
  }

  @Test
  public void testDeposer() throws ObjetNonPossedeParLeVivantException{
  vivant.deposer(pied);
  assertThat(vivant.possede(pied), is(false));
  assertThat(piece.contientObjet(pied), is(true));
  }

  @Test
  public void testPrendre() throws ObjetNonPossedeParLeVivantException, ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
  vivant.deposer(pied);
  vivant.prendre(pied);
  assertThat(vivant.possede(pied), is(true));
  assertThat(piece.contientObjet(pied), is(false));
  }

  @Test
  public void testEstMort() throws NomDEntiteDejaUtiliseDansLeMondeException{
  vivant2 = new Vivant("nom2",monde,0,20,piece,pied){};
  assertThat(vivant.estMort(), is(false));
  assertThat(vivant2.estMort(), is(true));
  }

  @Test
  public void testGetObjet(){
    assertThat(vivant.getObjet("pied"), is(pied));
  }

  @Test(expected=ObjetNonPossedeParLeVivantException.class)
  public void testObjetNonPossedeParLeVivantException() throws ObjetNonPossedeParLeVivantException, NomDEntiteDejaUtiliseDansLeMondeException{
    pied2 = new PiedDeBiche("pied2",monde);
    vivant.deposer(pied2);
  }

  @Test(expected=ObjetAbsentDeLaPieceException.class)
  public void testObjetAbsentDeLaPieceException() throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException, NomDEntiteDejaUtiliseDansLeMondeException{
    pied3 = new PiedDeBiche("pied3",monde);
    vivant.prendre(pied3);
  }

  @Test(expected=ObjetNonDeplacableException.class)
  public void testObjetNonDeplacableException() throws ObjetNonDeplacableException, NomDEntiteDejaUtiliseDansLeMondeException, ObjetAbsentDeLaPieceException{
    obj = new Objet("parpaing",monde){
      public boolean estDeplacable(){
        return false;
      }
    };
    piece.deposer(obj);
    vivant.prendre(obj);
  }
}
