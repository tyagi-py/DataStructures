val = [100,20,60,40]
wt = [3,2,4,1]
W = 5
def knapsack(W, wt, val):
    dp_arr = [[0 for i in range(W+1)] for j in range(len(val)+1)]

    for i in range(len(val)+1):
        for j in range(W+1):
            if i == 0 or j == 0:
                dp_arr[i][j] = 0
            elif wt[i-1] > j:
                dp_arr[i][j] = dp_arr[i-1][j]
            else:
                dp_arr[i][j] = max(dp_arr[i-1][j],  val[i-1] + dp_arr[i-1][j - wt[i-1]])
    for i in range(len(val)+1):
        for j in range(W+1):
            print(dp_arr[i][j], end=" ")
        print("")
    return dp_arr[len(val)][W]

print(knapsack(W, wt, val))