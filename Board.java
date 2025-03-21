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

    private static final int HEIGHT = 20; // Rozmiar tablicy (8x8)
    private static final int WIDTH = 10;
    private static final int SQUARE_SIZE = 30; // Rozmiar pojedynczego kwadratu
    public int[][] TetrisBoard; ;
    public GridPane gridPane;
    @Override
    public void start(Stage primaryStage) {
        gridPane = new GridPane();
        TetrisBoard = new int[10][20];
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                Rectangle square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);
                if (TetrisBoard[col][row] == 0) square.setFill(Color.WHITE);
                else square.setFill(Color.BLACK);
                gridPane.add(square, col, row);
            }
        }

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> Update(primaryStage)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.playFromStart();

        Scene scene = new Scene(gridPane, WIDTH* SQUARE_SIZE, HEIGHT* SQUARE_SIZE);
        primaryStage.setTitle("Chess Board");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void Update(Stage primaryStage)
    {
       // Random random = new Random();
      //  int x = random.nextInt(10);
       // int y = random.nextInt(20);
      //  TetrisBoard[x][y] = 1;
                for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                Rectangle square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);
                if (TetrisBoard[col][row] == 0) square.setFill(Color.WHITE);
                else square.setFill(Color.BLACK);
                gridPane.add(square, col, row);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}