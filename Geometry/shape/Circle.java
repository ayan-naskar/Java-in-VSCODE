package Geometry.shape;

public class Circle implements Geometricbject{
    double radius;
    public Circle(){
        radius = 1.0;
    }
    public Circle(double radius){
        this.radius = radius;
    }
    @Override
    public String toString(){
        return "Radius = "+radius+" Area = "+this.getArea()+" Perimeter = "+this.getPerimeter();
    }
    public double getPerimeter(){
        return 2.0*3.14*radius;
    }
    public double getArea(){
        return 3.14*radius*radius;
    }
}
