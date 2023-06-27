package Enumeration;

public class prog1 {
    enum Color
    {
        Red, Blue, Green, Yellow, White, Black
    }
    public static void main(String args[])
    {
        Color c=Color.Red;
        System.out.println(c);
        switch(c)
        {
            case Red:
                System.out.println("red");
        }
        System.out.println((7^5)+(5^8)+(8^4)+(4^10));
    }
}
/*
 * employee(personal, official, performance)
 * time-sheet
 * payslip(payrole)
 * recruitment
 * training
 * appraisal
 * company policies and norms[human resouce related](--ID,--name,--Description)
 * sarvay
 * suggestion/opinion/complain
 * facilities/insurance
 */