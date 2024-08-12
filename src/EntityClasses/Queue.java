package EntityClasses;

import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> list = new LinkedList<>();
    
    public void enqueue(T element) {
        list.addLast(element);
    }
    
    public T dequeue() {
        if (list.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.removeFirst();
    }
   
    public T peek() {
        if (list.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.getFirst();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
