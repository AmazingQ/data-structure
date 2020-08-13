package top.ethink.queue;

import java.util.Scanner;

/**
 * @author AmazingQ
 * @date 2020-08-06 7:24
 */
public class Queue {
    public static void main(String[] args) {
        ArrayQueue Queue = new ArrayQueue(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    Queue.show();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    Queue.add(scanner.nextInt());
                    break;
                case 'g':
                    try {
                        int res = Queue.get();
                        System.out.println(res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = Queue.showHead();
                        System.out.println(res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出");
    }

    /**
     * 使用数组模拟队列
     */
    static class ArrayQueue {
        private int maxSize;
        private int front;
        private int rear;
        private int[] arr;

        public ArrayQueue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = -1;
            rear = -1;
        }

        public boolean isFull() {
            return rear == maxSize - 1;
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public void add(int n) {
            if (isFull()) {
                System.out.println("队列满");
                return;
            }
            rear++;
            arr[rear] = n;
        }

        public int get() {
            if (isEmpty()) {
                throw new RuntimeException("队列空");
            }
            front++;
            return arr[front];
        }

        public void show() {
            if (isEmpty()) {
                System.out.println("队列空");
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
            }
        }

        public int showHead() {
            if (isEmpty()) {
                throw new RuntimeException("队列空");
            }
            return arr[front + 1];
        }
    }
}
