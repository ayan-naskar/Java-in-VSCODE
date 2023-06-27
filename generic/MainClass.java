import java.util.Random;

public class MainClass {
    public static void main(String args[])
    {
        Integer a[][]=new Integer[2][3];
        Complex c[][]=new Complex[2][2];
        Fraction f[][]=new Fraction[3][2];
        Random r=new Random();
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<3;j++)
                a[i][j]=r.nextInt(20);
        }
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
                c[i][j]=new Complex(r.nextInt(20),r.nextInt(20));
        }
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<2;j++)
                {f[i][j]=new Fraction(r.nextInt(20),r.nextInt(20)+1);
                f[i][j]=f[i][j].reduce();}
        }
        Matrix m1=new Matrix(2,3);
        Matrix m2=new Matrix(2,2);
        Matrix m3=new Matrix(3,2);
        m1.setMatrix(a);
        m2.setMatrix(c);
        m3.setMatrix(f);
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }
}
