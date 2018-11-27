package Graphs;
import java.util.LinkedList;
import  java.util.Queue;
public class BFS_Transverse {

    public static  void main(String args[]) {
        Graph g = new Graph();
        g.getGraph();
        print(g);
    }
    static void print(Graph graph){
        Queue<Integer> q =new LinkedList<Integer>();
        int si =0 ;
        q.add(si);


        boolean[] visited = new boolean[graph.n];
        while(q.size()!=0){
            int removed = q.remove();
            visited[removed] = true;
            System.out.println(removed);
            for(int i=0;i<graph.n;i++){
                if(graph.Edges[i][removed]==1 && !visited[i]){
                    q.add(i);
                }
            }
        }
    }


}
