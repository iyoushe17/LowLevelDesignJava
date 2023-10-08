import java.util.Random;

public class Dice {
  int size = 6;
  
  public int roll() {
    Random random = new Random();
    return random.nextInt(6) + 1;
  }
}