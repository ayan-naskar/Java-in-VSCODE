import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    public String getName() {
        return name;
    }
    private int currScore;
    public int getCurrScore() {
        return currScore;
    }
    public void setCurrScore(int currScore) {
        this.currScore = currScore;
    }
    private int currround;
    public int getCurrround() {
        return currround;
    }
    public void setCurrround(int currround) {
        this.currround = currround;
    }
    private List<Integer> roundInfo;
    public List<Integer> getRoundInfo() {
        return roundInfo;
    }
    Player(){
        name = "Computer";
        currScore = currround = 0;
        roundInfo = new ArrayList<>();
    }
    Player(String name){
        this();
        this.name = name;
    }
    public boolean isABunco(DiceCup dc) {
        return dc.getDice1() == dc.getDice2() && dc.getDice2() == dc.getDice3() && dc.getDice1() == currround;
    }
    public boolean isAMiniBunco(DiceCup dc) {
        return dc.getDice1() == dc.getDice2() && dc.getDice2() == dc.getDice3() && dc.getDice1() == 1 && currround!=1;
    }
    // public void playRound(DiceCup dc) {
    //     dc.roll();
    //     if(isABunco(dc)) 
    //     currScore+=21;
    //     else if(isAMiniBunco(dc))
    //     currScore+=5;
    //     else{
    //         if(currround == dc.getDice1())
    //         currScore+=1;
    //         if(currround == dc.getDice2())
    //         currScore+=1;
    //         if(currround == dc.getDice3())
    //         currScore+=1;
    //     }
    // }
}
