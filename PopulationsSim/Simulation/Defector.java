package Simulation;

public class Defector extends Organism {
    String type;
    public Defector() {
        type = "Defector";
    }

    public String getType(){
        return type;
    }

    public Organism reproduce(){
        Defector oDefector = new Defector();
        return oDefector;
    }

    public double getCooperationProbability(){
        return 0.0;
    }

    public boolean cooperates(){
        return false;
    }
}
