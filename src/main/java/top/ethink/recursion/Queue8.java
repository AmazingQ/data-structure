package top.ethink.recursion;

/**
 * 8皇后问题解析
 * @author AmazingQ
 * @date 2020-08-21 7:26
 */
public class Queue8 {
    /**
     * 定义共有多少个皇后
     */
    private final int max = 8;

    private int count = 0;
    /**
     * 定义数组 保存皇后防止位置的结果  例: arr = {0,4,7,5,2,6,1,3}
     * @param args
     */
    private int[] array = new int[max];

    /**
     * 查看当放置第n个皇后, 检测是否与之前放置的皇后冲突
     * @param n
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            // array[i] == array[n]  n 是要放置的皇后 , 需要比较是否和前面 n-1 个皇后是否在同一列4
    // Math.abs(n-i) == Math.abs(array[n] - array[i])  表示 判断第n个皇后是否和第i个皇后是否在同一斜线
            // Math.abs(1-0) = 1  Math.abs(array[n]-array[i]) = Math.abs(1-0) = 1
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    private void check(int n){
        // 放置
        if (n == max){
            print();
            return;
        }
        // 依次放入皇后并判断
        for (int i = 0; i < max; i++) {
            // 先把当前皇后放到该行的第一列
            array[n] = i;
            // 判断是否冲突
            if (judge(n)){
                // 接着放低n=n+1个
                check(n + 1);
            }
            // 如果冲突继续执行 array[n] = i;
        }
    }
    /**
     * 打印
     */
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // 测试
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(queue8.count);
    }
}
