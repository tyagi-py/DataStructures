arr = [1,3,5,2,4,8,6]

op = [0]*len(arr)
op[0] = 1

for i in range(1, len(arr)):
    maxx = 0
    for j in range(i-1, -1, -1):
        if arr[j] < arr[i]:
            if op[j] > maxx:
                maxx = op[j] 
    op[i] = maxx + 1

print(max(op))
