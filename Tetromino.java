public abstract class Tetromino
{
    int tileRotationState;
    int[][][] tileRotationSchemes;
    int[][] rotateLeft(int a)
    {
        return tileRotationSchemes[a+1];
    }
    int[][] rotateRight(int a)
    {
        if (a==0) a=4;
        return tileRotationSchemes[a-1];

    }
}
