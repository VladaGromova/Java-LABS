package Lab_5;

public class Liner extends Series {
    public Liner(double el, double r, int num) {
        super(el, r, num);
    }

    @Override
    public double getElement(int j) {
        return (firstElement + d*(j-1));
    }
}
