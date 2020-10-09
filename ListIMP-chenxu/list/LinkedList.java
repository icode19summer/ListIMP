import java.util.Scanner;

public class LinkedList<T> implements List<T> {
    public ListLinkNode<T> head;

    @Override
    public void clear() {
        head = new ListLinkNode<T>();
        head.setData(null);
        head.setNext(null);
    }//置空操作

    @Override
    public boolean isEmpty() {
        return head == null;
    }//判空操作

    @Override
    public int length() {
        ListLinkNode<T> curNode = head;
        int length = 0;
        while (curNode != null) {
            curNode = curNode.next;
            length++;
        }
        return length;
    }

    @Override
    public Object get(int i) {
        ListLinkNode<T> q = head;
        int index = 0;
        while (q != null) {
            if (index == i - 1) {
                break;
            }
            q = q.getNext();
            index++;
        }
        if (index == i - 1) {
            return q.getNext();
        } else {
            System.out.println("第i号元素不存在");
            return false;
        }
    }//读取线性表中第i个数据元素的值

    @Override
    public boolean insert(int i, Object x) {
        ListLinkNode<T> q = head;
        int index = 0;
        while (q != null) {
            if (index == i - 1) {
                break;
            }
            q = q.getNext();
            index++;
        }
        if (index == i - 1) {
            ListLinkNode<T> p = new ListLinkNode<>();
            p.setData((T) x);
            p.setNext(q.getNext());
            q.setNext(p);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(int i) {
        if (i < 1) {
            System.out.println("下标i错误");
        }
        int index = 1;
        ListLinkNode<T> q = head;
        ListLinkNode<T> p = head.getNext();
        while ((p != null) && (index < i)) {
            q = p;
            p = p.getNext();
            index = index + 1;
        }
        if (index == i) {
            q.setNext(p.getNext());
            return true;
        } else {
            System.out.println("下标i错误，超出列表长度！");
            return false;
        }

    }//删除操作，其中0<=i<=length()-1

    @Override
    public void display() {
        System.out.println("[");
        ListLinkNode<T> p = head.getNext();
        while (p != null) {
            T value = p.getData();
            System.out.println(value.toString());
            p = p.getNext();
            if (p != null) {
                System.out.println(",");
            }
        }
        System.out.println("]");
    }//输出线性表中各个数据元素值的操作

    @Override
    public int indexOf(Object x){
        ListLinkNode<T> q = head;
        int index=0;
        while ((q!=null)&&(q.getData()!=(T)x)){
            q=q.getNext();
            index++;
        }
        if (q==null){
            System.out.println(x+"元素不存在");
            return -1;
        }
        else{
            return index;
        }
        }//查找值为x的数据元素操作


    //单链表节点类
    public class ListLinkNode<T>{
        private T data;
        private ListLinkNode<T> next;
        public T getData(){
            return data;
        }
        public void setData(T data){
            this.data=data;
        }
        public ListLinkNode<T> getNext(){
            return next;
        }
        public void setNext(ListLinkNode<T> next){
            this.next=next;
        }
        public ListLinkNode(){
            this.setData(null);
            this.setNext(null);
        }
        public ListLinkNode(T data,ListLinkNode next){
            this.setNext((ListLinkNode<T>) data);
            this.setNext(next);
        }


    }
    public LinkedList(){
        head = new ListLinkNode<T>();
        head.setData(null);
        head.setNext(null);
    }
    public void addFromHead(T e){
        ListLinkNode<T> p=new ListLinkNode<T>();
        p.setData(e);
        p.setNext(head.getNext());
        head.setNext(p);
    }
    public static LinkedList<Integer> createFromHead(){
        LinkedList<Integer> listLinked=new LinkedList<Integer>();
        System.out.println("-头插法建立链表-");
        System.out.println("请输入链表长度：");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println("请输入值：");
        for(int i=0;i<n;i++){
            System.out.println("请输入第"+i+"个值：");
            int value =scanner.nextInt();
            listLinked.addFromHead(value);
        }
        System.out.println("链表创建完毕");
        return listLinked;
    }
}
