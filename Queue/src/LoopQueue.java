public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = tail = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return (tail + data.length - front) % data.length;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front % data.length) {
            resize(data.length);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {
        return data[front--];
    }

    @Override
    public E getFront() {
        return data[front];
    }

    private void resize(int newSize) {
        data = (E[]) new Object[newSize];
    }
}
