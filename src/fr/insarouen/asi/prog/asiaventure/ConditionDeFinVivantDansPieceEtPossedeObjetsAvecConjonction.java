package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.ConditionDeFinConjonctionDeConditionDeFin;
import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.ConditionDeFinVivantPossedeObjets;
import fr.insarouen.asi.prog.asiaventure.ConditionDeFinVivantDansPiece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;



public class ConditionDeFinVivantDansPieceEtPossedeObjetsAvecConjonction extends ConditionDeFinConjonctionDeConditionDeFin{

  public ConditionDeFinVivantDansPieceEtPossedeObjetsAvecConjonction(EtatDuJeu etatConditionVerifiee, Vivant vivant, Piece piece, Objet... objets){
    super (etatConditionVerifiee, new ConditionDeFinVivantDansPiece(etatConditionVerifiee, vivant, piece), new ConditionDeFinVivantPossedeObjets(etatConditionVerifiee, vivant, objets));
  }
}
