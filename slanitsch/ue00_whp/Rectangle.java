package slanitsch.ue00_whp;

public class Rectangle extends Figure {
    public static void main(String[] args) {
        Figure r = new Rectangle(10.0, 20.0);
        System.out.println(r);
    }

    private double a;
    private double b;

    private Rectangle(double a, double b) {
        this.b = b;
        this.a = a;

    }

    @Override
    public double getArea() {
        return a * b;

    }

    @Override
    public double getCircumference() {
        return 2 * a + 2 * b;

    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": Circumference = " + getCircumference() + ", area = "
                + getArea() + ", a = " + a + ", b = " + b;
    }
}
