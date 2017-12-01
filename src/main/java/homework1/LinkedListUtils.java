package homework1;

import java.lang.reflect.Array;
import java.util.*;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

    static void insertSorted(LinkedList<Integer> list, int value) {
        if (list == null) return;

        if (list.size() == 0) {
            list.add(value);
            return;
        }

        int indx = 0;
        for (Integer listV : list) {
            if (listV.intValue() >= value) {
                break;
            }
            indx++;
        }
        list.add(indx, value);
    }

    private static void insertSortedString(LinkedList<String> list, String value) {
        if (list == null) return;

        if (list.size() == 0) {
            list.add(value);
            return;
        }

        int indx = 0;
        for (String listV : list) {
            if (listV.compareTo(value) > 0) {
                break;
            }
            indx++;
        }
        list.add(indx, value);
    }

    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Ahmed");
        list.add("zoro");
        list.add("uuu");
        list.add("baba");

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) System.out.println(list.get(i));
    }

    static void removeMaximumValues(LinkedList<String> list, int N) {

        if (list == null) return;

        if (N >= list.size()) {
            list.clear();
            return;
        }

        while (N > 0 && list.size() > 1) {
            N--;
            int indx = 0;
            String obj = list.get(indx);
            for (int i = 0; i < list.size(); i++) {
                if (obj.compareTo(list.get(i)) < 0) {
                    indx = i;
                    obj = list.get(i);
                }
            }
            while (list.indexOf(obj) != -1) {
                list.remove(obj);
            }
        }

    }


    static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
        if (one == null || two == null) return false;

        if (two.size() > one.size()) return false;
        if (two.size() == 0) return false;

        for (int i = 0; i <= one.size() - two.size(); i++) {
            if (one.get(i).equals(two.get(0))) {
                int indx = 0;
                while (indx < two.size()) {
                    if (!two.get(indx).equals(one.get(i + indx))) {
                        break;
                    }
                    indx++;
                }
                if (indx == two.size()) return true;
            }
        }
        return false;
    }
}
