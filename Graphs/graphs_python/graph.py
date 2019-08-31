# vertices, edges
# number of vertices going in a vertex is degree
# path : collection of edges
# connected graph: if for every two vertices there is a path connecting them
# connected components: 
# tree: connected graph without a cycle
# n vertices : minimum edges=0  if graph connected, min_edges = n-1
# n vertices : if graph compelete min_edges = nC2 ie n(n-1)//2 ie O(n)
class Graph:
    def __init__(self):
        self.v = None
        self.e = None
        self.vertices = None
        self.edges = None

import sys

""" take input from user and return a graph object """
def graph_input():
    graph = Graph()
    print("Number of vertices?")
    graph.v = int(sys.stdin.readline().strip())
    graph.edges = [ [0 for i in range(graph.v)] for j in range(graph.v)]
    print("Number of edges?")
    graph.e = int(sys.stdin.readline().strip())

    for i in range(graph.e):
        f, s  = map(int, sys.stdin.readline().strip().split())
        graph.edges[f][s] = 1
        graph.edges[s][f] = 1

    return graph

def print_graph(graph, sv):

    visited = [False]*graph.v

    print_graph_helper(graph, sv, visited)

def print_graph_helper(graph, sv, visited):
    print(sv)
    visited[sv] = True

    for i in range(graph.v):
        if i ==  sv:
            continue
        if graph.edges[sv][i] == 1 and not visited[i]:
            print_graph_helper(graph, i, visited)
            visited[i] = True




""" *******************Driver code **************** """

graph = graph_input()

print_graph(graph, 1)


