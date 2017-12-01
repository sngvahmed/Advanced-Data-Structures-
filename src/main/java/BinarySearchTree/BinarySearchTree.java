package BinarySearchTree;

public class BinarySearchTree extends TreeTraversal {
    Node root;

    BinarySearchTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        root = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);


        root.left = node2;
        root.right = node6;

        node2.left = node1;
        node2.right = node3;

        node6.left = node5;
        node6.right = node7;
    }

    public boolean isExist(int number) {
        return isExist(root, number);
    }


    /**
     * @param node
     * @param number
     * @return true if exist false if not exist
     */
    public boolean isExist(Node node, Integer number) {
        if (node == null) return false;

        if (node.value == number) {
            return true;
        }

        if (number < node.value) {
            return isExist(node.left, number);
        } else
            return isExist(node.right, number);
    }

}
