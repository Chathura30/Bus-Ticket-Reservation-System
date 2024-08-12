package EntityClasses;

import java.util.LinkedList;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void push(T element) {
        list.addFirst(element);
    }

    public T pop() {
        if (list.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.removeFirst();
    }
    
    public T peek() {
        if (list.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.getFirst();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
