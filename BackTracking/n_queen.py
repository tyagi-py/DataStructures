n = int(input())
board = [[0 for i in range(n)] for j in range(n)]

def nQueen(board , row):
    if row >= len(board):
        for i in range(len(board)):
            for j in range(len(board)):
                print(board[i][j], end=" ")
        print("")
        return 
    for i in range(len(board)):
        if isPossible(board, row, i):
            board[row][i] = 1
            
            nQueen(board, row +1)
            board[row][i] = 0
    


def isPossible(board, row, col):
    
    for i in range(row, -1, -1):
        if board[i][col] == 1:
            return False
    i = row-1
    j = col-1
    while i>-1 and j >-1:
        if board[i][j] == 1:
            return False
        i-=1
        j-=1

    i = row-1
    j = col+1
    while i > -1 and j < len(board):
        if board[i][j] ==1:
            return False
        i-=1
        j+=1
    
    return True

nQueen(board, 0)


