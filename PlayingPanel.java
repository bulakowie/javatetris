import javax.swing.*;

public class PlayingPanel extends JPanel implements Runnable{
        int width = 400;
        int height = 835;
        int FPS = 60;
        Thread gameThread;
        int [][]boardstate = new int[10][20];
        //0 - black
        //1- light blue
        //2 - dark blue
        //3 - orange
        //4 - yellow
        //5 - green
        //6 - red
        //7 - purple
        public void start()
        {
            gameThread = new Thread(this);
            gameThread.start();
        }



    @Override
    public void run() {
    double draw = 100000/FPS;
    double delta = 0;
    long lastTime = System.nanoTime()  ;
    long currentTime;
    while ()
    }
}
