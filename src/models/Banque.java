package models;

public class Banque {
    private String name;
    private Client[] clients;
    private int nbrClient;

    public Banque(String name) {
        this.name = name;
        this.clients = new Client[1000];
        this.nbrClient = 0;
    }

    public String getName() {
        return name;
    }

    public int getNbrClient() {
        return nbrClient;
    }

    public Client[] getClients() {
        return clients;
    }

    public void ajouterClient(Client client) {
        this.clients[this.nbrClient] = client;
        this.nbrClient++;
    }

    public void bilanClient() {
        System.out.println("bilan client");
    }


}
