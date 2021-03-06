/*
 *   gamer of nim
 */

public class NimGamer
{
  public static void main(String[] args) 
  {
    GamePlayer nimGamer = new GamePlayer();
    System.out.println("WELCOME TO THE GAME OF NIM!!! \n");
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
