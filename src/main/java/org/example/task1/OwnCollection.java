package org.example.task1;

import java.util.Arrays;
import java.util.Iterator;

public class OwnCollection<E> {
    private Object[] arr;
    private final OwnCollectionIterator<E> iterator = new OwnCollectionIterator<>();

    public OwnCollectionIterator<E> getIterator() {
        return iterator;
    }

    public OwnCollection() {
        arr = new Object[]{};
    }


    public void add(E element) {
        Object[] temp_arr = new Object[arr.length + 1];

        for (int index = 0; index < arr.length; index++) {
            temp_arr[index] = arr[index];
        }
        temp_arr[temp_arr.length - 1] = element;

        arr = temp_arr;
    }

    public void remove(E element) {
        Integer position = find(element);
        if (position != null) {
            Object[] temp_arr = new Object[arr.length - 1];

            if (position >= 0) System.arraycopy(arr, 0, temp_arr, 0, position);

            if (arr.length - 1 - position >= 0)
                System.arraycopy(arr, position + 1, temp_arr, position, arr.length - 1 - position);

            arr = temp_arr;
        }
    }

    public Integer find(E element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(element)) return i;
        }
        return null;
    }

    public void info() {
        System.out.println(Arrays.toString(arr));
    }

    public class OwnCollectionIterator<T> implements Iterator<T>, Iterable<T> {
        private Integer index = 0;

        @Override
        public boolean hasNext() {
            return (arr.length > index);
        }

        @Override
        public T next() {
            if (hasNext()) {
                return (T) arr[index++];
            }
            return null;
        }

        @Override
        public Iterator<T> iterator() {
            return new OwnCollectionIterator<>();
        }
    }
}