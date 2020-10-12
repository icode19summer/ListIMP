import java.util.LinkedList;

public class MyLinkedList<T> extends MyAbstractList<T> implements MyList<T>{

    transient int size;
    transient Node<T> first;

    public MyLinkedList() {
        this.size = 0;
        this.first= new Node<>(null,null);
    }

    public MyLinkedList(int size, Node<T> first) {
        this.size = size;
        this.first = first;
    }

    public Node<T> getNode(int index){
            Node<T> p = first;
            int i=0;
            while (i<index){
                p=p.next;
            }
            return p;
    }

    @Override
    public T get(int index) {
        if (index==0){
            return  (T) first.item;
        }
        else {
            return (T) getNode(index).item;
        }
    }

    @Override
    public void insert(int index, T x) {
        Node<T> p = getNode(index-1);
        Node<T> x1=new Node<T>(x,p.getNext());
        p.next=x1;
    }

    @Override
    public void remove(int index) {
        getNode(index-1).next=getNode(index+1);
    }

    @Override
    public boolean isEmpty() {
        return first.item==null;
    }

    @Override
    public void display() {
        Node<T> p=first.next;
        while(p!=null){
            System.out.println(p.toString());
            p=p.next;
        }
    }

    @Override
    public int indexOf(T x) {
        for(int i=0;i<size;i++){
            if (x==getNode(i)){
                return i;
            }
        }
        return -1;
    }

    public static class Node<T>{
        transient T item;
        transient Node<T> next;

        public Node(T item,Node<T> next){
            this.item=item;
            this.next=next;
        }

        @Override
        public String toString() {
            return ""+item;
        }

        public Node getNext(){
            return  next;
        }

    }
}
