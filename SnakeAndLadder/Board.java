import java.util.*;

public class Board {
  Map<Integer, Integer> snakesMap;
  Map<Integer, Integer> laddersMap;
  
  Board() {
    // mark the snakes and ladders
    initializeSnakesAndLadders();
  }

  private void initializeSnakesAndLadders() {
    snakesMap = new HashMap<>();
    laddersMap = new HashMap<>();
    
    // 5 snakes
    snakesMap.put(29, 6);
    snakesMap.put(54, 37);
    snakesMap.put(63, 29);
    snakesMap.put(85, 44);
    snakesMap.put(99, 2);
    
    // 5 ladders
    laddersMap.put(5, 25);
    laddersMap.put(25, 65);
    laddersMap.put(36, 98);
    laddersMap.put(55, 85);
    laddersMap.put(89, 97);
  }

  public int moveThePlayer(int oldPosition, int moves) {
    // start the game only if 6 is rolled
    if (oldPosition == 0 && moves != 6) {
      // will not move
      return oldPosition;
    }
    int newPosition = oldPosition + moves;
    
    if (snakesMap.containsKey(newPosition)) {
      newPosition = snakesMap.get(newPosition);
      System.out.println("snake bite \uD83D\uDC0D");
    }
    if (laddersMap.containsKey(newPosition)) {
      newPosition = laddersMap.get(newPosition);
      System.out.println("ladder climb \uD83E\uDE9C");
    }
    
    if (newPosition >= 100)
      return 100;
    return newPosition;
  }
}