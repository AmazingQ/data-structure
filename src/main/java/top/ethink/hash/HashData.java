package top.ethink.hash;

/**
 * @author AmazingQ
 * @date 2020-09-16 22:57
 */
public class HashData {
    public static void main(String[] args) {
        //测试 创建HashTable
        HashTable hashTable = new HashTable(7);
        for (int i = 0; i < 14; i++) {
            char x = (char) (65 + i);
            Student student = new Student(i, x + "");
            hashTable.add(student);
        }
        hashTable.list();
        System.out.println();
        //Student findOne = hashTable.findStudentById(11);
        //System.out.println(findOne);
//        Student findTwo = hashTable.findStudentById(20);
//        System.out.println(findTwo);
        // 删除节点
        Student student = hashTable.deleteStudentById(23);
        System.out.println(student);
        hashTable.list();
    }


}

class HashTable {
    private LinkedList[] linkedLists;
    private int size;

    public HashTable(int size) {
        // 初始化数组(内部存放链表)
        this.size = size;
        linkedLists = new LinkedList[size];
        // 会出现 空指针异常  应该给所有的 每个链表初始化
        for (int i = 0; i < size; i++) {
            linkedLists[i] = new LinkedList();
        }

    }

    /**
     * HashTable 中的添加
     *
     * @param student
     * @return
     */
    public boolean add(Student student) {
        // 根据员工的id  获取员工应该存放到哪个数组中
        int hash = hash(student.id);
        // 将数据装入链表
        return linkedLists[hash].add(student);
    }

    /**
     * 遍历所有链表
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            linkedLists[i].list();
        }
    }

    /**
     * 查找
     * @param id
     * @return
     */
    public Student findStudentById(int id) {
        int hash = hash(id);
        System.out.println("可能存在的链表: " + hash);
        return linkedLists[hash].findStudentById(id);

    }

    public Student deleteStudentById(int id){
        int hash = hash(id);
        System.out.println("可能存在的链表: " + hash);
        return linkedLists[hash].deleteStudentById(id);
    }
    /**
     * 获取该数据应该存放的 数组索引
     * @param val
     * @return
     */
    public int hash(int val) {
        return val % size;
    }
}

/**
 * 表示一个学生
 */
class Student {
    public int id;
    public String name;
    public Student next;

    public Student() {
    }

    public Student(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}

// 链表
class LinkedList {
    private Student head;

    /**
     * 添加学生  添加学生时候 id 是自增长的
     * @param student
     */
    public boolean add(Student student) {
        // 如果是第一次添加
        if (head == null) {
            head = student;
            return true;
        }
        // 不是第一个的话
        Student currStu = head;
        while (currStu.next != null) {
            // 如果学生链表的下一个节点不为 null 则说明节点后 还存在
            currStu = currStu.next;
        }
        currStu.next = student;
        return true;
    }

    /**
     * 遍历链表
     */
    public void list() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        // 打印链表
        System.out.println("打印链表");
        Student currStu = head;
        while (currStu != null) {
            System.out.printf(" id=%d  name= %s\t", currStu.id, currStu.name);
            currStu = currStu.next;
        }
    }

    /**
     * 根据 ID 查找
     * @param id
     * @return
     */
    public Student findStudentById(int id) {
        // 判断是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        // 辅助指针
        Student curr = head;
        while (true) {
            if (curr.id == id) {
                break;
            }
            if (curr.next == null) {
                curr = null;
                break;
            }
            curr = curr.next;
        }
        return curr;
    }

    /**
     * 根据 ID 删除
     * @param id
     * @return
     */
    public Student deleteStudentById(int id) {
        // 判断是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        // 辅助指针
        Student curr = head;
        Student delNode = null;
        while (true) {
            if (curr == null){
                System.out.println("未找到删除节点");
                break;
            }
            if (head.id == id){
                // 如果头结点是所找元素 则直接 break
                head = curr.next;
                delNode = head;
                break;
            }
            if (curr.next != null){
                if (curr.next.id == id){
                    delNode = curr.next;
                    curr.next = curr.next.next;
                    break;
                }
            }
            curr = curr.next;
        }
        // TODO 链表断链 重组
        return delNode;
    }
}
