import models.BanqueInteraction;

public class Main {
    public static void main(String[] args) {
        BanqueInteraction banqueInteraction = new BanqueInteraction();
        banqueInteraction.displayMenu(banqueInteraction.interactionClient);
    }
}