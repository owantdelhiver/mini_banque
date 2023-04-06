package models;

import java.util.Scanner;

public class BanqueInteraction {
    private Banque banque;
    private Scanner scanner;

    public BanqueInteraction() {
        this.banque = new Banque("Ma banque");
        this.scanner  = new Scanner(System.in);
    }
    public void displayMenuPrincipal() {
        String[] menu = new String[4];
        menu[0] = "Quitter";
        menu[1] = "Ajouter un client";
        menu[2] = "Effectuer une opération client";
        menu[3] = "Afficher un bilan général";

        System.out.println("--- Menu principale ---");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + "- " + menu[i]);
        }

        System.out.print("- ");
        String choix = this.scanner.next();

        switch (choix) {
            case "0" -> System.out.println("bisous");
            case "1" -> ajouterClient();
            case "2" -> choixClient();
            default -> displayMenuPrincipal();
        }

    }
    private void ajouterClient() {
        System.out.println("--- Ajout d'un nouveau client ---");
        System.out.println("Entrer son nom");
        System.out.print("- ");
        String name = this.scanner.next();
        this.banque.ajouterClient(new Client(name));
        displayMenuPrincipal();
    }
    private void interactionClient(Client client) {
        System.out.println("--- Compte de " + client.getNom() + " ---");
        String[] menu = new String[4];
        menu[0] = "Quitter";
        menu[1] = "Afficher un bilan";
        menu[2] = "Faire un depot";
        menu[3] = "Afficher un bilan général";

        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + " - " + menu[i]);
        }

        System.out.print("- ");
        String choix = this.scanner.next();

        switch (choix) {
            case "0" -> displayMenuPrincipal();
            default -> interactionClient(client);
        }
    }
    private void choixClient() {
        System.out.println("--- Choix du client ---");
        System.out.println("0 - Quitter");
        for (int i = 0; i < this.banque.getNbrClient(); i++) {
            System.out.println((i+1) + " - " + this.banque.getClients()[i].getNom());
        }
        int idClient = this.scanner.nextInt();

        if(idClient == 0) {
            displayMenuPrincipal();
        } else if (MyMath.isBetween(idClient, 1, this.banque.getNbrClient())) {
            interactionClient(this.banque.getClients()[idClient-1]);
        } else {
            choixClient();
        }
    }
    //TODO Return Account from client
    private void choixCompte(Client client) {

    }
}
