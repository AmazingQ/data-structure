package top.ethink.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author AmazingQ
 * @date 2020-08-16 9:37
 */
public class PolishNotation {
    public static void main(String[] args) {
        String suffixExpress = "30 4 + 5 * 6 -";
        List<String> strings = listString(suffixExpress);
        System.out.println(strings);
        int result = calculate(strings);
        System.out.println(result);

        String e = "1+((2+3)*5)-5";
        System.out.println(e);
        List<String> list = toInfixExpressList(e);
        System.out.println(list);
        List<String> suffix = parseSuffixExpressList(list);
        System.out.println(suffix);
    }

    public static List<String> listString(String suffixExpress) {
        // 分割
        String[] strings = suffixExpress.split(" ");
        List<String> stringList = Arrays.asList(strings);
        return stringList;
    }

    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<String>();
        for (String item : ls) {
            // 匹配的是多位数
            if (item.matches("\\d+")) {
                // 入栈
                stack.push(item);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if ("+".equals(item)) {
                    res = num2 + num1;
                }
                if ("-".equals(item)) {
                    res = num2 - num1;
                }
                if ("*".equals(item)) {
                    res = num2 * num1;
                }
                if ("/".equals(item)) {
                    res = num2 / num1;
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * 将中缀表达式转换成对应的list
     * @return
     */
    public static List<String> toInfixExpressList(String str) {
        // 定义list
        List<String> list = new ArrayList<String>();
        // 指针用于遍历字符串
        int i = 0;
        // 多位数
        String s;
        // 遍历获得的字符
        char c;
        do {
            // 判断是否为数字
            if ((c = str.charAt(i)) < 48 || (c = str.charAt(i)) > 57) {
                list.add("" + c);
                // 指针移动
                i++;
            } else {
                s = "";
                while (i < str.length() && (c = str.charAt(i)) >= 48 && (c = str.charAt(i)) <= 57) {
                    s += c;
                    i++;
                }
                list.add(s);
            }
        } while (i < str.length());
        return list;
    }

    /**
     * 中缀表达式转换为后缀表达式List
     * @param list
     * @return
     */
    public static List<String> parseSuffixExpressList(List<String> list) {
        Stack<String> s1 = new Stack<String>();
        List<String> arrayList = new ArrayList<String>();
        for (String item : list) {
            if (item.matches("\\d+")) {
                arrayList.add(item);
            } else if ("(".equals(item)) {
                s1.push(item);
            } else if (")".equals(item)) {
                //如果是有括号")" 则依次弹出s1栈顶的运算符 并压入s2 直到遇到右括号为止, 丢弃括号
                while (!"(".equals(s1.peek())) {
                    arrayList.add(s1.pop());
                }
                // 将小括号弹出
                s1.pop();
            } else {
                // 当item的优先级小于等于栈顶运算符 , 将s1栈顶的运算符弹出到s2中
                while (s1.size() != 0 && Operation.getLevel(item) <= Operation.getLevel(s1.peek())) {
                    arrayList.add(s1.pop());
                }
                // 将item压入栈
                s1.push(item);
            }
        }
        // 剩余运算符加入到数组
        while (s1.size()!=0){
            arrayList.add(s1.pop());
        }
        return arrayList;
    }
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getLevel(String operation) {
        int res = 0;
        switch (operation) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                break;
        }
        return res;
    }
}