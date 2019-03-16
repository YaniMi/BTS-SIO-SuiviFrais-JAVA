package fr.cned.emdsgil.suividevosfrais;


import android.util.Log;

import org.json.JSONArray;

public class AccesDistant implements AsyncResponse {
    private Controle controle;
    /**
     * Constructeur
     */

    //constante
    private static final String SERVERADDR = "http://192.168.1.36/Suividefrais/serveursuividefrais.php";

    /**
     * Constructeur
     */
    public AccesDistant(){
        controle = Controle.getInstance();
    }
    @Override
    /** retour serveur distant
     *
     */
    public void processFinish(String output) {
        Log.d("serveur", "*********" + output);
        //découpage du message recu
        String[] message = output.split("%");
        //dans message[0] : "enreg", "dernier", "Erreur"
        //dans message[1] : reste du message

        //s'il y a 2 cases
        if (message.length > 1) ;
        if (message[0].equals("enreg")) {
            Log.d("enreg", "*********" + message[1]);


        } else {
            if (message[0].equals("dernier")) {
                Log.d("dernier", "*********" + message[1]);

            } else {
                if (message[0].equals("Erreur !")) {
                    Log.d("Erreur", "*********" + message[1]);
                }
            }
        }
    }
    public void envoi(String operation, JSONArray lesDonneesJSON){
        AccesHTTP accesDonnees = new AccesHTTP();
        //lien de délégation
        accesDonnees.delegate = this;
        //ajout paramètres
        accesDonnees.addParam("operation", operation);
        accesDonnees.addParam("lesdonnées", lesDonneesJSON.toString());
        //appel au serveur
        accesDonnees.execute(SERVERADDR);

    }
}