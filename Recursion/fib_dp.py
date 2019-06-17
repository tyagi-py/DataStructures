def fib(n,arr):
   
    if n ==0 or n ==1:
        return 1
    if arr[n] != 0:
        return arr[n]
    op = fib(n-1,arr) + fib(n-2,arr)
    arr[n] = op
    return op

n = int(input())
arr = [0 for i in range(n+1)]
print(fib(n,arr))
