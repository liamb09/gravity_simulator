public class Body {
    private double x;
    private double y;
    private double mass;
    private double dx;
    private double dy;

    public Body () {
        x = y = dx = dy = 0;
        mass = 1;
    }

    public Body (double x, double y, double mass) {
        this.x = x;
        this.y = y;
        this.mass = mass;
        dx = dy = 0;
    }

    public Body (double x, double y, double mass, double dx, double dy) {
        this(x, y, mass);
        this.dx = dx;
        this.dy = dy;
    }

    public double getX () {
        return x;
    }

    public double getY () {
        return y;
    }

    public double getMass () {
        return mass;
    }

    public void setX (double newX) {
        x = newX;
    }

    public void setY (double newY) {
        y = newY;
    }

    public void incrementPosition (double[] cm) {
        dx += cm[0];
        dy += cm[1];
        x += dx / mass / 1000;
        y += dy / mass / 1000;
    }

    public void setMass (double newMass) {
        mass = newMass;
    }
}
