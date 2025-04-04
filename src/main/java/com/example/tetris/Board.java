package com.example.tetris;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

public class Board extends Application {

    public FIndBestMove bestMove;
    public boolean isBlockDropping = false;
    private static final int HEIGHT = 20; // Rozmiar tablicy (8x8)
    private static final int WIDTH = 10;
    private static final int SQUARE_SIZE = 30; // Rozmiar pojedynczego kwadratu
    public int[][] TetrisBoard;
    public int[][] TetrisChange;
    public GridPane gridPane;
    Tetromino activeBlock;
    public int rotationValue;
    public boolean isBlockBig;
    public int expectedMoveIndex;
    public int expectedMoveRotation;
    public int startingIndex;
    @Override
    public void start(Stage primaryStage) {
        gridPane = new GridPane();
        bestMove = new FIndBestMove(gridPane);

        TetrisBoard = new int[10][24];

        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                Rectangle square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);
                if (TetrisBoard[col][row+2] == 0) square.setFill(Color.WHITE);
                else square.setFill(Color.BLACK);
                gridPane.add(square, col, row);
            }
        }
        /*TetrisBoard[0][0]  = 2;
        TetrisBoard[0][1]  = 2;
        TetrisBoard[0][2]  = 2;
        TetrisBoard[0][3]  = 2; */
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.02), e -> Update(primaryStage)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.playFromStart();

        Scene scene = new Scene(gridPane, WIDTH* SQUARE_SIZE + 300, HEIGHT* SQUARE_SIZE);
        primaryStage.setTitle("Tetris");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void moveBlockLeft() {
        boolean canMove = true;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT+3; j++) {
                if (TetrisBoard[i][j] == 2) {
                    if (i - 1 == -1) canMove = false;
                    else if (TetrisBoard[i-1][j] == 1 ) canMove = false;
                }
            }
        }
        if (canMove)
        {
            TetrisChange = new int[10][23];

            for (int i = 0; i < WIDTH; i++) {
                for (int j = 0; j < HEIGHT+3; j++) {
                    if (TetrisBoard[i][j] == 2) {
                        TetrisChange[i-1][j] = 2;
                    }
                    if (TetrisBoard[i][j] == 1) TetrisChange[i][j] = 1;
                }
            }
            TetrisBoard = TetrisChange;
        }
    }
    public void moveBlockRight() {
        boolean canMove = true;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT+3; j++) {
                if (TetrisBoard[i][j] == 2) {
                    if (i + 1 == 10) canMove = false;
                    else if( TetrisBoard[i+1][j] == 1 ) canMove = false;
                }
            }
        }
        if (canMove)
        {
            TetrisChange = new int[10][23];
            for (int i = 0; i < WIDTH; i++) {
                for (int j = 0; j < HEIGHT+3; j++) {
                    if (TetrisBoard[i][j] == 2) {
                        TetrisChange[i+1][j] = 2;
                    }
                    if (TetrisBoard[i][j] == 1) TetrisChange[i][j] = 1;
                }
            }
            TetrisBoard = TetrisChange;
        }
    }
    public void LineDeletion()
    {
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                if (TetrisBoard[col][row] != 1) break;
                else if (col == 9)
                {
                    for (int col2 = 0; col2>WIDTH ; col2++)
                    {
                        TetrisBoard[col2][row] = 0;
                    }
                }
            }
        }
    }
    public void Update(Stage primaryStage) {


     //   LineDeletion();
        if(!isBlockDropping) newBlock();
        DropDown();
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                Rectangle square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);
                if (TetrisBoard[col][row+2] == 0) square.setFill(Color.WHITE);
                else square.setFill(Color.BLACK);
                gridPane.add(square, col, row);
            }
        }

    }
    public void DropDown() {
        boolean BlockDropped = false;

        Random random = new Random();
       // System.out.println(expectedMoveRotation);
        if (rotationValue !=expectedMoveRotation) rotation(1);
        if (startingIndex>expectedMoveIndex)
        {
            moveBlockLeft();
            startingIndex--;
        }
        else if (startingIndex<expectedMoveIndex)
        {
            moveBlockRight();
            startingIndex++;
        }

            TetrisChange = new int[10][23];
            for (int i = 0; i < WIDTH; i++) {
                for (int j = 0; j < HEIGHT + 3; j++) {
                    if (TetrisBoard[i][j] == 2) {
                        TetrisChange[i][j + 1] = 2;
                        if (j + 1 == HEIGHT + 2) BlockDropped = true;
                        else if (TetrisBoard[i][j + 1] == 1) BlockDropped = true;
                    }
                    if (TetrisBoard[i][j] == 1) TetrisChange[i][j] = 1;
                }
            }
            if (BlockDropped) {
                  //System.out.println(123.456);
                for (int i = 0; i < WIDTH; i++) {
                    for (int j = 0; j < HEIGHT + 3; j++) {
                        if (TetrisBoard[i][j] == 2) {
                            // System.out.println(123.456);
                            TetrisBoard[i][j] = 1;
                        }
                    }
                }
            }
            else TetrisBoard = TetrisChange;
            if (BlockDropped) {
           /* TetrisBoard[3][0]  = 2;
            TetrisBoard[3][1]  = 2;
            TetrisBoard[3][2]  = 2;
            TetrisBoard[4][2]  = 2; */
                isBlockDropping = false;
                BlockDropped = false;
            }

            }

    public void rotation(int n) {
      //  if (n == 1) System.out.print("lewo");
       // else System.out.print("prawo");


        boolean ROTATE = true;
        //n - 1 : lewo
        int placeholderRotationValue;
        //n - 2 : prawo
        int topUp= 9999; int topLeft = 9999;
        int [][]TetrisChange2 =new int[10][23];

        if (n==1) placeholderRotationValue = rotationValue +1;
        else placeholderRotationValue = rotationValue -1;
        if (placeholderRotationValue == -1) placeholderRotationValue = 3;
        if (placeholderRotationValue == 4) placeholderRotationValue = 0;
        //System.out.println(placeholderRotationValue);
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT+3; j++) {
                if(TetrisBoard[i][j] == 2) {
                    if (j<topUp) topUp =j;
                    if (i<topLeft) topLeft = i;
                }
                if (TetrisBoard[i][j]==1) TetrisChange2[i][j]=1;
            }
        }
        System.out.println(topUp + " " + topLeft);
        for (int i=0; i<4; i++)
            for (int j = 0; j<4; j++)
            {
                if (i !=3 && j!=3) {
                    if (activeBlock.tileRotationSchemes[placeholderRotationValue][i][j] == 1)
                    {
                        if (i+topLeft>9 || j+topUp >22) ROTATE = false;
                        else if (TetrisBoard[i+topLeft][j+topUp]==1) ROTATE = false;
                        else TetrisChange2[i+topLeft][j+topUp] = 2;
                    }
                }
                else if (isBlockBig)
                {
                    if (activeBlock.tileRotationSchemes[placeholderRotationValue][i][j] == 1)
                    {
                        if (i+topLeft>9 || j+topUp >21) ROTATE = false;
                        else if (TetrisBoard[i+topLeft][j+topUp]==1) ROTATE = false;
                        else TetrisChange2[i+topLeft][j+topUp] = 2;
                    }
                }


            }
    //    System.out.println("penisisko");
    if (ROTATE)
    {TetrisBoard = TetrisChange2;
        rotationValue = placeholderRotationValue;}
    else System.out.println("penisisko");
    }
    public void newBlock() {
            startingIndex = 4;
        int offset = 4;
        Tetromino[] pool = {new BlueL(),new OrangeL(), new GreenZ(), new RedZ(), new Square(),new T_Piece(), new Long()};
        isBlockDropping = true;
        Random random = new Random();
        int n = random.nextInt(4);
        //n= 0;
        Tetromino fallingBlock =  pool[n];
        System.out.println(fallingBlock.toString());
        expectedMoveIndex = bestMove.getMove(TetrisBoard,fallingBlock).component1();
        expectedMoveRotation = bestMove.getMove(TetrisBoard,fallingBlock).component2();
        for (int i=0; i<4; i++)
            for (int j = 0; j<4; j++)
            {
                    if (i !=3 && j!=3) {
                        if (fallingBlock.tileRotationSchemes[0][i][j] == 1)
                            TetrisBoard[i+offset][j+1] = 2;
                        isBlockBig = false;
                    }
                    else if (n== 4 || n== 6)
                    {
                        isBlockBig = true;
                        if (fallingBlock.tileRotationSchemes[0][i][j] == 1)
                            TetrisBoard[i+offset][j+1] = 2;

                    }
            }

        System.out.println(expectedMoveIndex);
        activeBlock = fallingBlock;
        rotationValue = 0;



    }
    public static void main(String[] args) {
        launch(args);
    }
}