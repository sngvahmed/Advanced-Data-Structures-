package BinarySearchTree;

import BinarySearchTree.BinarySearchTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBinarySearchTree {

    BinarySearchTree binarySearchTree;

    @Before
    public void setUp() throws Exception {
        binarySearchTree = new BinarySearchTree();
    }

    @Test
    public void testInorder() {
        Assert.assertEquals("42513" , (binarySearchTree.testInorder()));
    }


    @Test
    public void testPostOrder() {
        Assert.assertEquals("45231" , (binarySearchTree.testPostOrder()));
    }

    @Test
    public void testPreorder() {
        Assert.assertEquals("12453" , (binarySearchTree.testPreorder()));
    }

}
