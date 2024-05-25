
public class Arena {
	private Player playerA;
    private Player playerB;

    public Arena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void attack() {
    	// Choosing the player with low health to attack first
    	Player firstAttacker = playerA.getHealth() <= playerB.getHealth() ? playerA : playerB;
        Player secondAttacker = firstAttacker == playerA ? playerB : playerA;

        while (playerA.isAlive() && playerB.isAlive()) {
            fight(firstAttacker, secondAttacker);
            if (secondAttacker.isAlive()) {
                fight(secondAttacker, firstAttacker);
            }
        }
        // Checking the player is alive or not
        if (!playerA.isAlive()) {
            System.out.println("Player A has been defeated!!!");
        } else {
            System.out.println("Player B has been defeated!!!");
        }
    }

    public void fight(Player attacker, Player defender) {
        int attackerDiceRoll = attacker.rollDice();     // Output of the Attacker by rolling the dice
        int defenderDiceRoll = defender.rollDice();     // Output of the Defender by rolling the dice

        int attackEffect = attacker.attackEffect(attackerDiceRoll);   // Effect of Attacking by Attacker
        int defenseEffect = defender.defenseEffect(defenderDiceRoll);  // Ability to defend by the defender

        int healthLoss = Math.max(0, attackEffect - defenseEffect);    // Amount of health lost by the defender
        defender.healthReduced(healthLoss);                            // Updating the health of the defender

        System.out.printf("%s attacks %s!\nAttack roll: %d, Defense roll: %d, Attack effect: %d, Defense effect: %d, Health Lost: %d, Defender's health: %d%n",
                attacker == playerA ? "Player A" : "Player B",
                defender == playerA ? "Player A" : "Player B",
                attackerDiceRoll, defenderDiceRoll, attackEffect, defenseEffect, healthLoss, defender.getHealth());
    }

}
