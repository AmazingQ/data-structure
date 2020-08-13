package top.ethink.linkedList;

import java.util.Stack;

/**
 * @author AmazingQ
 * @date 2020-03-05 23:20
 */
public class SingleLinkNode {
    public static void main(String[] args) {
        SingleLinkNode node1 = new SingleLinkNode(1, "A", "Angela");
        SingleLinkNode node2 = new SingleLinkNode(2, "B", "Baby");
        SingleLinkNode node3 = new SingleLinkNode(3, "C", "Code");
        SingleLinkNode node4 = new SingleLinkNode(4, "D", "Demo");
        SingleLinkNode node5 = new SingleLinkNode(5, "E", "Edge");
        SingleLinkList linkList = new SingleLinkList();

        // 顺序添加单链表
//        linkList.list();
        // 带排序单链表
        linkList.addAndSort(node2);
        linkList.addAndSort(node4);
        linkList.addAndSort(node3);
        linkList.addAndSort(node1);
        linkList.list();

        linkList.reverse(linkList.getHead());
        System.out.println("链表翻转");
        linkList.list();
        System.out.println("从尾到头打印不破坏单链表结构");
        linkList.reversePrint(linkList.getHead());
    }



    private int no;
    private String name;
    private String nickname;
    private SingleLinkNode next;
    private SingleLinkNode(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "SingleLinkNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    /**
     * 链表
     */
    public static class SingleLinkList{
        //初始化头结点
        private SingleLinkNode head = new SingleLinkNode(1,"","");

        public SingleLinkNode getHead() {
            return head;
        }

        public void add(SingleLinkNode singleLinkNode){
            //添加节点  找到链表的最后一个next  指向新的节点
            SingleLinkNode temp = head;
            //遍历链表
            while (true){
                //链表最后
                if (temp.next == null){
                    break;
                }
                //没有找到
                temp = temp.next;
            }
            //退出时候temp 指向链表最后
            temp.next = singleLinkNode;
        }

        /**
         * 有序添加
         * @param singleLinkNode
         */
        public void addAndSort(SingleLinkNode singleLinkNode){
            //添加节点有序插入  需要辅助指针定位添加位置 temp 未添加位置的前节点
            SingleLinkNode temp = head;
            boolean flag = false;
            while (true){
                if (temp.next == null){
                    //循环结束
                    break;
                }
                if (temp.next.no > singleLinkNode.no){
                    //位置确定
                    break;
                }else if (temp.next.no == singleLinkNode.no){
                    //已存在
                    flag = true;
                    break;
                }
                //指针后移
                temp = temp.next;
            }
            if (flag){
                System.out.println("存在");
            }else {
                //插入链表
                singleLinkNode.next = temp.next;
                temp.next = singleLinkNode;
            }
        }

        /**
         * 根据节点编号修改
         * @param singleLinkNode
         */
        public void update(SingleLinkNode singleLinkNode){
            if (head.next==null){
                System.out.println("空链");
                return;
            }
            //定义临时节点
            SingleLinkNode temp = head.next;
            boolean flag = false;
            while (true){
                if (temp == null){
                    //未找到
                    break;
                }
                if (singleLinkNode.no == temp.no){
                    //确定位置
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            //根据flag判断
            if (flag){
               temp.name = singleLinkNode.name;
               temp.nickname = singleLinkNode.nickname;
            }else {
                System.out.println("未找到该节点");
            }
        }

        /**
         * 根据节点编号删除
         */
        public void delete(int no){
            //定义临时节点
            SingleLinkNode temp = head;
            boolean flag = false;
            while (true){
                if (temp.next ==null){
                    return;
                }
                if (temp.next.no == no){
                    //找到
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            //根据flag判断
            if (flag){
                temp.next = temp.next.next;
            }else {
                System.out.println("未找到该节点");
            }
        }


        /**
         * 显示链表
         */
        public void list(){
            if (head.next == null){
                System.out.println("链表为空");
                return;
            }
            //头结点固定
            SingleLinkNode temp = head.next;
            while (true){
                if (temp == null){
                    break;
                }
                System.out.println(temp);//重写toString
                temp = temp.next;
            }
        }

        public void reverse(SingleLinkNode head){
            if (head.next==null || head.next.next == null){
                return;
            }
            //定于辅助指针
            SingleLinkNode curr = head.next;
            //记录当前节点curr的下一个节点 防止链表断裂
            SingleLinkNode next = null;
            SingleLinkNode reverseHead = new SingleLinkNode(0,"","");
            while (curr != null){
                next = curr.next;
                //将curr的下一节点指向新链表的最前端
                curr.next = reverseHead.next;
                reverseHead.next = curr;
                //curr后移
                curr = next;
            }
            head.next = reverseHead.next;
        }

        public  void reversePrint(SingleLinkNode head){
            if (head.next == null){
                return;
            }
            Stack<SingleLinkNode> stack = new Stack<SingleLinkNode>();
            SingleLinkNode curr = head.next;
            while (curr!=null){
                stack.push(curr);
                curr = curr.next;
            }
            while (stack.size()>0){
                System.out.println(stack.pop());
            }
        }
    }

    public static int getLength(SingleLinkNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        SingleLinkNode current = head.next;
        while (current != null){
            length ++;
            current = current.next;
        }
        return length;
    }



    public static SingleLinkNode findLastIndexNode(SingleLinkNode head,int index){
        if (head.next == null){
            return null;
        }
        int size = getLength(head);
        if (index<=0 || index > size){
            return null;
        }
        SingleLinkNode curr = head.next;
        for (int i = 0; i  < size - index; i++) {
            curr = curr.next;
        }
        return curr;
    }
}
