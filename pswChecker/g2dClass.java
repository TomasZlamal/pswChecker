package pswChecker;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class g2dClass extends JComponent{
    private  int r;
    private int g;
    private int b;
    public g2dClass(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double r = new Rectangle2D.Double(90, 150, 300, 10);
        g2d.setColor(new Color(this.r, this.g, this.b));
        g2d.fill(r);
    }
}