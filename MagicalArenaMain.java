
public class MagicalArenaMain {
	public static void main(String[] args) {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        System.out.println("Player A: " + playerA);
        System.out.println("Player B: " + playerB);

        Arena arena = new Arena(playerA, playerB);
        arena.attack();

        if (playerA.isAlive()) {
            System.out.println("Player A wins the game!");
        } else {
            System.out.println("Player B wins the game!");
        }
    }

}
