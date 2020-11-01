package Lab_3;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Lab_3 {
    public static void main(String[] args){

        SolveTriangleSystem ans1 = new SolveTriangleSystem();
        System.out.println("Task 1:");
        try{
        ans1.task1();
        } catch (FileNotFoundException ex1){
            System.out.println("File not found!");
        }
        catch (RuntimeException ex2){
            System.out.println("Problems with amount of symbols in your file!");
        }

        InverseMatrix ans2 = new InverseMatrix();
        System.out.println("Task 2:");
        try {
            ans2.task2();
        } catch (FileNotFoundException ex3){
            System.out.println("File not found!");
        } catch (RuntimeException ex4){
            System.out.println("Problems with amount of symbols in your file!");
        }
    }
}

// Task 1:
//1 2 3 14
//  5 6 28
//    7 21
//Answer: 1, 2, 3

//Task 2:
//2 3 2 2
//-1 -1 0 -1
//-2 -2 -2 -1
//3 2 2 2