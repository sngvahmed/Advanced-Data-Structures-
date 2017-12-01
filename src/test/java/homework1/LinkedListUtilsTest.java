package homework1;

import org.junit.Test;
import homework1.LinkedListUtils;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class LinkedListUtilsTest {

    @Test
    public void insertSorted() throws Exception {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        LinkedListUtils.insertSorted(linkedList, 4);
        LinkedListUtils.insertSorted(linkedList, 2);
        LinkedListUtils.insertSorted(linkedList, 3);
        assertEquals(linkedList.size(), 4);
        assertEquals(linkedList.get(3), 4);
        assertEquals(linkedList.get(2), 3);
        assertEquals(linkedList.get(1), 2);
        assertEquals(linkedList.get(0), 1);
    }

    @Test
    public void insertSortedInMiddle() throws Exception {
        LinkedList linkedList = new LinkedList();
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(1);
        LinkedListUtils.insertSorted(linkedList, 3);
        assertEquals(linkedList.size(), 4);
    }

    @Test
    public void insertSortedWithEmpty() throws Exception {
        LinkedList linkedList = new LinkedList();
        LinkedListUtils.insertSorted(linkedList, 3);
        assertEquals(1, linkedList.size());
        assertEquals(linkedList.get(0), 3);
    }


    @Test
    public void removeMaximumValues() throws Exception {

        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("100");
        linkedList.add("2");
        linkedList.add("1");

        LinkedListUtils.removeMaximumValues(linkedList, 70);
        assertEquals(2, linkedList.size());
        assertEquals("1", linkedList.get(1));
        assertEquals("2", linkedList.get(0));
    }

    @Test
    public void removeMaximumValuesWithEmpty() throws Exception {

        LinkedList<String> linkedList = new LinkedList<String>();

        LinkedListUtils.removeMaximumValues(linkedList, 70);
        assertEquals(0, linkedList.size());
    }


    @Test
    public void containsSubsequence() throws Exception {
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);


        LinkedList two = new LinkedList();

        two.add(1);
        two.add(2);

        assertEquals(true, LinkedListUtils.containsSubsequence(linkedList, two));
    }


    @Test
    public void containsSubsequenceAtEnd() throws Exception {
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);


        LinkedList two = new LinkedList();

        two.add(3);
        two.add(4);

        assertEquals(true, LinkedListUtils.containsSubsequence(linkedList, two));
    }


    @Test
    public void containsSubsequenceMiddle() throws Exception {
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);


        LinkedList two = new LinkedList();

        two.add(2);
        two.add(3);

        assertEquals(true, LinkedListUtils.containsSubsequence(linkedList, two));
    }


    @Test
    public void notContainsSubsequence() throws Exception {
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);


        LinkedList two = new LinkedList();

        two.add(1);
        two.add(1);

        assertEquals(false, LinkedListUtils.containsSubsequence(linkedList, two));
    }
}