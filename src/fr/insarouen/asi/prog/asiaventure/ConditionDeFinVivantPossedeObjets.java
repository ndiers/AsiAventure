package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.ConditionDeFin;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import java.util.*;

public class ConditionDeFinVivantPossedeObjets extends ConditionDeFin{

private Vivant vivant;
private Set<Objet> objets;

  public ConditionDeFinVivantPossedeObjets(EtatDuJeu etatConditionVerifiee, Vivant vivant, Objet[] objets){
    super(etatConditionVerifiee);
    this.vivant=vivant;
    this.objets = new HashSet<Objet>();
    for(Objet o : objets){
      this.objets.add(o);
    }
  }

  public EtatDuJeu verifierCondition(){
    EtatDuJeu varEtat = getEtatConditionVerifiee();
    for (Objet o : objets){
      if(!(vivant.possede(o))){
        varEtat = EtatDuJeu.ENCOURS;
      }
    }
    return varEtat;
  }

}
