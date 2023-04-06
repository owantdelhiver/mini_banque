package models;

import java.util.Scanner;

public class BanqueInteraction {
    private Banque banque;
    private Scanner scanner;

    public BanqueInteraction() {
        this.banque = new Banque("THE TOTO BANK");
        this.scanner  = new Scanner(System.in);
    }
    public void displayMenuPrincipal() {
        String[] menu = new String[4];
        menu[0] = "Quitter";
        menu[1] = "Ajouter un client";
        menu[2] = "Effectuer une opération client";
        menu[3] = "Afficher un bilan général";

        System.out.println("--- " + this.banque.getName() + " ---");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + "- " + menu[i]);
        }

        System.out.print("- ");
        int choix = this.scanner.nextInt();

        switch (choix) {
            case 0 -> System.out.println("bisous de moi !!! <3");
            case 1 -> ajouterClient();
            case 2 -> choixClient();
            case 3 -> displayBilanAllClient();
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
    private void displayBilanAllClient() {
        System.out.println("--- Bilan général ---");
        for(int i = 0; i < this.banque.getNbrClient(); i++) {
            System.out.println(this.banque.getClients()[i].getNom() + " a un solde de " + this.banque.getClients()[i].getSolde());
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
    private void interactionClient(Client client) {
        System.out.println("--- Compte de " + client.getNom() + " ---");
        String[] menu = new String[3];
        menu[0] = "Quitter";
        menu[1] = "Afficher un bilan";
        menu[2] = "Choisir un compte";

        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + " - " + menu[i]);
        }

        System.out.print("- ");
        int choix = this.scanner.nextInt();

        switch (choix) {
            case 0 -> displayMenuPrincipal();
            case 1 -> {
                displayBilanClient(client);
                interactionClient(client);
            }
            case 2 -> choixCompte();
            default -> interactionClient(client);
        }
    }

    private void choixCompte() {

    }
    private void displayBilanClient(Client client) {
        System.out.println("--- Bilan de " + client.getNom() + " ---");
        for (int i = 0; i < client.getNbrCompte(); i++) {
            System.out.println(client.getComptes()[i].getNumero() + " : " + client.getComptes()[i].getSolde());
        }
    }
}