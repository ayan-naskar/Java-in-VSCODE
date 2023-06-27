package Geometry.shape;

public class ResizableCircle extends Circle implements Resizable,Geometricbject{
    public ResizableCircle(double radius){
        super.radius=radius;
    }
    @Override
    public String toString(){
        return super.toString();
    }
    public void resize(int percent){
        super.radius*=1.0-percent/100.0;
    }

}