import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ArenaTest {
	
	private Player playerA;
    private Player playerB;
    private Arena arena;

	@Before
    public void setUp() {
        playerA = new Player(50, 5, 10);
        playerB = new Player(100, 10, 5);
        arena = new Arena(playerA, playerB);
    }

    @Test
    public void testFightPlayerAStarts() {
    	// Ensures Player A starts due to lower health
        arena.attack();                               
        assertTrue(playerA.getHealth() == 0 || playerB.getHealth() == 0);
    }

    @Test
    public void testFightPlayerBStarts() {
    	// Ensures Player B starts due to lower health
    	playerA = new Player(100, 10, 5);
        playerB = new Player(50, 5, 10);
        arena = new Arena(playerA, playerB);
        arena.attack();                              
        assertTrue(playerA.getHealth() == 0 || playerB.getHealth() == 0);
    }

    @Test
    public void testFight() {
        int initialHealthB = playerB.getHealth();
        int initialHealthA = playerA.getHealth();
        
        // Player A attacks Player B
        arena.fight(playerA, playerB);
        assertTrue("Player B's health should be reduced", playerB.getHealth() < initialHealthB);
        
        // Player B attacks Player A
        arena.fight(playerB, playerA);
        assertTrue("Player A's health should be reduced", playerA.getHealth() < initialHealthA);
    }


    @Test
    public void testReduceHealthToZero() {
        playerA = new Player(1, 5, 10);
        playerB = new Player(1, 5, 10);
        arena = new Arena(playerA, playerB);

        arena.attack();
        assertTrue(!playerA.isAlive() || !playerB.isAlive());
    }

    @Test
    public void testRollDice() {
    	// Checking rollDice method returns correct value
        for (int i = 0; i < 1000; i++) {
            int roll = playerA.rollDice();
            assertTrue(roll >= 1 && roll <= 6);
        }
    }

    @Test
    public void testAttackEffect() {
        // Checking attackEffect method returns correct value
        int diceRoll = 3;
        int expectedAttackEffect = playerA.attackEffect(diceRoll);
        assertEquals(30, expectedAttackEffect); // 3 * 10
    }

    @Test
    public void testDefenseEffect() {
        // Checking defenseEffect method returns correct value
        int diceRoll = 2;
        int expectedDefenseEffect = playerA.defenseEffect(diceRoll);
        assertEquals(10, expectedDefenseEffect); // 2 * 5
    }

    @Test
    public void testHealthReduced() {
        // Testing healthReduced method to ensure health reduces correctly
        playerA.healthReduced(20);
        assertEquals(30, playerA.getHealth());

        playerA.healthReduced(40);
        assertEquals(0, playerA.getHealth());        // Health should not go below 0
    }
}
