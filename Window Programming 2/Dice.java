public class Dice {
    private int value;
    public int getValue() {
        return value;
    }
    Dice(){
        roll();
    }
    void roll(){
        value = (int)(Math.random()*6)+1;
    }
}
