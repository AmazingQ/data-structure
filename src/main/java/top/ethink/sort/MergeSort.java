package top.ethink.sort;

import jdk.nashorn.internal.parser.Lexer;

import java.util.Arrays;

/**
 * 归并排序
 * @author AmazingQ
 * @date 2020-09-02 22:55
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {8, 9, 1, 7, 22, 3, 5, 4, 6, 0};
//        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};
        // 归并排序额外占用空间
        int temp[] = new int[arr.length];
        sort(arr,0,arr.length-1,temp);
        print(arr);
    }

    /**
     * 分解排序
     * @param arr 待排序的数组
     * @param left  左侧有序序列的初始索引
     * @param right   右面有序序列索引
     * @param temp  中转数组
     */
    static void sort(int[] arr,int left,int right,int[] temp) {
        if (left < right){
            // 计算中值
            int mid = (right + left) / 2;
            // 递归分解数组  向左递归分解
            sort(arr,left,mid,temp);
            // 向右递归分解
            sort(arr,mid +1,right,temp);
            // 合并数据
            merge(arr,left,mid,right,temp);
        }
    }
    /**
     * 合并
     * @param arr 待排序的数组
     * @param left  左侧有序序列的初始索引
     * @param mid   中间索引
     * @param right   右面有序序列索引
     * @param temp  中转数组
     */
    static void merge(int[] arr,int left,int mid, int right,int[] temp){
        // 左边有序序列初始索引
        int i = left;
        // 初始化j 右面有序序列初始索引
        int j = mid + 1;
        // 指向temp数组的当前索引
        int t = 0;
        // 一、 先把左右两边(有序) 的数据按照规则填充到 temp 数组 有一边处理完毕为止
        while (i <= mid && j <= right){
            // 如果当前序列元素小于右边序列的当前元素 将左面序列的当前元素拷贝到 temp 数组中  然后指针后移 反之亦然
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        // 二、将剩余元素一边的序列中的元素依次填充到 temp 中
        while (i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }
//        print(temp);
        // 三、数组拷贝
        t = 0;
        int tempLeft = left;
        System.out.println("tempLeft = " + tempLeft + "   right = " + right);
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
    static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
