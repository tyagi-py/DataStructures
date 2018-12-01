package Graphs;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Scanner;

public class GetPathDFS {
    static  ArrayList<Integer> arrayList = new ArrayList<>();
    static  boolean flag =true;
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();
        graph.getGraph();
        System.out.println(" Enter vertex 1:");
        int si = scanner.nextInt();
        System.out.println("Enter vertex 2:");
        int ei = scanner.nextInt();
        getPath(graph,si,ei);
        System.out.println(arrayList);

    }

    static void getPath(Graph graph, int si, int ei){

        boolean visited[] = new boolean[graph.n];

        if(si == ei){
            arrayList.add(ei);
            return ;
        }

        if(!HasPath.hasPath(graph,si,ei)) return ;
        else{
            arrayList.add(si);
            getPathHelper(graph,si,ei,visited);
            arrayList.add(ei);
        }






    }
    private static void getPathHelper(Graph graph, int si,int ei, boolean[] visited){

        visited[si] =true;
        for(int i=0;i<graph.n;i++){
            if(graph.Edges[si][i]==1 && !visited[i] && HasPath.hasPath(graph,i,ei) && flag){
                if(graph.Edges[i][ei]==1){
                    flag = false;
                }
                arrayList.add(i);
                getPathHelper(graph,i,ei,visited);


            }
        }

    }
}
