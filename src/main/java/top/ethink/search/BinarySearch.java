package top.ethink.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 * @author AmazingQ
 * @date 2020-09-14 7:56
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 21, 37, 47, 51, 51, 65, 74, 81, 90};
        int index = search(arr, 0, arr.length, 22);
        List<Integer> list = searchAll(arr, 0, arr.length, 51);
        System.out.println(index);
        System.out.println(list);

    }


    static int search(int[] arr, int low, int high, int value) {
        System.out.println("递归被调用search");
        // 如果没有找到直接返回 -1
        if (low > high) {
            return -1;
        }
        // 中值索引
        int mid = (low + high) / 2;
        // 中值
        int midValue = arr[mid];
        if (value > midValue) {
            // 向右递归查找
            return search(arr, mid + 1, high, value);
        } else if (value < midValue) {
            return search(arr, low, mid - 1, value);
        } else {
            return mid;
        }
    }

    static List<Integer> searchAll(int[] arr, int low, int high, int value) {
        System.out.println("递归被调用searchAll");
        // 如果没有找到直接返回 -1
        if (low > high) {
            return new ArrayList<Integer>();
        }
        // 中值索引
        int mid = (low + high) / 2;
        // 中值
        int midValue = arr[mid];
        if (value > midValue) {
            // 向右递归查找
            return searchAll(arr, mid + 1, high, value);
        } else if (value < midValue) {
            return searchAll(arr, low, mid - 1, value);
        } else {
            // 将索引值 装入集合 找出所有 下标 向左查找
            ArrayList<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (true){
                if (temp < 0 || arr[temp] != value){
                    break;
                }else {
                    list.add(temp);
                    temp--;
                }
            }
            list.add(mid);
            // 向右查找
            temp = mid + 1;
            while (true){
                if (temp > arr.length -1  || arr[temp] != value){
                    break;
                }else {
                    list.add(temp);
                    temp++;
                }
            }
            return list;
        }
    }
}
