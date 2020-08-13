package top.ethink.queue;

import java.util.Scanner;

/**
 * @author AmazingQ
 * @date 2020-03-04 22:18
 */
public class CircleQueue {
    public static void main(String[] args) {
        CircleQueue Queue = new CircleQueue(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    Queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    Queue.addQueue(scanner.nextInt());
                    break;
                case 'g':
                    try {
                        int res = Queue.outQueue();
                        System.out.println(res);
                        Queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = Queue.headQueue();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出");
    }

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == this.front;
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public void addQueue(int n) {
        if (this.isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int outQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        System.out.println("队列头"+front);
        return temp;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        for (int i = this.front; i < front + this.size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 获取当前队列的有效长度
     *
     * @return
     */
    public int size() {
//        System.out.println("尾:"+rear+"头:"+front+"最大:"+maxSize);
        return (this.rear - this.front + maxSize) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}
