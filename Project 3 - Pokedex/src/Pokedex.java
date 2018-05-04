import java.util.*;

public class Pokedex {
    //some values
    protected String species;
    private String speciesCheck;
    String pokemon[];
    private int pokeNum;
    private int counter;
    int stats[] = {-1,-1,-1};
    //some initialization
    public Pokedex() {
        species = "";
        pokeNum = 0;
        counter = 1;
        speciesCheck = "";
    }
    //sets the pokenum and creates a correctly sized array "pokemon"
    public void setpokeNum(int newPokeNum){
        pokeNum = newPokeNum;
        String pokemon2[] = new String[newPokeNum];
        pokemon = pokemon2;
    }
    //listing method
    public String[] listPokemon () {
        int a = 0;
        //counts how many values are in pokemon that are not null
        for(String monster:pokemon){
            if(monster != null){
                a++;
            }
        }
        //new array that is the current size of the pokedex entries
        String itemsPokemon[] = new String[a];
        //adds a numerical count and the pokedex entry to the new array
        for(int i = 0;i < itemsPokemon.length;i++){
            itemsPokemon[i] = (i+1) + ". " + pokemon[i];
        }
        //returns a ready-to-print array
        return itemsPokemon;
    }
    //add pokemon method
    public boolean addPokemon(String species) {
        boolean check = true;
        //checks the end of the array to see if it's full, changes check
        if (pokemon[pokeNum - 1] != null){
            check = false;
            System.out.println("Max");
        }
        else{
            //checks the array content to see if it's already inside, chenages check
            if(Arrays.asList(pokemon).contains(species)){
                check = false;
                System.out.println("Duplicate");
            }
            //adds species to the array of names, increases the counter for next time's position, doesn't change check
            else{
                pokemon[counter - 1] = species;
                counter++;
            }
        }
        //returns check boolean, if it wasnt changed the pokemon was added
        return check;
    }
    //check stats method
    public int[] checkStats(String species) {
        //initialize our stats array, negative values will be used to check against in main
        //checks to make sure pokemon is in the pokedex so we can get its stats
        if(Arrays.asList(pokemon).contains(species)) {
            if (speciesCheck.equals(species)){

            }
            if (!(speciesCheck.equals(species))) {
                Pokemon Mew = new Pokemon();
                Mew.setSpecies(species);
                Mew.setAttack(1);
                Mew.setDefense(1);
                Mew.setSpeed(1);
                //assign new values to stats array
                stats[0] = Mew.getAttack();
                stats[1] = Mew.getDefense();
                stats[2] = Mew.getSpeed();
            }
        }
        //pokemon not in pokedex
        else{
            System.out.print("Missing\n");
        }
        //return an integer array with the proper values for missing or printing
        return stats;
    }
    //sort the pokedex entries
    public void sortPokedex() {
        int a = 0;
        //get a new string array of proper size without any nulls so sorting doesnt error
        for (String monster:pokemon){
            if (monster != null){
                a++;
            }
        }
        String pokemon2000[] = new String[a];
        for (int i = 0; i < pokemon2000.length; i++){
            pokemon2000[i] = pokemon[i];
        }
        //sort the new array
        Arrays.sort(pokemon2000);
        int i=0;
        //pass back the sorted values to the original
        for (String monster:pokemon2000){
            pokemon[i]=monster;
            i++;
        }
    }
    //evolve the pokemon, values arent sticking is a known problem
    public boolean evolvePokemon(String species) {
        //boolean means we dont need negative int array values for check
        boolean check = true;
        //essentially the same as stats, but with .evolve() thrown in
        if(Arrays.asList(pokemon).contains(species)){
            Pokemon Mewtwo = new Pokemon();
            Mewtwo.setSpecies(species);
            Mewtwo.setAttack(1);
            Mewtwo.setDefense(1);
            Mewtwo.setSpeed(1);
            Mewtwo.evolve();
            stats[0] = Mewtwo.getAttack();
            stats[1] = Mewtwo.getDefense();
            stats[2] = Mewtwo.getSpeed();
            speciesCheck = species;
        }
        else{
            check = false;
            System.out.println("Missing");
        }
        //return the check to know if we are good to print in main
        return check;
    }
}
