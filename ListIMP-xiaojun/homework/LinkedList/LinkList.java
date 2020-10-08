package LinkedList;

import IList.IList;

import java.util.Scanner;

public class LinkList implements IList{
    public Node head;//单链表的头结点
    public LinkList(){
        head = new Node();//初始化头结点
    }
    public LinkList(int n,boolean Order) throws Exception{//构造一个长度为n的单链表
        this();//初始化头节点
        if(Order)           //用尾插法顺序建立单链表
            create1(n);
        else               //用头插法逆位序建立单链表 === 用尾插法逆序输入n个结点的数据域值，来创建单链表
            create2(n);
    }
    //用尾插法顺序建立单链表，其中n为单链表的结点个数
    public void create1(int n) throws Exception{
        Scanner sc = new Scanner(System.in);//构造用于输入的对象
        for(int j = 0 ; j < n ;  j++)//顺序输入n个结点的数据域值
        {
            insertAt(length(),sc.next());
        }
    }
    //用头插法逆位序建立单链表，其中n为单链表的结点个数
    public void create2(int n) throws Exception{
        Scanner sc = new Scanner(System.in);
        for(int j = 0 ; j < n ; j++)//逆序输入n个结点的数据域值
        {
            insertAt(0,sc.next());
        }
    }
    public void clear(){
        head.data = null;
        head.next = null;
    }
    public boolean isEmpty(){
        return head.next == null;
    }
    public int length(){
        Node p = head.next;
        int length = 0;
        while (p != null)
        {
            length++;
            p = p.next;   //指向后继节点
        }
        return length;
    }
    public Object get(int i){
        Node p = head.next;//初始化，p指向首节点，j为计数器
        int j = 0;
        while (p != null && j < i)//从首节点开始向后查找，直到 p指向第i个结点或 p为空
        {
            p = p.next;
            ++j;
        }
        if(p == null || j > i)//i小于0或者大于表长减1时，即i不合法   i > j 等价于 p == null
        {
            System.out.println("第"+ i + "元素不存在");
        }
        return p.data;
    }
    public void insertAt(int i,Object x){
        Node p = head;//初始化，p为头结点,j为计数器
        int j = -1;
        while (p != null && j < i - 1)//寻找第i个结点的前驱，也就是第i-1个结点
        {
            p = p.next;
            j++;
        }
        //操作过程分析：
//        length = 5  i = 3,x  = 2 ;
//        p = -1
//        j = -1< 2  p = 0, j = 0<2
//        p = 1, j = 1<2
//        p = 2 , j = 2 !< 2
        if(head.next != null)//非空才接着判断位置的合法性
        {
            if(p == null || j > i -1)
            {
                System.out.println("插入位置不合法");
            }
        }
        Node s = new Node(x);
        s.next = p.next;
        p.next = s;
    }
    public void  remove(int i){
        //Node p = head.next; 初始化，p指向首节点,j为计数器 不能这么做，防止此链表为空链表，没有首节点
        Node p = head;
        int j = -1;
        while (p != null && j < i-1 )//寻找第i个结点的前驱，也就是第i-1个结点
        {
            p = p.next;
            j++;
        }
        if(p.next != null)//非空才接着判断位置的合法性
        {
            if(p == null || j > i -1)
            {
                System.out.println("删除位置不合法");
            }
        }
        p.next = p.next.next;
    }
    public int indexOf(Object x)
    {
        Node p = head.next;//初始化，p指向首节点,j为计数器
        int j = 0;
        while ( p != null && !p.data.equals(x))
        {
            p = p.next;
            j++;
        }
        if( p != null)
        {
            return j;//返回值为x的结点在单链表中的位置
        }
        else
            return -1;//值为x的结点不在单链表中，则返回-1
    }
    public void display(){
        Node node = head.next;//初始化，node指向首节点
        while (node != null)
        {
            System.out.print(node.data+ " ");
            node = node.next;
        }
        System.out.println();
    }
}
