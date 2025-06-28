public class CircularQueue {
    int front, rear;
    int[] queue;
    int maxSize;
    int size;

    public CircularQueue(int maxSize){
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        size = 0;
        queue = new int[maxSize];
    }
    public void enqueue(int element){
        if(rear == -1 && maxSize >= 1){
            queue[++rear] = element;
            size++;
        }else if(size == maxSize){
            System.out.println("Queue is full");
        }
        else{
            rear = ++rear%maxSize;
            queue[rear] = element;
            size++;
        }
    }
    public int deque(){
        if(maxSize > 0 && size > 0){
            --size;
            return queue[(++front%maxSize)];
        }

        return -1;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if(size == 0){
            output.append("queue is empty");
        }else{
            for(int i = (front+1); i<= rear; i++){
                output.append(queue[i] + ",");
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        CircularQueue queue1 = new CircularQueue(3);
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        queue1.enqueue(4);

        System.out.println(queue1);
        System.out.println(queue1.deque());
        System.out.println(queue1);

    }
}
