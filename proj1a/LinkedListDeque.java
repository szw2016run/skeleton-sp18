public class LinkedListDeque<T> {

    private class Node {
        T item;
        Node prev;
        Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev.next = new Node(item, sentinel.prev, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T res = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return res;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T res = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return res;
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        int i = 0;
        Node p = sentinel.next;
        while (i < index) {
            p = p.next;
            i += 1;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return getRecursiveHelper(index, this.sentinel.next);

    }
    private T getRecursiveHelper(int index, Node node) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(index - 1, node.next);
    }

//    public boolean equals(Object o) {
//        if (o.getClass() != this.getClass()) {
//            return false;
//        }
//        LinkedListDeque obj = (LinkedListDeque) o;
//        if (this.size() != obj.size()) {
//            return false;
//        }
//        Node p1 = this.sentinel.next;
//        Node p2 = this.sentinel.next;
//        while (p1 != sentinel) {
//            if (!p1.item.equals(p2.item)) {
//                return false;
//            }
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//        return true;
//    }

//    public Iterator<T> iterator() {
//        return new LinkedListDequeIter();
//    }

//    private class LinkedListDequeIter implements Iterator<T> {
//        Node curr;
//        public LinkedListDequeIter() {
//            curr = sentinel.next;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return curr != sentinel; // curr.sentinel
//        }
//
//        @Override
//        public T next() {
//            T res = curr.item;
//            curr = curr.next;
//            return res;
//        }
//    }
}
