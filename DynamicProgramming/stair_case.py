# find the number of ways how can we take n steps
# if we can take 1, 2 or 3 steps at a time

n = int(input())

arr = [0] * (n+1)

arr[0] = 1
arr[1] = 1
arr[2] = 2

for i in range(3, n+1):
    arr[i] = arr[i-1] + arr[i-2] + arr[i-3]
print(arr[n+1])