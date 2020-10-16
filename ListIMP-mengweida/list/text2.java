package list;

public class text2 {
    public static void main(String[] args) {
        MyLinkList L = new MyLinkList();
        for(int i = 0,j = 10; i < 10; i++, j++)
        {
            L.insert(i, j);
        }
        L.display();
        L.isEmpty();
        L.length();
        L.indexOf(14);
        L.get(3);
        L.remove(1);
        L.clear();
    }
}
