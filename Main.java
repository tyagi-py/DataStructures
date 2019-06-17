import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // Write your code here
        Scanner in = new Scanner(System.in);
        int N, target;

        N = in.nextInt();
        target = in.nextInt();

        int arr[] = new int[N];


        for (int i = 0; i < N; i++){
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < N; i++){
            if (arr[i] == target){
                System.out.println("true");
                System.out.println(target);
                return;
            }
            if (arr[i] < target){
                int j = i +1;
                int s = arr[i];
                while (s < target && j < N){
                    s = s + arr[j];
                    j++;
                }
                if (s == target){
                    System.out.println("true");
                    for (int x = i; x <j; x++){
                        System.out.print(arr[x]+ " ");
                    }
                    return;
                }
            }
        }

    }

}