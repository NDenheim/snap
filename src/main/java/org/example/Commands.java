package org.example;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Commands {

    private static final Scanner scanner = new Scanner(System.in);
    private static Snap snap = new Snap();
    public static Player player1 = new Player(1);
    public static Player player2 = new Player(2);
    public static Player currentPlayer;
    public static Player otherPlayer;
    private static final String[] commands = {
            "Play game",
            "Quit"
    };

    private static final String[] levels = {
            "One player",
            "Two players",
            "Play against computer"
    };

    public static final String[] endGameCommandsSinglePlayer = {
            "Return to main menu",
            "Play again",
            "Quit"
    };

    public static final String[] endGameCommands = {
            "Return to main menu",
            "Play again",
            "View points",
            "Quit"
    };

    static int chosenLevel;

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player currentPlayer) {
        Commands.currentPlayer = currentPlayer;
    }

    public static Player getOtherPlayer() {
        return otherPlayer;
    }

    public static void setOtherPlayer(Player otherPlayer) {
        Commands.otherPlayer = otherPlayer;
    }

    public static void intro(){
        System.out.println("-----------------");
        System.out.println("Welcome to Snap!");
        System.out.println("-----------------");
    }

    public static void runCommands() throws IOException {
        intro();
        player1.setPoints(0);
        player2.setPoints(0);
        numberedCommands();

        int chosenValue = scanner.nextInt();

        while ( chosenValue <1 || chosenValue >2) {
            numberedCommands();
            chosenValue = scanner.nextInt();
        }

        if (chosenValue == 1){
            chooseLevel();
        } else {
            System.out.println("See you again soon!");
        }
    }

    public static void numberedCommands(){
        System.out.println("\nPlease select one of the following:");
        for (int i = 0; i < commands.length; i++) {
            printMessage((i+1) + ": " + commands[i]);
        }
    }

    public static void chooseLevel() throws IOException {
        System.out.println("\nChoose a level:");
        for (int i = 0; i < levels.length; i++) {
            printMessage((i+1) + ": " + levels[i]);
        }

        chosenLevel = scanner.nextInt();

        if (chosenLevel == 1) {
            nameInput(player1);
            snap.runOnePlayerGame();
        } else if (chosenLevel == 2) {
            nameInput(player1,player2);
            snap.runTwoPlayerGame(otherPlayer, currentPlayer);
        } else if (chosenLevel == 3) {
            nameInput(player1);
            snap.runVsComputerGame();
        }
    }

    public static void nameInput(Player player){
        System.out.println("Please enter your name:");
        player.setName(scanner.next());
        System.out.println("Hello "+ player1.getName() + "! Glad you could join us!");
    }

    public static void nameInput(Player player1, Player player2){
        System.out.println("Please enter your name player 1:");
        String name = scanner.next();
        player1.setName(name);
        System.out.println("Please enter your name player 2:");
        String name2 = scanner.next();
        player2.setName(name2);
        System.out.println("Hello "+ player1.getName() + " and " + player2.getName() + "! Glad you could join us!\n");
        selectPlayer();
        System.out.println("Start us off " + currentPlayer.getName() + "! Press enter to draw a card");
    }

    protected static void printMessage(String message) {
        System.out.println(message);
    }

    public static void selectPlayer(){
        Random random = new Random();
        if (player1.getPlayerId() == random.nextInt(3)+1){
            setCurrentPlayer(player1);
            setOtherPlayer(player2);
        } else {
            setCurrentPlayer(player2);
            setOtherPlayer(player1);
        }
    }

    public static void runGameEndCommandsSinglePlayer() throws IOException {
        System.out.println("\nPlease select one of the following:");
        for (int i = 0; i < endGameCommandsSinglePlayer.length; i++) {
            printMessage((i+1) + ": " + endGameCommandsSinglePlayer[i]);
        }
        String chosenValue = scanner.next();

        while (!Objects.equals(chosenValue, "1") && !Objects.equals(chosenValue, "2") && !Objects.equals(chosenValue, "3")){
            System.out.println("\nSorry that wasn't one of the options...try again!");
            for (int i = 0; i < endGameCommandsSinglePlayer.length; i++) {
                printMessage((i+1) + ": " + endGameCommandsSinglePlayer[i]);
            }
            chosenValue = scanner.next();
        }

        switch (chosenValue) {
            case "1":
                chooseLevel();
                break;
            case "2":
                selectPlayAgain();
                break;
            case "3":
                System.out.println("\nThanks for playing!");
                System.exit(0);
        }

    }

    public static void selectPlayAgain() throws IOException {
        if (chosenLevel == 1){
            snap.runOnePlayerGame();
        } else if (chosenLevel == 3) {
            snap.runVsComputerGame();
        }
    }

    public static void runGameEndCommands() throws IOException {
        System.out.println("\nPlease select one of the following:");
        for (int i = 0; i < endGameCommands.length; i++) {
            printMessage((i+1) + ": " + endGameCommands[i]);
        }
        String chosenValue = scanner.next();

        while (!Objects.equals(chosenValue, "1") && !Objects.equals(chosenValue, "2") && !Objects.equals(chosenValue, "3") && !Objects.equals(chosenValue, "4")){
            System.out.println("\nSorry that wasn't one of the options...try again!");
            for (int i = 0; i < endGameCommands.length; i++) {
                printMessage((i+1) + ": " + endGameCommands[i]);
            }
            chosenValue = scanner.next();
        }

        if (chosenValue.equals("1")) {
            chooseLevel();
        } else if (chosenValue.equals("2")){
            snap.runTwoPlayerGame(otherPlayer, currentPlayer);

        } else if (chosenValue.equals("3")){
            System.out.println("\n" + player1.getName() + ": " + player1.getPoints());
            System.out.println(player2.getName() + ": " + player2.getPoints() + "\n");
            runGameEndCommands();
        } else {
            System.out.println("\nThanks for playing!");
            System.exit(0);
        }

    }

}
