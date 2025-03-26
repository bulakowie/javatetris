package com.example.tetris;

public class OrangeL extends Tetromino{
    public OrangeL() {
        tileRotationState = 0;

        int[][][] t = {{{0,0,1},{1,1,1},{0,0,0}},{{0,1,0},{0,1,0},{0,1,1}},{{0,0,0},{1,1,1},{1,0,0}},{{1,1,0},{0,1,0},{0,1,0}}};
tileRotationSchemes = t;
    }
}
