package fraction;

public class Fraction {
    /*getter setter toString reduce gcd */
    private int numerator,denominator;
    public int getDenominator() {
        return denominator;
    }
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
    public int getNumerator() {
        return numerator;
    }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public Fraction(int numerator, int denominator){
        this.numerator=numerator;
        this.denominator=denominator;
    }
    @Override
    public String toString(){
        return numerator+" / "+denominator;
    }
    public Fraction reduce(){
        int _gcd = gcd(numerator,denominator);
        return new Fraction(numerator/_gcd, denominator/_gcd);
    }
    private int gcd(int a,int b){
        return (numerator%a==0 && denominator%a==0)? a : gcd(++a,b);
    }
}