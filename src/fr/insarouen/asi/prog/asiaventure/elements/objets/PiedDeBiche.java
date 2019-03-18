package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;


/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

public class PiedDeBiche extends Objet{

  /**
     * Constructeur de PiedDeBiche.
     *
     * @param nvNom Le nom du"PiedDeBiche".
     * @param nvMonde "Monde" du"PiedDeBiche".
     */
  public PiedDeBiche(String nvNom, Monde nvMonde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nvNom,nvMonde);
  }

  /**
	 * @return possibilité de déplacement du PiedDeBiche.
	 */
  public boolean estDeplacable(){
    return true;
  }

}
