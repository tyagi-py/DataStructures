def mergeSort(arr, beg, end):
    if beg >= end:
        return 
    mid = (beg + end)//2

    mergeSort(arr, beg, mid)
    mergeSort(arr, mid +1, end)
    merge(arr, beg, end)

def merge(arr, beg, end):
    
    i = beg
    mid =(beg + end)//2
    j = mid +1

    t = []
    while i <= mid and j <= end:
        if arr[i] < arr[j]:
            
            t.append(arr[i])
            i +=1

        else:
            t.append(arr[j])
            j +=1
    if i <=mid:
        while i <= mid:
            t.append(arr[i])
            i +=1
    else:
        while j <= end:
            t.append(arr[j])
            j +=1
    for k in range(len(t)):
        arr[beg + k] = t[k]
# Main
n=int(input())
arr=list(int(i) for i in input().strip().split(' '))
mergeSort(arr, 0, n-1)
print(*arr)