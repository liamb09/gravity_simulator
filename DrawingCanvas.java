import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DrawingCanvas extends JComponent {

    private int width;
    private int height;
    private ArrayList<Body> bodies;

    public DrawingCanvas (int w, int h) {
        width = w;
        height = h;
        bodies = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            double x = Math.random()*900 + 50;
//            double y = Math.random()*900 + 50;
//            double mass = Math.random() * 20 + 1;
//            double dx = Math.random()*1000;
//            double dy = Math.random()*1000;
//            System.out.println("Body " + i + ":  x=" + x + "  y=" + y + "  mass=" + mass + "  dx=" + dx + "  dy=" + dy);
//            bodies.add(new Body(x, y, mass, dx, dy));
//        }

        bodies.add(new Body(500, 500, 12));
        bodies.add(new Body(300, 500, 8, 0, 10000));
        bodies.add(new Body(250, 500, 2));
    }

    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Smooths rough edges to make better rendering
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(rh);

        // Rectangle to set background color
        Rectangle2D.Double r = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(new Color(0, 0, 0));
        g2d.fill(r);

        g2d.setColor(Color.white);
        for (int i = 0; i < bodies.size(); i++) {
            Body body = bodies.get(i);
            double[] cm = getCenterOfMass(i);
            Ellipse2D.Double e = new Ellipse2D.Double(body.getX(), body.getY(), body.getMass(), body.getMass());
            g2d.fill(e);
            body.incrementPosition(cm);
        }
    }

    public double[] getCenterOfMass (int except) { // except is the index that it won't include
        Body relativeOrigin = bodies.get(except);
        double xcm = 0;
        double ycm = 0;
        double massesSum = 0;
        for (int i = 0; i < bodies.size(); i++) {
            if (i != except) {
                xcm += (bodies.get(i).getX() - relativeOrigin.getX()) * bodies.get(i).getMass();
                ycm += (bodies.get(i).getY() - relativeOrigin.getY()) * bodies.get(i).getMass();
            }
            massesSum += bodies.get(i).getMass();
        }
        return new double[]{xcm/massesSum, ycm/massesSum};
    }

}