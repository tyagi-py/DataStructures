def n_fib(n):
    if n == 1:
        print(1)
        return
    print(1, end=" ")
    a = 0
    b = 1
    
    i = 0

    while i < n-1:
        c = a + b
        a = b
        b = c
        print(c, end=" ")

        i += 1
    print()

        
T = int(input())
for _ in range(T):
    n = int(input())
    n_fib(n)