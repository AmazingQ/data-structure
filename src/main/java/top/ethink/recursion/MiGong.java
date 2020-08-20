package top.ethink.recursion;

/**
 * @author AmazingQ
 * @date 2020-08-19 23:23
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        // 1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        map[5][3] = 1;
        map[5][4] = 1;
        map[5][5] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        // 测试
        System.out.println();
        System.out.println();
        System.out.println();
        setWay(map,1,1);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归解决迷宫找路
     * 约定 : 当map[i][j] 为0的点表示没有走过 , 当为1表示墙 , 2表示通路可以走 , 3表示已经走过走不通
     * 走迷宫时 , 需要确定一个策略 下 -> 右 -> 上 -> 左 如果走不动再回溯1
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;1
        } else {
            if (map[i][j] == 0) {
                // 当前点没有走过 , 按照策略尝试
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    // 向下走
                    return true;
                }else if (setWay(map, i, j + 1)){
                    // 向右走
                    return true;
                }else if (setWay(map, i - 1, j)){
                    // 向上走
                    return true;
                }else if (setWay(map, i, j - 1)){
                    // 向左走
                    return true;
                }else {
                    // 改点是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
