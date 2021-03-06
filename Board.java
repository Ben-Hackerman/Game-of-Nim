import java.util.Random;

//board logic
public class Board
{
  private int size; // size is variable 

  public void generateBoard() //create the board
  {
    Random randy = new Random();
    while (size <= 10)
    {
      size = randy.nextInt(50);
    }
  }

  public boolean removePiece(Integer remove) //code to remove pieces from board
  {
    if (remove > 1)
    {
      if (remove > (size / 2))
      {
        System.out.println("Too many pieces! You can only remove one half of the pile or less!");
        return false;
      }
    }
    size = size - remove;
    return true;
  }

  public int printBoard() //export out board
  {
    return size;
  }

  public boolean checkEnd() //check if game has been won
  {
    if (size <= 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}