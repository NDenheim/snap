package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.Card.*;

public class CardGame {
//    private static final List<Card> deckOfCards = new ArrayList<>();
    private static final ArrayList<Card> deckOfCards = new ArrayList<>();

    private static int cardValue;
    private static String suit;
    private static String symbol;

    static {

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; ++j) {
                deckOfCards.add(new Card(cardValues.get(i) , suits.get(j), symbols.get(i)));
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
        System.out.println(deckOfCards.size());
    }

    public Card dealCard(){
        Card topCard = deckOfCards.get(0);
        System.out.println(topCard);
        deckOfCards.remove(topCard);
        return topCard;
    }

    public ArrayList<Card> sortDeckInNumberOrder(){
        return (ArrayList<Card>) deckOfCards.stream().sorted((a,b)-> a.getCardValue() - b.getCardValue());
    }

    public ArrayList<Card> sortDeckIntoSuits(){
        ArrayList<Card> sortedList = (ArrayList<Card>) deckOfCards.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
        return sortedList;
    }

    public ArrayList<Card> shuffleDeck() {
//        List<ArrayList<Card>> deckList = Arrays.asList(deckOfCards);
//        Collections.shuffle(deckList);
//        deckList.toArray();
//        System.out.println(deckList);
//        return deckOfCards;
        Collections.shuffle(deckOfCards);
        System.out.println(deckOfCards);
        return deckOfCards;
    }
}




//        cards.add("  ------\n" +
//                " | 2    |\n" +
//                " |   " + HEART+ "  |\n" +
//                " |      |\n" +
//                "  ------");