import java.util.*;
public class CharSorter {
    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        //welcome text
        System.out.println("Welcome to Character Sorter Program");
        System.out.println("Please input a string to be sorted");
        //split big string into character array
        String bagels = userInput.nextLine();
        char[] splitBagels = bagels.toCharArray();
        //ASCII conversion to an integer array
        int[] asciiSplitBagels = new int[splitBagels.length];
        for (int i = 0; i < splitBagels.length; i++){
            asciiSplitBagels[i] = (int)splitBagels[i];
            //System.out.println(asciiSplitBagels[i]);
        }
        //start menu system
        printMenu();
        String menuNum = userInput.nextLine();
        //pick menu option and error check
        //menuNum and printMenu at end to avoid having to return a new menuNum and such from the methods called
        while (!menuNum.equals("4")){
            if (!(menuNum.equals("1")|| menuNum.equals("2")|| menuNum.equals("3"))){
                System.out.println("Error, bad input, please enter a number 1-4");
                printMenu();
                menuNum = userInput.nextLine();
            }
            //sorted alphabetically with frequency
            if(menuNum.equals("1")){
                alphabeticalSort(asciiSplitBagels);
                printMenu();
                menuNum = userInput.nextLine();
            }
            //sorted by frequency
            if(menuNum.equals("2")){
                frequencySort(asciiSplitBagels);
                printMenu();
                menuNum = userInput.nextLine();
            }
            //types of character frequencies
            if(menuNum.equals("3")){
                charTypes(asciiSplitBagels);
                printMenu();
                menuNum = userInput.nextLine();
            }
        }
        //exit text and command
        if (menuNum.equals("4")){
            System.out.println("Character Sorter Exited Successfully");
            System.exit(0);
        }
        //convert the string to ASCII
    }
    //menu printing method
    private static void printMenu(){
        System.out.println("\nPlease select the option you would like to see \n");
        System.out.println("1. Display character frequencies alphabetically");
        System.out.println("2. Display sorted frequencies");
        System.out.println("3. Show types of character frequencies");
        System.out.println("4. Exit");
    }
    //alphabetical sort method
    private static void alphabeticalSort(int[] args){
        //sort array by moving larger ASCII numbers right one spot
        for (int i = 0; i < args.length; i++){
            for (int j = i+1; j < args.length; j++){
                if (args[i] > args[j]){
                    int holdThis = args[j];
                    args[j] = args[i];
                    args[i] = holdThis;
                }
            }
        }
        //transfer ASCII organized array back into characters in a new array
        char[] sortArgs = new char[args.length];
        for (int l = 0; l < args.length; l++){
            sortArgs[l] = (char) args[l];
        }
        //initialize some variables and a temporary array
        //int[] freqHold = new int[sortArgs.length];
        int charFreq = 1;
        //for loop to get print statements and frequency
        for (int m = 0; m < sortArgs.length; m++){
            //compare two array values to get frequencies
            if ((m+1 < sortArgs.length) && (sortArgs[m+1] == sortArgs[m])){
                charFreq = charFreq + 1;
            }
            //print frequencies, pass frequency to a temp array, reset frequency, and count up one for a new symbol in the string input
            else{
                System.out.println(sortArgs[m] + " freq: " + charFreq);
                charFreq = 1;
            }
        }
    }
    //frequency sorting method
    //use alphabetical sort in the arguments and freq stor arrays in the commands?
    private static void frequencySort(int[] args){
        //transfer ASCII organized array back into characters in a new array
        char[] sortArgs = new char[args.length];
        for (int l = 0; l < args.length; l++){
            sortArgs[l] = (char) args[l];
        }
        //initialize some variables and a temporary array
        int[] freqHold = new int[sortArgs.length];
        char[] freqArgs = new char[sortArgs.length];
        int charFreq = 1;
        int countOne = 0;
        //for loop to get print statements and frequency
        for (int m = 0; m < sortArgs.length; m++){
            //compare two array values to get frequencies
            if ((m+1 < sortArgs.length) && (sortArgs[m+1] == sortArgs[m])){
                charFreq = charFreq + 1;
            }
            //print frequencies, pass frequency to a temp array, reset frequency, and count up one for a new symbol in the string input
            else{
                freqArgs[countOne] = sortArgs[m];
                freqHold[m] = charFreq;
                charFreq = 1;
                countOne = countOne + 1;
            }
        }
        //initialize a couple variables and a final frequency array
        int[]  freqStor= new int[countOne];
        int p = 0;
        //for loop to transfer non-zero values to the final frequency array
        for (int frequency:freqHold) {
            if (frequency != 0) {
                freqStor[p] = frequency;
                p = p + 1;
            }
        }
        //at this point I have an array freqStor that holds the frequency of each character and an array freqArgs that holds one of each character
        //sort array by moving lower frequency numbers right one spot
        for (int i = 0; i < freqStor.length; i++){
            for (int j = i+1; j < freqStor.length; j++){
                if (freqStor[j] > freqStor[i]){
                    //sort the character
                    char holdThis = freqArgs[i];
                    freqArgs[i] = freqArgs[j];
                    freqArgs[j] = holdThis;
                    //sort the frequencies
                    int holdThisToo = freqStor[i];
                    freqStor[i] = freqStor[j];
                    freqStor[j] = holdThisToo;
                }
            }
        }
        System.out.println("The sorted by frequency characters are:");
        //prints the necessary statements sorted correctly
        for (int q = 0; q < freqStor.length; q++){
            System.out.println(freqArgs[q] + " freq: " + freqStor[q]);
        }
    }
    //character type frequency method
    private static void charTypes(int[] args){
        //convert to ASCII
        //tick up one per char type in ASCII number region
        //system out print
        int whiteCount = 0;
        int charCount = 0;
        int numCount = 0;
        int symCount = 0;
        //for loop to count the things necessary
        for (int ascii:args) {
            //white space count
            if (ascii < 33){
                whiteCount = whiteCount + 1;
            }
            //number count
            if ((ascii < 58) && (ascii > 47)){
                numCount = numCount + 1;
            }
            //symbol count
            if (((ascii < 48) && (ascii > 32)) || ((ascii < 65) && (ascii > 57)) || ((ascii < 97) && (ascii > 90)) || (ascii > 122)){
                symCount = symCount + 1;
            }
            //character count
            if ((ascii < 91) && (ascii > 64) || ((ascii < 123) && (ascii > 96))){
                charCount = charCount + 1;
            }
        }
        System.out.println("Textual Character count: " + charCount + "\n" + "Numerical Character count: " + numCount + "\n" + "WhiteSpace Character count: " + whiteCount + "\n" + "Symbol Character count: " + symCount);
    }
}