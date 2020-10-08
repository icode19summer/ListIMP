package list;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.insert(6);
        arrayList.insert(2);
        arrayList.insert(4);
        arrayList.remove(0);
        arrayList.display();
        System.out.println("********************************");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(5);
        linkedList.remove(1);
        linkedList.display();
    }
}
