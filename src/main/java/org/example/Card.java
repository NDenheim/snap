package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Card {

    private String suit;
//    private String symbol = Arrays.toString(Symbols.values());
    private String symbol;
    private int cardValue;

    public static final ArrayList<String> suits = new ArrayList<>();
    public static final ArrayList<String> symbols = new ArrayList<>();
    public static final ArrayList<Integer> cardValues = new ArrayList<>();

    static {
        suits.add("Clubs");
        suits.add("Diamonds");
        suits.add("Hearts");
        suits.add("Spades");
    }

    static {
        symbols.add("Two");
        symbols.add("Three");
        symbols.add("Four");
        symbols.add("Five");
        symbols.add("Six");
        symbols.add("Seven");
        symbols.add("Eight");
        symbols.add("Nine");
        symbols.add("Ten");
        symbols.add("Jack");
        symbols.add("Queen");
        symbols.add("King");
        symbols.add("Ace");
    }

    static {
        cardValues.add(2);
        cardValues.add(3);
        cardValues.add(4);
        cardValues.add(5);
        cardValues.add(6);
        cardValues.add(7);
        cardValues.add(8);
        cardValues.add(9);
        cardValues.add(10);
        cardValues.add(11);
        cardValues.add(12);
        cardValues.add(13);
        cardValues.add(14);
    }

    public Card (int cardValue, String suit, String symbol){
        this.cardValue = cardValue;
        this.suit = suit;
        this.symbol=symbol;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
//        this.suit = suit;
        for (int i = 0; i < Suit.values().length ; i++) {
            this.suit = suit;
        }
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue() {
//        this.cardValue = Symbols.ACE.getCardValue();
        for (int i = 0; i < cardValues.size() ; i++) {
            this.cardValue = cardValues.get(i);
        }
    }

    public String getSymbol() {
        return setSymbol();
    }

    public String setSymbol() {
        for (int i = 0; i < symbols.size() ; i++) {
            this.symbol = symbols.get(i);
        }
        return this.symbol;
    }




    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", symbol='" + symbol + '\'' +
                ", value=" + cardValue +
                '}';
    }
}
