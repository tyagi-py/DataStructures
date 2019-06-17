def rat_in_maze(maze, n):
    solution = [[0 for j in range(n)]  for i in range(n)]
    
    maze_help(maze, n, solution, 0,0)

def maze_help(maze, n, solution, x, y):
    
    if x==n-1 and y==n-1:
        solution[x][y] = 1
        #print(solution)
        printSolution(solution)

    if x>=n or x <0 or y>=n or y<0 or maze[x][y]==0 or solution[x][y]==1:
        return

    solution[x][y] = 1
    maze_help(maze, n, solution, x-1, y)
    maze_help(maze, n, solution, x+1, y)
    maze_help(maze, n, solution, x, y-1)
    maze_help(maze, n, solution, x, y+1)
    solution[x][y] = 0

def printSolution(solution):
    for i in range(len(solution)):
        for j in range(len(solution)):
            print(solution[i][j], end=" ")
    print("")

n = int(input())
maze = []

for _ in range(n):
    maze.append([int(i) for i in input().strip().split()])

rat_in_maze(maze, n)