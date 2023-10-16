package org.example.lection4_collections.linklist;

import java.util.Collection;
import java.util.Iterator;

public class LinkList<T> implements Collection<T> {
    private ListNode<T> head, tail;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new OwnCollectionIterator<>();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    public class OwnCollectionIterator<T> implements Iterator {
        private Integer index = 0;
        private ListNode<T> current = (ListNode<T>) head;

        @Override
        public boolean hasNext() {
            return (size > index);
        }

        @Override
        public T next() {
            if (hasNext()) {
                index++;
                if (index == 1)
                    return (T) head.getValue();
                current = current.getNext();
                return (T) current.getValue();
            }
            return null;
        }
    }


    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (head == null) {
            head = new ListNode<T>(t);
            tail = head;

        } else {
            ListNode<T> current = new ListNode<T>(t, head, null);
            ListNode<T> prev = tail;
            tail.setNext(current);
            tail = current;
            tail.setPrevious(prev);
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
