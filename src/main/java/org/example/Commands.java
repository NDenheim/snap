package org.example;

import java.util.Scanner;

public class Commands {

    private static final Scanner scanner = new Scanner(System.in);
    private static Snap snap = new Snap();
    private static final String[] commands = {
            "Play game",
            "Quit"
    };

    public static void intro(){
        System.out.println("-----------------");
        System.out.println("Welcome to Snap!");
        System.out.println("-----------------");
    }

    public static void runCommands(){
        intro();
        numberedCommands();

        int chosenValue = scanner.nextInt();

        while ( chosenValue <1 || chosenValue >2) {
            numberedCommands();
            chosenValue = scanner.nextInt();
        }

        if (chosenValue == 1){
            snap.runGame();
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

    protected static void printMessage(String message) {
        System.out.println(message);
    }

}
