package SectionB;

import java.util.Scanner;

//main class, runs the code
public class MainGame {
    
    public static void main(String[] args) {
        
        String name;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter your name: ");
        name = input.nextLine();
        
        TreasureHuntGame game = new TreasureHuntGame(name, 5, 5);
        game.play();
    }
}