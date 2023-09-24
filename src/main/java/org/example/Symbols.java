package org.example;

public enum Symbols {
//    TWO(2, "TWO"), THREE(3, "THREE"), FOUR(4, "FOUR"), FIVE(5, "FIVE"), SIX(6, "SIX"), SEVEN(7, "SEVEN"), EIGHT(8, "EIGHT"), NINE(9, "NINE"), TEN(10, "TEN"), JACK(11, "J"), QUEEN(12, "Q"), KING(13, "K"), ACE(14, "A");
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);


    private int cardValue;
    private String symbol;

    Symbols(int value) {
        this.cardValue = value;
    }

    Symbols(int value, String symbol) {
        this.cardValue = value;
        this.symbol = symbol;
    }

    public int getCardValue() {
        return cardValue;
    }

    public String getSymbol() {
        return symbol;
    }

}


