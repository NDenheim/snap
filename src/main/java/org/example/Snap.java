package org.example;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Snap extends CardGame {
    Scanner scanner = new Scanner(System.in);
    Card currentCard;
    Card nextCard;

    public void runGame(){
        shuffleDeck();
        System.out.println("Press enter to draw the next card");
        scanner.nextLine();

        currentCard = dealCard();
        while (Objects.equals(scanner.nextLine(), "")) {

            nextCard = dealCard();

            checkCards();

        }
    }


    public void checkCards(){
        if (currentCard.cardValue == nextCard.cardValue){
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("SNAP - you win!");
                System.exit(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            currentCard = nextCard;

            if (deckOfCards.isEmpty()){
                System.out.println("Awks...you've run out of cards");
                System.exit(0);
            }
        }
    }

}

//            for (int i = 0; i < 1 ; i++) {
//                if (deckOfCards.get(i).getCardValue() == deckOfCards.get(i-1).getCardValue()){
//                    System.out.println("SNAP");
//                }
//            }