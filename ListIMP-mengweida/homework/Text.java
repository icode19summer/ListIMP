package homework;

import java.util.Scanner;

public class Text {
    //多项式p1
    public static void main(String[] args) {


        PolyList p1 = new PolyList();
        p1.insert(new PolyNode(2, 2));
        p1.insert(new PolyNode(100, 3));
        p1.insert(new PolyNode(45, 5));
        p1.insert(new PolyNode(3, 20));
        System.out.println("p1=" + p1.printS());

        //多项式p2
        PolyList p2 = new PolyList();
        p2.insert(new PolyNode(8, 2));
        p2.insert(new PolyNode(7, 3));
        p2.insert(new PolyNode(4, 4));
        p2.insert(new PolyNode(6, 18));
        p2.insert(new PolyNode(7, 20));
        System.out.println("p2=" + p2.printS());

        //相加
        PolyList resultList1 = PolyList.add(p1, p2);
        System.out.println("p1+p2=" + resultList1.printS());

        System.out.println();

        //多项式p3
        PolyList p3 = new PolyList();
        p3.insert(new PolyNode(2, 1));
        p3.insert(new PolyNode(3, 2));
        p3.insert(new PolyNode(4, 3));
        System.out.println("p3=" + p3.printS());


        //多项式p4
        PolyList p4 = new PolyList();
        p4.insert(new PolyNode(5, 1));
        p4.insert(new PolyNode(1, 2));
        System.out.println("p4=" + p4.printS());

        //相减
        PolyList resultList2 = PolyList.detel(p3, p4);
        System.out.println("p3-p4=" + resultList2.printS());
        System.out.println();
        //多项式p5
        PolyList p5 = new PolyList();
        p5.insert(new PolyNode(2, 1));
        p5.insert(new PolyNode(3, 2));
        p5.insert(new PolyNode(4, 3));
        System.out.println("p5=" + p5.printS());
        PolyList resultList3 = PolyList.re(p5);
        System.out.println("p5求导=" + resultList3.printS());
        System.out.println();

        //多项式6
        PolyList p6 = new PolyList();
        p6.insert(new PolyNode(5, 1));
        p6.insert(new PolyNode(1, 2));
        System.out.println("p6=" + p6.printS());
        PolyList resultList4 = PolyList.x(p6 );
        System.out.println("x的系数" + resultList4.current.getA());
        System.out.println();
    }
}
