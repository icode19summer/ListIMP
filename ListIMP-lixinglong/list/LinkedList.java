public class LinkedList<Item> {
    Item data;
    private int length;
    Node first;
    Node last;
    public LinkedList(){
        first=last=null;
        length=0;
    }
    public LinkedList(Item item){
        first.data=item;
        last=first;
        length=1;
    }
    public void clear(){
       first.next=null;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public boolean get(Item item){
        Node temp=first;
        while(temp.next!=null){
            if(temp.data.equals(item))
                return true;
            temp=temp.next;
        }
        return false;
    }
    public void add(Item item){
        Node s=new Node(item);
        if(first==null)
            first=last=s;
        last.next=s;
        last=s;
        length++;
    }
    public void insertFront(Item item,Item newItem){
        if(isEmpty()){
            System.out.println("empty.");
            return;
        }
        Node temp=first;
        Node prior;
        if(first.data.equals(item)){
            Node s=new Node(newItem);
            s.next=first;
            length++;
            return;
        }
        while(temp!=null){
            prior=temp;
            temp=temp.next;
            if(temp!=null&&temp.data.equals(item)){
                Node s=new Node(newItem);
                prior.next=s;
                s.next=temp;
                length++;
                return;
            }
        }
        System.out.println("not found.");
    }
    public void delete(Item item){
        if(isEmpty()){
            System.out.println("empty.");
            return;
        }
        Node temp=first;
        Node prior;
        if(first.data.equals(item)) {
            first = last = null;
            length--;
            return;
        }
        while(temp.next!=null){
           prior=temp;
           temp=temp.next;
           if(temp.data.equals(item)){
               prior.next=temp.next;
               length--;
               return;
           }
        }
        System.out.println("not found.");
    }
    public void display(){
        Node temp=first;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
