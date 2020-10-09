package homework;

public class Main {
    public static void main(String[] args) {
        PolynomialList list1 = new PolynomialList();
        list1.addNode(new Node(10, 0));
        list1.addNode(new Node(-8, 1));
        list1.addNode(new Node(6, 2));
        list1.addNode(new Node(3, 5));
        list1.addNode(new Node(6, 6));
        list1.addNode(new Node(3, 7));
        System.out.print("list1=");
        list1.display();

        PolynomialList list2 = new PolynomialList();
        list2.addNode(new Node(17, 0));
        list2.addNode(new Node(8, 1));
        list2.addNode(new Node(3, 2));
        list2.addNode(new Node(5, 4));
        System.out.print("list2=");
        list2.display();

        PolynomialList polynomialList = list2.addPolynomialList(list1);

        System.out.print("list1+list2=");
        list2.display();
        System.out.println("x的值为："+list2.xValue());
        list2.derivation();
        System.out.print("list1+list2 求导后结果：");
        list2.display();
        System.out.println("*******************");


        PolynomialList list3 = new PolynomialList();
        list3.addNode(new Node(10, 0));
        list3.addNode(new Node(-10, 1));
        list3.addNode(new Node(-6, 5));
        list3.addNode(new Node(3, 9));
        System.out.print("list3=");
        list3.display();

        PolynomialList list4 = new PolynomialList();
        list4.addNode(new Node(17, 0));
        list4.addNode(new Node(8, 1));
        list4.addNode(new Node(3, 6));
        list4.addNode(new Node(5, 5));
        list4.addNode(new Node(4, 2));
        System.out.print("list4=");
        list4.display();
        list4.subtractionPolynomialList(list3);
        System.out.print("list4-list3=");
        list4.display();
        System.out.println("x的值为："+list4.xValue());
        list4.derivation();
        System.out.print("list4-list3 求导后结果：");
        list4.display();
    }
}