package fraction;
public class MainClass {
    public static void main(String[] args) {
        Fraction fraction = new Fraction(25,75);
        Fraction reduced_fraction=fraction.reduce();
        System.out.println("The Original Fraction : " + fraction + "\nReduced Fraction : "+reduced_fraction);
    }
}
    