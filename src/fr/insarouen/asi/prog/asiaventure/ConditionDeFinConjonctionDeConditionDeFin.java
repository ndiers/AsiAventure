package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.ConditionDeFin;
import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.ConditionDeFinVivantMort;
import fr.insarouen.asi.prog.asiaventure.ConditionDeFinVivantPossedeObjets;
import fr.insarouen.asi.prog.asiaventure.ConditionDeFinVivantDansPiece;
import java.util.*;


public class ConditionDeFinConjonctionDeConditionDeFin extends ConditionDeFin{

  private Set<ConditionDeFin> conditions;

  public ConditionDeFinConjonctionDeConditionDeFin(EtatDuJeu etatDuJeu, ConditionDeFin... cfs){
    super(etatDuJeu);
    conditions = new HashSet<ConditionDeFin>();
    for(ConditionDeFin c : cfs){
      this.conditions.add(c);
    }
  }

  public EtatDuJeu verifierCondition(){
    EtatDuJeu varEtat = getEtatConditionVerifiee();
    for (ConditionDeFin c : conditions){
      if(c.verifierCondition().equals(EtatDuJeu.ENCOURS)){
        varEtat = EtatDuJeu.ENCOURS;
      }
    }
    return(varEtat);
  }
}
