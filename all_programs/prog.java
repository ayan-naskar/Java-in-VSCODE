package all_programs;
import java.util.*;

public class prog {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t,n,m,cases=1;
        t=sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String[] line=sc.nextLine().split(" ");
            n=Integer.valueOf(line[0]);
            m=Integer.valueOf(line[1]);
            line=sc.nextLine().split(" ");
            int[] array=new int[n];
            int i;
            for(i=0;i<n;i++){
                array[i]=Integer.valueOf(line[i]);
            }
            Arrays.sort(array);
            //reverse(array);
            i=0;
            double res=0.0;
            while(m-->1){
                res+=array[i++];
            }
            int len=n-i,mid=i+(len-1)/2;

            if(len%2==0){
                res+=(array[mid]+array[mid+1])/2.0;
            }else
                res+=array[mid];
            System.out.println("Case #"+ cases++ +": "+res);
        }
        sc.close();
    }

    public static void reverse(int[] array)
    {

        // Length of the array
        int n = array.length;

        // Swaping the first half elements with last half
        // elements
        for (int i = 0; i < n / 2; i++) {

            // Storing the first half elements temporarily
            int temp = array[i];

            // Assigning the first half to the last half
            array[i] = array[n - i - 1];

            // Assigning the last half to the first half
            array[n - i - 1] = temp;
        }
    }
}