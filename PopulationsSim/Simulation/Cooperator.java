package Simulation;

public class Cooperator extends Organism{
    private String type;

    public Cooperator() {
        type = "Cooperator";
    }

    public String getType(){
        return type;
    }

    public Organism reproduce(){
        Cooperator oCooperator = new Cooperator();
        return oCooperator;
    }

    public double getCooperationProbability(){
        return 1.0;
    }

    public boolean cooperates(){
        return true;
    }
}
