import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PlayingGrid extends JComponent {
    int width =  10;
    int height = 20;
    int squaresizeheight;
    int squaresizewidth;
    PlayingGrid(int windowWidth, int windowHeight)
    {
        squaresizeheight = windowHeight / height;
        squaresizewidth = windowWidth / width;
    }
    public void paint(Graphics g)
    {
        setBackground(Color.black);

        for (int i=1 ; i<height;i++)
        {
            g.drawLine(0,i*squaresizewidth, 1000, i*squaresizewidth);
        }
        for (int i=1; i<width; i++)
        {
            g.drawLine(squaresizeheight*i,0,squaresizeheight*i,1000);

        }

    }


}
