import java.math.BigDecimal;
import java.util.*;
import java.lang.*;

public class Main {
    //method to print the menu when called
    private static void printMenu(){
        System.out.println("\n" + "1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print game statistics");
        System.out.println("4. Exit");
        System.out.print("\n" + "Choose a numerical option: ");
    }
    //start of the main program
    public static void main(String [] args) {
        //random number between 1 and 13
        int playerDeal = 1 + (int)(Math.random() * 13);
        //random number between 16 and 26

        //input setup
        Scanner userInput = new Scanner(System.in);
        int playerHand = 0;
        double menuNum = 0;
        int gameCount = 1;
        int playerWin = 0;
        int dealerWin = 0;
        int tieGame = 0;
        //game loop
        while (menuNum !=4) {
            //first menu and get first card
            if (menuNum == 0){
                System.out.println("START GAME # " + gameCount + "\n");
                //exceptions for face cards and aces
                if (playerDeal == 1){
                    System.out.println("Your card is an ACE!");
                    playerHand = playerHand + 1;
                    System.out.println("Your hand is " + playerHand);
                }
                if (playerDeal == 11){
                    System.out.println("Your card is a JACK!");
                    playerHand = playerHand + 11;
                    System.out.println("Your hand is " + playerHand);
                }
                if (playerDeal == 12) {
                    System.out.println("Your card is a QUEEN!");
                    playerHand = playerHand + 12;
                    System.out.println("Your hand is " + playerHand);
                }
                if (playerDeal == 13) {
                    System.out.println("Your card is a KING!");
                    playerHand = playerHand + 13;
                    System.out.println("Your hand is " + playerHand);
                }
                //all other plain number cards
                if ((playerDeal > 1)&&(playerDeal < 11)){
                    System.out.println("Your card is a " + playerDeal + "!");
                    playerHand = playerHand + playerDeal;
                    System.out.println("Your hand is " + playerHand);
                }
                //print menu and wait for first user input
                printMenu();
                menuNum = userInput.nextDouble();
            }
            //menu item 1, get a new card
            if (menuNum == 1) {
                //random card between 1 and 13
                playerDeal = 1 + (int)(Math.random() * 13);
                //exceptions for face cards and aces
                if (playerDeal == 1){
                    System.out.println("Your card is an ACE!");
                    playerHand = playerHand + 1;
                    System.out.println("Your hand is " + playerHand);
                }
                if (playerDeal == 11){
                    System.out.println("Your card is a JACK!");
                    playerHand = playerHand + 11;
                    System.out.println("Your hand is " + playerHand);
                }
                if (playerDeal == 12) {
                    System.out.println("Your card is a QUEEN!");
                    playerHand = playerHand + 12;
                    System.out.println("Your hand is " + playerHand);
                }
                if (playerDeal == 13) {
                    System.out.println("Your card is a KING!");
                    playerHand = playerHand + 13;
                    System.out.println("Your hand is " + playerHand);
                }
                //all other value cards
                if ((playerDeal > 1)&&(playerDeal < 11)){
                    System.out.println("Your card is a " + playerDeal + "!");
                    playerHand = playerHand + playerDeal;
                    System.out.println("Your hand is " + playerHand);
                }
                //check if the player has hit 21 after drawing a card
                if (playerHand == 21){
                    System.out.println("BLACKJACK! You win!");
                    //increase correct stats
                    gameCount = gameCount + 1;
                    playerWin = playerWin + 1;
                    //reset hand and start a new game
                    playerHand = 0;
                    System.out.println("\n" + "START GAME # " + gameCount + "\n");
                    //random card between 1 and 13
                    playerDeal = 1 + (int)(Math.random() * 13);
                    //check if card is an ace or face
                    if (playerDeal == 1){
                        System.out.println("Your card is an ACE!");
                        playerHand = playerHand + 1;
                        System.out.println("Your hand is " + playerHand);
                    }
                    if (playerDeal == 11){
                        System.out.println("Your card is a JACK!");
                        playerHand = playerHand + 11;
                        System.out.println("Your hand is " + playerHand);
                    }
                    if (playerDeal == 12) {
                        System.out.println("Your card is a QUEEN!");
                        playerHand = playerHand + 12;
                        System.out.println("Your hand is " + playerHand);
                    }
                    if (playerDeal == 13) {
                        System.out.println("Your card is a KING!");
                        playerHand = playerHand + 13;
                        System.out.println("Your hand is " + playerHand);
                    }
                    //all other numbered cards
                    if ((playerDeal > 1)&&(playerDeal < 11)){
                        System.out.println("Your card is a " + playerDeal + "!");
                        playerHand = playerHand + playerDeal;
                        System.out.println("Your hand is " + playerHand);
                    }
                }
                //check if player hand is over 21
                if (playerHand > 21) {
                    System.out.println("You exceeded 21! You lose :(");
                    //increase proper stats
                    gameCount = gameCount + 1;
                    dealerWin = dealerWin + 1;
                    //reset hand and start a new game
                    playerHand = 0;
                    System.out.println("\n" + "START GAME # " + gameCount + "\n");
                    //random card between 1 and 13
                    playerDeal = 1 + (int)(Math.random() * 13);
                    //check if card is an ace or face
                    if (playerDeal == 1){
                        System.out.println("Your card is an ACE!");
                        playerHand = playerHand + 1;
                        System.out.println("Your hand is " + playerHand);
                    }
                    if (playerDeal == 11){
                        System.out.println("Your card is a JACK!");
                        playerHand = playerHand + 11;
                        System.out.println("Your hand is " + playerHand);
                    }
                    if (playerDeal == 12) {
                        System.out.println("Your card is a QUEEN!");
                        playerHand = playerHand + 12;
                        System.out.println("Your hand is " + playerHand);
                    }
                    if (playerDeal == 13) {
                        System.out.println("Your card is a KING!");
                        playerHand = playerHand + 13;
                        System.out.println("Your hand is " + playerHand);
                    }
                    //all other numbered cards
                    if ((playerDeal > 1)&&(playerDeal < 11)){
                        System.out.println("Your card is a " + playerDeal + "!");
                        playerHand = playerHand + playerDeal;
                        System.out.println("Your hand is " + playerHand);
                    }
                }
                //end of menu item 1, print a new menu and get the next choice by player
                printMenu();
                menuNum = userInput.nextDouble();
            }
            //menu item 2, hold your hand
            if (menuNum == 2) {
                //random card between 16 and 26
                int dealerHand = 16 + (int)(Math.random() * 11);
                //print out the 2 hands
                System.out.println("\n" + "Dealer's hand: " + dealerHand);
                System.out.println("Your hand is: " + playerHand + "\n");
                //compare the two hands to see who wins
                //if statement to cover all dealer win conditions
                if (((dealerHand < 21) && (dealerHand > playerHand)) || (dealerHand == 21)) {
                    System.out.println("\n" + "Dealer wins!");
                    gameCount = gameCount + 1;
                    dealerWin = dealerWin + 1;
                }
                //if statement to cover player wins
                if ((dealerHand > 21)||(playerHand > dealerHand)){
                    System.out.println("\n" + "You win!");
                    gameCount = gameCount + 1;
                    playerWin = playerWin + 1;
                }
                //if statement to cover ties
                if (playerHand == dealerHand){
                    System.out.println("\n" + "It's a tie! No one wins!");
                    gameCount = gameCount + 1;
                    tieGame = tieGame + 1;
                }
                //reset players hand
                playerHand = 0;
                //new game starts
                System.out.println("\n" + "START GAME # " + gameCount + "\n");
                //random card between 1 and 13
                playerDeal = 1 + (int)(Math.random() * 13);
                //check if card is an ace or face
                if (playerDeal == 1){
                    System.out.println("Your card is an ACE!");
                    playerHand = playerHand + 1;
                    System.out.println("Your hand is " + playerHand);
                }
                if (playerDeal == 11){
                    System.out.println("Your card is a JACK!");
                    playerHand = playerHand + 11;
                    System.out.println("Your hand is " + playerHand);
                }
                if (playerDeal == 12) {
                    System.out.println("Your card is a QUEEN!");
                    playerHand = playerHand + 12;
                    System.out.println("Your hand is " + playerHand);
                }
                if (playerDeal == 13) {
                    System.out.println("Your card is a KING!");
                    playerHand = playerHand + 13;
                    System.out.println("Your hand is " + playerHand);
                }
                //all other numbered cards
                if ((playerDeal > 1)&&(playerDeal < 11)){
                    System.out.println("Your card is a " + playerDeal + "!");
                    playerHand = playerHand + playerDeal;
                    System.out.println("Your hand is " + playerHand);
                }
                //print the menu and get next player input
                printMenu();
                menuNum = userInput.nextDouble();
            }
            //menu item 3, showing statistics to output
            if (menuNum == 3) {
                //long decimal win percentage
                double winPercent = ((double)(playerWin) / (double)(gameCount-1)) * 100;
                //set-up to round long decimal win percentage
                BigDecimal roundWin = new BigDecimal(winPercent);
                //print statistics
                System.out.println("\n" + "Number of Player wins: " + playerWin);
                System.out.println("Number of Dealer wins: " + dealerWin);
                System.out.println("Number of tie games: " + tieGame);
                System.out.println("Total # of games: " + (gameCount - 1));
                //round off win percentage to 1 decimal place
                System.out.println("Percentage of Player wins: " + (roundWin.setScale(1, BigDecimal.ROUND_HALF_UP)) + " %");
                //print menu and get next player input
                printMenu();
                menuNum = userInput.nextDouble();
            }
            //if player input is not a valid menu item response
            if (((menuNum < 1)||(menuNum > 4)) || (menuNum % 1 != 0)){
                System.out.println("\n" + "Invalid input!" + "\n" + "Please enter an integer value between 1 and 4.");
                //print menu and get next player input
                printMenu();
                menuNum = userInput.nextDouble();
            }
        }
        //while breaks at 4 and executes the exit code
        System.exit(0);
    }
}
