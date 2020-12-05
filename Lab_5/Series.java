package Lab_5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Series {
    protected double firstElement;
    protected   double d;
    protected int numOfElements;
    public Series(double el, double r, int num){
        firstElement = el;
        d = r;
        numOfElements = num;
    }
    public abstract double getElement(int j);
    public double sum(){
        double sum = 0.0;
        for (int i=0; i<numOfElements; ++i){
            sum += getElement((i+1));
        }
        return  sum;
    }
    @Override
    public String toString(){
        String answer = "";
        StringBuffer sb = new StringBuffer(answer);
        for (int i=0; i<numOfElements; ++i){
            sb.append(getElement(i+1));
            sb.append(' ');
        }
        return sb.toString();
    }
    public void save(String name) throws IOException {
        //FileWriter writer = new FileWriter("out.txt", false);
        String s = toString();
        PrintWriter writer = new PrintWriter((name + ".txt"), "UTF-8");
        writer.println(s);
        writer.println('\n');
        writer.println("Sum: " + sum());
        writer.close();
    }
}
