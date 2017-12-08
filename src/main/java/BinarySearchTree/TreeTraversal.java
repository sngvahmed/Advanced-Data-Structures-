package BinarySearchTree;/*
* see doc
* http://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
* different between postorder , preorder and inorder
* */

import static sun.swing.MenuItemLayoutHelper.max;

public class TreeTraversal {

    class Node {
        Node left, right;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    private StringBuilder res = new StringBuilder("");

    public Node generateRoot() {
        Node root = new Node(1);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node2.left = node4;
        node2.right = node5;
        root.left = node2;
        root.right = node3;

        return root;
    }


    TreeTraversal() {
    }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        printNode(node);
        inorder(node.right);
    }

    private void preorder(Node node) {
        if (node == null) return;

        printNode(node);
        preorder(node.left);
        preorder(node.right);
    }

    private void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        printNode(node);
    }

    private void printNode(Node node) {
        res.append(node.value);
    }

    /*
    * Inorder (Left, Root, Right)
    * */
    public String testInorder(Node root) {
        res = new StringBuilder("");
        inorder(root);
        return res.toString();
    }

    /*
    * Preorder (Root, Left, Right)
    * */
    public String testPreorder(Node root) {
        res = new StringBuilder("");
        preorder(root);
        return res.toString();
    }

    /*
    * Postorder (Left, Right, Root)
    * */
    public String testPostOrder(Node root) {
        res = new StringBuilder("");
        postOrder(root);
        return res.toString();
    }

}
