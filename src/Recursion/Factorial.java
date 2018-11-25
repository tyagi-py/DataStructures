package Recursion;
import  java.util.Scanner;
public class Factorial {
    public static void main(String args[]){
        int n;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number");
        n = scanner.nextInt();
        System.out.println(fact(n));
    }
    static int fact(int f){
        if(f==1||f==0) return  1;
        else return f*fact(f-1);
    }
}
