package Sorting;
import java.util.Scanner;
public class MergeSort {
    static  int[] array ;
    static int n;
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        array = new int[n];
        System.out.println("Enter Elemets:");
        for(int i=0;i<array.length;i++){
            array[i] = scanner.nextInt();
        }
        System.out.println("Sroted Array: ");
        mergesort(array,0,array.length-1);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }

    }

    static void mergesort(int[] arr,int BEG,int END){

        if(BEG>=END) return;

        int mid = (BEG + END)/2;
       // System.out.println("beg "+BEG+" End "+END+" mid "+mid);
        mergesort(arr,BEG,mid);
        mergesort(arr,mid+1,END);
        merge(arr,BEG,END);
    }
    static void merge(int[] arr,int BEG,int END){
        int i = BEG;
        int mid = (BEG + END)/2;
        int j = mid+1;
        int c = 0;
        int[] temp = new int[END-BEG+1];

        while(i<=mid && j<=END){
           // System.out.println("Merge: "+" arr[i] arr[j] "+arr[i]+" "+arr[j]);
            if(arr[i]<arr[j]){
                temp[c] = arr[i];
                i++;
            }
            else{
                temp[c] = arr[j];
                j++;
            }
            c++;
        }
        if (i<mid){
            while (i<=mid){
                temp[c]=arr[i];
                c++;
                i++;
            }
        }
        else{
            while (j<=END){
                temp[c]=arr[j];
                c++;
                j++;
            }
        }

       for(int k=0;k<temp.length;k++){
           arr[BEG+k] =temp[k];
       }

    }

}
