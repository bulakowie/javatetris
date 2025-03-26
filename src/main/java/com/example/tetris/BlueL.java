package com.example.tetris;

public class BlueL extends Tetromino{
    int[][][] tileRotationSchemes = {{{1,0,0},{1,1,1},{0,0,0}},{{0,1,1},{0,1,0},{0,1,0}},{{0,0,0},{1,1,1},{0,0,1}},{{0,1,0},{0,1,0},{1,1,0}}};

    public BlueL() {
        tileRotationState = 0;
    }
}
