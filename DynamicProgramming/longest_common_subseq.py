'''
Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.

Input:
First line of the input contains no of test cases  T,the T test cases follow.
Each test case consist of 2 space separated integers A and B denoting the size of string str1 and str2 respectively
The next two lines contains the 2 string str1 and str2 .

Output:
For each test case print the length of longest  common subsequence of the two strings .

Constraints:
1<=T<=200
1<=size(str1),size(str2)<=100

Example:
Input:
2
6 6
ABCDGH
AEDFHR
3 2
ABC
AC

Output:
3
2

Explanation
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.

LCS of "ABC" and "AC" is "AC" of length 2
'''


import sys
T = int(sys.stdin.readline())
for _ in range(T):
    n1, n2 = map(int, sys.stdin.readline().strip().split(' '))
    s1 = sys.stdin.readline()
    s2 = sys.stdin.readline()
    arr = [[0 for j in range(n1+1)] for i in range(n2+1)]
    for i in range(1, n2+1):
        for j in range(1, n1+1):
            if s2[i-1] == s1[j-1]:
                arr[i][j] = arr[i-1][j-1] + 1
            else:
                arr[i][j] = max(arr[i-1][j],arr[i][j-1])
    
    # for i in range(n2+1):
    #     for j in range(n1+1):
    #         print(arr[i][j], end= ' ')
    #     print()
    print(arr[n2][n1])