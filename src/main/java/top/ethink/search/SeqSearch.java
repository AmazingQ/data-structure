package top.ethink.search;

/**
 * 序列查找
 * @author AmazingQ
 * @date 2020-09-14 7:20
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {18, 239, 21, 7, 27, 31, 35, 24, 61, 20};
        int index = search(arr, 21);
        System.out.println(index);

    }
    static int search(int[] arr, int value){
        // 线性查找并逐个比对数据 发现相同值 返回下标  和 String indexOf  的原理类似
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
