import java.util.*;
public class Main {
    //method to print the menu
    private static void printMenu(){
        System.out.print("\n1. List Pokemon\n2. Add Pokemon\n3. Check a Pokemon's Stats\n4. Evolve Pokemon\n5. Sort Pokemon\n6. Exit\n\nWhat would you like to do: "); }
    //checks users input for non-integer menu items
    private static Integer menuCheck(){
        Scanner userInput = new Scanner(System.in);
        int menuNumCheck = 0;
        try{
            menuNumCheck = userInput.nextInt();
        }
        catch(Exception e){
            System.out.println("This is not a valid choice. Try again.");
        }
        return menuNumCheck;
    }
    //start of the main method
    public static void main(String[] args){
        //set up a scanner and some variables
        int menuNum = -1;
        String newSpecies;
        Scanner userInput = new Scanner(System.in);
        //Welcome screen text
        System.out.print("Welcome to your new PokeDex!\nHow many Pokemon are in your region: ");
        int newPokeNum = menuCheck();
        //makes sure the user puts in a + # of pokemon after menuCheck makes sure it's a number
        while (menuNum == -1){
            if (newPokeNum < 1){
                newPokeNum = menuCheck();
            }
            if (newPokeNum >0){
                menuNum = 0;
            }
        }
        //make a new pokedex item
        Pokedex Red = new Pokedex();
        //immediately set pokenum for array creation
        Red.setpokeNum(newPokeNum);
        System.out.println("\nYour new Pokedex can hold " + newPokeNum + " Pokemon. Let's start using it!");
        //6 will break this loop and go to exit code
        while(menuNum != 6){
            //initial menu print and user input, only runs once
            if(menuNum == 0){
                printMenu();
                menuNum = menuCheck();
            }
            //list all the pokemon
            if(menuNum == 1){
                //get the returned array and frint it with a for each loop
                String itemsPokemon[] = Red.listPokemon();
                for(String monster:itemsPokemon){
                    System.out.println(monster);
                }
                printMenu();
                menuNum = menuCheck();
            }
            //add a pokemon to the pokedex
            if(menuNum == 2){
                System.out.print("\nPlease enter the Pokemon's Species: ");
                //get the raw input name
                String species = userInput.nextLine();
                //format the name so i starts with a capital letter then all lowercase
                newSpecies = species.substring(0,1).toUpperCase() + species.substring(1).toLowerCase();
                //pass the formatted name into pokedex
                Red.addPokemon(newSpecies);
                printMenu();
                menuNum = menuCheck();
            }
            //check the stats for a pokemon
            if(menuNum == 3){
                System.out.print("\nPlease enter the Pokemon of interest: ");
                String species = userInput.nextLine();
                newSpecies = species.substring(0,1).toUpperCase() + species.substring(1).toLowerCase();
                //get the returned integer array from pokedex
                int stats[] = Red.checkStats(newSpecies);
                //can get stats for any pokemon without these ifs, negative one means nothing was done to the array
                if (stats[0] == -1);
                if(stats[0] != -1){
                    System.out.println("\nThe stats for " + species + " are:\nAttack: " + stats[0] + "\nDefense: " + stats[1] + "\nSpeed: " + stats[2]);
                }
                printMenu();
                menuNum = menuCheck();
            }
            //evolve a pokemon
            if(menuNum == 4){
                System.out.print("\nPlease enter the Pokemon of interest: ");
                String species = userInput.nextLine();
                newSpecies = species.substring(0,1).toUpperCase() + species.substring(1).toLowerCase();
                //get the returned boolean
                boolean check = Red.evolvePokemon(newSpecies);
                //if statements to print out right thing
                if (check){
                    System.out.println(newSpecies + " has evolved!");
                }
                printMenu();
                menuNum = menuCheck();
            }
            //leically sort the pokedex array
            if(menuNum == 5){
                //call the pokedex sort method
                Red.sortPokedex();
                printMenu();
                menuNum = menuCheck();
            }
            //this is here because if you put in 6 it would trigger my catch all and then break the loop rather than just breaking the loop immediately
            if(menuNum == 6){
                break;
            }
            //catch all for any non-menu items that happen to come through
            if((menuNum != 0) && (menuNum != 1) && (menuNum != 2) && (menuNum != 3) && (menuNum != 4) && (menuNum != 5)){
                System.out.println("That is not a valid choice. Try again.");
                printMenu();
                menuNum = menuCheck();
            }
        }
        //if you hit 6 this runs
        System.exit(0);
    }
}