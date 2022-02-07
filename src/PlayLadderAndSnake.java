// -----------------------------------------------------
// Assignment #1 (or #0)
// Question: Part 2
// Written by: Artur Gubaidullin 40208924
// -----------------------------------------------------

//This program is a simulation of the Snakes and Ladders game.
//It starts by asking the user the wanted number of players.
//The user has 4 attempts to input a number between 2 and 4, after which the program closes
//If the input is correct, the program creates and plays a new game with the desired number of players.

/**
 * Artur Gubaidullin
 * COMP249
 * Assignment #1
 * Due Date 07/02/2022
 */

//importing Scanner for input
import java.util.Scanner;

//This is the driver class.
public class PlayLadderAndSnake {

    static Scanner keyboard = new Scanner(System.in);

    static final int maxPlayers = 4; //This integer controls the max amount of Players.
    //change the 4 to any number to test sorting algorithm.

    public static void main(String[] args) {

        System.out.println("--------------------------------------------------------------\nWelcome to Ladder and Snake Java program by Artur Gubaidullin\n--------------------------------------------------------------");

        //Asks player for input. Player can only input valid numbers and only valid numbers. He has 4 attempts to do so.
        int playerCount = 0;
        int attempts = 0;
        System.out.print("Please input the number of players (between 2 and "+maxPlayers+" inclusively): ");
        do {
            if (keyboard.hasNextInt()){
                playerCount = keyboard.nextInt();
                if (playerCount < 2 || playerCount > maxPlayers) {
                    attempts += 1;
                    System.out.print("--- The value is not between 2 and "+maxPlayers+"! You have "+(4-attempts)+" attempt(s) left.");
                    if (attempts < 4) {
                        System.out.print("\nPlease try again: ");
                    }
                }
            } else {
                attempts += 1;

                System.out.println("The value entered is not a number!");
                if (attempts < 4) {
                    System.out.print("\nPlease try again: ");
                }
                keyboard.next();
            }
        } while ((playerCount < 2 || playerCount > maxPlayers) && attempts < 4);

        //This checks if player used all 4 attempts.
        if (attempts == 4) {
            System.out.println("\n--------------------------------------------------\nSorry! You ran out of attempts to input a valid number of players.\nProgram terminating...");
            System.exit(0);
        }

        //If not, the game starts.
        LadderAndSnake game = new LadderAndSnake(playerCount);
        game.play();

    }
}
