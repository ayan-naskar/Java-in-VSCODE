package Simulation;

public class PartialCooperator extends Organism{
    String type;
    public PartialCooperator() {
        type = "PartialCooperator";
    }

    public String getType(){
        return type;
    }

    public Organism reproduce(){
        PartialCooperator oPartialCooperator = new PartialCooperator();
        return oPartialCooperator;
    }

    public double getCooperationProbability(){
        return 0.5;
    }

    public boolean cooperates(){
        return Math.random()>getCooperationProbability();
    }
}
