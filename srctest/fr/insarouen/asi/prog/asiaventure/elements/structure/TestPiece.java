package fr.insarouen.asi.prog.asiaventure.elements.structure;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;

public class TestPiece {

  public Monde monde;
  public PiedDeBiche pied;
  public PiedDeBiche pied2;
  public Piece piece;
  public Vivant vivant;
  public Piece piece2;
  public Vivant vivant2;
  public Vivant vivant3;
  public Objet obj;

  @Before
  public void preTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
    monde = new Monde("monde");
    pied = new PiedDeBiche("pied",monde);
    piece = new Piece("piece",monde);
    vivant = new Vivant("nom",monde,10,20,piece,pied){};
  }


  @Test
  public void testConstructeurGetEtContientVivant(){
    piece.deposer(pied);
    assertThat(piece.getNom(), is("piece"));
    assertThat(piece.getMonde(), is(monde));
    assertThat(piece.contientVivant(vivant), is(true));
  }

  @Test
  public void testDeposerEtContientObjet() {
    piece.deposer(pied);
    assertThat(piece.contientObjet(pied), is(true));
  }

  @Test
  public void testRetirer() throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
    piece.deposer(pied);
    piece.retirer(pied);
    assertThat(piece.contientObjet(pied), is(false));
  }

  @Test
  public void testEntrer() {
    piece.entrer(vivant);
    assertThat(piece.contientVivant(vivant), is(true));
  }

  @Test
  public void testSortir() throws VivantAbsentDeLaPieceException{
    piece.entrer(vivant);
    assertThat(piece.sortir(vivant), is(vivant));
  }

  @Test(expected=ObjetAbsentDeLaPieceException.class)
  public void testObjetAbsentDeLaPieceException() throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException, NomDEntiteDejaUtiliseDansLeMondeException{
    pied2 = new PiedDeBiche("pied2",monde);
    piece.retirer(pied2);
  }

  @Test(expected=ObjetNonDeplacableException.class)
  public void testObjetNonDeplacableException() throws ObjetNonDeplacableException, NomDEntiteDejaUtiliseDansLeMondeException, ObjetAbsentDeLaPieceException{
    obj = new Objet("parpaing",monde){
      public boolean estDeplacable(){
        return false;
      }
    };
    piece.deposer(obj);
    piece.retirer(obj);
  }

  @Test(expected=VivantAbsentDeLaPieceException.class)
  public void testVivantAbsentDeLaPieceException() throws VivantAbsentDeLaPieceException, NomDEntiteDejaUtiliseDansLeMondeException{
    piece2 = new Piece("piece2",monde);
    vivant2 = new Vivant("nom2",monde,10,20,piece2){};
    piece.sortir(vivant2);
  }

}
