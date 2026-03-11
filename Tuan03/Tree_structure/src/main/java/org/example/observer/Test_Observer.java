package org.example.observer;

public class Test_Observer {

        public static void main(String[] args) {

            Stock stock = new Stock();

            Investor inv1 = new Investor("Alice");
            Investor inv2 = new Investor("Bob");

            stock.attach(inv1);
            stock.attach(inv2);

            stock.setPrice(100);
            stock.setPrice(120);
        }

}
