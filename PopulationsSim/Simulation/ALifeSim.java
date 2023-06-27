package Simulation;
import java.util.HashMap;
import java.util.Scanner;
//java ALifeSim <#/iterations> <#/cooperators> <#/defectors> <#/partial cooperators>
/*
1000 20 30 25
*/
public class ALifeSim {
    int iterations;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ALifeSim ob = new ALifeSim();
        String[] line = sc.nextLine().split(" ");
        sc.close();
        ob.iterations = Integer.valueOf(line[0]);
        HashMap<String,Integer> counts = new HashMap<String,Integer>();
        counts.put("Cooperator",Integer.valueOf(line[1]));
        counts.put("Defector",Integer.valueOf(line[2]));
        counts.put("PartialCooperator",Integer.valueOf(line[3]));

        Population population = new Population(counts);

        while(ob.iterations-->0){
            population.update();
        }

        counts = (HashMap<String, Integer>) population.getPopulationCounts();
        double CooperationMean = population.calculateCooperationMean();

        for(String str : counts.keySet()){
            System.out.println(str + " = " + counts.get(str));
        }
        System.out.println("Mean Cooperation Probability = " + CooperationMean);
    }
}
