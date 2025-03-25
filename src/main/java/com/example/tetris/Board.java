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
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

public class Board extends Application {

    public boolean isBlockDropping = false;
    private static final int HEIGHT = 20; // Rozmiar tablicy (8x8)
    private static final int WIDTH = 10;
    private static final int SQUARE_SIZE = 30; // Rozmiar pojedynczego kwadratu
    public int[][] TetrisBoard; ;
    public int[][] TetrisChange;
    public GridPane gridPane;
    @Override
    public void start(Stage primaryStage) {
        gridPane = new GridPane();
        TetrisBoard = new int[10][24];

        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                Rectangle square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);
                if (TetrisBoard[col][row+2] == 0) square.setFill(Color.WHITE);
                else square.setFill(Color.BLACK);
                gridPane.add(square, col, row);
            }
        }
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), e -> Update(primaryStage)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.playFromStart();

        Scene scene = new Scene(gridPane, WIDTH* SQUARE_SIZE + 300, HEIGHT* SQUARE_SIZE);
        primaryStage.setTitle("Chess Board");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void Update(Stage primaryStage)
    {
        //if(!isBlockDropping) newBlock();
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

        TetrisChange = new int[10][23];
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT+3; j++) {
                if (TetrisBoard[i][j] == 2) {
                    TetrisChange[i][j + 1] = 2;
                    if (j + 1 > HEIGHT || TetrisBoard[i][j + 2] == 1) BlockDropped = true;
                }
                if (TetrisBoard[i][j] == 1) TetrisChange[i][j] = 1;
            }
        }
        if (BlockDropped) {
            System.out.println(123.456);
            for (int i = 0; i < WIDTH; i++) {
                for (int j = 0; j < HEIGHT+3; j++) {
                    if(TetrisChange[i][j] == 2) {
                        System.out.println(123.456);
                        TetrisChange[i][j] = 1;
                    }
                }
            }
        }
        TetrisBoard = TetrisChange;
        if (BlockDropped)
        {
            BlockDropped = false;
        }


    }
    public void newBlock()
    {
        Random random = new Random();
        int n = random.nextInt(7);
        Tetromino newOne = new BlueL();
        switch(n)
        {
            case 0: newOne = new BlueL();
            case 1: newOne = new OrangeL();
            case 2: newOne = new GreenZ();
            case 3: newOne = new RedZ();
            case 4: newOne = new Square();
            case 5: newOne = new T_Piece();
            case 6: newOne = new Long();
        }
        for (int i=0; i<3; i++)
            for (int j = 0; j<3; j++)
            {

                   TetrisBoard[i][j] = 2;
            }



    }
    public static void main(String[] args) {
        launch(args);
    }
}