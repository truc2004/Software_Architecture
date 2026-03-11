package org.example.observer.stock;

public class Main_Stock {
    public static void main(String[] args) {
        Stock stock = new Stock("AAPL");

        Investor investor1 = new Investor("An");
        Investor investor2 = new Investor("Bình");

        stock.registerObserver(investor1);
        stock.registerObserver(investor2);

        stock.setPrice(150.0);
        stock.setPrice(155.5);
    }
}
