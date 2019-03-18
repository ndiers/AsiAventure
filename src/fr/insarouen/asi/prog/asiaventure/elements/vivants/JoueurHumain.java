package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import java.lang.reflect.*;
import java.util.*;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.Executable;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.CommandeImpossiblePourLeVivantException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;





public class JoueurHumain extends Vivant implements Executable{

  private String ordre;

  public JoueurHumain (String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... objets) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde,pointVie,pointForce,piece,objets);
    ordre=null;
  }

  private String obtenirCommande(StringTokenizer strTok){
      String action = strTok.nextToken();
      return "commande"+action;
  }

  private String[] obtenirArguments(StringTokenizer strTok){
    String[] args = null;
    while(strTok.hasMoreTokens()){
      String[] args2 = new String[args.length+1];
      for (int i=0; i<args.length; i++){
        args2[i] = args[i];
      }
      args2[args2.length] = strTok.nextToken();
      args = args2;
    }
    return args;
  }

  private Class[] obtenirClass(String[] args){
    Class[] typeArgs = null;
    for (int j=0; j<args.length; j++){
      Class[] typeArgs2 = new Class[typeArgs.length+1];
      for (int i=0; i<typeArgs.length; i++){
        typeArgs2[i] = typeArgs[i];
      }
      typeArgs2[typeArgs2.length] = String.class;
      typeArgs = typeArgs2;
    }
    return typeArgs;
  }

  public void executer() throws CommandeImpossiblePourLeVivantException{
    StringTokenizer tokOrdre = new StringTokenizer(ordre);
    String commande = obtenirCommande(tokOrdre);
    String[] args = obtenirArguments(tokOrdre);
    Class[] typeArgs = obtenirClass(args);
    Object[] args2 = (Object[]) args;
    try{
      Method meth = this.getClass().getDeclaredMethod(commande, typeArgs);
      meth.invoke(this, args2);
    }
    catch(NoSuchMethodException e1){
        throw new CommandeImpossiblePourLeVivantException("La commande ("+commande+") n'existe pas pour le vivant");
    }
    catch(InvocationTargetException e2){
        throw new CommandeImpossiblePourLeVivantException("La commande ("+commande+") ne fonctionne pas pour le vivant : "+e2.getTargetException().getMessage());
    }
    catch(IllegalAccessException e3){
      System.err.println("Ne doit jamais arriver");
      System.exit(1);
    }
  }

  public void setOrdre(String nvOrdre){
    ordre=nvOrdre;
  }

  private void commandePrendre(String nomObjet) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
    prendre(nomObjet);
  }

  private void commandePoser(String nomObjet) throws ObjetNonPossedeParLeVivantException{
    deposer(nomObjet);
  }

  private void commandeFranchir(String nomPorte) throws PorteFermeException, PorteInexistanteDansLaPieceException{
    franchir(nomPorte);
  }

  private void commandeOuvrirPorte(String nomPorte) throws ActivationException, PorteInexistanteDansLaPieceException{
    this.getPiece().getPorte(nomPorte).activer();
  }

  private void commandeOuvrirPorte(String nomPorte, String nomObjet) throws ActivationException, PorteInexistanteDansLaPieceException,ObjetNonPossedeParLeVivantException {
    this.getPiece().getPorte(nomPorte).activerAvec(getObjet(nomObjet));
  }
}
