import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel implements MouseMotionListener {
    private List<Point> curve = new ArrayList<>();
    private BufferedImage bi = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);

    public DrawingPanel() {
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        for (Point pt : curve) {
//            g.drawOval(pt.x, pt.y, 5, 5);
//        }
        //g.drawOval(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(bi, 0, 100, this);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        curve.add(mouseEvent.getPoint());
//        repaint();
        Graphics gr = bi.getGraphics();
        gr.drawOval(mouseEvent.getX(), mouseEvent.getY(),10, 10);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
