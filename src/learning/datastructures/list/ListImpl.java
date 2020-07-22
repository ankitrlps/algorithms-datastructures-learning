package learning.datastructures.list;

import java.util.Collection;

public interface ListImpl<E> extends Collection<E>{
    boolean add(E e);
    boolean add(int index, E e);
    boolean addAll(Collection<? extends E> obj);
    E get(int index);
    boolean remove(int index);
    boolean remove(Object obj);
    E set(int index, E e);
    int size();
    boolean isEmpty();
    boolean contains(Object obj);
    boolean containsAll(Collection<?> obj);
    int indexOf(Object obj);
    ListImpl<E> subList(int fromIndex, int toIndex);
    void clear();
}
