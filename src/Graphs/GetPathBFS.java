package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GetPathBFS {

    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();
        graph.getGraph();
        System.out.println("Enter vertex 1:");

        int si = scanner.nextInt();
        System.out.println("Enter vertex 2:");
        int ei = scanner.nextInt();
        getPath(graph,si,ei);

        System.out.println(arrayList);

    }

    static void getPath(Graph graph, int si, int ei) {
        if(si ==ei){
            arrayList.add(ei);
            return;
        }
        if(!HasPath.hasPath(graph,si,ei)){
            return;
        }
        arrayList.add(si);
        boolean[] visited = new boolean[graph.n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(si);
        visited[si] = true;
        boolean flag =true;
        while (!queue.isEmpty()){
            int item = queue.remove();
            for(int i =0;i<graph.n && flag;i++){
                if(graph.Edges[i][item]==1 && !visited[i] && HasPath.hasPath(graph,i,ei)){

                    arrayList.add(i);
                    if(graph.Edges[i][ei]==1) flag =false;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        arrayList.add(ei);
    }
}
