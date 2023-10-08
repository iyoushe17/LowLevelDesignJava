import java.util.*;

public class Game {
  Board board;
  Deque<Player> players;
  Dice dice;
  List<String> leaderBoard;

  Game() {
    initializeGame();
  }

  private void initializeGame() {

    this.board = new Board();
    this.leaderBoard = new ArrayList<>();
    this.dice = new Dice();

    // initialize player data
    getPlayerData();
  }

  public List<String> startGame() {
    while (players.size() > 1) {

      // retreive the current player
      Player currentPlayer = players.removeFirst();

      // retrieve the lastPosition
      int lastPosition = currentPlayer.getLastPosition();

      // roll the dice 
      int steps = dice.roll();
      System.out.println(currentPlayer.name + " rolled " + steps);

      // alter the position of the player
      int newPosition = board.moveThePlayer(lastPosition, steps);
      currentPlayer.setNewPosition(newPosition);
      System.out.println("Last Position: " + lastPosition + " Current Position: " + newPosition);
      System.out.flush();

      // check if they stay in the game
      if (newPosition == 100) {
        // player wins, added to the leaderboard
        System.out.println(currentPlayer.name + " wins! \uD83C\uDF89");
        this.leaderBoard.add(currentPlayer.name);
      } else {
        // player stays in the game
        players.addLast(currentPlayer);
      }
    }
    this.leaderBoard.add(players.removeFirst().name);
    return this.leaderBoard;
  }

  private void getPlayerData() {
    this.players = new ArrayDeque<>();
    int totalPlayers;
    Scanner intInput = new Scanner(System.in);
    Scanner stringInput = new Scanner(System.in);

    System.out.print("Please input the number of players: ");
    totalPlayers = intInput.nextInt();

    String name;
    for (int i = 0; i < totalPlayers; i++) {
      System.out.print("Please input name of Player " + (i + 1) + ": ");
      name = stringInput.nextLine();
      Player player = new Player(name);
      this.players.add(player);
    }
    intInput.close();
    stringInput.close();
  }
}