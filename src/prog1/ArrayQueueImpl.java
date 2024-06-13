package prog1;

public class ArrayQueueImpl {
    private int[] arr = new int[10];
    private int front = -1;
    private int rear = 0;

    public boolean isEmpty(){
        if (front == -1)
            return true;
        return false;
    }
    public int size(){
        if(isEmpty()) return 0;
        if(front == rear) return 0;
        return (rear-front)+1;
    }
    public void enqueue(int item){
        if(isEmpty()){
            front = rear = 0;
            arr[front] = item;
        }
        else{
            if(front !=0){
                freeSpace(); // re-arrange array
            }
            else if(front == 0 && rear == arr.length-1){
                resize(); // size storage
            }
            rear = rear + 1;
            arr[rear] = item;
        }
    }
    public int dequeue(){
        if(isEmpty()) return 0;
        int delete = peek();
        front = front + 1;
        return delete;
    }
    public int peek(){
        if(isEmpty()) return 0;
        return arr[front];
    }

    private void freeSpace(){
        int[] temp = new int[arr.length];
        System.arraycopy(arr,front, temp, 0, rear);
        arr = temp;
        rear = rear - front;
        front = 0;
    }

    private void resize(){
        int[] temp = new int[size()*2];
        System.arraycopy(arr, front, temp, 0, size());
        arr = temp;
    }

    @Override
    public String toString(){
        if(isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for(int i = front; i <= rear; i++){
            sb.append(arr[i]);
            if(i != rear) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        //Resize
        //Reuse Free Memory
        ArrayQueueImpl myQueue = new ArrayQueueImpl();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        System.out.println("Dequeue: " + myQueue.dequeue());
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(6);
        myQueue.enqueue(7);
        myQueue.enqueue(8);
        myQueue.enqueue(9);
        myQueue.enqueue(10);
        System.out.println(myQueue + " size:" + myQueue.size());
        System.out.println("Peek: " + myQueue.peek());
        System.out.println("Dequeue: " + myQueue.dequeue());
        System.out.println("Dequeue: " + myQueue.dequeue());
        System.out.println(myQueue + " size:" + myQueue.size());
        myQueue.enqueue(11);
        myQueue.enqueue(12);
        System.out.println(myQueue + " size:" + myQueue.size());
        myQueue.enqueue(13);
        myQueue.enqueue(14);
        myQueue.enqueue(15);
        myQueue.enqueue(16);
        System.out.println("Peek: " + myQueue.dequeue());
        System.out.println("Peek: " + myQueue.dequeue());
        myQueue.enqueue(17);
        myQueue.enqueue(18);
        myQueue.enqueue(19);
        myQueue.enqueue(20);
        System.out.println("Peek: " + myQueue.dequeue());
        System.out.println("Peek: " + myQueue.dequeue());
        System.out.println("Peek: " + myQueue.dequeue());

        System.out.println(myQueue + " size:" + myQueue.size());
    }
}
