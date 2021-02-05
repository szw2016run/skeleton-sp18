import edu.princeton.cs.algs4.In;
import org.junit.Test;

import edu.princeton.cs.algs4.Queue;

import java.beans.IntrospectionException;

import static org.junit.Assert.*;



public class QuickSortTest {
    @Test
    public void testQuickSort() {
        Queue<Integer> tas = new Queue<>();
        tas.enqueue(8);
        tas.enqueue(3);
        tas.enqueue(1);
        tas.enqueue(5);
        tas.enqueue(0);
        tas.enqueue(2);
        tas.enqueue(6);
        tas.enqueue(4);
        for (int i = 10; i < 10000; i += 1) {
            tas.enqueue(i);
        }
        assertTrue(isSorted(QuickSort.quickSort(tas)));

        Queue<String> pas = new Queue<>();
        pas.enqueue("Joe");
        pas.enqueue("Nancy");
        pas.enqueue("Caroline");
        pas.enqueue("Jeffery");
        pas.enqueue("Tom");
        pas.enqueue("Ava");
        pas.enqueue("Peter");
        pas.enqueue("Josh");
        pas.enqueue("Hug");
        assertTrue(isSorted(QuickSort.quickSort(pas)));
    }

    public <Item extends Comparable> boolean isSorted(Queue<Item> items) {

        if (items.size() <= 1) {
            return true;
        }

       Item prev = items.dequeue();
        Item curr = prev;
       while (!items.isEmpty()) {
           prev = curr;
           curr = items.dequeue();
           if (prev.compareTo(curr) > 0) {
               return false;
           }
       }
       return true;
    }
}
