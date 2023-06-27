public class DiceCup {
    private Dice dice1, dice2, dice3;

    public int getDice1() {
        return dice1.getValue();
    }
    public int getDice2() {
        return dice2.getValue();
    }
    public int getDice3() {
        return dice3.getValue();
    }

    DiceCup(){
        dice1 = new Dice();
        dice2 = new Dice();
        dice3 = new Dice();
    }

    void roll(){
        dice1.roll();
        dice2.roll();
        dice3.roll();
    }

    @Override
    public String toString(){
        return getDice1()+", "+getDice2()+", "+getDice3();
    }
}
