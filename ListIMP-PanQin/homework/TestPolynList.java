package homework;

public class TestPolynList {
    public static void main(String[] args) {
        MyPolyList p1 = new MyPolyList(4);
        p1.insert(3, 2);
        p1.insert(2, 4);
        p1.insert(1, 1);
        p1.insert(1);
        System.out.println("p1的项数为：" + p1.size());
        System.out.println("p1 = " + p1);
        System.out.println("p1的x系数为：" + p1.xCoef());
        MyPolyList p2 = new MyPolyList();
        p2.insert(6, 4);
        p2.insert(4, 11);
        p2.insert(3, 2);
        p2.insert(1, 0);
        System.out.println("p2的项数为：" + p2.size());
        System.out.println("p2 = " + p2);
        MyPolyList dp = p1.derPol();
        System.out.println("p1求导后：" + dp);
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        p1.addPol(p2);
        System.out.println("p1 + p2 = " + p1);
//        p2.subPol(p1);
//        System.out.println("p1 - p2 = " + p2);
    }
}
