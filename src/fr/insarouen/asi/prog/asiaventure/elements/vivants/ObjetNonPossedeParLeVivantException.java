package fr.insarouen.asi.prog.asiaventure.elements.vivants;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

import fr.insarouen.asi.prog.asiaventure.elements.vivants.VivantException;

public class ObjetNonPossedeParLeVivantException extends VivantException{

/**
 * Constructeur de ObjetNonPossedeParLeVivantException.
 *
 * @param msg Message d'erreur.
 */

  public ObjetNonPossedeParLeVivantException(String msg){
    super(msg);
  }

/**
 * Constructeur de ObjetNonPossedeParLeVivantException.
 */

  public ObjetNonPossedeParLeVivantException(){
  }
}
