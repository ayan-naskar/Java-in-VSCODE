public class MainClass2 {
    public static void main(String[] Args){
        Circle ob = new Circle(5.0);
        ResizableCircle op = new ResizableCircle(10.0);
        System.out.println(ob);
        System.out.println(op);
        op.resize(50);
        System.out.println(op);
    }
}

interface Resizable {
    public void resize(int percent);
}

class Circle implements Geometricbject{
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

class ResizableCircle extends Circle implements Resizable{
    public ResizableCircle(double radius){
        super.radius=radius;
    }
    @Override
    public String toString(){
        return super.toString();
    }
    public void resize(int percent){
        super.radius*=1.0-percent/100.0;
    }
}

interface Geometricbject {
    public double getPerimeter();
    public double getArea();
}
