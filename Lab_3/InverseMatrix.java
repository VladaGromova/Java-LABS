package Lab_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InverseMatrix {
    public void task2() throws FileNotFoundException {
        File file = new File("C://FAMCS//input2.txt");
        //File file = new File("C://FAMCS//input3.txt");
        Scanner sc = new Scanner(file);
        int n=0;
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            ++n;
        }
        sc = new Scanner(file);
        double[][] arr = new double[n][n];
        double[][] E = new double[n][n];
        sc = new Scanner(file);
        for (int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(!sc.hasNextInt()){
                    throw new RuntimeException();
                }
                arr[i][j] = sc.nextInt();
                if(i==j){
                    E[i][i] = 1;
                } else{
                    E[i][j]=0;
                }
            }
        }
        if(sc.hasNextInt()){
            throw new RuntimeException();
        }
        for (int i=0; i<n; ++i){
            double el = arr[i][i];
            for(int j=0; j<n; ++j){
                (arr[i][j]) /= el;
                (E[i][j]) /= el;
            }
            for (int k=(i+1); k<n; ++k){
                double m = (arr[k][i])*(-1)/(arr[i][i]);
                if(m!=0){
                    for(int j=0; j<n; ++j){
                        arr[k][j] += (arr[i][j])*m;
                        E[k][j] += (E[i][j])*m;
                    }
                }
            }
        }
        for (int i=(n-1); i>0; --i){
            for(int k=0; k<i; ++k){
                double m = (-1)*(arr[k][i]);
                if(m!=0){
                    for (int e=0; e<n; ++e){
                        E[k][e] += (E[i][e])*m;
                    }
                    arr[k][i] += (arr[i][i])*m;
                }
            }
        }
        for (int i=0; i<n; ++i){
            String s="";
            for (int j=0; j<n; ++j){
                s += Double.toString(E[i][j]);
                s += "  ";
            }
            System.out.println(s);
        }
    }
}
