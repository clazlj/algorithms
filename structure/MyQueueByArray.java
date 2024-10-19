package structure;

/**
 * 数组实现的循环队列：当做一个环想象
 * 物理结构：数组
 * 逻辑结构：队列
 */
public class MyQueueByArray {
    private final int[] array;
    private final int capacity;
    private int front;
    //队尾指针指向的位置。永远空出1位。
    private int rear;


    /**
     * 实际容量为capacity-1，给rear空一个位置
     *
     * @param capacity
     */
    public MyQueueByArray(int capacity) {
        this.array = new int[capacity];
        this.capacity = capacity;
    }

    public int enQueue(int element) throws Exception {
        if ((rear + 1) % capacity == front) {
            throw new Exception("队列已满");
        }
        array[rear] = element;
        rear = (rear + 1) % capacity;
        return element;
    }

    public int deQueue() throws Exception {
        if (front == rear) {
            throw new Exception("队列已空");
        }
        int result = array[front];
        // 这一步可以不做，实际输出取不到即可
//        array[front] = 0;

        front = (front + 1) % capacity;
        return result;
    }

    public void print() {
        for (int i = front; i != rear; i = (i + 1) % capacity) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyQueueByArray queue = new MyQueueByArray(5);

        System.out.println("入队：" + queue.enQueue(1));
        System.out.println("入队：" + queue.enQueue(2));

        System.out.println("出队：" + queue.deQueue());

        System.out.println("入队：" + queue.enQueue(3));

        System.out.println("出队：" + queue.deQueue());

        System.out.println("入队：" + queue.enQueue(4));
        System.out.println("入队：" + queue.enQueue(5));

        System.out.println("出队：" + queue.deQueue());


        System.out.println("入队：" + queue.enQueue(6));
        System.out.println("入队：" + queue.enQueue(7));

        queue.print();

        System.out.println("入队：" + queue.enQueue(8));
        System.out.println("入队：" + queue.enQueue(9));
        System.out.println("入队：" + queue.enQueue(10));

        System.out.println("出队：" + queue.deQueue());

    }
}
