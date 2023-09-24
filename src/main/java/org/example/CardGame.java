package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CardGame {
    private static final ArrayList<Card> deckOfCards = new ArrayList<>();
    private static int value;
    private static String suit;
    private static String symbol;

    private static final ArrayList<String> suits = new ArrayList<>();

    private static final ArrayList<String> symbols = new ArrayList<>();
    private static final ArrayList<Integer> cardValues = new ArrayList<>();

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

    static {

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; ++j) {
                deckOfCards.add(new Card(cardValues.get(i), suits.get(j), symbols.get(i)));
            }

        }

    }

    // CONSTRUCTOR NEEDS TO BE FILLED
    public CardGame() {
    }


    public void getDeck(){
        for (Card card : deckOfCards) {
            System.out.println(card.toString());
        }
    }

    public Card dealCard(){
        System.out.println(deckOfCards.get(0));
        return deckOfCards.get(0);
    }

    public ArrayList<Card> sortDeckInNumberOrder(){
        return (ArrayList<Card>) deckOfCards.stream().sorted((a,b)-> a.getCardValue() - b.getCardValue());
    }

    public ArrayList<Card> sortDeckIntoSuits(){
        return (ArrayList<Card>) deckOfCards.stream().collect( Collectors.groupingBy(card -> suits,
                Collectors.counting() ) );

    }
}




//        cards.add("  ------\n" +
//                " | 2    |\n" +
//                " |   " + HEART+ "  |\n" +
//                " |      |\n" +
//                "  ------");