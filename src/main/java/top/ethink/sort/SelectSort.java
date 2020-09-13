package top.ethink.sort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * 插入 排序
 * @author AmazingQ
 * @date 2020-09-01 7:30
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 21, 4, 66, -2};
        sort(arr);
        // print(arr);
    }
    static void sort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            // 待插入数据
            insertVal = arr[i];
            // 插入索引
            insertIndex = i - 1;
            // >= 0 保证插入位置不越界   < 待插入的数未找到插入位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 循环结束时 插入位置确定, index + 1
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
            print(arr);
        }
    }

    static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
