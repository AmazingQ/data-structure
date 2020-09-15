package top.ethink.search;

/**
 * 差值查找算法
 * @author AmazingQ
 * @date 2020-09-15 22:49
 */
public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i+1;
        }
        int index = search(arr, 0, arr.length - 1, 22  );
        System.out.println(index);
    }

    static int search(int[] arr, int low, int high, int value) {
        System.out.println("递归被调用");
        // 如果没有找到直接返回 -1    value < arr[0] || value > arr[arr.length - 1]  必须存在 防止数组越界 mid 值的控制
        if (low > high || value < arr[0] || value > arr[arr.length - 1]) {
            return -1;
        }
        // 中值索引
        int mid = low + (high - low) * (value - arr[low]) / (arr[high] - arr[low]);
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
}
