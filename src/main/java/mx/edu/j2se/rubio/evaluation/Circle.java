package mx.edu.j2se.rubio.evaluation;

public class Circle {
    private double radius;

    public Circle(){
        radius = 1;
    }

    public Circle(double radius) {
        if (radius<1)
            throw new IllegalArgumentException("Radius value less than 1 is not possible");
        this.radius = radius;
    }

    public void setRadius(double radius) {
        if (radius<1)
            throw new IllegalArgumentException("Radius value less than 1 is not possible");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea(){
        return Math.PI*Math.pow(radius,2);
    }
}
