package top.ethink.stack;

/**
 * @author AmazingQ
 * @date 2020-08-14 8:13
 */
public class Calculator {
    static class ArrayStack {
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
        public int peek(){
            return stack[top];
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
                System.out.printf("stack[%d]=%d \n", i, stack[i]);
            }
        }

        /**
         * 运算符优先级 数字越大优先级越高
         */
        public int priority(int oper) {
            if (oper == '*' || oper == '/') {
                return 1;
            } else if (oper == '+' || oper == '-') {
                return 0;
            } else {
                return -1;
            }
        }
        /**
         * 判断是否运算符
         * @param val
         * @return
         */
        public boolean isOper(char val) {
            return val == '+' || val == '-' || val == '*' || val == '/';
        }
        /**
         * 计算方法 注意顺序
         * @param num1
         * @param num2
         * @param oper
         * @return
         */
        public int cal(int num1, int num2, int oper) {
            int res = 0;
            switch (oper) {
                case '+':
                    res = num2 + num1;
                    break;
                case '-':
                    res = num2 - num1;
                    break;
                case '*':
                    res = num2 * num1;
                    break;
                case '/':
                    res = num2 / num1;
                    break;
                default:
                    break;
            }
            return res;
        }

    }


    public static void main(String[] args) {
        String express = "25+8*6-12";
        // 数字栈
        ArrayStack numStack = new ArrayStack(10);
        // 操作符栈
        ArrayStack operStack = new ArrayStack(10);
        // 扫描指针
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        String keepNum = "";
        int res = 0;
        char ch = ' ';
        while (true){
            // 获取表达式中每一个
            ch = express.substring(index,index+1).charAt(0);
            // 判断ch 是否为运算符
            if (operStack.isOper(ch)) {
                // 判断栈是否为空
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                } else {
                    // 操作栈中有操作符 进行比较, 如果当前操作符的优先级小于等于栈中的操作符,从数栈中pop两个数
                    // 从符号栈中pop出一个符号, 运算得到结果 入数栈 当前操作符进入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        // 运算结果入数栈
                        numStack.push(res);
                        // 当前操作符入符号栈
                        operStack.push(ch);
                    } else {
                        // 当前操作符的有优先级大于栈中的操作符 , 直接入符号栈
                        operStack.push(ch);
                    }
                }
            }else {
                // 如果是数栈 直接入数栈  ASCII
                // numStack.push(ch - 48);
                // 定义变量 用来拼接多位数字
                keepNum+= ch;
                // 判断是否为空
                if (index == express.length() - 1){
                    numStack.push(Integer.valueOf(keepNum));
                }else {
                    if (operStack.isOper(express.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.valueOf(keepNum));
                        keepNum= "";
                    }
                }
                // 判断下个数字是否为数字
            }
            // 扫描指针增加
            index++;
            if (index >= express.length()){
                break;
            }
        }
        // 表达式扫描完毕 数栈和符号栈中 pop 出数据运行
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            // 运算结果入数栈
            numStack.push(res);
        }
        // 输出结果
        System.out.printf("表达式%s = %d",express,numStack.pop());
    }
}
