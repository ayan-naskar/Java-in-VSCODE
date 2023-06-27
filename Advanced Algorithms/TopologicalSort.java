import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class TopologicalSort{
    class Node{
        List<Integer> dest;
        int indegree, nodeNumber;
        Node(){
            indegree = 0;
        }
    }

    private List<Integer> inputList(){
        String nums[] = new Scanner(System.in).nextLine().split(" ");
        List<Integer> numsList = new ArrayList<>();
        if(nums[0].equals("")) return numsList;
        for(String num: nums){
            numsList.add(Integer.parseInt(num));
        }
        return numsList;
    }
    
    private Node[] GraphInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        Node graph[] = new Node[n];
        for(int i=0;i<n;i++) graph[i]=new Node();
        for(int i=0;i<n;i++){
            System.out.println("Enter the Destination Nodes for Node "+i);
            graph[i].nodeNumber = i;
            graph[i].dest = inputList();
            for(int destNode: graph[i].dest){
                graph[destNode].indegree++;
            }
        }
        return graph;
    }

    private List<Integer> topoSort(Node[] graph){ // TC:O(V*V*E)
        List<Integer> res = new ArrayList<Integer>();
        int popCount=0, n=graph.length;
        while(popCount < n){
            List<Integer> list = new ArrayList<>();
            for(Node node: graph){
                if(node.indegree == 0){
                    res.add(node.nodeNumber);
                    list.add(node.nodeNumber);
                    popCount++;
                    node.indegree=-1;
                }
            }

            if(list.isEmpty()) return null;

            for(int node: list){
                for(int destNode: graph[node].dest){
                    graph[destNode].indegree--;
                }
            }
        }
        return res;
    }

    private List<Integer> topoSort2(Node[] graph){ // TC:O(V*E)
        List<Integer> res = new ArrayList<Integer>();
        int popCount=0, n=graph.length;
        Queue<Node> queue = new LinkedList<>();
        for(Node node: graph) if(node.indegree == 0) queue.add(node);
        while(!queue.isEmpty()){
            Node pop = queue.poll();
            res.add(pop.nodeNumber);
            popCount++;
            for(int destNode: pop.dest){
                graph[destNode].indegree--;
                if(graph[destNode].indegree==0) queue.add(graph[destNode]);
            }
        }
        if(popCount != n) return null;
        return res;
    }

    public static void main(String[] args){
        TopologicalSort obj = new TopologicalSort();
        System.out.println("Enter the graph details: ");
        Node[] graph = obj.GraphInput();

        // List<Integer> res = obj.topoSort(graph);
        // if(res == null) System.out.println("There is a cycle in the graph!!");
        // else System.out.println("The Topologically sorted graph is: " + res);

        List<Integer> res = obj.topoSort2(graph);
        if(res == null) System.out.println("There is a cycle in the graph!!");
        else System.out.println("The Topologically sorted graph is: " + res);
    }
}
/*
5
1 2
3 4
3
4

 */