package all_programs;

public class example2 {
    public static void main(String[] args) {
        float   x=(float)Math.random()*10,
                y=(float)Math.random()*10,
                xs=(float)Math.random()*2,
                ys=(float)Math.random()*2;
        MovablePoint mp = new MovablePoint(x,y,xs,ys);
        System.out.println(mp);
        for(int i=0;i<10;i++)
            mp.move();
        System.out.println(mp);
    }
}
