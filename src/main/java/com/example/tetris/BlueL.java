package com.example.tetris;

public class BlueL extends Tetromino{


    public BlueL() {
        tileRotationState = 0;
        int[][][] t = {{{1,0,0},{1,1,1},{0,0,0}},{{0,1,1},{0,1,0},{0,1,0}},{{0,0,0},{1,1,1},{0,0,1}},{{0,1,0},{0,1,0},{1,1,0}}};
        tileRotationSchemes= t;
    }
}
