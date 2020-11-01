package Lab_1;

public class Sum {
    public void calculate(double x, double e){
        double sum = 0;
        int k=1;
        double x1 = Math.pow(x, 3*Math.pow(k, 2));
        double delta;
        double xi = x1;
        while(xi>=e){
            sum+=xi;
            System.out.println("k = " + k + "   ; x" + k + " = " + xi +":   sum = " + sum);
            xi*=(Math.pow(x, 3*(2*k + 1)));
            ++k;
        }
    }
}
