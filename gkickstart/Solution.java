import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=Integer.valueOf(sc.nextLine()),T,n,qq,a,b,i,query;
        for(T=1;T<=t;T++){
            String[] line=sc.nextLine().split(" ");
            n=Integer.valueOf(line[0]);
            qq=Integer.valueOf(line[1]);
            List<Integer>[] list = new List[n];
            for(int p=0;p<n;p++){
                list[p] = new ArrayList<Integer>();
                // System.out.println("iterated");
            } 
            for(i=1;i<n;i++){
                line=sc.nextLine().split(" ");
                a=Integer.valueOf(line[0])-1;
                b=Integer.valueOf(line[1])-1;
                // if(list[a]==null){
                //     list[a]=new ArrayList<Integer>();
                // }
                list[a].add(b);
                list[b].add(a);
            }
            HashMap<Integer,Integer> level2node=new HashMap<Integer,Integer>();
            HashMap<Integer,Integer> node2level=new HashMap<Integer,Integer>();
            Queue<Integer> q = new LinkedList<Integer>();
            HashSet<Integer> set = new HashSet<Integer>();
            q.add(0);
            int level=0;
            int numOfNodes=1;
            while(!q.isEmpty()){
                Queue<Integer> que=new LinkedList<Integer>();
                level2node.put(level,numOfNodes);
                numOfNodes=0;
                while(!q.isEmpty()){
                    int pop=q.poll();
                    set.add(pop);
                    node2level.put(pop,level);
                    // System.out.println("["+pop+"]");
                    for(int node: list[pop]){
                        if(!set.contains(node)){
                            que.add(node);
                            numOfNodes++;
                        }
                    }
                }
                level++;
                q=que;
            }
            int currlvl=0,res=0;
            double depth=0.0;
            for(i=0;i<qq;i++){
                query=Integer.valueOf(sc.nextLine());
                numOfNodes=level2node.get(currlvl);
                depth+=1.0/(double)numOfNodes;
                if(depth>1.0){
                    res+=numOfNodes;
                    currlvl++;
                    double excesswater = (depth-1.0)*numOfNodes;
                    depth=excesswater/level2node.get(currlvl);
                }else if(depth==1.0){
                    res+=numOfNodes;
                    currlvl++;
                    depth=0;
                }
            }
            System.out.println("Case #"+T+": "+res);
        }
    }
}

// import java.util.*;
// public class Solution{
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         int t=Integer.valueOf(sc.nextLine()),n,d,u;
//         String color;
//         for(int i=1;i<=t;i++){
//             n=Integer.valueOf(sc.nextLine());
//             fabric[] array = new fabric[n];
//             fabric[] arra1 = new fabric[n];
//             fabric[] arra2 = new fabric[n];
//             for(int j=0;j<n;j++){
//                 String[] fab=sc.nextLine().split(" ");
//                 color=fab[0];
//                 // for(String str: fab) System.out.println(str);
//                 d=Integer.valueOf(fab[1]);
//                 u=Integer.valueOf(fab[2]);
//                 array[j]=new fabric(color,d,u);
//                 arra1[j]=new fabric(color,d,u);
//                 arra2[j]=new fabric(color,d,u);
//             }
//             int res=new doit(array,arra1,arra2,n).res;
//             System.out.println("Case #"+i+": "+res);
//         }
//     }
// }
// class fabric{
//     String color;
//     int d,u;
//     fabric(String color, int d, int u){
//         this.color=color;
//         this.d=d;
//         this.u=u;
//     }
// }

// class doit{
//     int res=0;
//     doit(fabric[] arr, fabric[] brr, fabric[] crr, int n){
//         Arrays.sort(arr,(a,b)->(a.color.compareTo(b.color)!=0)?a.color.compareTo(b.color): a.u-b.u);
//         Arrays.sort(brr,(a,b)->(a.d!=b.d)?a.d-b.d: a.u-b.u);
//         for(int i=0;i<n;i++){
//             if(arr[i].u==brr[i].u) res++;
//         }
//     }
// }