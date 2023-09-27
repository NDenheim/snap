package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Snap extends CardGame {
    Scanner scanner = new Scanner(System.in);
    Card currentCard;
    Card nextCard;

    public void runOnePlayerGame() throws IOException {
        shuffleDeck();
        scanner.nextLine();

        currentCard = dealCard();
        while (Objects.equals(scanner.nextLine(), "")) {

            nextCard = dealCard();

            if (currentCard.cardValue == nextCard.cardValue){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("\nSNAP - you win!");
                Commands.runGameEndCommands();
            } else {
                currentCard = nextCard;

                if (deckOfCards.isEmpty()){
                    System.out.println("\nAwks...you've run out of cards...wanna try again?");
                    Commands.runGameEndCommands();
                }
            }

        }
    }

    public void runTwoPlayerGame(Player otherPlayer, Player currentPlayer) throws IOException {
        shuffleDeck();
        System.out.println(currentPlayer.getName() + "'s turn");
        scanner.nextLine();
        currentCard = dealCard();
        System.out.println(otherPlayer.getName() + "'s turn");

        while (Objects.equals(scanner.nextLine(), "")) {
            nextCard = dealCard();

            checkCards(currentPlayer, otherPlayer);
            Player temp = currentPlayer;
            currentPlayer = otherPlayer;
            otherPlayer = temp;
            System.out.println("\n" + otherPlayer.getName() + "'s turn");

        }
    }

    public void runVsComputerGame() throws IOException {
        shuffleDeck();
        scanner.nextLine();
        currentCard = dealCard();
        computerLogic();

        while (Objects.equals(scanner.nextLine(), "")) {
            nextCard = dealCard();
            checkCards();
            computerLogic();

        }
    }

    public void computerLogic() throws IOException {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        nextCard = dealCard();
        checkCards();
    }

    public void checkCards() throws IOException {
        if (currentCard.cardValue == nextCard.cardValue){
            BufferedReader timer = new BufferedReader(new InputStreamReader(System.in));
            long startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) < 3000 && !timer.ready()) {}

            if (timer.ready() && Objects.equals(timer.readLine(), "snap")) {
                System.out.println("\nWINNER WINNER!!");
                Commands.runGameEndCommands();
            } else {
                System.out.println("\nToo slow! YOU LOSE!");
                Commands.runGameEndCommands();
            }
        } else {
            currentCard = nextCard;

            if (deckOfCards.isEmpty()){
                System.out.println("Awks...you've run out of cards...wanna try again?");
                Commands.runGameEndCommands();
            }
        }
    }

    public void checkCards(Player currentPlayer, Player otherPlayer) throws IOException {
        if (currentCard.cardValue == nextCard.cardValue){
            BufferedReader timer = new BufferedReader(new InputStreamReader(System.in));
            long startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) < 3000 && !timer.ready()) {}

            if (timer.ready() && Objects.equals(timer.readLine(), "snap")) {
                System.out.println(otherPlayer.getName() + " is the winner!");
                otherPlayer.setPoints(otherPlayer.getPoints()+1);
                Commands.runGameEndCommands();
            } else if (timer.ready() && !Objects.equals(timer.readLine(), "snap")) {
                System.out.println("\nNooooo " + otherPlayer.getName() + ", you didn't type snap! YOU LOSE!");
                currentPlayer.setPoints(currentPlayer.getPoints()+1);
                Commands.runGameEndCommands();
            } else {
                System.out.println("\nToo slow " + otherPlayer.getName() + "! YOU LOSE!");
                currentPlayer.setPoints(currentPlayer.getPoints()+1);
                Commands.runGameEndCommands();
            }
        } else {
            currentCard = nextCard;

            if (deckOfCards.isEmpty()){
                System.out.println("Awks...you've run out of cards...wanna try again?");
                Commands.runGameEndCommands();
            }
        }
    }


//    public void checkCards(){
//        if (currentCard.cardValue == nextCard.cardValue){
//            try {
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println("SNAP - you win!");
//                Commands.runGameEndCommands();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        } else {
//            currentCard = nextCard;
//
//            if (deckOfCards.isEmpty()){
//                System.out.println("Awks...you've run out of cards...wanna try again?");
//                Commands.runGameEndCommands();
//            }
//        }
//    }

}
