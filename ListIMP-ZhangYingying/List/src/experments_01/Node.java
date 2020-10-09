package experments_01;

public class Node<T> {
    public Object data; //节点的数据
    public Node next; //指向的下一个节点

    public Node() {
        this(null,null);
    }
    public Node(Object data){
        this.data = data;
    }
    public Node(Object data, Node next) {
        this.data = data;
        this.next=next;
    }
    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}
