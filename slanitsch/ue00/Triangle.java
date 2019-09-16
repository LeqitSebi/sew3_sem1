package slanitsch.ue00;


public class Triangle extends Figure {

    public static void main(String[] args) {
        Figure t = new Triangle(10.0, 20.0, 30.0);
        System.out.println(t);
    }

    private double a;
    private double b;
    private double c;

    private Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getCircumference() {
        return a + b + +c;

    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": Circumference = " + getCircumference() + ", area = "
                + getArea() + ", a = " + a + ", b = " + b + ", c = " + c;

    }
}
