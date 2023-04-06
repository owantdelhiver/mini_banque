package models;

public class Compte {
    private String numero;
    private float solde;

    public Compte(String numero, float solde) {
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

    public void virement(float value, Compte compte) {
        this.retrait(value);
        compte.depot(value);
    }

    public String getNumero() {
        return numero;
    }
}
