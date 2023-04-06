package models;

public class Client {
    private String nom;
    public Compte[] comptes;
    private int nbrCompte;
    private int compteCourant;

    public Client(String nom) {
        this.nom = nom;
        this.comptes = new Compte[100];
        this.nbrCompte = -1;
        this.compteCourant = 0;
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

    public void renflouer() {
        int compteur = 1;
        while (this.comptes[this.compteCourant].getSolde() < 0) {
            if(this.comptes[compteur].getSolde() < Math.abs(this.comptes[this.compteCourant].getSolde())) {

            } else {
                this.comptes[compteur].virement(Math.abs(this.comptes[this.compteCourant].getSolde()), this.comptes[this.compteCourant]);
            }
        }
    }
}
