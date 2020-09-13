package top.ethink.sort;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

/**
 * 快速排序
 * @author AmazingQ
 * @date 2020-09-02 20:57
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        print(arr);
        sort(arr,0,arr.length-1);
    }
    /**
     * @param arr
     * @param left  左下标
     * @param right 右下标
     */
    static void sort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        // pivot 中轴值
        int pivot = arr[(left + right) / 2];
        // 定义临时变量
        int temp = 0;
        // 定义循环 中轴值左面的数据都小于 中轴值 右面数据大于中轴值
        while (l < r){
            // 寻找中轴值左面的大于中轴值的下标
            while (arr[l] < pivot){
                l++;
            }
            // 寻找中轴值右面面的小于中轴值的下标
            while (arr[r] > pivot){
                r--;
            }
            if (l >= r){
                break;
            }
            // 交换数据
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 如果交换完之后 避免数据相等 栈溢出 移动数据
            if (arr[l] == pivot){
                r--;
            }
            if (arr[r] == pivot){
                l++;
            }
        }
        if (l == r){
            l++;
            r--;
        }

        // 左侧递归
        if (left < r){
            sort(arr,left,r);
        }
        // 向右递归
        if (right > l){
            sort(arr,l,right);
        }
        print(arr);
//        System.out.println("当前中值为 : " + pivot);
    }
    static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
