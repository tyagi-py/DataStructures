package Graphs;

import java.util.Scanner;

public class DirectedGraph {
    int n,e;
    int[][] Edges;

    public  void getGraph(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter No of Vertices: ");

        n = scanner.nextInt();
        System.out.println("Enter no of edges: ");
        e = scanner.nextInt();
        Edges = new int[n][n];
        System.out.println("Enter Edges: ");


        for(int j = 0; j< e; j++){
            int si = scanner.nextInt();
            int ei = scanner.nextInt();
            Edges[si][ei] = 1;

        }

    }
}
