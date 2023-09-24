package org.example;

public enum Suit {
    CLUB("♣"), DIAMOND("♦"), HEART("♥"), SPADE("♠");

    private String suit;

    Suit(String suit){
        this.suit = suit;
    }
}
