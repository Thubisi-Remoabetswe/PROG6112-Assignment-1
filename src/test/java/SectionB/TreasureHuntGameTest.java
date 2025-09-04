package SectionB;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

//unit tests
public class TreasureHuntGameTest {
    
    private Player player;
    private Treasure treasure;
    
    @BeforeEach
    public void setup() {
        player = new Player("TestPlayer", 5);
        treasure = new Treasure(5); // grid size 5x5
    }

    @Test
    public void testTreasureHuntGrid() {
        int x = treasure.getX();
        int y = treasure.getY();
        assertTrue(x >= 1 && x <= 5, "Treasure X should be within grid bounds");
        assertTrue(y >= 1 && y <= 5, "Treasure Y should be within grid bounds");
    }

    @Test
    public void testPlayerMoves() {
        player.makeMove(1, 2);
        player.makeMove(3, 4);
        assertEquals(2, player.getMovesCount(), "Player should have made 2 moves");
        assertArrayEquals(new int[]{1, 2}, player.getMoves()[0], "First move should be (1,2)");
        assertArrayEquals(new int[]{3, 4}, player.getMoves()[1], "Second move should be (3,4)");
    }
    
    @Test
    public void testTreasure() {
    Treasure fixed = new Treasure(5) {
            { setX(2); setY(3); }
        };
        assertTrue(fixed.isFound(2, 3), "Treasure should be found at (2,3)");
        assertFalse(fixed.isFound(1, 1), "Treasure should not be found at (1,1)");
    }
}
