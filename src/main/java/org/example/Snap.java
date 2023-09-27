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
        System.out.println("Press enter to draw a card:");
        scanner.nextLine();


        currentCard = dealCard();
        int counter = 1;
        while (Objects.equals(scanner.nextLine(), "")) {
            counter++;

            nextCard = dealCard();

            if (currentCard.cardValue == nextCard.cardValue) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("\nSNAP - you win!");
                Commands.runGameEndCommandsSinglePlayer();
            } else {
                currentCard = nextCard;

                if (counter == 52) {
                    System.out.println("\nAwks...you've run out of cards...wanna try again?");
                    shuffleDeck();
                    Commands.runGameEndCommandsSinglePlayer();
                }
            }

        }
    }

    public void runTwoPlayerGame(Player otherPlayer, Player currentPlayer) throws IOException {
        shuffleDeck();
        System.out.println(currentPlayer.getName() + "'s turn");
        scanner.nextLine();
        currentCard = dealCard();
        int counter = 1;
        System.out.println(otherPlayer.getName() + "'s turn");

        while (Objects.equals(scanner.nextLine(), "")) {
            counter++;
            nextCard = dealCard();

            checkCards(currentPlayer, otherPlayer);
            Player temp = currentPlayer;
            currentPlayer = otherPlayer;
            otherPlayer = temp;
            System.out.println("\n" + otherPlayer.getName() + "'s turn");

            if (counter == 52) {
                System.out.println("\nAwks...you've run out of cards...wanna try again?");
                shuffleDeck();
                Commands.runGameEndCommands();
            }

        }
    }

    public void runVsComputerGame() throws IOException {
        shuffleDeck();
        System.out.println("Press enter to draw a card:");
        scanner.nextLine();
        currentCard = dealCard();
        int counter = 1;
        computerLogic();

        while (Objects.equals(scanner.nextLine(), "")) {
            counter++;
            nextCard = dealCard();
            checkCards();
            computerLogic();

            if (counter == 52) {
                System.out.println("\nAwks...you've run out of cards...wanna try again?");
                shuffleDeck();
                Commands.runGameEndCommandsSinglePlayer();
            }
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
        if (currentCard.cardValue == nextCard.cardValue) {
            BufferedReader timer = new BufferedReader(new InputStreamReader(System.in));
            long startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) < 3000 && !timer.ready()) {
            }

            if (timer.ready() && Objects.equals(timer.readLine(), "snap")) {
                System.out.println("\nWINNER WINNER!!");
                Commands.runGameEndCommandsSinglePlayer();
            } else {
                System.out.println("\nToo slow! YOU LOSE!");
                Commands.runGameEndCommandsSinglePlayer();
            }
        } else {
            currentCard = nextCard;
        }
    }

    public void checkCards(Player currentPlayer, Player otherPlayer) throws IOException {
        if (currentCard.cardValue == nextCard.cardValue) {
            BufferedReader timer = new BufferedReader(new InputStreamReader(System.in));
            long startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) < 3000 && !timer.ready()) {
            }

            if (timer.ready() && Objects.equals(timer.readLine(), "snap")) {
                System.out.println(otherPlayer.getName() + " is the winner!");
                otherPlayer.setPoints(otherPlayer.getPoints() + 1);
                Commands.runGameEndCommands();
            } else {
                System.out.println("\nToo slow " + otherPlayer.getName() + "! YOU LOSE!");
                currentPlayer.setPoints(currentPlayer.getPoints() + 1);
                Commands.runGameEndCommands();
            }
        } else {
            currentCard = nextCard;
        }
    }
}