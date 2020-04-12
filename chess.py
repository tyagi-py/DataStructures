import sys
N  = int(sys.stdin.readline().strip())
M  = int(sys.stdin.readline().strip())

MAT = []

def mat_change(mat, n, m, i, j):
    row = i+1
    col = j+1
    sol = 0
    while   col<m and row<n:
        if mat[row][col]!= '.':
            break
        col += 1
        sol += 1
        row += 1

    col = j-1
    row = i - 1

    while row>=0 and col>=0:
        if mat[row][col]!= '.':
            break
        sol+=1
        row-=1
        col-=1
    row = i+1
    col = j-1

    while  col>=0 and row<n:
        if mat[row][col]!= '.':
            break
        col-=1
        sol+=1
        row+=1

    col = j+1
    row = i-1

    while col<m and row>=0 :
        if mat[row][col]!= '.':
            break

        col+=1
        sol+=1
        row-=1

    return sol

def change_mat(mat, n, m, i, j):
    sol = 0

    c = j + 1
    while c < m:
        if mat[i][c] != '.':
            break
        sol +=1
        c += 1

    c = j - 1
    while c > -1:
        if mat[i][c] != '.':
            break
        sol+=1
        c -= 1

    r = i + 1
    while r < n:
        if mat[r][j] != '.':
            break
        sol += 1
        r += 1

    r = i-1
    while r >-1:
        if mat[r][j] != '.':
            break
        sol += 1
    r -= 1

    return sol


for i in range(N):
    a = sys.stdin.readline().strip()
    l = []
    for j in a:
        l.append(j)
    MAT.append(l)

sol = 0

for i in range(N):
    for j in range(M):
        if MAT[i][j] != '.':
            if MAT[i][j]== 'R':
                sol+=change_mat(MAT, N, M, i, j)
            elif MAT[i][j]== 'B':
                sol+=mat_change(MAT, N, M, i, j)
            else:
                sol+= change_mat(MAT, N, M, i, j) + mat_change(MAT, N, M, i, j)

print(sol)