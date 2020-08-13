package top.ethink.linkedList;

/**
 * @author AmazingQ
 * @date 2020-08-12 8:02
 */
public class People {
    public static void main(String[] args) {
        CircleSingleLinkedList circleList = new CircleSingleLinkedList();
        circleList.add(5);
        circleList.showList();
        System.out.println("测试数据");
        circleList.countPeople(1,2,5);
    }

    private int no;
    private People next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public People getNext() {
        return next;
    }

    public void setNext(People next) {
        this.next = next;
    }

    public People(int no) {
        this.no = no;
    }

    /**
     * 创建环形链表
     */
    public static class CircleSingleLinkedList {
        private People first = null;

        // 确定环形链表中的人数
        public void add(int num) {
            if (num < 1) {
                System.out.println("数据有误");
            }
            People currPeople = null;
            for (int i = 1; i <= num; i++) {
                // 根据编号添加链表元素
                People people = new People(i);
                if (i == 1) {
                    this.first = people;
                    // 构造环状
                    first.setNext(first);
                    // 辅助指针指向第一个节点
                    currPeople = first;
                } else {
                    // 指针指向下一个节点
                    currPeople.setNext(people);
                    // 节点指向第一个节点
                    people.setNext(first);
                    // 当前指针后移
                    currPeople = people;
                }
            }
        }

        public void showList() {
            if (first == null) {
                System.out.println("链表为空");
                return;
            }
            // 定义辅助指针
            People currPeople = first;
            while (true) {
                System.out.printf("链表节点编号 %d \n", currPeople.getNo());
                if (currPeople.getNext() == first) {
                    // 遍历完毕
                    break;
                }
                // 指针后移
                currPeople = currPeople.getNext();
            }
        }

        /*
         * @param startNo
         * @param countNum
         * @param nums
         */
        public void countPeople(int startNo, int countNum, int nums) {
            if (first == null || startNo < 1 || startNo > nums) {
                System.out.println("数据有误");
                return;
            }
            // 创建辅助指针
            People helper = first;
            // helper 指向最后一个节点
            while (true){
                if (helper.getNext() == first){
                    break;
                }
                helper = helper.next;
            }
            // 让first 和 helper 移动 k - 1 次
            for (int i = 0; i < startNo - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            // 循环出圈
            while (true){
                // 圈中只有一个节点时候停止
                if (helper == first){
                    break;
                }
                // 移动first 和 helper 指针同时移动到 countNum - 1
                for (int i = 0; i < countNum - 1; i++) {
                    first = first.next;
                    helper = helper.next;
                }
                System.out.printf("出圈的编号%d \n",first.getNo());
                first = first.getNext();
                helper.setNext(first);
            }
            System.out.println(first.getNo());
        }
    }
}
