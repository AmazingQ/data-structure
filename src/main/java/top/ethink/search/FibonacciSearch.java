package top.ethink.search;

import java.util.Arrays;

/**
 * 斐波那契 查找算法
 * @author AmazingQ
 * @date 2020-09-16 7:43
 */
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 9, 22, 37, 47, 51, 51, 65, 74, 81, 90};
        int index = search(arr, 22);
        System.out.println(index);
    }

    public static int[] fibonacci() {
        int[] fib = new int[maxSize];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    static int search(int[] arr,int value) {
        int low = 0;
        int high = arr.length - 1;
        // 表示斐波那契 分割数值的下标
        int k = 0;
        int mid = 0;
        int[] fib = fibonacci();
        // 获取斐波那契 分割数值的下标
        while (high > fib[k] - 1){
            k++;
        }
        // 因为 fib[k] 的值 可能大于 arr.length 因此需要构造新的数组 并指向temp[]
        int[] temp = Arrays.copyOf(arr,fib[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = temp[high];
        }
        // 使用循环处理找到的 key
        while (low <= high){
            mid = low + fib[k-1] -1;
            if (value < temp[mid]){
                high = mid - 1;
                // 全部元素 = 前面的元素 + 后边的元素   fib[k] = fib[k-1]+ fib[k-2]   fib[k-1] = fib[k-2]+ fib[k-3]
                // 下次循环 继续前面查找 k--
                k--;
            }else if (value > temp[mid]){
                low = mid + 1;
                // 当前 k 与右边的元素   fib[k-2] = fib[k-3]+ fib[k-4] 下次循环 mid = low + fib[k-3] - 1
                k -= 2;
            }else {
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }

        return -1;
    }
}
