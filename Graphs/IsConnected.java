package Graphs;

public class IsConnected {
    static int count = 0;
    public static void main(String args[]){

        Graph graph = new Graph();
        graph.getGraph();
        System.out.println(isConnected(graph));
    }
    public static boolean isConnected(Graph graph){
        boolean[] visited = new boolean[graph.n];
        int si = 0;

        isConnectedHelperDFS(graph,si,visited);
        if(count == graph.n) return true;
        else return  false;

    }



    private static void isConnectedHelperDFS(Graph graph, int si, boolean[] visited) {
        visited[si] = true;
        count++;
        for(int i=0; i<graph.n; i++){
            if(graph.Edges[i][si]==1 && !visited[i]){
                isConnectedHelperDFS(graph, i, visited);
            }
        }
    }
}
