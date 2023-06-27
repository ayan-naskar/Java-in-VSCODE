package all_programs.Shape;

public class MainClass  {
    public static void main(String[] args){
        //Shape shape = new Shape("Green",false);
        Shape shape=new Shape("Blue",false);
        Circle circle = new Circle(25.0);
        Rectangle rectangle = new Rectangle(10.0,20.0);
        
        Square square = new Square(50.0);
        square.testv+=5;
        //System.out.println(square.testv);
        //method overriding (runtime polymorphism)
        System.out.println(shape+" , "+(shape instanceof Shape)+" : "+shape.hashCode());  /*<--- toString function of Shape class being called as shape
                                            is refering Shape class object*/
        System.out.println(circle+" : "+circle.hashCode());
        System.out.println(rectangle);
        System.out.println(square);
        shape=circle;  // reference changed
        
        System.out.println(shape+" : "+shape.hashCode());  /*<--- to String function of Circle class being called as shape
                                            is refering to Circle class object */
                                            Shape shape3=new Shape("Blue",false);
                                            Shape shape2=new Shape("Blue",false);
        System.out.println(shape2.hashCode());        
        System.out.println(shape3.hashCode());
    }
}
