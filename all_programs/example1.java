package all_programs;
//import java.util.Scanner;
import java.util.Arrays;
class Complex implements Comparable<Complex>
{
    private double real;
    private double img;

    public Complex()
    {
        this.real=0.0;
        this.img=0.0;
    }
    public Complex(double real,double img)
    {
        this.real=real;
        this.img=img;
    }
    public Complex(Complex complex)
    {
        this.real=complex.real;
        this.img=complex.img;
    }
    //Setter or mutator
    public void setReal(double real)
    {
        this.real=real;
    }
    public void setImg(double img)
    {
        this.img=img;
    }
    //Getter or Accessor
    public double getReal()
    {
        return this.real;
    }
    public double getImg()
    {
        return this.img;
    }
    @Override
    public int compareTo(Complex c)
    {
        if(this.real!=c.getReal())
            return (int)(this.real-c.getReal());
        else
            return (int)(this.img-c.getImg());
    }
    @Override
    public boolean equals(Object o)
    {
        if(o==this)
            return true;
        if(!(o instanceof Complex))
            return false;
        Complex c=(Complex)o;
        if(this.real==c.getReal() && this.img==c.getImg())
            return true;
        else
            return false;
    }
    @Override
    public String toString()
    {
        return this.real+((this.img>=0.0)?" + ":" ")+this.img+"i";
    }
}

public class example1 {
    public static void main(String args[])
    {
        Complex array[]=new Complex[5]; //Integer ar[]=new Integer[5];
        //Complex c=new Complex(1,1);
        //System.out.println(c);
        array[0]=new Complex(5,3); //ar[0]=8;
        array[1]=new Complex(3,1);
        array[2]=new Complex(3 ,7);
        array[3]=new Complex(-4,-6);
        array[4]=new Complex(2,-1);
        for(int i=0;i<5;i++)
        {
            System.out.println(array[i]);
        }
        //array[2].setReal(6);
        Arrays.sort(array);
        System.out.println("After sort: ");
        for(int i=0;i<5;i++)
        {
            System.out.println(array[i]);
        }
        //System.out.println(c.equals(new Complex(1,1)));
        //System.out.println(c.equals(array[0]));
    }
}
