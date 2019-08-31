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

def update_tree(arr, tree, start, end, tree_node, idx, val):

    if start == end:
        arr[idx] = val
        tree[tree_node] = val
        return
    
    mid = (start + end)//2
    if idx > mid:
        update_tree(arr, tree, mid+1, end, 2*tree_node, idx, val)
    else:
        update_tree(arr, tree, start, mid, 2*tree_node, idx, val)
    
    tree[tree_node] = tree[2*tree_node] + tree[2*tree_node +1]

def query(tree, start, end, tree_node, left, right):

    """ completely outside given range """
    if start > right or end < left:
        return 0

    """ Completely inside the given range """
    if start >= left and end <= right:
        return tree[tree_node]

    """ Partially inside and partially outside """
    mid = (start + end)//2
    ans1 = query(tree, start, mid, 2*tree_node, left, right)
    ans2 = query(tree, mid+1, end, 2*tree_node, left, right)
    return ans1 + ans2


buildTree(arr, tree, 0, len(arr)-1, 1)
update_tree(arr, tree, 0, len(arr)-1, 1, 2, 10)

ans= query(tree,0,4,1,2,4)
print(ans)
print(*tree[1:])