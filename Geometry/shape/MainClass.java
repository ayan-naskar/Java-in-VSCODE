package Geometry.shape;

// import Geometry.Circle;
// import Geometry.ResizableCircle;

public class MainClass {
    public static void main(String[] Args){
        Circle ob = new Circle(5.0);
        ResizableCircle op = new ResizableCircle(10.0);
        System.out.println(ob);
        System.out.println(op);
        op.resize(50);
        System.out.println(op);
    }
}
