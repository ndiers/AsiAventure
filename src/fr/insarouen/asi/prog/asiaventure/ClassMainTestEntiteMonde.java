package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.*;
import fr.insarouen.asi.prog.asiaventure.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;

public class ClassMainTestEntiteMonde{
  public static void main(String[] args){
    try{
      Monde monde = new Monde("monde");
      Monde monde1 = new Monde("monde1");
      Entite entite1 = new Entite("entite1",monde){
      };
      Entite entite2 = new Entite("entite2",monde){
      };
      PiedDeBiche pied = new PiedDeBiche("pied",monde);
      PiedDeBiche pied2 = new PiedDeBiche("pied2",monde);
      Piece piece = new Piece("piece",monde);
      Piece piece1 = new Piece("piece1",monde);
      Vivant vivant = new Vivant("jeanlouis",monde,10,5,piece1,pied){
      };
      //piece.sortir(vivant);
      //piece.retirer(pied);
      vivant.deposer(pied2);
    }
    //catch(ObjetAbsentDeLaPieceException e1){
    //  e1.printStackTrace();
    //}
    //catch(VivantAbsentDeLaPieceException e2){
    //  e2.printStackTrace();
    //}
    catch(NomDEntiteDejaUtiliseDansLeMondeException e3){
      e3.printStackTrace();
    }
    //catch(ObjetNonDeplacableException e4){
    //  e4.printStackTrace();
    //}
    catch(ObjetNonPossedeParLeVivantException e5){
      e5.printStackTrace();
    }
  }
}
