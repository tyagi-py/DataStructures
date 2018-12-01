package Graphs;

import java.util.Scanner;

public class WeightedGraph {
    int n,e;
    int[][] Edges;
    int[] Vertices;
    public  void getGraph(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter No of Vertices: ");

        n = scanner.nextInt();
        System.out.println("Enter no of edges: ");
        e = scanner.nextInt();
        Edges = new int[n][n];
        System.out.println("Enter Edges and Their weight: ");


        for(int j = 0; j< e; j++){
            int si = scanner.nextInt();
            int ei = scanner.nextInt();
            int wt = scanner.nextInt();
            Edges[si][ei] = wt;
            Edges[ei][si] = wt;
        }

    }

}
