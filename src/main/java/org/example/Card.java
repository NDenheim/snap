package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class Card {

    public String suit;
//    private String symbol = Arrays.toString(Symbols.values());
    public String symbol;
    public int cardValue;

    public static final ArrayList<String> suits = new ArrayList<>();
    public static final ArrayList<String> symbols = new ArrayList<>();
    public static final ArrayList<Integer> cardValues = new ArrayList<>();
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";


    static {
        suits.add("♣");
        suits.add("♦");
        suits.add("♥");
        suits.add("♠");
    }

    static {
        symbols.add("2");
        symbols.add("3");
        symbols.add("4");
        symbols.add("5");
        symbols.add("6");
        symbols.add("7");
        symbols.add("8");
        symbols.add("9");
        symbols.add("10");
        symbols.add("J");
        symbols.add("Q");
        symbols.add("K");
        symbols.add("A");
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

    public Card(){}

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




//    @Override
//    public String toString() {
//        return "Card{" +
//                "suit='" + suit + '\'' +
//                ", symbol='" + symbol + '\'' +
//                ", value=" + cardValue +
//                '}';
//    }

//    @Override
//    public String toString() {
//        return symbol + " of " + suit;
//    }

    @Override
    public String toString() {
        if (Objects.equals(symbol, "10") && (Objects.equals(suit, "♦") || Objects.equals(suit, "♥"))){
            return "  -------\n" +
                    " | " + symbol + "    |\n" +
                    " |   " + ANSI_RED + suit + ANSI_RESET + "   |\n" +
                    " |       |\n" +
                    "  -------";
        } else if (Objects.equals(symbol, "10")){
        return "  -------\n" +
                " | " + symbol + "    |\n" +
            " |   " + suit + "   |\n" +
            " |       |\n" +
            "  -------";
        } else if (Objects.equals(suit, "♦") || Objects.equals(suit, "♥")){
            return "  -------\n" +
                    " | " + symbol + "     |\n" +
                    " |   " + ANSI_RED + suit + ANSI_RESET + "   |\n" +
                    " |       |\n" +
                    "  -------";
        } else {
            return "  -------\n" +
                    " | " + symbol + "     |\n" +
                    " |   " + suit + "   |\n" +
                    " |       |\n" +
                    "  -------";
        }
    }
}
