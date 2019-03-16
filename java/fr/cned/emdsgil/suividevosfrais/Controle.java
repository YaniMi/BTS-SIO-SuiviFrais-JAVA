package fr.cned.emdsgil.suividevosfrais;


import org.json.JSONArray;

import java.util.ArrayList;

public final class Controle {
 private static Controle instance = null;
 private FraisMois profilfrais;
 private static AccesDistant accesDistant;



private Controle() {
 super();
 }



public static final Controle getInstance() {
   if (Controle.instance == null) {
    Controle.instance = new Controle();
    accesDistant = new AccesDistant();
    accesDistant.envoi("dernier", new JSONArray());
 }
 return Controle.instance;
 }


 /**
 * création de la liste de frais
 * @param mois
 * @param annee
 * @param etape
 * @param km
 * @param nuitee
 * @param repas
 * @param lesFraisHf
 */
public void creerProfil(Integer mois, Integer annee, Integer etape, Integer km, Integer nuitee, Integer repas,  ArrayList<FraisHf> lesFraisHf){
 profilfrais = new FraisMois(mois, annee);
 accesDistant.envoi("enreg", profilfrais.convertToJSONArray());

 }
 }

