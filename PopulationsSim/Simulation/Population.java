package Simulation;

// import java.util.HashMap;
// import java.util.Map;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Population {
    List<Organism> organisms;
    int cooperationCount,totalChecks;

    public Population(Map<String,Integer> counts){
        cooperationCount=totalChecks=0;
        organisms = new ArrayList<Organism>();
        for(String key : counts.keySet()){
            int count = counts.get(key);
            if(key.equals("Cooperator")){
                for(int i=0;i<count;i++)
                    organisms.add(new Cooperator());
            }
            else if(key.equals("Defector")){
                for(int i=0;i<count;i++)
                    organisms.add(new Defector());
            }
            else if(key.equals("PartialCooperator")){
                for(int i=0;i<count;i++)
                    organisms.add(new PartialCooperator());
            }
            else{
                throw new IllegalArgumentException();
            }
        }
    }

    public void update(){
        int i=0,j;
        HashSet<Integer> removingIndexes = new HashSet<Integer>();
        List<Organism> removing_org = new ArrayList<Organism>();
        List<Organism> org = new ArrayList<Organism>();

        for(Organism ob : organisms){
            ob.update();
            totalChecks++;
            if(ob.cooperates()){
                cooperationCount++;
                ob.update(-1);
                int size=organisms.size()-1;
                HashSet<Integer> set = new HashSet<Integer>();
                set.add(i);
                j=0;
                while(j<8){
                    int select = (int)(Math.random()*size);
                    if(!set.contains(select)){
                        set.add(select);
                        j++;
                    }
                }
                set.remove(i);
                j=0;
                for(Organism o : organisms){
                    if(set.contains(j))
                        o.update();
                    j++;
                }
            }
            if(ob.getEnergy()>=10){
                int randvalue;
                do{
                    randvalue=(int)(organisms.size()*Math.random());
                }while(removingIndexes.contains(randvalue));
                removingIndexes.add(randvalue);
                removing_org.add(organisms.get(randvalue));
                // organisms.remove(randvalue);
                int choice = (int)(3*Math.random());
                switch(choice){
                    case 1:
                    org.add(new Cooperator());
                    break;
                    case 2:
                    org.add(new Defector());
                    break;
                    default:
                    org.add(new PartialCooperator());
                }
            }
            i++;
        }

        for(Organism ob : removing_org){
            organisms.remove(ob);
        }
        organisms.addAll(org);
    }

    public double calculateCooperationMean(){
        int c1=0,c2=0,c3=0;
        
        for(Organism ob : organisms){
            if(ob.getType().equals("Cooperator"))
                c1++;
            else if(ob.getType().equals("PartialCooperator"))
                c2++;
            else c3++;
        }
        return (c1*new Cooperator().getCooperationProbability()+c2*new PartialCooperator().getCooperationProbability() +
                c3*new Defector().getCooperationProbability())/organisms.size();
    }
    public Map<String,Integer> getPopulationCounts(){
        HashMap<String,Integer> counts = new HashMap<String,Integer>();
        int count;
        for(Organism ob : organisms){
            switch(ob.getType()){
                case "Cooperator":
                    count=counts.getOrDefault("Cooperator",0)+1;
                    counts.put("Cooperator",count);
                break;
                case "Defector":
                    count=counts.getOrDefault("Defector",0)+1;
                    counts.put("Defector",count);
                break;
                case "PartialCooperator":
                    count=counts.getOrDefault("PartialCooperator",0)+1;
                    counts.put("PartialCooperator",count);
                break;
            }
        }
        return counts;
    }
}