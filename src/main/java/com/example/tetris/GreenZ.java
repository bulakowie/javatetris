package com.example.tetris;

public class GreenZ extends Tetromino{
    public GreenZ ()
    {
        tileRotationState = 0;
        int[][][] t = {{{0,1,1},{1,1,0},{0,0,0}},{{0,1,0},{0,1,1},{0,0,1}},{{0,0,0},{0,1,1},{1,1,0}},{{1,0,0},{1, 1,0},{0,1,0}}};
tileRotationSchemes = t;
    }
}
