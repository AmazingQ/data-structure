package top.ethink.stack;

import java.util.Scanner;

/**
 * @author AmazingQ
 * @date 2020-08-13 7:41
 */
public class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈操作
     *
     * @param val
     */
    public void push(int val) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        // 入栈操作
        stack[top] = val;
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int val = stack[top];
        top--;
        return val;
    }

    /**
     * 遍历栈  从栈顶开始
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d \n", i,stack[i]);
        }
    }


    public static void main(String[] args) {
        // 测试使用
        ArrayStack stack = new ArrayStack(5);
        String key = "";
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("show: 显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 添加数据");
            System.out.println("pop: 出栈操作");
            System.out.println("输入选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入添加的数字");
                    int val = scanner.nextInt();
                    stack.push(val);
                    break;
                case "pop":
                    try {
                        int pop = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", pop);
                    } catch (Exception e) {

                    }
                    break;
                case "exit":
                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序结束");
    }
}
