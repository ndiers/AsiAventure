package fr.insarouen.asi.prog.asiaventure.elements.structure;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;

public class VivantAbsentDeLaPieceException extends PieceException{

/**
 * Constructeur de VivantAbsentDeLaPieceException.
 *
 * @param msg Message d'erreur.
 */

  public VivantAbsentDeLaPieceException(String msg){
    super(msg);
  }

/**
 * Constructeur de VivantAbsentDeLaPieceException.
 */

  public VivantAbsentDeLaPieceException(){
  }
}
