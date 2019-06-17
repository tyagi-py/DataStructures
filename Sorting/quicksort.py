def quickSort(arr, beg, end):
    # Please add your code here
    if beg >= end:
        return
    pivot = partition(arr, beg, end )
    quickSort(arr, beg, pivot-1)
    quickSort(arr, pivot+1, end)

def partition(arr, start, end):
    pivot = arr[start]
    count = 0
    for i in range(start+1, end+1):
        if arr[i] < pivot:
            count +=1
    pivot_pos = start + count
    arr[pivot_pos], arr[start] = arr[start], arr[pivot_pos]
    pivot = arr[pivot_pos]
    
    i = start
    j = end
    while i < pivot_pos and j > pivot_pos:
        if arr[i] <= pivot:
            i +=1
        else:
            if arr[j] >= pivot:
                j-=1
            else:
                arr[i], arr[j] = arr[j], arr[i]
    return pivot_pos

n=int(input())
arr=list(int(i) for i in input().strip().split(' '))
quickSort(arr, 0, n-1)
print(*arr)
