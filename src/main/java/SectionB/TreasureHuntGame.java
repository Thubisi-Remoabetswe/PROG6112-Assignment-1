package SectionB;

import java.util.Scanner;

public class TreasureHuntGame {
    
    private Player player;
    private Treasure treasure;
    private int gridSize;
    
    public TreasureHuntGame(String playerName, int gridSize, int maxMoves){
        this.player = new Player(playerName, maxMoves);
        this.treasure = new Treasure(gridSize);
        this.gridSize = gridSize;
    }
    
    //user input and grid system
    public void play(){
        Scanner input = new Scanner(System.in);
        int row;
        int col;
        
        boolean found = false;
        
        System.out.println("Welcome to Treasure Hunt " + player.getName() + "!");
        System.out.println("The grid is " + gridSize + "x" + gridSize + ".");
        System.out.println("You have " + player.getMaxMoves() + " moves to find the treasure.");

        while(player.getMovesCount() < player.getMaxMoves() && !found){
            System.out.print("Enter your guess (row col format): ");
            row = input.nextInt();
            col = input.nextInt();
            
             player.makeMove(row, col);

            if (treasure.isFound(row, col)) {
                System.out.println("🎉 You found the treasure!");
                found = true;
            } else {
                System.out.println("Miss!");
            }
        }

        showReport(found);
    }

    //full game report
    public void showReport(boolean found) {
        System.out.println("\n--- Game Report ---");
        System.out.println("Player: " + player.getName());
        System.out.print("Guesses: ");
        for (int i = 0; i < player.getMovesCount(); i++) {
            System.out.print("(" + player.getMoves()[i][0] + "," + player.getMoves()[i][1] + ")");
            if (i < player.getMovesCount() - 1) System.out.print(", ");
        }
        System.out.println();

        if (found) {
            System.out.println("Result: WON in " + player.getMovesCount() + " moves");
        } else {
            System.out.println("Result: LOST! The treasure was at (" + treasure.getX() + "," + treasure.getY() + ")");
        }
    }
    }
            
