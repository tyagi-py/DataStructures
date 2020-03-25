// Java program to find  minimum number of swaps 
// required to sort an array 
import java.util.ArrayList;
import java.util.*;

public class MinSwaps
{
    private static void minSwaps(int arr[]) {
        int swaps = 0;
        boolean[] visited = new boolean[ arr.length];

        for (int i = 0; i < arr.length; i++) {
            int j = i;
            int cycles = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j] - 1;
                cycles++;
            }

            if (cycles != 0) {
                swaps = swaps + cycles - 1;
            }
        }
        System.out.println("Minimum number of swaps :: " + swaps);
    }

    public static void main(String[] args)
    {
        int []a = {1, 5, 4, 3, 2};

       minSwaps(a);
    }
}

