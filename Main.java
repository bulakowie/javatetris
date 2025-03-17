
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class Main {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Java Tetris");
        GameEngine game = new GameEngine();
        frame.setSize(1200, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.black);

        frame.setVisible(true);
        game.start();
    }
}