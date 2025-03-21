package com.example.tetris;

public class RedZ extends Tetromino{
    public RedZ ()
    {
        tileRotationState = 0;
        int[][][] tileRotationSchemes = {{{1,1,0},{0,1,1},{0,0,0}}, {{0,0,1},{0,1,1},{0,1,0}},{{0,0,0},{1,1,0},{0,1,1}},{{0,1,0},{1, 1,0},{1,0,0}}};

    }
}
