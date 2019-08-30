arr = [1,2,3,4,5]

tree = [0] * (2* len(arr))

def buildTree(arr, tree, start, end, tree_node):
    
    if start == end:
        tree[tree_node] = arr[start]
        return

    mid = (start + end) // 2
    buildTree(arr, tree, start, mid, 2*tree_node)
    buildTree(arr, tree, mid+1, end, 2*tree_node +1)

    tree[tree_node] = tree[2*tree_node] + tree[2*tree_node +1]

buildTree(arr, tree, 0, len(arr)-1, 1)

print(*tree[1:])  