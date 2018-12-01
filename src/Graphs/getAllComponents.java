package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class getAllComponents {
    public static void main(String args[]){

        Graph graph = new Graph();
        graph.getGraph();

        System.out.println(getallComponents(graph));

    }

    public  static ArrayList<ArrayList<Integer>> getallComponents(Graph graph){

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        boolean[] visited = new boolean[graph.n];

        for(int i=0; i<graph.n; i++){
            if(!visited[i]){
                arrayLists.add(getallComponentsHelper(graph,i,visited));
            }
        }
        return arrayLists;
    }

    private static ArrayList<Integer> getallComponentsHelper(Graph graph,int si,boolean[] visited){

        //Component in form of arraylist
        ArrayList<Integer> arrayList = new ArrayList<>();

        //BFS Transverse
        Queue<Integer> queue = new LinkedList<>();

        queue.add(si);
        visited[si] = true;

        while ((!queue.isEmpty())){
            int e = queue.remove();
            arrayList.add(e);
            for (int i=0; i<graph.n; i++){
                if(graph.Edges[i][e]==1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        return  arrayList;
    }
}
