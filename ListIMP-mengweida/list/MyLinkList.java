package list;

public class MyLinkList<T> implements IList {
    public Node head; //记录头结点
    public int size; //记录链表长度

    //结点内部类
    public class Node{
        public T item; //存储数据
        public Node next; //下一个结点

        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }
    //构造方法
    public MyLinkList(){
        //初始化头结点
        this.head = new Node(null,null);
        //初始化元素个数
        this.size = 0;
    }

    @Override
    public void clear() {
        head.next = null;
        this.size = 0;
        System.out.println("清空后的线性表元素个数为：" + size);
    }

    @Override
    public boolean isEmpty() {
        if(size == 0) {
            System.out.println("空表");
        } else {
            System.out.println("非空表");
        }
        return size == 0;
    }

    @Override
    public int length() {
        System.out.println("此顺序表的长度为"+ size);
        return size;
    }

    @Override
    public Object get(int i) {
        //通过循环，从头结点开始往后找，找i次，即找到对应元素
        Node n = head.next; //第一个存储数据的结点
        for (int index = 0; index < i; index++){ //遍历i次
            n = n.next;
        }
        System.out.println("获取索引" + i + "处的元素为：" + n.item);
        return n.item;
    }

    @Override
    public void insert(int i, Object x) {
        //找到i位置前一个结点
        Node pre = head;
        for (int index = 0; index <= i - 1; index++){
            pre = pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //创建新结点，并新结点指向原来i位置的结点
        Node newNode = new Node((T) x,curr);
        //原来i位置的前一个结点指向新结点
        pre.next = newNode;
        //元素个数 + 1
        size++;
    }

    @Override
    public void remove(int i) {
        //找到i位置的前一个结点
        Node pre = head;
        for (int index = 0; index <= i - 1; index++){
            pre = pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //找到i位置的下一个结点
        Node nextNode = curr.next;
        //前一个结点指向下一个结点
        pre.next = nextNode;
        //元素个数 - 1
        System.out.println("删除的元素是：" + curr.item);
        size--;
    }

    @Override
    public int indexOf(Object x) {
        //从头结点开始，找到每一个结点，取出item和t比较，相同则找到
        Node n = head;
        for (int i = 0; n.next != null; i++){ //n.next != null则有下一个元素
            n = n.next;
            if (n.item.equals(x)){
                System.out.println(x + "的索引为: "+ i);
                return i;
            }
        }
        System.out.println("表中没有该元素");
        return -1;
    }

    @Override
    public void display() {
        Node n = head.next;
        while (n != null){
            System.out.print(n.item + " ");
            n = n.next;
        }
        System.out.println();
    }
}
