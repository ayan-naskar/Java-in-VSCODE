import java.util.*;
public class test {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),i,j,max=Integer.MIN_VALUE,res=0;
        int arr[]=new int[n];
        for(i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                int num=map.get(arr[i]);
                num++;
                map.put(arr[i],num);
            }else{
                map.put(arr[i],1);
            }
        }
        for(i=0;i<n;i++){
            int num=map.get(arr[i]);
            if(max<num){
                res=arr[i];
                max=num;
            }
        }
        if(n!=0) System.out.println("The Max Freequent element is: "+res);
    }
}
