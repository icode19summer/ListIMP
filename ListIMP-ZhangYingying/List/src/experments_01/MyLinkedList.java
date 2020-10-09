package experments_01;

import experments_02.PolynNode;

import java.util.Scanner;

 public class MyLinkedList<T> extends experments_01.Node implements List<T>{
    public Node head;  //头结点
    private Node tail;  //尾结点
    private int size;   //链表长度
    public Object data;//存放结点值

    public MyLinkedList(int length) {
        this.size = length;
        this.head=new Node();
    }
    public MyLinkedList(Object data ,Node next){
        this.data = data;
        this.next = next;
    }

    @Override
    public void clear() {
        head.next = null;
        tail = null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int length() {
        Node p = head.getNext();
        int length = 0;
        while (p!=null) {
            p = p.next;
            ++length;
        }
        return length;
    }

    @Override
    public Object get(int i) throws Exception {
        Node p = head.getNext();
        int j = 0;
        while (!p.equals(head) && j < i) {
            p = p.getNext();
            ++j;
        }
        if (j > i || p.equals(head)) {
            throw new Exception("第" + i + "个元素不存在");
        }
        return p.getData();
    }

    @Override
    public void insert(int i, Object e) throws Exception {
        Node p =head;
        int j =-1;
        while(p != null && j < i-1){//寻找第i个结点的前驱
            p=p.next;
            ++j;
        }
        if (j > i-1 || p == null) {
            throw new Exception("错误，加入指定索引越界");
        }
        Node s = new Node(e);
        s.next = p.next;
        p.next = s;

    }

    @Override
    public void remove(int i) throws Exception {
        Node p = head;
        int j = -1;
        while(p.next!=null&&j<i-1){
            p=p.next;
            ++j;
        }
        if (j>i-1 || p.next==null) {
            throw new Exception("错误，删除指定索引越界");
        }
        p.next = p.next.next;
    }

    @Override
    public int indexOf(Object x) {
        Node p = head.next;
        int j = 0;// j为计数器
        while (p != null && !p.data.equals(x)) {
            p = p.next;
            ++j;
        }
            if (p !=null)// 判断j的位置是否位于表中
                return j; // 返回x元素在顺序表中的位置
            else
                return -1;// x元素不在顺序表中
    }

    @Override
    public void display() {
        Node p = head.next;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

}
