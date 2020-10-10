import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入第一个多项式的项数：");
        double a_n = input.nextDouble();
        int i = 0;
        System.out.print("请输入第一个多项式各项的系数与指数(按指数降序排序)：");

        double[][] a_data = new double[(int) a_n][2];

        for (int i1 = 0; i1 < a_data.length; i1++) {
            a_data[i1][0] = input.nextDouble();
            a_data[i1][1] = input.nextDouble();
        }
        node a_head = new node(a_n, 0.0);
        node a_node = a_head;

        while (i < a_n) {
            node p = new node(0.0, 0.0, null);
            p.setN(a_data[i][0]);
            p.setC_n(a_data[i][1]);
            a_node.setNext(p);

            a_node = p;
            i++;
        }
        System.out.print("请输入第二个多项式的项数：");
        double b_n = input.nextDouble();
        int k = 0;
        System.out.print("请输入第二个多项式各项的系数与指数(按指数降序排序)：");
        double[][] b_data = new double[(int) b_n][2];
        for (int i1 = 0; i1 < b_data.length; i1++) {
            b_data[i1][0] = input.nextDouble();
            b_data[i1][1] = input.nextDouble();
        }

        node b_head = new node(b_n, 0.0);
        node b_node = b_head;
        while (k < b_n) {
            node p = new node(0.0, 0.0, null);
            p.setN(b_data[k][0]);
            p.setC_n(b_data[k][1]);
            b_node.setNext(p);

            b_node = p;
            k++;
        }
        b_node.setNext(null);

        System.out.println("-----------测试用例-----------");
////        display(a_head);
//        //输出
        display(add(a_head, b_head));
//        //加法
//        display(sub(a_head, b_head));
//        //减法
////        display(derivation(a_head));
//        //求导
////        System.out.print(calculate(a_head, 2));
//        //求值，可自行改值
        
    }

    public static void display(node node_display) {
//输出多项式
        while (node_display.getNext() != null) {
            node_display = node_display.getNext();
            if (node_display.getN() != 0) {
                System.out.print(node_display.getN());

                if (node_display.getC_n() != 0) {
                    System.out.print("X^");
                    System.out.print(node_display.getC_n());
                }
                if (node_display.getNext() != null) {
                    System.out.print("+");
                }
            }
        }
        System.out.println();
    }

    public static node add(node a, node b) {
        //加法
        double result_n = a.getN() >= b.getN() ? a.getN() : b.getN();
        node result = new node(result_n, 0.0);
        node change = result;

        a = a.getNext();
        b = b.getNext();

        while (a != null && b != null) {
            node p = new node();
            if (a.getC_n() > b.getC_n()) {

                p.setN(a.getN());
                p.setC_n(a.getC_n());

                a = a.getNext();
            } else if (a.getC_n() < b.getC_n()) {

                p.setN(b.getN());
                p.setC_n(b.getC_n());

                b = b.getNext();

            } else {

                p.setN(a.getN() + b.getN());
                p.setC_n(a.getC_n());
                a = a.getNext();
                b = b.getNext();
            }

            change.setNext(p);

            change = change.getNext();

        }
        change.setNext(a == null ? b : a);

        return result;
    }

    public static node sub(node a, node b) {
        //减法
        double result_n = a.getN() >= b.getN() ? a.getN() : b.getN();
        node result = new node(result_n, 0.0);
        node p = new node();
        node change = result;
        while (a.getNext() != null && b.getNext() != null) {


            a = a.getNext();
            b = b.getNext();

            if (a.getC_n() > b.getC_n()) {
                p.setN(a.getN());
                p.setC_n(a.getC_n());
                a = a.getNext();
            } else if (a.getC_n() < b.getC_n()) {
                p.setN(b.getN());
                p.setC_n(b.getC_n());
                b = b.getNext();
            } else {
                p.setN(a.getN() - b.getN());
                p.setC_n(a.getC_n());
                if (a.getC_n().equals(a.getNext().getC_n()))
                    a = a.getNext();
            }
            change.setNext(p);
            change = change.getNext();
        }

        if (a.getNext() != null) {
            change.setNext(a.getNext());
        }
        if (b.getNext() != null) {
            change.setNext(b.getNext());
        }

        return result;
    }

    public static node derivation(node n) {

        node result = new node(n.getN(), 0.0);
        node p = result;

        while (n.getNext() != null) {

            n = n.getNext();
            node change = new node();
            change.setN(n.getN() * n.getC_n());
            change.setC_n(n.getC_n() - 1);

            p.setNext(change);
            p = p.getNext();
        }
        return result;
    }

    public static double calculate(node n, double x) {
        double result = 0;
        while (n.getNext() != null) {
            n = n.getNext();
            double result_1 = Math.pow(x, n.getC_n()) * n.getN();
            result += result_1;
        }
        return result;
    }
}
