package all_programs;

import java.util.Scanner;
import java.util.Arrays;

public class SortOBJ {
    public static void main(String[] ag){
        Scanner sc=new Scanner(System.in);
        node array[]=new node[5];
        System.out.println("Enter the parameters: ");
        for(int i=0;i<5;i++){
            String[] values=sc.nextLine().split(" ");
            array[i]=new node(Integer.valueOf(values[0]),values[1]);
        }
        Arrays.sort(array);
        System.out.println("The sorted array is:");
        for(int i=0;i<5;i++){
            System.out.println(array[i].val+" : "+array[i].s);
        }
        sc.close();
    }
}

class node implements Comparable<node>{
    int val;
    String s;
    node(){
        val=0;
        s="";
    }
    node(int v,String str){
        val=v;
        s=str;
    }
    @Override
    public int compareTo(node NODE){
        return this.s.compareTo(NODE.s);
    }
}
/*
1 ayan
2 nayan
3 dayan
4 mayan
5 sayan

 */