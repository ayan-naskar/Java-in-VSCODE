package AbstractClasses;

abstract class Shape
{
    int dim[];
    Shape(int dim[])
    {
        this.dim=dim;
    }

    abstract public double area();
}

// interface shape{
//     public double area();
// }

class Rectangle extends Shape
{
    Rectangle(int l,int b)
    {
        super(new int[]{l,b});
    }
    public double area()
    {
        return (double)super.dim[0]*super.dim[1];
    }
}

// class rectangle implements shape
// {
//     int l,b;
//     rectangle(int l,int b)
//     {
//         this.l=l;
//         this.b=b;
//     }
//     public double area()
//     {
//         return (double)l*b;
//     }
// }

public class AbstractC {
    public static void main(String args[])
    {
        //int a[]={45,23};
        //Shape s=new Shape(a);
        Rectangle r=new Rectangle(5,8);
        System.out.println(r.area());
    }
}
