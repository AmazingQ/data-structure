package top.ethink.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author AmazingQ
 * @date 2020-09-01 6:46
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 21, 4, 66, -2, 15};
        sort(arr);
        // print(arr);
    }
    static void sort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            print(arr);
            if (flag){
                break;
            }else {
                flag = false;
            }
        }
    }
    static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
