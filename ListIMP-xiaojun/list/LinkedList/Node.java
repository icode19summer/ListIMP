package LinkedList;
//节点类
public class Node {
    public Object data;//存放结点值
    public Node next;//后继结点的引用
    public Node()
    {
        this.data = null;
        this.next = null;
    }
    public Node(Object data)
    {
        this.data = data;
        next = null;
    }
    public Node(Object data, Node next)
    {
        this.data = data;
        this.next = next;
    }


}
