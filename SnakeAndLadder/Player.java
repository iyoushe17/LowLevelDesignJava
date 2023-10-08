import java.util.*;

public class Player {
  String name;
  int lastPosition;

  Player(String name) {
    this.lastPosition = 0;
    this.name = name;
  }
  
  public int getLastPosition() {
    return this.lastPosition;
  }

  public void setNewPosition(int newPosition) {
    this.lastPosition = newPosition;
  }
} 