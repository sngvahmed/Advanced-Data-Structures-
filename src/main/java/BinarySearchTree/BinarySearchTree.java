package BinarySearchTree;


import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import static sun.swing.MenuItemLayoutHelper.max;

public class BinarySearchTree<E extends Comparable<E>> {
    class Node {
        E value;
        Node leftChild = null;
        Node rightChild = null;

        Node(E value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if ((obj instanceof BinarySearchTree.Node) == false)
                return false;
            @SuppressWarnings("unchecked")
            Node other = (Node) obj;
            return other.value.compareTo(value) == 0 &&
                    other.leftChild == leftChild && other.rightChild == rightChild;
        }
    }

    protected Node root = null;

    protected void visit(Node n) {
        System.out.println(n.value);
    }

    public boolean contains(E val) {
        return contains(root, val);
    }

    protected boolean contains(Node n, E val) {
        if (n == null) return false;

        if (n.value.equals(val)) {
            return true;
        } else if (n.value.compareTo(val) > 0) {
            return contains(n.leftChild, val);
        } else {
            return contains(n.rightChild, val);
        }
    }

    public boolean add(E val) {
        if (root == null) {
            root = new Node(val);
            return true;
        }
        return add(root, val);
    }

    protected boolean add(Node n, E val) {
        if (n == null) {
            return false;
        }
        int cmp = val.compareTo(n.value);
        if (cmp == 0) {
            return false; // this ensures that the same value does not appear more than once
        } else if (cmp < 0) {
            if (n.leftChild == null) {
                n.leftChild = new Node(val);
                return true;
            } else {
                return add(n.leftChild, val);
            }
        } else {
            if (n.rightChild == null) {
                n.rightChild = new Node(val);
                return true;
            } else {
                return add(n.rightChild, val);
            }
        }
    }

    public boolean remove(E val) {
        return remove(root, null, val);
    }

    protected boolean remove(Node n, Node parent, E val) {
        if (n == null) return false;

        if (val.compareTo(n.value) == -1) {
            return remove(n.leftChild, n, val);
        } else if (val.compareTo(n.value) == 1) {
            return remove(n.rightChild, n, val);
        } else {
            if (n.leftChild != null && n.rightChild != null) {
                n.value = maxValue(n.leftChild);
                remove(n.leftChild, n, n.value);
            } else if (parent == null) {
                root = n.leftChild != null ? n.leftChild : n.rightChild;
            } else if (parent.leftChild == n) {
                parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
            } else {
                parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
            }
            return true;
        }
    }

    protected E maxValue(Node n) {
        if (n.rightChild == null) {
            return n.value;
        } else {
            return maxValue(n.rightChild);
        }
    }


    /*********************************************
     *
     * IMPLEMENT THE METHODS BELOW!
     *
     *********************************************/


    // Method #1.
    public Node findNode(E val) {
        if (val == null) return null;
        return findNode(root, val);
    }

    private Node findNode(Node node, E val) {
        if (node == null) return null;

        if (node.value.compareTo(val) == 0) return node;
        else if (node.value.compareTo(val) > 0) return findNode(node.leftChild, val);
        else return findNode(node.rightChild, val);
    }

    // ###############################################################################

    // Method #2.
    protected int depth(E val) {
        if (val == null) return -1;
        int depth = 0;
        return getDepth(root, depth, val);
    }

    private int getDepth(Node node, int depth, E val) {
        if (node == null) {
            return -1;
        }
        if (node.value.compareTo(val) == 0) return depth;
        else if (node.value.compareTo(val) > 0) return getDepth(node.leftChild, depth + 1, val);
        else return getDepth(node.rightChild, depth + 1, val);
    }

    // Method #3.
    protected int height(E val) {
        if (val == null) return -1;
        Node node = getNode(root, val);
        if (node == null) return -1;
        return getHeight(node) - 1;
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return 1 + max(getHeight(node.rightChild), getHeight(node.leftChild));
    }

    private Node getNode(Node node, E val) {
        if (node == null) {
            return null;
        }

        if (node.value.compareTo(val) == 0) return node;
        else if (node.value.compareTo(val) > 0) return getNode(node.leftChild, val);
        else return getNode(node.rightChild, val);
    }

    // Method #4.
    protected boolean isBalanced(Node n) {
        if (n == null) return false;
        int diff = Math.abs(getHeight(n.leftChild) - getHeight(n.rightChild));
        return (diff == 0 || diff == 1);
    }

    // Method #5. .
    public boolean isBalanced() {
        return checkAllIsBalanced(root);
    }

    private boolean checkAllIsBalanced(Node node) {
        if (node == null) return true;
        boolean res1;
        if (node.leftChild == null)
            res1 = true;
        else
            res1 = isBalanced(node.leftChild);

        boolean res2 = false;
        if (node.rightChild == null)
            res2 = true;
        else
            res2 = isBalanced(node.rightChild);

        boolean res = res1 && res2;
        if (res == true) {
            return checkAllIsBalanced(node.leftChild) && checkAllIsBalanced(node.rightChild);
        }
        return false;
    }

}
