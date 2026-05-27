package com.example.itertor;

import java.util.Iterator;

public class MyCollection <T> implements Iterable<T> {
    private Object[] array;
    private int size = 0;

    public MyCollection(int capacity) {
        this.array = new Object[capacity];
    }

    public void add(T item){
        if(size < array.length){
            array[size] = item;
        }
        size++;
    }
    @Override
    public Iterator<T> iterator() {
        return new MyCollectionIterator();
    }

    private class MyCollectionIterator implements Iterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            return (T) array[cursor++];
        }
    }
}
