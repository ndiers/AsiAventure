package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

public abstract class Entite {

  /**
	 * Nom de l'Entite.
	 */
  private String nom;

  /**
	 * Monde dans lequel se trouve l'Entite.
	 */
  private Monde monde;

  /**
	 * Construteur de Entite.
	 *
	 * @param nvNom Nom de l'Entite.
	 * @param nvMonde Monde dans lequel se situe l'Entite.
	 * 
	 * @throws NomDEntiteDejaUtiliseDansLeMondeException
	 * Si le nom de l'entite est deja present dans le monde. 	 */
  public Entite (String nvNom, Monde nvMonde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    nom=nvNom;
    monde =nvMonde;
    try{
      monde.ajouter(this);
    }
    catch(EntiteDejaDansUnAutreMondeException e){
      System.err.println("Ne doit jamais arriver");
      System.exit(1);
    }
  }

  /**
	 * Permet de récupérer le nom de l'Entite
	 */
  public String getNom() {
    return nom;
  }

  /**
	 * Permet de récupérer le Monde de l'Entite
	 */
  public Monde getMonde(){
    return monde;
  }

  public String toString() {
    return(nom+','+monde.getNom());
  }


  public boolean equals(Object o) {
    if (o.getClass()==this.getClass()) {
      Entite oBis = (Entite)o;
      return(this.hashCode()==oBis.hashCode() && (this.getMonde().equals(oBis.getMonde())));
    }
    else {
      return false;
    }
  }

  public int hashCode() {
    return nom.hashCode()+7*monde.hashCode();
  }
}
