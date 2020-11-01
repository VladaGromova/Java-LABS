package Lab_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SolveTriangleSystem {
    public void task1() throws FileNotFoundException {
        File file = new File("C://FAMCS//input.txt");
        Scanner sc = new Scanner(file);
        int n=0;
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            ++n;
        }
        double[][] arr = new double[n][n];
        double[] bArr = new double[n];
        sc = new Scanner(file);
        for (int i = 0; i < n; ++i){
            int j = i;
            while(j < n){
                if(!sc.hasNextInt()){
                    throw new RuntimeException();
                }
                arr[i][j] = sc.nextInt();
                ++j;
            }
            bArr[i] = sc.nextInt();
        }
        if(sc.hasNextInt()){
            throw new RuntimeException();
        }
        double[] answer = new double[n];
        for (int i = (n-1); i>=0; --i){
            double summ = 0;
            int j = (n - 1);
            while (j>i){
                summ += (arr[i][j]) * answer[j];
                --j;
            }
            answer[i] = (bArr[i] - summ) / arr[i][i];
        }
        for(int i=0; i<n; ++i){
            System.out.println(answer[i]);
        }
    }
}
