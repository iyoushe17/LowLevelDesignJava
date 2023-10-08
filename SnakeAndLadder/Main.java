import java.util.*;


public class Main {
  public static void main(String[] args) {
    Game game = new Game();
    List<String> leaderBoard = game.startGame();
    System.out.println(leaderBoard);
  }
} 