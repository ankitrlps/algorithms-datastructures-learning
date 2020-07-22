package learning.datastructures.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ArrayListImpl<E> implements ListImpl<E> {

    private static final int initial_capacity = 10;

    private Object[] list;

    public ArrayListImpl(){
        list = new Object[initial_capacity];
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean add(int index, E e) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> obj) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }

    @Override
    public E set(int index, E e) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object obj) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> obj) {
        return false;
    }

    @Override
    public int indexOf(Object obj) {
        return 0;
    }

    @Override
    public ListImpl<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }
}
