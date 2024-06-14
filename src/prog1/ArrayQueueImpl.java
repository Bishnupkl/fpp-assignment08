package prog1;

public class ArrayQueueImpl {
    private int[] arr = new int[10];
    private int front = -1;
    private int rear = 0;

    public boolean isEmpty() {
        if (front == -1)
            return true;
        return false;
    }

    public int size() {
        if (isEmpty()) return 0;
        if (front == rear) return 0;
        return (rear - front) + 1;
    }

    public void enqueue(int item) {
        if (isEmpty()) {
            front = rear = 0;
            arr[front] = item;
        } else {
            if (front != 0) {
                freeSpace(); // re-arrange array
            } else if (front == 0 && rear == arr.length - 1) {
                resize(); // size storage
            }
            rear = rear + 1;
            arr[rear] = item;
        }
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        int delete = peek();
        front = front + 1;
        return delete;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    private void freeSpace() {
        int[] temp = new int[arr.length];
        System.arraycopy(arr, front, temp, 0, rear);
        arr = temp;
        rear = rear - front;
        front = 0;
    }

    private void resize() {
        int[] temp = new int[size() * 2];
        System.arraycopy(arr, front, temp, 0, size());
        arr = temp;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = front; i <= rear; i++) {
            sb.append(arr[i]);
            if (i != rear) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
