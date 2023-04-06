package models;

public class Compte {
    private int numero;
    private float solde;

    public Compte(int numero, float solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public void depot(float value) {
        this.solde += value;
    }

    public void retrait(float value) {
        this.solde -= value;
    }

    public float getSolde() {
        return solde;
    }

    public void afficherSolde() {
        System.out.println(this.solde);
    }

    public void virement(float value, Compte compte) {
        this.retrait(value);
        compte.depot(value);
    }

    public int getNumero() {
        return numero;
    }
}
