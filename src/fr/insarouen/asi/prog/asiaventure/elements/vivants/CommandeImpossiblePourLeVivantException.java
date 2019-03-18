package fr.insarouen.asi.prog.asiaventure.elements.vivants;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

import fr.insarouen.asi.prog.asiaventure.elements.vivants.VivantException;

public class CommandeImpossiblePourLeVivantException extends VivantException{

/**
 * Constructeur de CommandeImpossiblePourLeVivantException.
 *
 * @param msg Message d'erreur.
 */

  public CommandeImpossiblePourLeVivantException(String msg){
    super(msg);
  }

/**
 * Constructeur de CommandeImpossiblePourLeVivantException.
 */

  public CommandeImpossiblePourLeVivantException(){
  }
}
