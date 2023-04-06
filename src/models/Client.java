package models;

import java.util.UUID;

public class Client {
    private String nom;
    public Compte[] comptes;
    private int nbrCompte;

    public Client(String nom) {
        this.nom = nom;
        this.comptes = new Compte[100];
        this.nbrCompte = -1;
        this.ajouterCompte(new Compte(UUID.randomUUID().toString(), 150f));
    }

    public String getNom() {
        return this.nom;
    }

    public void ajouterCompte(Compte compte) {
        this.nbrCompte+=1;
        this.comptes[nbrCompte] = compte;
    }

    public float getSolde() {
        float value = 0;
        for (int i = 0; i <= nbrCompte; i++) {
            value += this.comptes[i].getSolde();
        }
        return value;
    }

    public void afficherSolde() {
        System.out.println("Solde total : " + this.getSolde());
    }

    //TODO renflour
//    public void renflouer() {
//        int compteur = 1;
//        while (this.comptes[0].getSolde() < 0) {
//            if(this.comptes[compteur].getSolde() < Math.abs(this.comptes[0].getSolde())) {
//
//            } else {
//                this.comptes[compteur].virement(Math.abs(this.comptes[0].getSolde()), this.comptes[0]);
//            }
//        }
//    }
}
