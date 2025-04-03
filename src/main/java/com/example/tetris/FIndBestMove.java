package com.example.tetris;

import kotlin.Pair;

public class FIndBestMove {
    public Pair<Integer,Integer> getMove (int [][] board, Tetromino block)
    {
        int bestMoveIndex =-1;
        int bestRotationIndex = -1;

        int bestGapsLeft = 99999;
        int bestSmallestHeight = 99999;

        int[][] placeholderBoard = new int[10][23];
        for (int rotate=0; rotate <4; rotate++)
        for (int index=0; index<9; index++)
        {
                placeholderBoard = hardDrop(board,block,rotate,index);
                for (int i=0; i<10; i++) {
                    for (int j = 0; j < 23; j++)
                    {
                        if (board[i][j]==2 && i<bestSmallestHeight)
                        {
                            bestMoveIndex = index;
                            bestRotationIndex = rotate;
                        }
                    }
                }
        }

        return new Pair<Integer, Integer>(bestMoveIndex,bestRotationIndex);
    }
    public int[][] hardDrop (int[][] board, Tetromino block, int rotation, int position)
    {
        for (int i=position; i<4+position; i++)
            for (int j = 0; j<4; j++)
            {
                if (i !=3 && j!=3) {
                    if (block.tileRotationSchemes[rotation][i-position][j] == 1)
                        board[i][j+1] = 2;
                }
                else if (block instanceof Long || block instanceof Square)
                {
                    if (block.tileRotationSchemes[0][i-position][j] == 1)
                        board[i][j+1] = 2;

                }
            }
        boolean HardDropping = true;
        while (HardDropping)
        {
            int [][] TetrisChange = new int[10][23];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20 + 3; j++) {
                    if (board[i][j] == 2) {
                        TetrisChange[i][j + 1] = 2;
                        if (j + 1 == 12) HardDropping = false;
                        else if (board[i][j + 1] == 1) HardDropping = false;
                    }
                    if (board[i][j] == 1) TetrisChange[i][j] = 1;
                }
            }
            board = TetrisChange;
        }
        return board;
        //return board;
    }
}
