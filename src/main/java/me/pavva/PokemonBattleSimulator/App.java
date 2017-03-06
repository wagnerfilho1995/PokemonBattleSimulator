package me.pavva.PokemonBattleSimulator;

import java.util.Scanner; //User input
import java.util.Random; //Random numbers


class Pokemon { //Pokemon Object Constructors and get-set methods

    private String name;
    private String type;
    private double health;
    private int    usedMove;
    private String move1;
    private String move2;
    private String move3;
    private String move4;

    public Pokemon(String pokemon_name,
                   String pokemon_type,
                   double pokemon_health,
                   int pokemon_used_move,
                   String pokemon_move1,
                   String pokemon_move2,
                   String pokemon_move3,
                   String pokemon_move4) {

        this.name = pokemon_name;
        this.type = pokemon_type;
        this.health = pokemon_health;
        this.usedMove = pokemon_used_move;
        this.move1 = pokemon_move1;
        this.move2 = pokemon_move2;
        this.move3 = pokemon_move3;
        this.move4 = pokemon_move4;

    }

    public Pokemon() {
        this.name = null;
        this.type = null;
        this.health = 0.0;
        this.usedMove = 0;
        this.move1 = null;
        this.move2 = null;
        this.move3 = null;
        this.move4 = null;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setType(String type) {

        this.type = type;
    }

    public void setHealth(double health) {

        this.health = health;
    }

    public void setUsedMove(int usedMove) {

        this.usedMove = usedMove;
    }

    public void setMove1(String move1) {

        this.move1 = move1;
    }

    public void setMove2(String move2) {

        this.move2 = move2;
    }

    public void setMove3(String move3) {

        this.move3 = move3;
    }

    public void setMove4(String move4) {

        this.move4 = move4;
    }

    public String getName() {

        return this.name;
    }

    public String getType() {

        return this.type;
    }

    public double getHealth() {

        return this.health;
    }

    public int getUsedMove() {

        return this.usedMove;
    }

    public String getMove1() {

        return this.move1;
    }

    public String getMove2() {

        return this.move2;
    }

    public String getMove3() {

        return this.move3;
    }

    public String getMove4() {

        return this.move4;
    }

}

public class App { //Contains public static void main(String[] args) and the main game loop within

	public static void battle(Pokemon yourPoke, Pokemon opponentPoke,  Pokemon[] poke){
		
		Scanner s = new Scanner(System.in); //Used for User Input
        Random rand = new Random(); //Random Numbers
    	
		int yourPick;
	    int opponentPick;
		
        while (yourPoke.getHealth() > 0.0 && opponentPoke.getHealth() > 0.0) {
        	
        	System.out.println("********* BATTLE *********");
             
            System.out.println("Your " + yourPoke.getName() + " has " + yourPoke.getHealth() + " health left.");
            System.out.println("The foe's " + opponentPoke.getName() + " has " + opponentPoke.getHealth() + " health left.\n");
            System.out.println("Your " + yourPoke.getName() + " knows");
            System.out.println("1 - " + yourPoke.getMove1() + "		;	2 - " + yourPoke.getMove2());
            System.out.println("3 - " + yourPoke.getMove3() + "		;	4 - " + yourPoke.getMove4());
            System.out.println("Type the number corresponding to the move you would like " + yourPoke.getName() + " to use. Select '5' to switch out to a different Pokemon.");
            yourPoke.setUsedMove(s.nextInt());

            if (yourPoke.getUsedMove() == 1) {

                opponentPoke.setHealth(opponentPoke.getHealth() - 20);
                System.out.println(yourPoke.getName() + " used " + yourPoke.getMove1() + " !");

            } else if (yourPoke.getUsedMove() == 2) {

                opponentPoke.setHealth(opponentPoke.getHealth() - 18);
                System.out.println(yourPoke.getName() + " used " + yourPoke.getMove2() + " !");

            } else if (yourPoke.getUsedMove() == 3) {

                opponentPoke.setHealth(opponentPoke.getHealth() - 25);
                yourPoke.setHealth(yourPoke.getHealth() - 5);
                System.out.println(yourPoke.getName() + " used " + yourPoke.getMove3() + " !");

            } else if (yourPoke.getUsedMove() == 4) {

                opponentPoke.setHealth(opponentPoke.getHealth() - 30);
                yourPoke.setHealth(yourPoke.getHealth() - 10);
                System.out.println(yourPoke.getName() + " used " + yourPoke.getMove4() + " !");
                
            }                
            else {
                
                s.close();
                throw new IllegalArgumentException("Please enter a number between 1 and 4, inclusive");

            }
            
            if (opponentPoke.getUsedMove() == 1) {

                yourPoke.setHealth(yourPoke.getHealth() - 20);
                System.out.println("The foe's " + opponentPoke.getName() + " used " + opponentPoke.getMove1() + "\n");

            } else if (opponentPoke.getUsedMove() == 2) {

                yourPoke.setHealth(yourPoke.getHealth() - 20);
                System.out.println("The foe's " + opponentPoke.getName() + " used " + opponentPoke.getMove2() + "\n");

            } else if (opponentPoke.getUsedMove() == 3) {

                yourPoke.setHealth(yourPoke.getHealth() - 25);
                opponentPoke.setHealth(opponentPoke.getHealth() - 5);
                System.out.println("The foe's " + opponentPoke.getName() + " used " + opponentPoke.getMove3() + "\n");

            } else if (opponentPoke.getUsedMove() == 4) {

                yourPoke.setHealth(yourPoke.getHealth() - 30);
                opponentPoke.setHealth(opponentPoke.getHealth() - 10);
                System.out.println("The foe's " + opponentPoke.getName() + " used " + opponentPoke.getMove4() + "\n");

            }

            if (yourPoke.getHealth() < 0.0 && opponentPoke.getHealth() > 0.0) {
                
                System.out.println("Sorry, but your opponent won.");
                System.out.println(yourPoke.getName() + " has fainted.");
                System.out.println(opponentPoke.getName() + " has " + opponentPoke.getHealth() + " health left.");

            } else if (yourPoke.getHealth() > 0.0 && opponentPoke.getHealth() < 0.0) {
                
                System.out.println("Congratulations! You won!");
                System.out.println(opponentPoke.getName() + " has fainted.");
                System.out.println(yourPoke.getName() + " has " + yourPoke.getHealth() + " health left.");

            }

            opponentPoke.setUsedMove(rand.nextInt(4));

            if (opponentPoke.getUsedMove() == 1) {

                yourPoke.setHealth(yourPoke.getHealth() - 20);
                System.out.println("The foe's " + opponentPoke.getName() + " used " + opponentPoke.getMove1() + "\n");

            } else if (opponentPoke.getUsedMove() == 2) {

                yourPoke.setHealth(yourPoke.getHealth() - 20);
                System.out.println("The foe's " + opponentPoke.getName() + " used " + opponentPoke.getMove2() + "\n");

            } else if (opponentPoke.getUsedMove() == 3) {

                yourPoke.setHealth(yourPoke.getHealth() - 25);
                opponentPoke.setHealth(opponentPoke.getHealth() - 5);
                System.out.println("The foe's " + opponentPoke.getName() + " used " + opponentPoke.getMove3() + "\n");

            } else if (opponentPoke.getUsedMove() == 4) {

                yourPoke.setHealth(yourPoke.getHealth() - 30);
                opponentPoke.setHealth(opponentPoke.getHealth() - 10);
                System.out.println("The foe's " + opponentPoke.getName() + " used " + opponentPoke.getMove4() + "\n");

            }

            if (yourPoke.getHealth() < 0.0 && opponentPoke.getHealth() > 0.0) {
                
                System.out.println("Sorry, but your opponent won.");
                System.out.println(yourPoke.getName() + " has fainted.");
                System.out.println(opponentPoke.getName() + " has " + opponentPoke.getHealth() + " health left.");

            } else if (yourPoke.getHealth() > 0.0 && opponentPoke.getHealth() < 0.0) {
                
                System.out.println("Congratulations! You won!");
                System.out.println(opponentPoke.getName() + " has fainted.");
                System.out.println(yourPoke.getName() + " has " + yourPoke.getHealth() + " health left.");

            }

        }
		
	}
	
    public static void main(String[] args) throws IllegalArgumentException {

        final String ANSI_RESET = "\u001B[0m"; //ANSI Color Codes
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";

        final String ANSI_BLACK_BACKGROUND = "\u001B[40m"; //ANSI Background Color Codes
        final String ANSI_RED_BACKGROUND = "\u001B[41m";
        final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

        Scanner s = new Scanner(System.in); //Used for User Input
        Random rand = new Random(); //Random Numbers
        
        int play = 1;
        
        while(play == 1){
        
	        int aux = 0;
	        
	        Pokemon Chimchar = new Pokemon("Chimchar", "fire", 120, 0, "Flamethrower", "Flame Charge", "Tackle", "Skull Bash");
	        Pokemon Bulbasaur = new Pokemon("Bulbasaur", "grass", 120, 0, "Energy Ball", "Solar Ball", "Vine Whip", "Tackle");
	        Pokemon Squirtle = new Pokemon("Squirtle", "water", 120, 0, "Aqua Jet", "Hydro Cannon", "Skull Bash", "Crunch");
	        Pokemon Pikachu = new Pokemon("Pikachu", "eletric", 120, 0, "Thunder", "ThunderShock", "Slam", "Quick Attack");
	
	        Pokemon[] poke = new Pokemon[]{Chimchar, Bulbasaur, Squirtle, Pikachu};
	        
	        Pokemon yourPoke = new Pokemon();
	        Pokemon opponentPoke = new Pokemon();
	        
	        while(aux == 0){
		
	        	System.out.println("******** POKEBALLS *********");
		        
		        for (int i = 0; i < poke.length; i++) {
		
		            System.out.println((i+1) + " - " + poke[i].getName() + " is of type " + poke[i].getType() + ". It has " + poke[i].getHealth()
		                               + " health points and it knows " + poke[i].getMove1() + ", " + poke[i].getMove2() + ", "
		                               + poke[i].getMove3() + ", " + poke[i].getMove4() + ".");
		
		        }
		
		        System.out.println("\nChoose the number that corresponds to the Pokemon you would like to play with in the list above.");
		        int yourPick = s.nextInt();
		        int opponentPick = rand.nextInt(poke.length);
		    
		        yourPoke = poke[yourPick - 1];
		        opponentPoke = poke[opponentPick];
		       
		        if (yourPick > poke.length || yourPick < 0) {
		            s.close();
		            throw new IllegalArgumentException("\n\n" + ANSI_RESET + ANSI_RED + "Please pick an integer between 1 and " + poke.length + ", inclusive.\n"
		                                               + ANSI_RESET);
		        }
		        
		        System.out.println("You have selected " + yourPoke.getName() + "!");
		        System.out.println("Your opponent has selected " + opponentPoke.getName() + "!");
		        
		        System.out.println("\nWanna change?");
		        System.out.println("0 - Yes");
		        System.out.println("1 - No");
		        aux = s.nextInt();
	        }
	        
	        battle(yourPoke, opponentPoke, poke);
	 
	        System.out.println("\nWanna play again?");
	        System.out.println("0 - No");
	        System.out.println("1 - Yes");
	        play = s.nextInt();
	    
        }
        
        s.close();

    }
}