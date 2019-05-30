package BinaryTree;

import javax.print.DocFlavor;
import java.util.*;

public class BinaryTreeUse {

    public static void main(String args[]){
        /*BTreeNode<Integer> root = new BTreeNode<>(1);
        root.left = new BTreeNode<>(2);
        root.right = new BTreeNode<>(3);
        System.out.println(root.data);*/

        Scanner scanner = new Scanner(System.in);
        BTreeNode<Integer> root = takeInputIter();
        /*printTree(root);
        System.out.println("No of Nodes: " + countNodes(root));
        System.out.println("Diameter: "+diameter(root));
        System.out.println("Diameter Efficiently: "+heightDiameter(root).d);
        System.out.println("Height : "+ getHeight(root));
        System.out.println("PreOrder Transversal: ");
        preOrder(root);
        int pre[] = {1,2,4,5,3,6,7};
        int in[] = {4,2,5,1,6,3,7};
        printTree(buildTree(in, pre));*/

        System.out.println(getPath(root,new BTreeNode<Integer>(6)));

    }
    public static  BTreeNode<Integer> takeInput(Scanner scanner){
        int rootData;
        System.out.println("Enter root data");
        rootData = scanner.nextInt();

        if (rootData == -1) return null;

        BTreeNode<Integer> root = new BTreeNode<>(rootData);

        root.left = takeInput(scanner);
        root.right = takeInput(scanner);
        return root;
    }
    public static void printTree(BTreeNode<Integer> root){
        if (root == null) return;

        String res = root.data + ":= ";

        if (root.left != null) res += "L: "+ root.left.data +",";
        if (root.right != null) res += "R: " + root.right.data;

        System.out.println(res);

        printTree(root.left);
        printTree(root.right);
    }
    public static BTreeNode<Integer> takeInputIter(){

        System.out.println("Enter root data: ");
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        BTreeNode<Integer> root = new BTreeNode<>(data);

        Queue<BTreeNode<Integer>> q = new LinkedList<>();
        ((LinkedList<BTreeNode<Integer>>) q).add(root);

        while (!q.isEmpty()){
            int n;
            System.out.println("Enter the left of "+ ((LinkedList<BTreeNode<Integer>>) q).getFirst().data);
            n = scanner.nextInt();
            if (n == -1) ((LinkedList<BTreeNode<Integer>>) q).getFirst().left = null;
            else {
                ((LinkedList<BTreeNode<Integer>>) q).getFirst().left = new BTreeNode<>(n);
                ((LinkedList<BTreeNode<Integer>>) q).add(((LinkedList<BTreeNode<Integer>>) q).getFirst().left);

            }
            System.out.println("Enter the right of "+ ((LinkedList<BTreeNode<Integer>>) q).getFirst().data);
            n = scanner.nextInt();
            if (n == -1) ((LinkedList<BTreeNode<Integer>>) q).getFirst().right = null;
            else{
                ((LinkedList<BTreeNode<Integer>>) q).getFirst().right = new BTreeNode<>(n);
                ((LinkedList<BTreeNode<Integer>>) q).add(((LinkedList<BTreeNode<Integer>>) q).getFirst().right);

            }
            ((LinkedList<BTreeNode<Integer>>) q).pop();

        }
        return root;
    }
    static int count ;
    public static int countNodes(BTreeNode<Integer> root){
        if  (root == null){
            count = 0;
            return count;
        }

        countHelper(root);


        return count;
    }

    private static void countHelper(BTreeNode<Integer> root) {
        count += 1;

        if(root.left != null) countHelper(root.left);
        if(root.right != null) countHelper(root.right);

    }
    /*Time complexity of diameter O(n * h) */
    public static int diameter(BTreeNode<Integer> root){
        if (root == null) return 0;

        int op1 = height(root.left) + height(root.right);
        int op2 = diameter(root.left);
        int op3 = diameter(root.right);

        return Math.max(op1,Math.max(op2,op3));

    }

    //time complexity of height: O(n)

    private static int height(BTreeNode<Integer> root) {

        if (root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return 1 + Math.max(lh, rh);
    }

    public static  Pair<Integer, Integer> heightDiameter(BTreeNode<Integer> root){
        if (root == null){
            Pair<Integer, Integer> pair = new Pair<>();
            pair.d = 0;
            pair.h = 0;
            return pair;
        }

        Pair<Integer, Integer> lo = heightDiameter(root.left);
        Pair<Integer, Integer> ro = heightDiameter(root.right);

        int height = 1 + Math.max(lo.h, lo.h);

        int op1 = lo.h + ro.h;

        int op2 = lo.d;
        int op3 = ro.d;
        int diameter = Math.max(op1, Math.max(op2,op3));

        Pair<Integer, Integer> op = new Pair<>();

        op.h = height;
        op.d = diameter;

        return op;

    }

    public static int getHeight(BTreeNode<Integer> root){
        if (root == null) return 0;

        return 1 + Math.max(getHeight(root.right),getHeight(root.left));
    }

    public static void preOrder(BTreeNode<Integer> root){
        if (root == null) return;

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(BTreeNode<Integer> root){
        if (root == null) return ;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static void inOrder(BTreeNode<Integer> root){
        if (root == null) return;

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public static BTreeNode<Integer> buildTree(int in[], int pre[]){

        return buildTreeHelper(in, pre, 0, in.length-1, 0, pre.length-1);

    }
    private static BTreeNode<Integer> buildTreeHelper(int in[], int pre[], int inst, int inend, int prest, int preend){

        if (inst > inend ) return null;

        int r = pre[prest];
        BTreeNode<Integer> root = new BTreeNode<>(r);
        int rootIndx = -1;
        for (int i = inst; i <= inend; i++){
            if (in[i] == r){
                rootIndx = i;
                break;
            }
        }

        int inleftst = inst;
        int inleftend = rootIndx - 1;
        int inrightst = rootIndx + 1;
        int inrightend = inend;

        int preleftst = prest + 1;
        int preleftend = inleftend - inleftst + preleftst;
        int prerightst = preleftend + 1;
        int prerightend = preend;

        root.left = buildTreeHelper(in, pre, inleftst, inleftend, preleftst, preleftend);
        root.right = buildTreeHelper(in, pre, inrightst, inrightend, prerightst, prerightend);

        return root;
    }

    private static ArrayList<Integer> a  = new ArrayList<>();
    boolean flag = true;
    public static boolean getPath(BTreeNode<Integer> root, BTreeNode<Integer> node){
        if (root ==  null) return false;
        a.add(root.data);
        if (root.data == node.data) return true;

        printa(a);
        return getPath(root.left,node) | getPath(root.right,node);

    }
    private static void printa(ArrayList<Integer> a){
        for (int i = 0; i < a.size(); i++){
            System.out.print(a.get(i));
        }
        System.out.println("");
    }

}
