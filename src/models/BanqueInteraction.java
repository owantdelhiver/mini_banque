package models;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BanqueInteraction {
    private Banque banque;

    public String[][] interactionPrincipal;
    public String[][] interactionClient;

    public BanqueInteraction() {
        this.banque = new Banque("ma banque");
        //Interaction Principale
        this.interactionPrincipal = new String[1][2];

        this.interactionPrincipal[0][0] = "Ajouter un client";
        this.interactionPrincipal[0][1] = "ajouterClient";


        //Client
        this.interactionClient = new String[1][2];
        this.interactionClient[0][0] = "Afficher le bilan";
        this.interactionClient[0][1] = "bilanClient";
    }
    public void displayMenu(String[][] interactions) {
        this.callMethod(this.banque,"bilanClient");
        this.callMethod(this.banque,"ajouterClient");
    }

    public void callMethod(Object object, String method) {
        try {
            object.getClass().getMethod(method).invoke(object);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public void ajouterClient() {
        System.out.println("ajouter un client (banque interaction)");
//        System.out.println("quel est le nom du client");
//        String name = "toto";
//        this.banque.ajouterClient(new Client(name));
    }
}
