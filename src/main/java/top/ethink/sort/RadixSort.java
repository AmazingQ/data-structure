package top.ethink.sort;

import java.util.Arrays;

/**
 *  基数排序
 * @author AmazingQ
 * @date 2020-09-11 6:39
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {18, 239, 21, 7, 27, 31, 35, 24, 61, 20};
        radixSort(arr);
        // print(arr);
    }

    /**
     *  0       1       2       3       4       5       6       7       8       9
     *  20      21                      24      35              7       18      239
     *          31                                              27
     *          61
     * 第一轮输出结果应该为  20  21  31  61  24  35  7  27  18  239
     * @param arr
     */
    static void sort(int[] arr) {
        // 定义二维数组表示10个桶 标号从0 - 9  单个桶的最大大小为数组长度
        int[][] bucket = new int[10][arr.length];
        // 定义数组 记录每个桶中存放了多少数据
        int[] bucketCount = new int[10];
        // 第一轮排序
        for (int i = 0; i < arr.length; i++) {
            //获取待排序中的数据   例如: 18 % 10 = 8  放入第8个桶
            int bucketElement = arr[i] % 10;
            // bucketCount[bucketElement] 取出当前桶中对应的元素个数  例如: bucketCount[8] = 0; 放入一个元素 bucketCount[8] = 1
            bucket[bucketElement][bucketCount[bucketElement]] = arr[i];
            // 桶中元素个数增加
            bucketCount[bucketElement]++;
        }
        // 按照桶的顺序一次取出数据放入原来的数组中
        int index = 0;
        // 遍历桶 取出桶中的数据放入原数组
        for (int i = 0; i < bucketCount.length; i++) {
            // 判断如果桶中有数据放入原数组
            if (bucketCount[i] != 0){
                // 桶中存放的有数据 循环该桶放入数据
                for (int j = 0; j < bucketCount[i]; j++){
                    // 取出元素放入原数组中
                    arr[index++] = bucket[i][j];
                }
            }
            // 第一轮结束后 给每个桶都清空
            bucketCount[i] = 0;
        }
        print(arr);
    }

    static void radixSort(int[] arr) {
        // 已知最大数长度
        for (int max = 0,n = 1; max < 3; max++, n *= 10) {
            // 定义二维数组表示10个桶 标号从0 - 9  单个桶的最大大小为数组长度
            int[][] bucket = new int[10][arr.length];
            // 定义数组  记录每个桶中存放了多少数据
            int[] bucketCount = new int[10];
            // 第一轮排序
            for (int i = 0; i < arr.length; i++) {
                //获取待排序中的数据  例如: 18 % 10 = 8  放入第8个桶
                int bucketElement = arr[i] / n % 10;
                // bucketCount[bucketElement] 取出当前桶中对应的元素个数  例如: bucketCount[8] = 0; 放入一个元素 bucketCount[8] = 1
                bucket[bucketElement][bucketCount[bucketElement]] = arr[i];
                // 桶中元素个数增加
                bucketCount[bucketElement]++;
            }

            // 按照桶的顺序一次取出数据放入原来的数组中
            int index = 0;
            // 遍历桶 取出桶中的数据放入原数组
            for (int i = 0; i < bucketCount.length; i++) {
                // 判断如果桶中有数据放入原数组
                if (bucketCount[i] != 0) {
                    // 桶中存放的有数据 循环该桶放入数据
                    for (int j = 0; j < bucketCount[i]; j++) {
                        // 取出元素放入原数组中
                        arr[index++] = bucket[i][j];
                    }
                }
                // 第一轮结束后 给每个桶都清空
                bucketCount[i] = 0;
            }
            print(arr);
        }
    }
    static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
