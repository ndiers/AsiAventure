package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.Etat;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;






public class Serrure extends Objet implements Activable{

  private static int compteur = 0;
  private Clef clef;
  private Etat etat;

  public Serrure(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
    clef=null;
    etat=Etat.VERROUILLE;
  }

  public Serrure(Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    this(Serrure.creerNom("Serrure", monde),monde);
  }


  public final Clef creerClef(){
    try{
      if (clef==null){
        clef= new Clef (getNom()+creerNom("Clef", getMonde()),this.getMonde());
      }
      else{
        clef = null;
      }
    }
    catch(NomDEntiteDejaUtiliseDansLeMondeException e){
      System.err.println("Ne doit jamais arriver");
      System.exit(1);
    }
    return clef;
  }

  private void inverserEtat(){
    if (etat.equals(Etat.VERROUILLE)){
      etat = Etat.DEVERROUILLE;
    }
    else{
      etat = Etat.VERROUILLE;
    }
  }

  public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException{
    if(activableAvec(obj)){
      inverserEtat();
    }
    else{
      throw new ActivationImpossibleAvecObjetException(obj.getNom()+" n'est pas la clef.");
    }
  }

  public boolean estDeplacable(){
    return false;
  }

  public boolean activableAvec(Objet obj){
    return clef.equals(obj);
  }

  public void activer() throws ActivationImpossibleException{
    throw new ActivationImpossibleException(getNom()+" ne peut pas être activée sans objet.");
  }

  public Etat getEtat(){
    return etat;
  }

  private static String creerNom(String type, Monde monde){
    String nvNom=type+compteur;
    while (!(monde.getEntite(nvNom)==null)){
      compteur+=1;
      nvNom = type+compteur;
    }
    compteur+=1;
    return nvNom;
  }

}
