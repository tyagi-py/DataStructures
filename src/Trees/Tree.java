package Trees;

import javax.print.DocFlavor;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree {
    public static void main(String args[]) {
        /*TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(3);
        TreeNode<Integer> node3 = new TreeNode<>(5);
        TreeNode<Integer> node4 = new TreeNode<>(6);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);

        System.out.println(root);*/
        Scanner scanner = new Scanner(System.in);
        //TreeNode<Integer> root = takeInput(scanner);
        TreeNode<Integer> root = takeInputLevelvise();
        /*print(root);*/
        /*System.out.println(countNode(root));*/
        /*System.out.println("Largest Node: " + largestNode(root).data);*/
        /*System.out.println("Height: " + getHeight(root));*/
        /*System.out.println("Nodes at depth 2: ");*/
        /*printNodeAtDepth(2, root);*/
        /*System.out.println("No of Leaves :" + countLeaves(root));*/
        /*transversalPreOrder(root);*/
        transversalPostOrder(root);
    }

    public static TreeNode<Integer> takeInput(Scanner scanner) {
        int n;
        System.out.println("enter next node data");
        n = scanner.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("enter child for :" + n);
        int childCount = scanner.nextInt();
        for (int i = 0; i < childCount; i++) {
            TreeNode<Integer> child = takeInput(scanner);
            root.children.add(child);
        }
        return root;
    }

    public static void print(TreeNode<Integer> root) {
        String s = root.data + ": ";
        for (int i = 0; i < root.children.size(); i++) {
            s = s + root.children.get(i).data + ",";
        }
        System.out.println(s);
        for (int i = 0; i < root.children.size(); i++) {
            print(root.children.get(i));
        }
    }

    public static TreeNode<Integer> takeInputLevelvise() {
        System.out.println("Enter the data of node");
        Scanner scanner = new Scanner(System.in);
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        int n = scanner.nextInt();
        TreeNode<Integer> root = new TreeNode<>(4);
        ((LinkedList<TreeNode<Integer>>) q).add(root);

        while (!q.isEmpty()) {

            System.out.println("Enter no childrens for the node: " + ((LinkedList<TreeNode<Integer>>) q).getFirst().data);
            int child_no = scanner.nextInt();
            System.out.println("Enter the data of childrens ");
            for (int i = 0; i < child_no; i++) {
                n = scanner.nextInt();
                TreeNode<Integer> child = new TreeNode<>(n);
                ((LinkedList<TreeNode<Integer>>) q).add(child);
                ((LinkedList<TreeNode<Integer>>) q).getFirst().children.add(child);

            }
            ((LinkedList<TreeNode<Integer>>) q).pop();
        }
        return root;
    }

    private static int count = 0;

    public static int countNode(TreeNode<Integer> root) {
        count += 1;
        countNodeHelper(root);
        return count;
    }

    private static void countNodeHelper(TreeNode<Integer> root) {
        count += root.children.size();
        for (int i = 0; i < root.children.size(); i++) {
            countNodeHelper(root.children.get(i));
        }
    }

    static public TreeNode<Integer> largestNode(TreeNode<Integer> root) {
        int largest = root.data;
        TreeNode<Integer> largestNode = root;
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        ((LinkedList<TreeNode<Integer>>) q).add(root);

        while (!q.isEmpty()) {
            int child_no = ((LinkedList<TreeNode<Integer>>) q).getFirst().children.size();
            for (int i = 0; i < child_no; i++) {
                ((LinkedList<TreeNode<Integer>>) q).add(((LinkedList<TreeNode<Integer>>) q).getFirst().children.get(i));
            }

            if (largest < ((LinkedList<TreeNode<Integer>>) q).getFirst().data) {
                largest = ((LinkedList<TreeNode<Integer>>) q).getFirst().data;

                largestNode = ((LinkedList<TreeNode<Integer>>) q).getFirst();
            }

            ((LinkedList<TreeNode<Integer>>) q).pop();

        }

        return largestNode;
    }

    private static int finalheight;

    static int getHeight(TreeNode<Integer> root) {
        finalheight = 0;
        if (root != null) {
            finalheight = 1;
        } else {
            return finalheight;
        }

        getheightHelper(1, root);
        return finalheight;
    }

    private static void getheightHelper(int height, TreeNode<Integer> root) {
        if (root.children.size() != 0) {
            height += 1;
        }


        for (int i = 0; i < root.children.size(); i++) {
            getheightHelper(height, root.children.get(i));
            if (finalheight < height) {
                finalheight = height;
            }
        }

    }

    public static void printNodeAtDepth(int depth, TreeNode<Integer> root) {
        int a = 0;

        getNodeAtDepthHelper(a, root, depth);

    }

    private static void getNodeAtDepthHelper(int a, TreeNode<Integer> root, int depth) {
        if (a == depth) System.out.println("Node: " + root.data);
        if (root.children.size() != 0) a += 1;

        for (int i = 0; i < root.children.size(); i++) {
            getNodeAtDepthHelper(a, root.children.get(i), depth);
        }
    }

    private static int leaves_no = 0;

    public static int countLeaves(TreeNode<Integer> root) {
        countLeavesHelper(root);
        return leaves_no;
    }

    private static void countLeavesHelper(TreeNode<Integer> root) {
        if (root.children.size() == 0) leaves_no += 1;

        for (int i = 0; i < root.children.size(); i++) {
            countLeavesHelper(root.children.get(i));
        }
    }

    public static void transversalPreOrder(TreeNode<Integer> root) {
        transversalPreOrderHelper(root);
    }

    private static void transversalPreOrderHelper(TreeNode<Integer> root) {
        System.out.println(root.data);
        for (int i = 0; i < root.children.size(); i++) {
            transversalPreOrderHelper(root.children.get(i));
        }
    }

    public static void transversalPostOrder(TreeNode<Integer> root) {
        transversalPostOrderHelper(root);
    }

    private static void transversalPostOrderHelper(TreeNode<Integer> root) {

        for (int i = 0; i < root.children.size(); i++) {
            transversalPreOrderHelper(root.children.get(i));
        }
        System.out.println(root.data);

    }
}