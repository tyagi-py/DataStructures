package Graphs;

import java.util.Scanner;

public class DFSAdjacencyMatrix {

    public static void main(String args[]){
        Graph graph = new Graph();
        graph.getGraph();

        print(graph.Edges);


    }

    private static  void PrintHelper(int[][] edges,int sv, boolean[] visited){
        System.out.println(sv);
        visited[sv] = true;
        for(int i=0; i<edges.length; i++){
            if(edges[sv][i] == 1 && !visited[i]){
                PrintHelper(edges,i,visited);
            }
        }
    }
    public static  void print(int[][] edges){
        boolean[] visited = new boolean[edges.length];

        for(int i=0;i<edges.length;i++){
            if(!visited[i]){
                PrintHelper(edges,i,visited);
            }
        }
    }

}
