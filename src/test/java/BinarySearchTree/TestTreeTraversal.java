package BinarySearchTree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTreeTraversal {

    TreeTraversal treeTraversal;
    BinarySearchTree binarySearchTree;

    @Before
    public void setUp() throws Exception {
        treeTraversal = new TreeTraversal();
        binarySearchTree = new BinarySearchTree();
    }

    @Test
    public void testInorder() {
        Assert.assertEquals("42513", (treeTraversal.testInorder()));
    }


    @Test
    public void testPostOrder() {
        Assert.assertEquals("45231", (treeTraversal.testPostOrder()));
    }

    @Test
    public void testPreorder() {
        Assert.assertEquals("12453", (treeTraversal.testPreorder()));
    }

    @Test
    public void testIsExistInBinarySearchTree() {
        Assert.assertTrue(binarySearchTree.isExist(1));
        Assert.assertTrue(binarySearchTree.isExist(2));
        Assert.assertTrue(binarySearchTree.isExist(3));
        Assert.assertTrue(binarySearchTree.isExist(4));
        Assert.assertTrue(binarySearchTree.isExist(5));
        Assert.assertTrue(binarySearchTree.isExist(6));
        Assert.assertTrue(binarySearchTree.isExist(7));
        Assert.assertFalse(binarySearchTree.isExist(10));
    }

}
