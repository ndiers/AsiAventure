package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

public class ElementStructurel extends Entite{

  /**
     * Constructeur de ElementStructurel.
     *
     * @param nvNom Le nom de l'"ElementStructurel".
     * @param nvMonde "Monde" de l'"ElementStructurel".
	*
	* @throws NomDEntiteDejaUtiliseDansLeMondeException
	* Si le nom de l'entite est deja present dans le monde.
     */
  public ElementStructurel (String nvNom, Monde nvMonde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nvNom,nvMonde);
  }
}
