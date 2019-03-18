package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

public abstract class Objet extends Entite {

  /**
     * Constructeur de Objet.
     *
     * @param nvNom Le nom de l'"Objet".
     * @param nvMonde "Monde" de l'"Objet".
	* @throws NomDEntiteDejaUtiliseDansLeMondeException
	* Si le nom de l'entite est deja present dans le monde.
     */
  public Objet(String nvNom, Monde nvMonde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nvNom,nvMonde);
  }

  /**
	 * @return possibilité de déplacement de l'Objet.
	 */
  public abstract boolean estDeplacable();

}
