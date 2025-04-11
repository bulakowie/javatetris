package com.example.tetris;

public class T_Piece extends  Tetromino {
    public T_Piece()
    {
        tileRotationState = 0;
        int[][][] t = {{{0,1,0},{1,1,1},{0,0,0}},{{0,1,0},{0,1,1},{0,1,0}},{{1,1,1},{0,1,0},{0,0,0}},{{0,1,0},{1, 1,0},{0,1,0}}};
tileRotationSchemes = t;
    }
}
