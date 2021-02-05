import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>{
    private int size;
    private int nextLast;
    private int nextFirst;
    private int capacity = 8;
    private T[] ArrayDeque;
    public ArrayDeque() {
        size = 0;
        nextFirst = 4;
        nextLast = 5;
        ArrayDeque = (T[]) new Object[capacity];
    }
    private void resize(int num) {
        T[] newDeque = (T[]) new Object[num];
        int first = (nextFirst + 1) % capacity;
        for (int i = 0; i < size; i++) {
            newDeque[i] = ArrayDeque[first];
            first = (first + 1) % capacity;
        }
        nextFirst = num - 1;
        nextLast = size;
        capacity = num;
        ArrayDeque = newDeque;
    }
    public void addFirst(T item) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        ArrayDeque[nextFirst] = item;
        nextFirst = (nextFirst - 1 + capacity) % capacity;
        size += 1;
    }

    public void addLast(T item) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        ArrayDeque[nextLast] = item;
        nextLast = (nextLast + 1) % capacity;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int first = (nextFirst + 1) % capacity;
        int i = 0;
        while (i < size) {
            System.out.print(ArrayDeque[(first + i) % capacity] + " ");
            i += 1;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size * 1.0 / capacity < 0.25) {
            resize(capacity / 2);
        }
        nextFirst = (nextFirst + 1) % capacity;
        T res = ArrayDeque[nextFirst];
        size -= 1;
        return res;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (size * 1.0 / capacity < 0.25) {
            resize(capacity / 2);
        }
        nextLast = (nextLast - 1 + capacity) % capacity;
        T res = ArrayDeque[nextLast];
        size -= 1;
        return res;
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return ArrayDeque[(nextFirst + 1 + index) % capacity];
    }

    public Iterator<T> iterator() {
        return new ArrayDequeItea();
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass()) {
            return false;
        }
        ArrayDeque obj = (ArrayDeque) o;
        if (this.size != obj.size) {
            return false;
        }
        int p1 = (this.nextFirst + 1) % capacity;
        int p2 = (obj.nextFirst + 1) % obj.capacity;
        int i = 0;
        while (i < size) {
            if (!this.ArrayDeque[p1].equals(obj.ArrayDeque[p2])) {
                return false;
            }
            p1 = (p1 + 1) % capacity;
            p2 = (p2 + 1) % capacity;
            i += 1;
        }
        return true;
    }

    private class ArrayDequeItea implements Iterator<T>{
        int index;
        public ArrayDequeItea() {
            index = 0;
        }
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T res =  get(index);
            index += 1;
            return res;
        }
    }
}
