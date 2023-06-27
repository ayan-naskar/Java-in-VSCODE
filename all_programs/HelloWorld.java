package all_programs;
import java.util.*;
public class HelloWorld{
    public static void main(String args[]){
        System.out.println("Enter the number: ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("The number is: "+n);
        sc.close();
    }
}