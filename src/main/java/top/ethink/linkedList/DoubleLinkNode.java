package top.ethink.linkedList;

/**
 * @author AmazingQ
 * @date 2020-03-23 20:58
 */
public class DoubleLinkNode {
    public static void main(String[] args) {
        DoubleLinkNode node1 = new DoubleLinkNode(1, "A", "Angela");
        DoubleLinkNode node2 = new DoubleLinkNode(2, "B", "Baby");
        DoubleLinkNode node3 = new DoubleLinkNode(3, "C", "Code");
        DoubleLinkNode node4 = new DoubleLinkNode(4, "D", "Demo");
        DoubleLinkNode node5 = new DoubleLinkNode(5, "E", "Edge");
        DoubleLinkList linkList = new DoubleLinkList();
        linkList.add(node1);
        linkList.add(node5);
        linkList.add(node2);
        linkList.add(node4);
        linkList.add(node3);
        linkList.list();
        System.out.println("修改");
        DoubleLinkNode node6 = new DoubleLinkNode(4, "DD", "UPDATE");
        linkList.update(node6);
        linkList.list();
    }


    private int no;
    private String name;
    private String nickname;
    private DoubleLinkNode pre;
    private DoubleLinkNode next;

    private DoubleLinkNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "DoubleLinkNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public static class DoubleLinkList {
        private DoubleLinkNode head = new DoubleLinkNode(1, "", "");
        public DoubleLinkNode getHead() {
            return head;
        }

        /**
         * 遍历双向链表
         */
        public void list() {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            //头结点固定
            DoubleLinkNode temp = head.next;
            while (true) {
                if (temp == null) {
                    break;
                }
                //重写toString
                System.out.println(temp);
                temp = temp.next;
            }
        }

        /**
         * 双向链表添加
         */
        public void add(DoubleLinkNode doubleLinkNode) {
            //添加节点  找到链表的最后一个next  指向新的节点
            DoubleLinkNode temp = head;
            //遍历链表
            while (true) {
                //链表最后
                if (temp.next == null) {
                    break;
                }
                //没有找到
                temp = temp.next;
            }
            //退出时候temp 指向链表最后
            temp.next = doubleLinkNode;
            doubleLinkNode.pre = temp;
        }


        /**
         * 根据节点编号修改
         *
         * @param doubleLinkNode
         */
        public void update(DoubleLinkNode doubleLinkNode) {
            if (head.next == null) {
                System.out.println("空链");
                return;
            }
            //定义临时节点
            DoubleLinkNode temp = head.next;
            boolean flag = false;
            while (true) {
                if (temp == null) {
                    break;
                }
                if (doubleLinkNode.no == temp.no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            //根据flag判断
            if (flag) {
                temp.name = doubleLinkNode.name;
                temp.nickname = doubleLinkNode.nickname;
            } else {
                System.out.println("未找到该节点");
            }
        }

        /**
         * 根据节点编号删除
         */
        public void delete(int no) {
            if (head.next == null) {
                return;
            }
            DoubleLinkNode temp = head.next;
            boolean flag = false;
            while (true) {
                if (temp == null) {
                    return;
                }
                if (temp.no == no) {
                    //找到
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            //根据flag判断
            if (flag) {
                temp.pre.next = temp.next;
                //如果是最后一个节点不需要执行
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
            } else {
                System.out.println("未找到该节点");
            }
        }
    }


}
