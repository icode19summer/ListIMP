public class Node<Item> {
    public Item data;
    public Node next;
    public Node(){
        this(null,null);
    }
    public Node(Item data){
        this(data,null);
    }
    public Node(Item data,Node next){
        this.data=data;
        this.next=next;
    }
}
