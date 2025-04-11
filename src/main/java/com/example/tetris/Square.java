package com.example.tetris;

public class Square extends Tetromino{
    public Square() {
        tileRotationState = 0;
        int [][][] t = {{{1,1,0}, {1,1,0}, {0,0,0}}, {{1,1,0},{1,1,0},{1,1,0}},  {{1,1,0},{1,1,0},{1,1,0}},  {{0,0,0},{1,1,0},{1,1,0}}};
        tileRotationSchemes = t;
    }
}