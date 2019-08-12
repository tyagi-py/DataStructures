def bin_search(arr, key):
    beg = 0
    end = len(arr)-1
    
    while beg <= end:
        mid = (beg + end)//2
        if arr[mid] == key:
            return mid
        elif key < arr[mid]:
            end = mid - 1
        else:
            beg = mid + 1
    return -1

arr = [int(i) for i in input().strip().split()]
key = int(input())
print(bin_search(arr, key))
