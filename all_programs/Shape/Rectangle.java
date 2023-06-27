package all_programs.Shape;

public class Rectangle extends Shape {
    private double width,length;
    protected int testv;

    public Rectangle(){
        super();
        width=length=1.0;
        testv=-1;
    }

    public Rectangle(double width, double length) {
        super();
        this.width = width;
        this.length = length;
        testv=-1;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
        testv=-1;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    public double getArea(){
        return width*length;
    }
    public double getPerimeter(){
        return 2*(width+length);
    }
    @Override
    public String toString(){
        return "Rectangle["+super.toString()+",width="+getWidth()+",length="+getLength()+"]";
    }
}
