package top.ethink.sort;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

/**
 * 希尔排序  交换法
 * @author AmazingQ
 * @date 2020-09-02 7:13
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        sort(arr);
        // print(arr);
//        sort2(arr);
//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int)(Math.random()*8000000);
//        }
        LocalDateTime now1 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(now1);
        sort2(arr);
        LocalDateTime now2 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(now2);
    }



    /**
     * 希尔排序  交换法
     * @param arr
     */
    static void sort(int[] arr) {
        // 定义步长
        int len = arr.length / 2;
        while (len >= 1){
            for (int i = len; i < arr.length; i++) {
                // 循环对比步长数据和当前数据
                for (int j = i - len; j >= 0; j -= len) {
                    if (arr[j] > arr[j + len]){
                        int temp = arr[j];
                        arr[j] = arr[j+len];
                        arr[j+len] = temp;
                    }
                }
            }
//            print(arr);
            len = len / 2;
        }
    }


    /**
     * 希尔排序  移位法
     * @param arr
     */
    static void sort2(int[] arr) {
        // 定义步长
        int len = arr.length / 2;
        while (len >= 1){
            // 从步长数据开始 对每个组中的数据进行直接插入排序
            for (int i = len; i < arr.length; i++) {
                int j = i;
                // 定义临时数据为 每组第一个数据
                int temp = arr[j];
                if (arr[j] < arr[j-len]){
                    while (j - len >= 0 && temp < arr[j - len]){
                        arr[j] = arr[j - len];
                        j -= len;
                    }
                    // 定位插入位置
                    arr[j] = temp;
                }
            }
//            print(arr);
            len = len / 2;
        }

    }
    static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
