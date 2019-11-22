# #Given two arrays of integers, write a program to check if a pair of values (one value from each array) exists such that swapping the elements of the pair will make the sum of two arrays equal.
#
# Input:
# First line of input contains a single integer T which denotes the number of test cases. T test cases follows. First line of each test case contains two space separated integers N and M. Second line of each test case contains N space separated integers denoting the elements of first array. Third line of each test case contains M space separated integers denoting the elements of second array.
#
# Output:
# For each test case, print 1 if there exists any such pair otherwise print -1.
#
# Constraints:
# 1 <= T <= 100
# 1 <= N <= 104
# 1 <= M <= 104
# 0 <= elements <= 104
#
# Example:
# Input:
# 2
# 6 4
# 4 1 2 1 1 2
# 3 6 3 3
# 4 4
# 5 7 4 6
# 1 2 3 8
#
# Output:
# 1
# 1
#
# Explanation:
# Testcase 1: 1 and 3 are two such values one from first array other from second one, if we swap these two values then we will get both arrays sum as equal.


import sys

T = int(sys.stdin.readline().strip())

for _ in range(T):
    m, i = list(map(int, sys.stdin.readline().strip().split()))
    arr1 = list(map(int, sys.stdin.readline().strip().split()))
    arr2 = list(map(int, sys.stdin.readline().strip().split()))
    arr = None
    s = None
    if sum(arr1) == sum(arr2):
        print(1)
        continue
    if sum(arr1) < sum(arr2):
        arr = arr1
        s = set(arr2)
    else:
        arr = arr2
        s = set(arr1)
    for i in arr:
        if
