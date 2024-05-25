import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {

	@Test
    public void testPlayerAttributes() {
		// Testing attributes of players
        Player player = new Player(50, 5, 10);
        assertEquals(50, player.getHealth());
        assertEquals(5, player.getStrength());
        assertEquals(10, player.getAttack());
        assertTrue(player.isAlive());
    }

	@Test
    public void testToString() {
		// Testing toString to get proper output
        Player player = new Player(50, 5, 10);
        String expectedString = "Player [health=50, strength=5, attack=10]";
        assertEquals(expectedString, player.toString());
    }

    @Test
    public void testStrengthGetterAndSetter() {
    	//Testing getters and setters for Strength attribute
        Player player = new Player(50, 5, 10);
        assertEquals(5, player.getStrength());
        player.setStrength(8);
        assertEquals(8, player.getStrength());
    }

    @Test
    public void testAttackGetterAndSetter() {
    	//Testing getters and setters for Attack attribute
        Player player = new Player(50, 5, 10);
        assertEquals(10, player.getAttack());
        player.setAttack(15);
        assertEquals(15, player.getAttack());
    }
    
    @Test
    public void testHealthGetterAndSetter() {
    	//Testing getters and setters for Health attribute
        Player player = new Player(50, 5, 10);
        assertEquals(50, player.getHealth());
        player.setHealth(60);
        assertEquals(60, player.getHealth());
    }
    
    @Test
    public void testInvalidPlayerAttributes() {
    	// Testing valid Input 
        try {
            new Player(-1, 5, 10);
        } catch (IllegalArgumentException e) {
            assertEquals("Attributes must be positive integers.", e.getMessage());
        }

        try {
            new Player(50, -1, 10);
        } catch (IllegalArgumentException e) {
            assertEquals("Attributes must be positive integers.", e.getMessage());
        }

        try {
            new Player(50, 5, -1);
        } catch (IllegalArgumentException e) {
            assertEquals("Attributes must be positive integers.", e.getMessage());
        }
    }
    @Test
    public void testReduceHealth() {
        Player player = new Player(50, 5, 10);
        player.healthReduced(20);
        assertEquals(30, player.getHealth());
        player.healthReduced(40);
        assertEquals(0, player.getHealth());
        assertFalse(player.isAlive());
    }

    @Test
    public void testRollDice() {
    	// Testing to get proper random value between 1 and 6
        Player player = new Player(50, 5, 10);
        for (int i = 0; i < 100; i++) {
            int diceRoll = player.rollDice();
            assertTrue(diceRoll >= 1 && diceRoll <= 6);
        }
    }

    @Test
    public void testAttackEffect() {
    	// Testing the effect of the attack
        Player player = new Player(50, 5, 10);
        int diceRoll = 3;
        int expectedAttackEffect = player.attackEffect(diceRoll);
        assertEquals(30, expectedAttackEffect); // 3 * 10
    }

    @Test
    public void testDefenseEffect() {
    	// Testing the defense capability
        Player player = new Player(50, 5, 10);
        int diceRoll = 2;
        int expectedDefenseEffect = player.defenseEffect(diceRoll);
        assertEquals(10, expectedDefenseEffect); // 2 * 5
    }

    @Test
    public void testIsAlive() {
    	// Testing the find out the player is alive or not
        Player player = new Player(50, 5, 10);
        assertTrue(player.isAlive());
        player.healthReduced(50);
        assertFalse(player.isAlive());
    }

}
