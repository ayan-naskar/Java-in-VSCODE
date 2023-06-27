package all_programs;
import java.util.*;
public class inputarray {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the numbers: ");
        String line=s.nextLine();
        String nums[]=line.split(" ");
        System.out.println("The numbers are: "+Arrays.toString(nums));

        //Here is the declaration
        Integer array[]=new Integer[nums.length];

        for(int i=0;i<nums.length;i++)
        array[i]=Integer.valueOf(nums[i]);

        //Arrays can be sorted using comparator by using Integer obj rather than int
        Arrays.sort(array,(a,b)->b-a);

        System.out.println("The array is: "+Arrays.toString(array));
        s.close();
    }
}
/*
 * 10 11 12 13 14 15 1 2 3 4 5 6 7 8 9
 */