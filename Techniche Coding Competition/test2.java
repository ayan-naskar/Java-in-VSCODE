import java.util.*;
public class test2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        HashSet<Integer> set= new HashSet<>();
        int n=sc.nextInt(),i;
        int arr[]=new int[n];
        for(i=0;i<n;i++){
            arr[i]=sc.nextInt();
            set.add(arr[i]);
        }
        int diff=sc.nextInt();
        int res=0;
        for(i=0;i<n;i++){
            if(set.contains(arr[i]+diff) && set.contains(arr[i]+diff+diff))
            res++;
        }
        System.out.println("The result is: "+res);
    }
}
