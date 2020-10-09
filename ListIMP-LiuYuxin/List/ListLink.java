package evlic.DataStructure.List;

public class ListLink<T> implements List<T>{
    public ListLinkNode<T> head;
    public ListLinkNode<T> p;
    private int index;
    private int length;

    public ListLink() {
        head=new ListLinkNode<T>();
        p=new ListLinkNode<T>();
    }

    //set() 初始化
    private void set(){
        index=0;
        p=head;
    }
    //find(i) 令p变成第i位节点
    private void find(int i){
        set();
        while(index < i){
            p=p.getNext();
            index++;
        }
    }

    @Override
    public void clear() {
        head.setData(null);
        head.setNext(null);
    }

    @Override
    public boolean isEmpty() {
        return head.getNext()==null;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public T get(int i) {
//      判断位数是否合法
        if (i<0||i>length){
            System.out.println("位数不合法！");
            return (T)"error";
        }
        find(i);
        return p.getData();
    }

    @Override
    public void insert(int i, T x) {
//      判断位数是否合法
        if (i<0||i>length+1){
            System.out.println("位数不合法！");
            return;
        }
        ListLinkNode<T> q = new ListLinkNode<T>(x,null);
        find(i-1);
        q.setNext(p.getNext());
        p.setNext(q);
        length++;
    }

    @Override
    public void remove(int i) {
        //      判断位数是否合法
        if (i<0||i>length) {
            System.out.println("位数不合法！");
            return;
        }
        find(i-1);
        p.setNext(p.getNext().getNext());
        length--;
    }

    @Override
    public int indexOf(T x) {
        set();
        if(this.isEmpty()){
            System.out.println("链表为空！");
            return -1;
        }
        while (index!=length){
            if(p.getData()==x){
                return index;
            }
            p=p.getNext();
            index++;
        }
        if (p.getData() == x)
            return index;
        else{
            System.out.println("未找到匹配对象！");
            return -99;
        }
    }

    @Override
    public void display() {
        set();
        while (true){
            p=p.getNext();
            index++;
            System.out.println(p.getData());
            if(index==length)
                return;
        }
    }

    public static class ListLinkNode<T>{
        private T data;
        private  ListLinkNode<T> next;

        //  无参构造
        public ListLinkNode() {
            this.setData(null);
            this.setNext(null);
        }
        //  有参构造
        public ListLinkNode(T data, ListLinkNode<T> next) {
            this.data = data;
            this.next = next;
        }

        //  get&set
        public T getData() {
            return data;
        }
        public void setData(T data) {
            this.data = data;
        }
        public ListLinkNode<T> getNext() {
            return next;
        }
        public void setNext(ListLinkNode<T> next) {
            this.next = next;
        }
    }

}