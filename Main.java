
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
    JFrame frame = new JFrame("Java Tetris");
    frame.setBackground(Color.black);
        frame.setSize(400,835);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    PlayingGrid grid = new PlayingGrid(400,800);
    frame.add(new PlayingPanel());
   frame.add(grid);
    frame.setVisible(true);
    grid.setVisible(true);

    while(true)
    {
        //spawn cube
        //check if dropped
        //delete lines
        //check if lose
        //repeat
    }
    }
}