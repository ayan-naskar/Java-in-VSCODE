package Simulation;

public abstract class Organism{
    private int energy;
    public Organism(){
        energy=0;
    }
    public void update(){
        incrementEnergy();
    }
    public void update(int updateBy){
        for(int i=0;i<Math.abs(updateBy);i++)
            if(updateBy>0) incrementEnergy();
            else decrementEnergy();
        energy=Math.max(energy,0);
    }
    public int getEnergy(){
        return energy;
    }
    private void incrementEnergy(){
        energy++;
    }
    private void decrementEnergy(){
        energy--;
    } 

    public abstract String getType();

    public abstract Organism reproduce();

    public abstract double getCooperationProbability();

    public abstract boolean cooperates();
}