package SectionB;

import java.util.Random;

//child class
public class Treasure extends Game {
    
    public Treasure(int gridSize){
        super(new Random().nextInt(gridSize) + 1, 
              new Random().nextInt(gridSize) + 1);
    }
    
    public boolean isFound(int guessX, int guessY) {
        return (getX() == guessX && getY() == guessY);
    }   
}
