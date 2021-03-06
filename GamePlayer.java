import java.util.Scanner;
import java.util.Random;

public class GamePlayer // game function
{
  //declare variables
  private int playerOneScore = 0;
  private int playerTwoScore = 0;
  private int piecesRemoved;
  private int playerInput;
  private int currentPlayer = 0;
  private boolean gameRun = true;
  private boolean roundRun = true;
  //random number class
  private Random rando = new Random();
  //board generation class
  private Board nimGame = new Board();
  //scanner class
  private Scanner sc = new Scanner(System.in);

  private void playerMove() //code for player making move
  {
    System.out.print("There are ");
    System.out.print(nimGame.printBoard());
    System.out.print(" pieces left on the board. ");
    System.out.print("How many pieces do you want to remove, ");
    if (currentPlayer == 1)
    {
      System.out.println("Player One?");
    }
    if (currentPlayer == 2)
    {
      System.out.println("Player Two?");
    }
    piecesRemoved = sc.nextInt();
    nimGame.removePiece(piecesRemoved);
  }

  private void startGame() //starts a round of nim
  {
    System.out.println("\n(1) Start round of NIM, (2) get scores, (3) quit");
    playerInput = sc.nextInt();
    if (playerInput == 1)
    {
      nimGame.generateBoard();
      while (currentPlayer == 0)
      {
        currentPlayer = rando.nextInt(2);
      }
      roundRun = true;
    }
    if (playerInput == 2)
    {
      roundRun = false;
    }
    if (playerInput == 3)
    {
      System.out.println("Thanks for playing THE GAME OF NIM!");
      roundRun = false;
      gameRun = false;
      System.exit(0);
    }
  }

  private void checkWin() //check if board is empty
  {
    if(nimGame.checkEnd() == true)
    {
      roundRun = false;
      if(currentPlayer == 1)
      {
        playerTwoScore++;
      }
      if(currentPlayer == 2)
      {
        playerOneScore++;
      }
      this.printScores();
    }
    if(nimGame.checkEnd() == false)
    {
      if(currentPlayer == 1)
      {
        currentPlayer = 2;
      }
      if(currentPlayer == 2)
      {
        currentPlayer = 1;
      }
    }
  }

  private void printScores() //print out player scores
  {
    System.out.print("Player 1 score: ");
    System.out.println(playerOneScore);
    System.out.print("Player 2 score: ");
    System.out.println(playerTwoScore);
  }

  private boolean gameRunVar() //function the outputs the gameRun var
  {
    return gameRun;
  }

  private boolean roundRunVar() //function that outputs the roundRun var
  {
    return roundRun;
  }

  public void play()
  {
    while (this.gameRunVar()) // game loop
    {
      this.startGame();
      while (this.roundRunVar()) // round loop
      {
        this.playerMove();
        this.checkWin();
      }
      this.printScores(); //print scores after each round
    }
  }
}