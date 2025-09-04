package SectionB;

public class Player extends Game{
    
    private String name;
    private int maxMoves;
    private int movesCount;
    private int [][] moves;
    
    public Player(String name, int maxMoves){
        super(0,0);
        this.name = name;
        this.maxMoves = maxMoves;
        this.movesCount = 0;
        this.moves = new int[maxMoves][2];
    }
    
    public void makeMove(int row, int col){
        if (movesCount < maxMoves){
            moves[movesCount][0] = row;
            moves[movesCount][1] = col;
            movesCount++;
        }
    }
    
    public String getName(){
        return name;
    }
    
    public int getMaxMoves(){
        return maxMoves;
    }
    
    public int getMovesCount(){
        return movesCount;
    }
    
    public int[][] getMoves(){
        return moves;
    }
    
}
