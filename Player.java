
public class Player {

	 	private int health;
	 	private int strength;
	    private int attack;

	    public Player(int health, int strength, int attack) {
	        if (health <= 0 || strength <= 0 || attack <= 0) {
	            throw new IllegalArgumentException("Attributes must be positive integers.");
	        }
	        this.health = health;
	        this.strength = strength;
	        this.attack = attack;
	    }
	    // Getters and Setters for Health Attribute
	    public int getHealth() {
			return health;
		}

		public void setHealth(int health) {
			this.health = health;
		}
	    // Getters and Setters for Strength Attribute
		public int getStrength() {
			return strength;
		}

		public void setStrength(int strength) {
			this.strength = strength;
		}
	    // Getters and Setters for Attack Attribute
		public int getAttack() {
			return attack;
		}

		public void setAttack(int attack) {
			this.attack = attack;
		}

		public void healthReduced(int amount) {
	        this.health = Math.max(0, this.health - amount);
	    }

	    public int rollDice() {
	        return (int) (Math.random() * 6) + 1;
	    }

	    public int attackEffect(int diceRoll) {
	        return this.attack * diceRoll;
	    }

	    public int defenseEffect(int diceRoll) {
	        return this.strength * diceRoll;
	    }

	    public boolean isAlive() {
	        return this.health > 0;
	    }

		@Override
		public String toString() {
			return "Player [health=" + health + ", strength=" + strength + ", attack=" + attack + "]";
		}   
}


