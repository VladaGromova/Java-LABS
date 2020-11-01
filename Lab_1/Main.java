package Lab_1;

import javax.xml.parsers.ParserConfigurationException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        if(args.length!=2){
            throw new IllegalArgumentException();
        }
        try{
        double x = Double.parseDouble(args[0]);
        double e = Double.parseDouble(args[1]);
        Sum s = new Sum();
        s.calculate(x, e);
        } catch(NumberFormatException e){
            System.out.println("Number format exception!");
        } catch (IllegalArgumentException ex){
            System.out.println("Illegal Argument Exception");
        }
    }
}
