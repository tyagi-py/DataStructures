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

    for _ in range(graph.e):
        f, s  = map(int, sys.stdin.readline().strip().split())
        graph.edges[f][s] = 1
        graph.edges[s][f] = 1

    return graph

def print_graph_dfs(graph, sv):

    visited = [False for i in range(graph.v)]

    __print_graph_helper(graph, sv, visited)

def __print_graph_helper(graph, sv, visited):
    print(sv)
    visited[sv] = True

    for i in range(graph.v):
        if i ==  sv:
            continue
        if graph.edges[sv][i] == 1 and not visited[i]:
            __print_graph_helper(graph, i, visited)
            visited[i] = True

import queue
def print_graph_bfs(graph, sv):
    
    visited = [False for i in range(graph.v)]

    q = queue.Queue(maxsize=0)
    q.put(sv)
    while not q.empty():
        n = q.get()
        print(n)
        visited[n] = True
        for i in range(graph.v):
            if graph.edges[n][i] == 1 and not visited[i]:
                q.put(i)
                visited[i] = True

import queue
def has_path(graph, sv, e):
    if sv == e:
        return True
    visited = [False for i in range(graph.v)]

    q = queue.Queue(maxsize=0)
    q.put(sv)
    while not q.empty():
        n = q.get()
        if n == e:
            return True
        visited[n] = True
        for i in range(graph.v):
            if graph.edges[n][i] == 1 and not visited[i]:
                q.put(i)
                visited[i] = True

    return False

def get_path_helper(graph, st, en, visited):

    if st == en:
        return [en]

    visited[st] = True

    for i in range(graph.v):
        if graph.edges[st][i] and not visited[i]:
            small_out = get_path_helper(graph, i, en, visited)
            if small_out is not None:
                small_out.append(st)
                return small_out
    return None

    
        

def get_path(graph, st, en):
    visited = [False for i in range(graph.v)]
    return get_path_helper(graph, st, en, visited)


""" *******************Driver code **************** """

graph = graph_input()
print_graph_dfs(graph, 0)

print(get_path(graph,0, 3))

