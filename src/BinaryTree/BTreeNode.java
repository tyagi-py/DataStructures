package BinaryTree;

public class BTreeNode<T> {

    public T data;
    public BTreeNode<T> left;
    public BTreeNode<T> right;

    public BTreeNode(T data) {
        this.data = data;
    }
}
