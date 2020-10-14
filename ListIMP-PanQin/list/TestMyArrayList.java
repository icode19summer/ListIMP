package list;

public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList L1 = new MyArrayList(10);
        for(int i = 0,j = 1; i < 10; i++, j++)
        {
            L1.insert(i, j);
        }
        L1.display();
        L1.isEmpty();
        L1.length();
        L1.indexOf(4);
        L1.remove(2);
        L1.get(3);
        L1.clear();
    }
}
