package fr.insarouen.asi.prog.asiaventure;

import java.util.*;
import java.lang.*;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.Executable;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

public class Monde {

  /**
	 * Nom du Monde.
	 */
  private String nom;

  /**
	 * Entités contenues dans le Monde.
	 */
  private Map<String,Entite> entites;

  /**
	 * Constructeur de Monde.
	 *
	 * @param nvNom Nom du Monde.
	 */
  public Monde(String nvNom) {
    nom = nvNom;
    entites = new HashMap<String,Entite>();
  }

  /**
	 * Permet de récupérer le nom du Monde
	 */
  public String getNom() {
    return nom;
  }

  /**
	 * Permet de récupérer une Entité contenue dans le Monde depuis le nom de cette Entité.
	 *
	 * @param nomEntite Nom de l'Entité recherchée.
	 * @return Entité recherchée si trouvée, null si non.
	 */
  public Entite getEntite(String nomEntite) {
    return entites.get(nomEntite);
  }

  private boolean estPresentEntite(String nomEntite){
    return entites.containsKey(nomEntite);
  }

  /**
	 * Permet d'ajouter une Entité dans le Monde.
	 *
	 * @param entite Entite a ajouter.
	 *
	 * @throws NomDEntiteDejaUtiliseDansLeMondeException
	 * Si le nom de l'entite est deja present dans le monde. 	 *
	 * @throws EntiteDejaDansUnAutreMondeException
	 * Si l'entite est deja presente dans un autre monde.
	 */
  public void ajouter(Entite entite) throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException{
    if (estPresentEntite(entite.getNom())){
      throw new NomDEntiteDejaUtiliseDansLeMondeException("Nom d'objet ("+entite.getNom()+") deja present dans le monde");
    }
    if (!(this.equals(entite.getMonde()))){
      throw new EntiteDejaDansUnAutreMondeException("Objet deja present dans le monde "+entite.getMonde().getNom());
    }
    entites.put(entite.getNom(),entite);
  }

  public String toString(){
    String res = this.getNom();
    for (String str:entites.keySet()) {
      res=String.format("%s,%s",res,str);
    }
    return res;
  }

  public Set<Executable> getExecutables(){
    Set<Executable> executables = new HashSet<Executable>();
    Set<Entite> setEntites = (HashSet<Entite>)entites.values();
    for (Entite ent:setEntites) {
      if (ent instanceof Executable){
        executables.add((Executable)ent);
      }
    }
    return(executables);
  }
}
