import java.util.Random;

public class GameEngine
{
    int[][] board = new int[10][20];
    boolean isThePieceDropping = false;
    public void start()
    {
        Tetromino[] allPieces={new Long(),new BlueL(), new OrangeL(), new T_Piece(),new Square(), new GreenZ(), new RedZ()};

        if (!isThePieceDropping)
        {
            spawnPiece();
            isThePieceDropping = true;
        }
        else
        {
            //if (!update())
              //  isThePieceDropping = false;
        }
    }
    public void spawnPiece()
    {
        Random rand = new Random();
        int n = rand.nextInt(7);
        n+=1;

    }
}
