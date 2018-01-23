package emoji;

import javax.swing.*;
import java.awt.*;

public class Smiley extends JFrame {

    public  Smiley()
    {
        setBackground(Color.DARK_GRAY);
        setTitle("Smiley Face");
        setSize(640,480);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void paint(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.drawOval(150,50,300,300);
        g.fillOval(150,50,300,300);
        g.setColor(Color.BLUE);
        g.fillOval(200,150,50,50);
        g.fillOval(350,150,50,50);
        g.setColor(Color.RED);
        g.drawArc(250,275,100,50,180,180);

    }

    public static void main(String[] args)
    {
        Smiley smiley = new Smiley();
        smiley.paint(null);
    }
}
