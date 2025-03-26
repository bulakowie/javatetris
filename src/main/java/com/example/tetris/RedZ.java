package com.example.tetris;

public class RedZ extends Tetromino{
    public RedZ ()
    {
        tileRotationState = 0;
        int[][][] t = {{{1,1,0},{0,1,1},{0,0,0}}, {{0,0,1},{0,1,1},{0,1,0}},{{0,0,0},{1,1,0},{0,1,1}},{{0,1,0},{1, 1,0},{1,0,0}}};
tileRotationSchemes = t;
    }
}
