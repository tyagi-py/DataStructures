# vertices, edges
# number of vertices going in a vertex is degree
# path : collection of edges
# connected graph: if for every two vertices there is a path connecting them
# connected components: 
# tree: connected graph without a cycle
# n vertices : minimum edges=0  if graph connected, min_edges = n-1
# n vertices : if graph compelete min_edges = nC2 ie n(n-1)//2 ie O(n)
import queue
import sys

class Graph:
    def __init__(self):
        self.v = None
        self.e = None
        self.vertices = None
        self.edges = None

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

def __get_path_helper_dfs(graph, st, en, visited):

    if st == en:
        return [en]
    visited[st] = True
    for i in range(graph.v):
        if graph.edges[st][i] and not visited[i]:
            small_out = __get_path_helper_dfs(graph, i, en, visited)
            if small_out is not None:
                small_out.append(st)
                return small_out
    return None

def get_path_dfs(graph, st, en):
    visited = [False for i in range(graph.v)]
    return __get_path_helper_dfs(graph, st, en, visited)

def is_connected(graph):
    import queue
    visited = [False for i in range(graph.v)]

    q = queue.Queue(maxsize=0)
    q.put(0)
    while not q.empty():
        n = q.get()
        visited[n] = True
        for i in range(graph.v):
            if graph.edges[n][i] == 1 and not visited[i]:
                q.put(i)
                visited[i] = True
    if False in visited:
        return False
    else:
        return True


# TODO: commit on git 
def get_components(graph):
    visited = [False for i in range(graph.v)]
    components = []
    for i in range(graph.v):
        if not visited[i]:
            c = []
            q = queue.Queue(maxsize=0)
            q.put(i)
            while not q.empty():
                n = q.get()
                c.append(n)
                visited[n] = True
                for i in range(graph.v):
                    if graph.edges[n][i] == 1 and not visited[i]:
                        q.put(i)
                        visited[i] = True
            components.append(c)       
    return components

""" *******************Driver code **************** """

graph = graph_input()

print(get_components(graph))
