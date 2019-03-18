package fr.insarouen.asi.prog.asiaventure.elements.structure;

import java.util.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

public class Piece extends ElementStructurel{

  /**
	 * Tableau contenant l'ensemble des Objets présents dans la Piece.
	 */
  private Map<String, Objet> objetsPresents;

  /**
	 * Tableau contenant l'ensemble des Vivants présents dans la Piece.
	 */
  private Map<String, Vivant> vivantsPresents;

  private Map<String, Porte> portesPresents;

  /**
     * Constructeur de Piece.
     *
     * @param nvNom Le nom de la "Piece".
     * @param nvMonde "Monde" de la "Piece".
	*
	* @throws NomDEntiteDejaUtiliseDansLeMondeException
	* Si le nom de l'entite est deja present dans le monde.
     */
  public Piece (String nvNom, Monde nvMonde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nvNom,nvMonde);
    objetsPresents=new HashMap<String, Objet>();
    vivantsPresents=new HashMap<String, Vivant>();
    portesPresents=new HashMap<String, Porte>();
  }

  /**
	 * Permet d'ajouter un Objet dans la Piece.
	 *
	 * @param obj Objet a deposer.
	 */
  public void deposer(Objet obj){
    objetsPresents.put(obj.getNom(),obj);
  }

  /**
	 * Permet de retirer grâce a son nom, un Objet de la Piece s'il est déplacable.
	 *
	 * @param nomObj Nom de l'Objet a retirer.
	 * @return Objet retiré.
	 *
	 * @throws ObjetAbsentDeLaPieceException
	 * Si l'objet a retirer n'est pas present dans la piece.
	 *
	 * @throws ObjetNonDeplacableException
	 * Si l'objet a retirer n'est pas deplacable.
	 */
  public Objet retirer(String nomObj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
    if (!(contientObjet(nomObj))){
      throw new ObjetAbsentDeLaPieceException("l'objet "+nomObj+" est absent de la pièce");
    }
    Objet res = objetsPresents.get(nomObj);
    if (!(res.estDeplacable())){
      throw new ObjetNonDeplacableException("l'objet "+nomObj+" n'est pas déplacable");
    }
    return objetsPresents.remove(nomObj);
  }

  /**
	 * Permet de retirer un Objet de la Piece s'il est déplacable.
	 *
	 * @param obj Objet a retirer.
	 * @return Objet retiré.
	 *
	 * @throws ObjetAbsentDeLaPieceException
	 * Si l'objet � retirer n'est pas pr�sent dans la piece.
	 *
	 * @throws ObjetNonDeplacableException
	 * Si l'objet � retirer n'est pas d�placable.
	 */
  public Objet retirer(Objet obj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
    return retirer(obj.getNom());
  }

  /**
	 * Permet de savoir si une String (représentant un Objet) passé en paramètre est contenu dans la Piece.
	 *
	 * @param nomObj Nom de l'Objet a tester.
	 * @return L'objet est contenu ou non.
	 */
  public boolean contientObjet(String nomObj){
    return objetsPresents.containsKey(nomObj);
  }

  /**
	 * Permet de savoir si l'Objet passé en paramètre est contenu dans la Piece.
	 *
	 * @param obj Objet a tester.
	 * @return L'objet est contenu ou non.
	 */
  public boolean contientObjet(Objet obj){
    return contientObjet(obj.getNom());
  }

  /**
	 * Permet de récupérer le tableau des Objets présents
	 */
  public Map<String, Objet> getObjets(){
    return objetsPresents;
  }

  public String toString(){
    String res = this.getNom();
    for (String str:objetsPresents.keySet()) {
      res=String.format("%s,%s",res,str);
    }
    for (String str:vivantsPresents.keySet()) {
      res=String.format("%s,%s",res,str);
    }
    return res;
  }

  /**
	 * Permet de savoir si une String (représentant un Vivant) passé en paramètre est contenu dans la Piece.
	 *
	 * @param nomVivant Nom du Vivant a tester.
	 * @return Le Vivant est contenu ou non.
	 */
  public boolean contientVivant(String nomVivant){
    return vivantsPresents.containsKey(nomVivant);
  }

  /**
	 * Permet de savoir si le Vivant passé en paramètre est contenu dans la Piece.
	 *
	 * @param vivant Vivant a tester.
	 * @return Le Vivant est contenu ou non.
	 */
  public boolean contientVivant(Vivant vivant){
    return contientVivant(vivant.getNom());
  }

  /**
	 * Permet d'ajouter un Vivant dans la Piece.
	 *
	 * @param vivant Vivant a ajouter.
	 */
  public void entrer(Vivant vivant){    vivantsPresents.put(vivant.getNom(),vivant);
  }

  /**
	 * Permet de retirer grâce a son nom, un Vivant de la Piece.
	 *
	 * @param nomVivant Nom du Vivant à retirer.
	 * @return Vivant retiré.
	 *
	 * @throws VivantAbsentDeLaPieceException
	 * Si le vivant � retirer n'est pas pr�sent dans la piece.
	 */
  public Vivant sortir(String nomVivant) throws VivantAbsentDeLaPieceException{
    if (!(contientVivant(nomVivant))){
      throw new VivantAbsentDeLaPieceException("le vivant "+nomVivant+" est absent de la pièce");
    }
    return vivantsPresents.remove(nomVivant);
  }

  /**
	 * Permet de retirer un Vivant de la Piece.
	 *
	 * @param vivant Vivant à retirer.
	 * @return Vivant retiré.
	 *
	 * @throws VivantAbsentDeLaPieceException
	 * Si le vivant � retirer n'est pas pr�sent dans la 	 	 * piece.
	 */
  public Vivant sortir(Vivant vivant) throws VivantAbsentDeLaPieceException{
    return sortir(vivant.getNom());
  }

  protected void addPorte(Porte porte){
    portesPresents.put(porte.getNom(),porte);
  }

  public boolean aLaPorte(String nomPorte){
    return portesPresents.containsKey(nomPorte);
  }

  public boolean aLaPorte(Porte porte){
    return aLaPorte(porte.getNom());
  }

  public Porte getPorte(String nomPorte){
    return portesPresents.get(nomPorte);
  }

  public Map<String, Porte> getPortes(){
    return portesPresents;
  }
}
