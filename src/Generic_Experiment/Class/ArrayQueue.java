package Generic_Experiment.Class;

public class ArrayQueue<T> {
    private final T[] elements;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    public ArrayQueue() {
        this(16);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.elements = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void add(T element) {
        if (isFull()) {
            return;
        }
        elements[rear] = element;
        rear = (rear + 1) % capacity;
        size++;
    }

    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T removed = elements[front];
        elements[front] = null;
        front = (front + 1) % capacity;
        size--;
        return removed;
    }
}