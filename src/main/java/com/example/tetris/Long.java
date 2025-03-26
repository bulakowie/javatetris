package com.example.tetris;

public class Long extends Tetromino
{
    public Long() {
        tileRotationState = 0;
        int[][][] t= {{{0, 0, 0, 0}, {0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 0}}, {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}},
                {{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}}, {{0, 1, 0, 0}, {0, 0, 1, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}}};
        tileRotationSchemes = t;
    }
}

