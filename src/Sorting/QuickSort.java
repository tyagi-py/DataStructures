package Sorting;

public class QuickSort {
    public static void main(String args[]){
        int[] array = {1,3,5,7,9,2,4,6,8,10};
        quickSort(array,0,array.length-1);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
    public static void quickSort(int[] arr,int si,int ei){
        if(si>=ei) return;

        int pivot = partition(arr,si,ei);
        quickSort(arr,si,pivot-1);
        quickSort(arr,pivot+1,ei);
    }

    private static int partition(int[] arr, int si, int ei) {
        int pivot = arr[si];
        int count = 0;
        for(int i = si+1;i<=ei;i++){
            if(arr[i]<pivot){
                count++;
            }
        }
        int pivot_pos = si+count;
        //swap(arr[si],arr[si+count]);
        int temp = arr[si];
        arr[si] = arr[si+count];
        arr[si+count] = temp;
        int i = si;
        int j = ei;
        while(i<pivot_pos && j>pivot_pos){
            if(arr[i]<arr[pivot_pos]){
                i++;
            }
            else{
                if(arr[j]<arr[pivot_pos]){
                    //swap(arr[i],arr[j]);
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
                else{
                    j--;
                }
            }
        }
        return pivot_pos;
    }
    

}
