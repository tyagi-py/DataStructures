package Sorting;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int[] a={1,3,5,7,9,2,4,6,8,10};

        for(int i=1;i<a.length;i++){
            int j=i-1;
            int key=a[i];
            while(j>=0&&a[j]>key){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;

        }
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+"");
        }
    }
}
