package BinaryTree;


import LinkedList.LinkedList;
import LinkedList.Node;

public class BSTUse {

    public static void main(String args[]){
        //BTreeNode<Integer> root = BinaryTreeUse.takeInputIter();
        /*BTreeNode<Integer> e = findElement(root, 8);
        if (e == null) System.out.println("Not present");
        else System.out.println(e.data);*/
        /*System.out.println("Max :" + maxof(root));
        System.out.println("Min : "+ minof(root));
        System.out.println("bst: "+ checkBST2(root));
        findRange(root,2,6);
        Integer a = 3;
        System.out.println(a);*/
        int[] a = {1,2,3,4,5,6,7};
        BinaryTreeUse.printTree(buildBST(a));

    }
    public static BTreeNode<Integer> findElement(BTreeNode<Integer> root,int key){
        if (root == null) return null;
        if (root.data == key) return root;

        if (root.data > key) return findElement(root.left,key);
        else return findElement(root.right, key);
    }
    public static void findRange(BTreeNode<Integer> root, int start, int end){
        if (root == null) return;
        System.out.println(root.data);
        if (root.data > start) findRange(root.left,start,end);
        if (root.data < end) findRange(root.right,start,end);
    }
    public static boolean checkBST(BTreeNode<Integer> root){
        if (root == null) return true;

        boolean childs = checkBST(root.left) & checkBST(root.right);
        System.out.println(childs);
        if (childs == false) return false;
        if (root.right == null & root.left == null) return true;

        if (root.data < minof(root.right) & root.data > maxof(root.left)) return true;
        else return false;

    }

    public static int maxof(BTreeNode<Integer> root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.data,Math.max(maxof(root.left),maxof(root.right)));
    }
    public static int minof(BTreeNode<Integer> root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.data,Math.min(minof(root.left),minof(root.right)));
    }

    public static Pair2 checkBSTBetter(BTreeNode<Integer> root){

        Pair2<Integer> pair = new Pair2<>();
        pair.min = Integer.MAX_VALUE;
        pair.max = Integer.MIN_VALUE;
        pair.isBST = true;

        if (root == null) return pair;

        Pair2 gpairl = checkBSTBetter(root.left);
        Pair2 gpairr = checkBSTBetter(root.right);

        pair.min = Math.min(root.data,Math.min((int)gpairl.min,(int)gpairr.min));
        pair.max = Math.max(Math.max((int)gpairl.max,(int)gpairr.max),root.data);

        boolean minmax = root.data < (int) gpairr.min & root.data > (int) gpairl.max;
        pair.isBST = gpairl.isBST & gpairr.isBST & minmax;

        return pair;
    }

    public static boolean checkBST2(BTreeNode<Integer> root){
        return checkBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkBSTHelper(BTreeNode<Integer> root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.data < minValue | root.data > maxValue) return false;
        return checkBSTHelper(root.left, minValue, Math.min(root.data, maxValue)) & checkBSTHelper(root.right, Math.max(root.data, minValue),maxValue);
    }
    public static BTreeNode<Integer> buildBST(int[] arr){
        int BEG = 0;
        int END = arr.length - 1;

        return buildBSTHelper(arr,BEG,END);
    }

    private static BTreeNode<Integer> buildBSTHelper(int[] arr, int BEG, int END) {
        if (BEG > END) return null;
        int mid = (BEG + END) / 2;
        BTreeNode<Integer> root = new BTreeNode<>(arr[mid]);
        root.left = buildBSTHelper(arr,BEG,mid-1);
        root.right = buildBSTHelper(arr,mid+1, END);
        return root;

    }

}
