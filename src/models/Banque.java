package models;

public class Banque {
    private String name;
    private Client[] clients;
    private int nbrClient;

    public Banque(String name) {
        this.name = name;
        this.clients = new Client[1000];
        this.nbrClient = -1;
    }

    public String getName() {
        return name;
    }

    public Client[] getClients() {
        return clients;
    }

    public void ajouterClient(Client client) {
        System.out.println("ajouter client (banque)");
//        this.nbrClient++;
//        this.clients[this.nbrClient] = client;
    }

    public void bilanClient() {
        System.out.println("bilan client");
    }
}
