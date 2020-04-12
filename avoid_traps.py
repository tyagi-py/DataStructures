import math


def right_most(x):
    f = -1
    n = -1
    for i in x:
        if f <= uni_prime_count[i]:
            f = uni_prime_count[i]
            n = i
    return n

uni_prime_count = []
N = 1000000
is_prime = []

for i in range(N + 1):
    is_prime.append(1)
    uni_prime_count.append(0)


for i in range(2, N + 1):
    if is_prime[i] == 1:
        uni_prime_count[i] = 1
        j = i * 2
        while j <= N:
            uni_prime_count[j] = uni_prime_count[j] + 1
            is_prime[j] = 0
            j = j + i

import sys
x, n = list(map(int, sys.stdin.readline().strip().split()))

ARR = list(map(int, sys.stdin.readline().strip().split()))




mi = math.inf
i = 0
while i < len(ARR) - x + 1:
    mi = min(mi, right_most(ARR[i:i + x]))
    i += 1
print(mi)