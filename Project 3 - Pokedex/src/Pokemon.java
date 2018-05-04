public class Pokemon extends Pokedex {
    private int attack;
    private int defense;
    private int speed;
    private String species;

    public Pokemon(){
        attack = 0;
        defense = 0;
        speed = 0;
        species = "";
    }
    public int getAttack(){
        return attack;
    }
    public void setAttack(int newAttack){
        newAttack = species.length() * 4 + 2;
        attack = newAttack;
    }
    public int getDefense(){
        return defense;
    }
    public void setDefense(int newDefense){
        newDefense = species.length() * 2 + 7;
        defense = newDefense;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int newSpeed){
        newSpeed = species.length() * 3 + 5;
        speed = newSpeed;
    }
    public String getSpecies(){
        return species;
    }
    public void setSpecies(String newSpecies){
        species = newSpecies.substring(0,1).toUpperCase() + newSpecies.substring(1).toLowerCase();
    }
    public void evolve(){
        speed = speed * 2;
        attack = attack * 3;
        defense = defense * 5;
    }
}