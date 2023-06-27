public class Complex {
    private int real, img;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public Complex(int real, int img) {
        this.real=real;
        this.img=img;
    }

    @Override
    public String toString(){
        return real+" "+((img>=0)?"+ ":"- ")+Math.abs(img)+"i";
    }
}