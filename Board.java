import java.util.Random;

//board logic
public class Board
{
  private int size; // size is variable 

  void generateBoard()
  {
    Random randy = new Random();
    while (size >= 10)
    {
      size = randy.nextInt(50);
    }
  }

  bool removePiece(Integer remove) //code to remove pieces from board
  {
    if (remove > size)
    {
      return false;
    }
    if ((size / 2) > remove)
    {
      return false;
    }
    size = size - remove;
    return true;
  }

  int printBoard() //export out board
  {
    return size;
  }

  bool checkEnd() //check if game has been won
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