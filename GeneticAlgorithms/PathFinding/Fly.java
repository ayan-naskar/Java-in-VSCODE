public class Fly{
    double posX, posY, velX, velY;
    AccVec dna[]; // Acceleration Vector
    int currIteration;
    public Fly(int posX, int posY, int Iteration) {
        this.posX = posX;
        this.posY = posY;
        this.velX = 0.0;
        this.velY = 0.0;
        dna = new AccVec[Iteration];
        for(int i=0;i<Iteration;i++) dna[i]=new AccVec();
        currIteration = 0;
    }
    public Fly(int startposx, int startposy, int iteration, Fly fly, Fly fly2) { // crossover constructor
        this.posX = startposx;
        this.posY = startposy;
        this.velX = 0.0;
        this.velY = 0.0;
        dna = new AccVec[iteration];

        int mid=(int)(Math.random()*iteration);
        for(int i=0;i<iteration; i++) {
            dna[i]=(i<=mid)?fly.dna[i]:fly2.dna[i];
            if(Math.random()<Simulation.mutationProb) dna[i]=new AccVec();
        }
    }    
}