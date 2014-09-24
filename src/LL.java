import java.util.Iterator;
import java.util.NoSuchElementException;

public class LL<Item> implements Iterable<Item> {
    private int N;               // number of elements in LL
    private Node<Item> first;    // beginning of LL

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty LL.
     */
    public LL() {
        first = null;
        N = 0;
    }

    /**
     * Is this LL empty?
     * @return true if this LL is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this LL.
     * @return the number of items in this LL
     */
    public int size() {
        return N;
    }

    /**
     * Adds the item to this LL.
     * @param item the item to add to this LL
     */
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }


    /**
     * Returns an iterator that iterates over the items in the LL in arbitrary order.
     * @return an iterator that iterates over the items in the LL in arbitrary order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }


}


