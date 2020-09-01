package top.ethink.sort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @author AmazingQ
 * @date 2020-09-01 7:30
 */
public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {3, 1, 21, 4, 66, -2};
        sort(arr);
        // print(arr);
    }
    static void sort(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            int minIndex = j;
            int min = arr[minIndex];
            for (int i = j + 1; i < arr.length; i++) {
                if (min > arr[i]){
                    min = arr[i];
                    minIndex = i;
                }
            }
            // 交换数据
            if (minIndex != j){
                arr[minIndex] = arr[j];
                arr[j] = min;
            }
            print(arr);
        }
    }
    static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
