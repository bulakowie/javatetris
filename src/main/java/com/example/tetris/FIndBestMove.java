package com.example.tetris;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import kotlin.Pair;
import org.controlsfx.control.spreadsheet.Grid;
import org.jetbrains.annotations.NotNull;

public class FIndBestMove {
    GridPane grid;
    FIndBestMove (GridPane grid)
    {
        this.grid = grid;
    }
    public Pair<Integer,Integer> getMove (@NotNull int [][] board, Tetromino block)  {
        boolean startcounting;
        int bestMoveIndex =-1;
        boolean canBeTrue;
        int bestRotationIndex = -1;
        int highestPointofBlock = 99999;
        int[][] givenBoard = board.clone();
        int bestGapsLeft = 99999;
        int bestSmallestHeight = -1;
        int bestSolution = 99999;
        int[][] placeholderBoard = new int[10][23];
        //int rotate = 0;
        for (int rotate=0; rotate <4; rotate++) {
            for (int index = 0; index < 9; index++) {

                canBeTrue = false;
                placeholderBoard = new int[10][23];
                givenBoard = board.clone();
                placeholderBoard = hardDrop(givenBoard, block, rotate, index);
                highestPointofBlock = 9999;
                startcounting = false;
                int gapsNumber =0;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 23; j++) {
                        if (placeholderBoard[i][j] == 5) {
                            startcounting = true;
                            canBeTrue = true;
                            if (j<highestPointofBlock) {
                                highestPointofBlock = j;
}

                        }
                        if (placeholderBoard[i][j]==0&& startcounting) gapsNumber++;
                        if (placeholderBoard[i][j]==1 && startcounting) startcounting = false;
                        if (j ==22) startcounting = false;
                    }
                }
                int solutionNumber = gapsNumber * 6 - highestPointofBlock *3;
                if (solutionNumber < bestSolution && canBeTrue)
                {
                 //   System.out.println(gapsNumber);
                    bestSmallestHeight = highestPointofBlock;
                    bestGapsLeft = gapsNumber;
                    bestSolution = solutionNumber;
                    bestMoveIndex = index;
                    bestRotationIndex = rotate;
                }
               /* if (highestPointofBlock> bestSmallestHeight && canBeTrue) {
                    bestSmallestHeight = highestPointofBlock;
                    bestMoveIndex = index;
                    bestRotationIndex = rotate;
                   // System.out.println("Najlepsza opcja zostaje:" + index + " z wartoscia" + bestSmallestHeight + " i rotacją" + rotate);
                } */
               placeholderBoard = new int[10][23];
            }
        }
        //System.out.println(bestMoveIndex + " " + bestRotationIndex);
        return new Pair<Integer, Integer>(bestMoveIndex,bestRotationIndex);
    }
    public int getScore(Tetromino block,int[][] board ) {
        boolean startcounting;
        int bestMoveIndex = -1;
        boolean canBeTrue;
        int bestRotationIndex = -1;
        int highestPointofBlock = 99999;
        int[][] givenBoard = board.clone();
        int bestGapsLeft = 99999;
        int bestSmallestHeight = -1;
        int bestSolution = 99999;
        int[][] placeholderBoard = new int[10][23];
        //int rotate = 0;
        for (int rotate = 0; rotate < 4; rotate++) {
            for (int index = 0; index < 9; index++) {

                canBeTrue = false;
                placeholderBoard = new int[10][23];
                givenBoard = board.clone();
                placeholderBoard = hardDrop(givenBoard, block, rotate, index);
                highestPointofBlock = 9999;
                startcounting = false;
                int gapsNumber = 0;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 23; j++) {
                        if (placeholderBoard[i][j] == 5) {
                            startcounting = true;
                            canBeTrue = true;
                            if (j < highestPointofBlock) {
                                highestPointofBlock = j;
                            }

                        }
                        if (placeholderBoard[i][j] == 0 && startcounting) gapsNumber++;
                        if (placeholderBoard[i][j] == 1 && startcounting) startcounting = false;
                        if (j == 22) startcounting = false;
                    }
                }
                int solutionNumber = gapsNumber * 8 - highestPointofBlock * 3;
                if (solutionNumber < bestSolution && canBeTrue) {
                    //   System.out.println(gapsNumber);
                    bestSmallestHeight = highestPointofBlock;
                    bestGapsLeft = gapsNumber;
                    bestSolution = solutionNumber;
                    bestMoveIndex = index;
                    bestRotationIndex = rotate;
                }
            }
        }
        return bestSolution;

    }

    public int[][] hardDrop (int[][] board, Tetromino block, int rotation, int position) {
        //System.out.println(rotation);
        int[][] board2 = new int[10][23];
       for (int i=position; i<3+position; i++)
            for (int j = 0; j<4; j++)
            {
                if (block instanceof Square)
                {
                    if (i-position<3 && j<3)
                    {
                        if (block.tileRotationSchemes[rotation][i-position][j] == 1)
                            if (i >=10) return new int[10][23];
                            else board2[i][j] = 5;
                    }
                }
                else if (i-position !=3 && j!=3) {
                    if (block.tileRotationSchemes[rotation][i-position][j] == 1)
                        if (i >=10) return new int[10][23];
                            else board2[i][j] = 5;
                }
                else if (block instanceof Long)
                {
                    if (block.tileRotationSchemes[rotation][i-position][j] == 1)
                        if (i==10) break;
                        else board2[i][j] = 5;

                }
            }
        int cycle = 0;
        boolean HardDropping = true;
        while (HardDropping)
        {
            //System.out.println();
            cycle++;
            int [][] TetrisPlaceholder = new int[10][23];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20 + 3; j++) {
                    if (board2[i][j] == 5) {
                       // System.out.println("Znaleziono blok na koordynatach: " + i + " oraz " + j);
                        if (j + 1 == 23)
                        {
                            HardDropping = false;
                          //  System.out.println("Dotknieto dna na wysokosci" + j);
                        }
                        else if (board[i][j + 1] == 1)
                        {
                            HardDropping = false;
                            //System.out.println("Dotknieto bloku na wysokosci" + j);
                        }
                        else                         TetrisPlaceholder[i][j + 1] = 5;

                    }
                    if (board[i][j] == 1) TetrisPlaceholder[i][j] = 1;
                }
            }

            if (HardDropping) board2 = TetrisPlaceholder.clone();
        }
        /* System.out.println("Cykl trwal" + cycle);
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 10; j++) {
               System.out.print(board[j][i]);
            }
            System.out.println();
        }

        System.out.println(); */

       // System.out.println();




        return board2;
        //return board;
    }
    public boolean shouldYouHold (Tetromino next, Tetromino held, int[][] board)
    {
        if (getScore(next,board) > getScore(held, board)) return true;
        else return false;
    }
}
