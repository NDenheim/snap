package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        CardGame cards = new CardGame();
        cards.getDeck();
        System.out.println("Top card:");
        cards.dealCard();
        System.out.println("Sorted in number order");
        System.out.println("Sorted in suit order");
        cards.sortDeckIntoSuits();
        cards.getDeck();

    }
}