class Shape {
    int length;
    Shape(int length){
        this.length=length;
    }
    void show(){
        System.out.println(length);
    }
}
class Rectangle {
    int length, breadth;
    Rectangle(int length, int breadth){
        this.length=length;
        this.breadth=breadth;
    }
    void show(){
        System.out.println(length+" "+breadth);
    }
}
public class MainCheck {
    public static void main(String[] args) {
        // Rectangle rec = new Rectangle(0,2,4);
        // Shape sh = rec;
        // sh.show();
        Shape sh = new Shape(5);
        // Rectangle rec = sh;
        // rec.show();
    }
}
