import java.util.Scanner;
import java.util.Random;

public class GamePlayer // game function
{
  //declare variables
  private int playerOneScore;
  private int playerTwoScore;
  private int piecesRemoved;
  private int playerInput;
  private int currentPlayer;
  private bool gameRun = true;
  private bool roundRun = true;
  //random number class
  private Random rando = new Random();
  //board generation class
  private Board nimGame = new Board();
  //scanner class
  private Scanner sc = new Scanner(System.in);

  public void setupVars()
  {
    gameRun = true;
    roundRun = true;
  }

  public void playerMove() //code for player making move
  {
    System.out.print("Your turn, ");
    System.out.println(currentPlayer);
    System.out.print("There are ");
    System.out.print(nimGame.printBoard());
    System.out.print(" pieces left on the board.");
    piecesRemoved = sc.nextInt();
    nimGame.removePiece(piecesRemoved);
  }

  public void startGame() //starts a round of nim
  {
    System.out.println("Start round of nim? (1) yes or (2) no ");
    playerInput = sc.nextInt();
    if (playerInput == 1)
    {
      nimGame.generateBoard();
      currentPlayer = rando.nextInt(2);
      roundRun = true;
    }
    if (playerInput == 2)
    {
      roundRun = false;
      System.out.print(player);
    }
    else
    {
      System.out.println("─────────▄──────────────▄"); //le funny doge
      System.out.println("────────▌▒█───────────▄▀▒▌");
      System.out.println("────────▌▒▒▀▄───────▄▀▒▒▒▐");
      System.out.println("───────▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐");
      System.out.println("─────▄▄▀▒▒▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐");
      System.out.println("───▄▀▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▀██▀▒▌");
      System.out.println("──▐▒▒▒▄▄▄▒▒▒▒▒▒▒▒▒▒▒▒▒▀▄▒▒▌");
      System.out.println("──▌▒▒▐▄█▀▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐");
      System.out.println("─▐▒▒▒▒▒▒▒▒▒▒▒▌██▀▒▒▒▒▒▒▒▒▀▄▌");
      System.out.println("─▌▒▀▄██▄▒▒▒▒▒▒▒▒▒▒▒░░░░▒▒▒▒▌");
      System.out.println("─▌▀▐▄█▄█▌▄▒▀▒▒▒▒▒▒░░░░░░▒▒▒▐");
      System.out.println("▐▒▀▐▀▐▀▒▒▄▄▒▄▒▒▒▒▒░░░░░░▒▒▒▒▌");
      System.out.println("▐▒▒▒▀▀▄▄▒▒▒▄▒▒▒▒▒▒░░░░░░▒▒▒▐");
      System.out.println("─▌▒▒▒▒▒▒▀▀▀▒▒▒▒▒▒▒▒░░░░▒▒▒▒▌");
      System.out.println("─▐▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▐");
      System.out.println("──▀▄▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▄▒▒▒▒▌");
      System.out.println("────▀▄▒▒▒▒▒▒▒▒▒▒▄▄▄▀▒▒▒▒▄▀");
      System.out.println("───▐▀▒▀▄▄▄▄▄▄▀▀▀▒▒▒▒▒▄▄▀");
    }
  }

  public void checkWin() //check if board is empty
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

  public void printScores() //print out player scores
  {
    System.out.print("Player one's score is ");
    System.out.println(playerOneScore);
    System.out.print("Player two's score is ");
    System.out.println(playerTwoScore);
  }

  public bool gameRunVar() //function the outputs the gameRun var
  {
    return gameRun;
  }

  public bool roundRunVar() //function that outputs the roundRun var
  {
    return roundRun;
  }
}