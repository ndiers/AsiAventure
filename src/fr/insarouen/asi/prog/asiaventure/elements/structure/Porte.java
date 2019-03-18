package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;



public class Porte extends ElementStructurel implements Activable{

  private Piece pieceA;
  private Piece pieceB;
  private Etat etat;
  private Serrure serrure;

  public Porte(String nom, Monde monde, Piece pieceA ,Piece pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
    this.pieceA = pieceA;
    this.pieceB = pieceB;
    etat = Etat.FERME;
    serrure = null;
  }

  public Porte(String nom, Monde monde, Serrure serrure, Piece pieceA ,Piece pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
    this.pieceA = pieceA;
    this.pieceB = pieceB;
    etat = Etat.FERME;
    this.serrure = serrure;
  }

  public Etat getEtat(){
    return etat;
  }

  public Piece getPieceAutreCote(Piece piece){
    if (piece.equals(pieceA)){
      return pieceB;
    }
    else{
      return pieceA;
    }
  }

  public void activer() throws ActivationImpossibleException{
    if (etat.equals(Etat.FERME)){
      etat = Etat.OUVERT;
    }
    if (etat.equals(Etat.OUVERT)){
      etat = Etat.FERME;
    }
  }

  public boolean activableAvec(Objet obj){
    return (((obj instanceof PiedDeBiche)&&(etat.equals(Etat.FERME)||etat.equals(Etat.VERROUILLE)))||(serrure.activableAvec(obj)&&(etat.equals(Etat.VERROUILLE)||etat.equals(Etat.OUVERT))));
  }

  public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException, ActivationImpossibleException{
    if (activableAvec(obj)){
      if (obj instanceof PiedDeBiche){
        etat = Etat.CASSE;
      }
      else{
        if (etat.equals(Etat.VERROUILLE)){
          etat = Etat.DEVERROUILLE;
          serrure.activerAvec(obj);
        }
        else{
          etat = Etat.VERROUILLE;
          serrure.activerAvec(obj);
        }
      }
    }
  }

  public Serrure getSerrure(){
    return serrure;
  }

  public String toString(){
    return (this.getNom());
  }
}
