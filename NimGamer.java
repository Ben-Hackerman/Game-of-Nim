/*
 *   gamer of nim
 */
import java.util.Random;
import java.util.Scanner;

public class NimGamer
{
  public static void main(String[] args) 
  {
    GamePlayer nimGamer = new GamePlayer();
    nimGamer.setupVars();
    while (nimGamer.gameRunVar()) // game loop
    {
      nimGamer.startGame();
      while (nimGamer.roundRunVar()) // round loop
      {
        nimGamer.playerMove();
        nimGamer.checkWin();
      }
      nimGamer.printScores(); //print scores after each round
    }
  }
} 
