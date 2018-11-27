package Graphs;
import java.util.LinkedList;
import  java.util.Queue;
public class BFS_Transverse {

    public static  void main(String args[]) {
        Graph g = new Graph();
        g.getGraph();
        print(g);
    }
    static void printHelper(Graph graph,int si,boolean[] visited){
        Queue<Integer> q =new LinkedList<Integer>();

        q.add(si);
        visited[si] =true;
        while(q.size()!=0){
            int removed = q.remove();

            System.out.println(removed);
            for(int i=0;i<graph.n;i++){
                if(graph.Edges[i][removed]==1 && !visited[i]){
                    q.add(i);
                    visited[i] =true;
                }
            }
        }
    }
    static void print(Graph graph){
        boolean[] visited = new boolean[graph.n];

        for(int i=0;i<graph.n;i++){
            if(!visited[i]){
                printHelper(graph,i,visited);
            }
        }
    }


}
