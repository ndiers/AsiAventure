package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import java.lang.String;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import java.util.Arrays;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.Etat;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

public class Monstre extends Vivant{

  public Monstre(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... objets)throws NomDEntiteDejaUtiliseDansLeMondeException,EntiteDejaDansUnAutreMondeException{
    super(nom,monde,pointVie,pointForce,piece,objets);
  }

public void executer()throws PorteFermeException,PorteInexistanteDansLaPieceException, VivantAbsentDeLaPieceException,ObjetAbsentDeLaPieceException,ObjetNonPossedeParLeVivantException, ObjetNonDeplacableException{
  franchirPorte();
  perdsPointsDeVie();
  ramasserDeposer();
}

private void perdsPointsDeVie(){
  setPointsDeVie(getPointVie()-1);
}

public void franchirPorte()throws PorteFermeException,PorteInexistanteDansLaPieceException, VivantAbsentDeLaPieceException{
  ArrayList<Porte> portesFranchissables = new ArrayList<>();
  for(Porte p:getPiece().getPortes().values()){
    if ((p.getEtat()!=Etat.VERROUILLE)&&(p.getEtat()!=Etat.CASSE)){
      portesFranchissables.add(p);
    }
  }

  Iterator<Porte> iteratorPorte=portesFranchissables.iterator();
  Porte porteAFranchir=null;
  int numeroPorte=0;
  if(!portesFranchissables.isEmpty()){
    numeroPorte = (int)(Math.random() * portesFranchissables.size());
  }
  for(int i=0;i<numeroPorte;i++){
      porteAFranchir=iteratorPorte.next();
  }
  franchir(porteAFranchir);
}

  private void ramasserDeposer() throws ObjetAbsentDeLaPieceException,ObjetNonPossedeParLeVivantException, ObjetNonDeplacableException {
	  Collection<Objet> temp=getObjets().values();
			for(Objet o : getPiece().getObjets().values()){
				this.prendre(o);
      }
			for(Objet o: temp){
			  this.deposer(o);
			}
	 }

}
