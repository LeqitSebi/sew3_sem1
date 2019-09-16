package slanitsch.ue00;

public class Circle extends Figure {
    public static void main(String[] args) {
        Figure c = new Circle(100);
        System.out.println(c);
    }

    private double radius;

    private Circle(double radius) {
        this.radius = radius;

    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;

    }

    @Override
    public double getCircumference() {
        return 2 * radius * Math.PI;

    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": Circumference = " + getCircumference() + ", area = "
                + getArea() + ", radius = " + radius;
    }
}
