package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        CardGame snap = new CardGame();
        snap.getDeck();
        System.out.println("Top card:");
        snap.dealCard();
        System.out.println("Sorted in number order");
        System.out.println("Sorted in suit order");
//        snap.sortDeckIntoSuits();
//        snap.getDeck();
        snap.shuffleDeck();
        snap.shuffleDeck();
//        snap.sortDeckIntoSuits();
        snap.dealCard();
        snap.dealCard();
        snap.getDeck();

    }
}