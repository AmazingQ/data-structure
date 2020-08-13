package top.ethink.array;

/**
 * @author AmazingQ
 * @date 2020-08-05 23:29
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建原始数组 11 * 11
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[8][8] = 2;
        // 输出原始数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("sum = "+ sum);

        // 创建稀疏数组
        System.out.println("稀疏数组");
        int sparseArray[][] = new int[sum+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }
        // 输出稀疏数组
        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //
        System.out.println("恢复数组");
        int chessArr2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        // 遍历稀疏数组
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        for (int[] row : chessArr2 ) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
