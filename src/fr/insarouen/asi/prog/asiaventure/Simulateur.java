package fr.insarouen.asi.prog.asiaventure;

import java.io.*;
import java.util.*;
import java.lang.*;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.elements.Executable;
import fr.insarouen.asi.prog.asiaventure.ConditionDeFin;
import fr.insarouen.asi.prog.asiaventure.ConditionDeFinVivantDansPiece;
import fr.insarouen.asi.prog.asiaventure.ConditionDeFinVivantMort;
import fr.insarouen.asi.prog.asiaventure.ConditionDeFinVivantPossedeObjets;
import fr.insarouen.asi.prog.asiaventure.ConditionDeFinVivantDansPieceEtPossedeObjetsAvecConjonction;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.JoueurHumain;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;





public class Simulateur{

  private Monde monde;
  private EtatDuJeu etat;
  private List<ConditionDeFin> conditions;

  public Simulateur(Monde monde){
    this.monde=monde;
    etat = EtatDuJeu.ENCOURS;
    conditions = new LinkedList<ConditionDeFin>();
  }

  public Simulateur(ObjectInputStream ois) throws IOException, ClassNotFoundException{
    monde = (Monde) ois.readObject();
  }

  public Simulateur(Reader reader) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException{
    StreamTokenizer strTok = new StreamTokenizer(reader);
    strTok.eolIsSignificant(false);
    strTok.quoteChar(Character.getNumericValue('"'));
    String str;
    while (!((strTok.nextToken())==strTok.TT_EOF)){

      switch(strTok.sval){
        case "Monde": iniMonde(strTok);
        break;
        case "Piece": iniPiece(strTok);
        break;
        case "PorteSerrure": iniPorteSerrure(strTok);
        break;
        case "Porte": iniPorte(strTok);
        break;
        case "Clef": iniClef(strTok);
        break;
        case "JoueurHumain": iniJoueurHumain(strTok);
        break;
        case "ConditionDeFinVivantDansPiece": iniFinVivantDansPiece(strTok);
        break;
        case "ConditionDeFinVivantMort": iniFinVivantMort(strTok);
        break;
        case "ConditionDeFinVivantPossedeObjets": iniFinVivantPossedeObjets(strTok);
        break;
        case "ConditionDeFinVivantDansPieceEtPossedeObjets": iniFinVivantDansPieceEtPossedeObjets(strTok);
        break;
      }
      System.out.println(monde);
    }
    reader.close();
  }

  private void iniMonde(StreamTokenizer strTok) throws IOException{
    strTok.nextToken();
    monde = new Monde(strTok.sval);
  }

  private void iniPiece(StreamTokenizer strTok) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException{
    strTok.nextToken();
    Piece piece = new Piece(strTok.sval, monde);
  }

  private void iniPorteSerrure(StreamTokenizer strTok) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException{
    strTok.nextToken();
    String nom = strTok.sval;
    strTok.nextToken();
    String nomPiece1 = strTok.sval;
    Piece piece1 = (Piece) monde.getEntite(nomPiece1);
    strTok.nextToken();
    String nomPiece2 = strTok.sval;
    Piece piece2 = (Piece) monde.getEntite(nomPiece2);
    Serrure serrure = new Serrure(monde);
    Porte porte = new Porte(nom, monde, serrure, piece1, piece2);
  }

  private void iniPorte(StreamTokenizer strTok) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException{
    strTok.nextToken();
    String nom = strTok.sval;
    strTok.nextToken();
    String nomPiece1 = strTok.sval;
    Piece piece1 = (Piece) monde.getEntite(nomPiece1);
    strTok.nextToken();
    String nomPiece2 = strTok.sval;
    Piece piece2 = (Piece) monde.getEntite(nomPiece2);
    Porte porte = new Porte(nom, monde, piece1, piece2);
  }

  private void iniClef(StreamTokenizer strTok) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException{
    strTok.nextToken();
    String nomPorte = strTok.sval;
    Porte porte = (Porte) monde.getEntite(nomPorte);
    strTok.nextToken();
    String nomPiece = strTok.sval;
    Piece piece = (Piece) monde.getEntite(nomPiece);
    piece.deposer(porte.getSerrure().creerClef());
  }

  private void iniJoueurHumain(StreamTokenizer strTok) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException{
    strTok.nextToken();
    String nom = strTok.sval;
    strTok.nextToken();
    int ptVie= (int)strTok.nval;
    strTok.nextToken();
    int ptForce= (int)strTok.nval;
    strTok.nextToken();
    String nomPiece = strTok.sval;
    Piece piece = (Piece) monde.getEntite(nomPiece);
    JoueurHumain joueurHumain= new JoueurHumain(nom,monde,ptVie,ptForce,piece);
  }

  private void iniFinVivantDansPiece(StreamTokenizer strTok) throws IOException{
//    strTok.eolIsSignificant(true);
    strTok.nextToken();
    EtatDuJeu etatCondition = stringToEtatDuJeu(strTok.sval);
    strTok.nextToken();
    String nomVivant = strTok.sval;
    Vivant vivant = (Vivant) monde.getEntite(nomVivant);
    strTok.nextToken();
    String nomPiece = strTok.sval;
    Piece piece = (Piece) monde.getEntite(nomPiece);
    conditions.add(new ConditionDeFinVivantDansPiece(etatCondition,vivant,piece));
//    strTok.nextToken();
  }

  private void iniFinVivantMort(StreamTokenizer strTok) throws IOException{
//    strTok.eolIsSignificant(true);
    strTok.nextToken();
    EtatDuJeu etatCondition = stringToEtatDuJeu(strTok.sval);
    strTok.nextToken();
    String nomVivant = strTok.sval;
    Vivant vivant = (Vivant) monde.getEntite(nomVivant);
    conditions.add(new ConditionDeFinVivantMort(etatCondition,vivant));
//    strTok.nextToken();
  }

  private void iniFinVivantPossedeObjets(StreamTokenizer strTok) throws IOException{
    strTok.eolIsSignificant(true);
    strTok.nextToken();
    EtatDuJeu etatCondition = stringToEtatDuJeu(strTok.sval);
    strTok.nextToken();
    String nomVivant = strTok.sval;
    Vivant vivant = (Vivant) monde.getEntite(nomVivant);
    Set<Objet> objets = new HashSet<Objet>();
    while(strTok.nextToken()==strTok.TT_EOL){
      objets.add((Objet) monde.getEntite(strTok.sval));
    }
    Objet[] objets2 = (Objet[])objets.toArray();
    conditions.add(new ConditionDeFinVivantPossedeObjets(etatCondition,vivant,objets2));
  }

  private void iniFinVivantDansPieceEtPossedeObjets(StreamTokenizer strTok) throws IOException{
    strTok.eolIsSignificant(true);
    strTok.nextToken();
    EtatDuJeu etatCondition = stringToEtatDuJeu(strTok.sval);
    strTok.nextToken();
    String nomVivant = strTok.sval;
    Vivant vivant = (Vivant) monde.getEntite(nomVivant);
    strTok.nextToken();
    String nomPiece = strTok.sval;
    Piece piece = (Piece) monde.getEntite(nomPiece);
    Set<Objet> objets = new HashSet<Objet>();
    while(strTok.nextToken()==strTok.TT_EOL){
      objets.add((Objet) monde.getEntite(strTok.sval));
    }
    Objet[] objets2 = (Objet[])objets.toArray();
    conditions.add(new ConditionDeFinVivantDansPieceEtPossedeObjetsAvecConjonction(etatCondition,vivant,piece,objets2));
  }


  public void enregistrer(ObjectOutputStream oos) throws IOException{
    oos.writeObject(monde);
  }

  private EtatDuJeu stringToEtatDuJeu(String nomEtatDuJeu){
    if (nomEtatDuJeu=="SUCCES"){
      return(EtatDuJeu.SUCCES);
    }
    else{
      return(EtatDuJeu.ECHEC);
    }
  }

  public EtatDuJeu executerUnTours() throws java.lang.Throwable{
    Set<Executable> executables = monde.getExecutables();
    Set<JoueurHumain> joueurHumains = new HashSet<JoueurHumain>();
    for (Executable exe:executables) {
      if (exe instanceof JoueurHumain){
        joueurHumains.add((JoueurHumain)exe);
      }
    }
    for (JoueurHumain jh:joueurHumains) {
      System.out.println(jh.toString());
      Scanner sc = new Scanner(System.in);
      jh.setOrdre(sc.nextLine());
    }
    for (Executable exe:executables) {
      exe.executer();
    }
    for (ConditionDeFin cdf:conditions) {
      if(cdf.verifierCondition()==EtatDuJeu.ECHEC){
        etat = EtatDuJeu.ECHEC;
      }
      else{
        if(cdf.verifierCondition()==EtatDuJeu.SUCCES){
          etat = EtatDuJeu.SUCCES;
        }
      }
    }
    return (etat);
  }

  public EtatDuJeu executerJusquALaFin() throws java.lang.Throwable{
    while (etat==EtatDuJeu.ENCOURS){
      etat=executerUnTours();
    }
    return etat;
  }
}
