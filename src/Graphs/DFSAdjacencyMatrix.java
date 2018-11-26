package Graphs;

import java.util.Scanner;

public class DFSAdjacencyMatrix {
    static int n,e;
    static int[][] Edges;


    public static void main(String args[]){
        getGraph();
        print(Edges);


    }
    static void getGraph(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter No of n: ");

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
    static  void PrintHelper(int[][] edges,int sv, boolean[] visited){
        System.out.println(sv);
        visited[sv] = true;
        for(int i=0; i<edges.length; i++){
            if(edges[sv][i] == 1 && !visited[i]){
                PrintHelper(edges,i,visited);
            }
        }
    }
    static  void print(int[][] edges){
        boolean[] visited = new boolean[edges.length];

        for(int i=0;i<edges.length;i++){
            if(!visited[i]){
                PrintHelper(edges,i,visited);
            }
        }
    }

}
