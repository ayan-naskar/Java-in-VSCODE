package all_programs.Shape;

public class Circle extends Shape {
    private double radius;
    public Circle(){
        super();
        radius=1.0;
    }
    public Circle(double radius){
        super();
        this.radius=radius;
    }
    public Circle(double radius, String color, boolean filled){
        super(color,filled);
        this.radius=radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }
    public double getArrea(){
        return 3.14*radius*radius;
    }
    public double getPerimeter(){
        return 2*3.14*radius;
    }
    @Override
    public String toString(){
        return "Circle["+super.toString()+",radius="+getRadius()+"]";
    }
}
