public class Main {
    public static void main(String[] args) {
        try{
            Hexadecimal num = new Hexadecimal();
            num.convertDecimalToHex(25);
            System.out.println(num);
            int deci = num.getDecimal();
            System.out.println(deci);
            System.out.print("Enter the Hexadecimal String: ");
            String hex = new java.util.Scanner(System.in).next();
            num.setVal(hex);
            System.out.println(num);
        }
        catch(HexException e)
        {
            e.printStackTrace();
        }
    }
}
/*
 * 25
 * 00011001
 */
