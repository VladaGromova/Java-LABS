package Lab_5;

public class Exponential extends Series {
    public Exponential(double el, double r, int num) {
        super(el, r, num);
    }

    @Override
    public double getElement(int j) {
        return (firstElement*(Math.pow(d, (j-1))));
    }
}
