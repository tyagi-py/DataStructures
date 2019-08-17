# Given an array of integers A and a sum B, find all unique combinations in A where the sum is equal to B.

# ach number in A may only be used once in the combination.

# Note:
#    All numbers will be positive integers.
#    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
#    The combinations themselves must be sorted in ascending order.
#    If there is no combination possible the print "Empty" (without qoutes).
# Example,
# Given A = 10,1,2,7,6,1,5 and B(sum) 8,

# A solution set is:

# [1, 7]
# [1, 2, 5]
# [2, 6]
# [1, 1, 6]
# def printSubset(arr, k, lst):
#     n=len(arr)
#     if n==0:
#         return
#     if n==1:
#         if arr[0]==k:
#             print(k, *lst)
#             return

#     printSubset(arr[:-1], k, lst)
#     printSubset(arr[:-1], k-arr[-1], [arr[-1]]+lst)
#     if arr[-1]==k:
#         print(k, *lst)
# def printSubsetMain(arr, k):
#     printSubset(arr, k, [])
def subset(arr, k):
    n=len(arr)
    if(n==1):
        if(arr[0]==k):
            output = [ [k] ]
            return output
        else:
            output = []
            return output

    output1 = subset(arr[:-1], k)
    output2 = subset(arr[:-1], k-arr[-1])
    for lst in output2:
        lst.append(arr[-1])
    if arr[-1]==k:
        output2.append([k])
    return output1 + output2

    


T = int(input())
for _ in range(T):
    n = int(input())
    arr = [int(i) for i in input().strip().split()]
    x = int(input())
    print(subset(arr, x))


