package org.example;

import java.util.*;
import java.util.stream.Collectors;

import static org.example.Card.*;

public class CardGame {
    public static ArrayList<Card> deckOfCards = new ArrayList<>();

    public CardGame() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; ++j) {
                deckOfCards.add(new Card(cardValues.get(i) , suits.get(j), symbols.get(i)));
            }

        }
    }

    public void getDeck(){
        for (Card card : deckOfCards) {
            System.out.println(card.toString());
        }
        System.out.println(deckOfCards.size());
    }

    public Card dealCard(){
//        Random random = new Random();
//        Card topCard = deckOfCards.get((random.nextInt(52)));
        Card topCard = deckOfCards.get(0);
        System.out.println(topCard);
        deckOfCards.remove(topCard);
        deckOfCards.add(topCard);
        return topCard;
    }

    public ArrayList<Card> sortDeckInNumberOrder(){

        deckOfCards = (ArrayList<Card>) deckOfCards.stream().sorted((a, b)-> a.getCardValue() - b.getCardValue()).collect(Collectors.toList());
        System.out.println(deckOfCards);
        return deckOfCards;
    }

    public List<Card> sortDeckIntoSuits(){
        deckOfCards = (ArrayList<Card>) deckOfCards.stream().sorted((a, b)->a.cardValue - b.cardValue).sorted((a, b)-> a.getSuit().compareTo(b.getSuit())).collect(Collectors.toList());
        System.out.println(deckOfCards);
        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }
}

