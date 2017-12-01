package BinarySearchTree;/*
* see doc
* http://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
* different between postorder , preorder and inorder
* */

public class TreeTraversal {
    private Node root;
    private StringBuilder res = new StringBuilder("");

    class Node {
        public Node left;
        public Node right;
        public Integer value;

        Node(Integer value) {
            this.value = value;
        }
    }

    TreeTraversal() {
        root = new Node(1);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node2.left = node4;
        node2.right = node5;
        root.left = node2;
        root.right = node3;
    }


    /*
    * Inorder (Left, Root, Right)
    * */
    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        printNode(node);
        inorder(node.right);
    }

    /*
    * Preorder (Root, Left, Right)
    * */
    private void preorder(Node node) {
        if (node == null) return;

        printNode(node);
        preorder(node.left);
        preorder(node.right);
    }

    /*
    * Postorder (Left, Right, Root)
    * */
    private void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        printNode(node);
    }

    private void printNode(Node node) {
        res.append(node.value);
    }

    public String testInorder() {
        reset();
        inorder(root);
        return res.toString();
    }

    public String testPreorder() {
        reset();
        preorder(root);
        return res.toString();
    }

    public String testPostOrder() {
        reset();
        postOrder(root);
        return res.toString();
    }


    private void reset() {
        res.setLength(0);
    }
}
