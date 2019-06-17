package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HasPath {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();
        graph.getGraph();
        System.out.println(" Enter vertex 1:");
        int si = scanner.nextInt();
        System.out.println("Enter vertex 2:");
        int ei = scanner.nextInt();
        System.out.println(hasPath(graph, si, ei));

    }
    public static boolean hasPath(Graph graph,int si,int ei){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.n];
        queue.add(si);
        visited[si] = true;
        boolean flag = false;
        while (!queue.isEmpty()){
            int item = queue.remove();
            for(int i=0; i<graph.n; i++){
                if(graph.Edges[item][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    if(i==ei){
                        flag = true;
                    }
                }
            }
        }

        return flag;
    }

}
