package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.ConditionDeFin;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;

public class ConditionDeFinVivantDansPiece extends ConditionDeFin{

private Vivant vivant;
private Piece piece;

  public ConditionDeFinVivantDansPiece(EtatDuJeu etatConditionVerifiee, Vivant vivant, Piece piece){
    super(etatConditionVerifiee);
    this.vivant=vivant;
    this.piece=piece;
  }

  public EtatDuJeu verifierCondition(){
    if (vivant.getPiece().equals(piece)) {
      return getEtatConditionVerifiee();
    }
    else {
      return EtatDuJeu.ENCOURS;
    }
  }

}
