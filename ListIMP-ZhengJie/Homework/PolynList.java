package Homework;

import List.MyLinkedList;
import List.Node;

import java.util.Scanner;

public class PolynList extends MyLinkedList {
    public PolynList(int n) throws Exception {
        head.data = new PolynNode(0, -1);
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= n; i++) {
            double coef = sc.nextDouble();
            int expn = sc.nextInt();
            insert(new PolynNode(coef, expn));
        }
    }

    public void insert(PolynNode e) throws Exception {
        int j = 0;
        while (j < length()) {
            PolynNode t = (PolynNode) get(j);
            if (t.expn > e.expn)
                break;
            j++;
        }
        insert(j, e);
    }

    public int cmp(PolynNode a, PolynNode b) {
        if (a.expn < b.expn)
            return -1;
        else if (a.expn == b.expn)
            return 0;
        else
            return 1;
    }

    public PolynList addPolyn(PolynList LA, PolynList LB) {
        Node ha = LA.head;
        Node qa = LA.head.next;
        Node qb = LB.head.next;
        while (qa != null && qb != null) {
            PolynNode a = (PolynNode) qa.data;
            PolynNode b = (PolynNode) qb.data;
            switch (cmp(a, b)) {
                case -1:
                    ha.next = qa;
                    ha = qa;
                    qa = qa.next;
                    break;
                case 0:
                    double sum = a.coef + b.coef;
                    if (sum != 0.0) {
                        a.coef = sum;
                        ha.next = qa;
                        ha = qa;
                        qa = qa.next;
                        qb = qb.next;
                    } else {
                        qa = qa.next;
                        qb = qb.next;
                    }
                    break;
                case 1:
                    ha.next = qb;
                    ha = qb;
                    qb = qb.next;
                    break;
            }
        }
        ha.next = (qa != null ? qa : qb);
        return LA;
    }

    public PolynList subtraction(PolynList LA, PolynList LB) {
        Node ha = LA.head;
        Node qa = LA.head.next;
        Node qb = LB.head.next;
        while (qa != null && qb != null) {
            PolynNode a = (PolynNode) qa.data;
            PolynNode b = (PolynNode) qb.data;
            switch (cmp(a, b)) {
                case -1:
                    ha.next = qa;
                    ha = qa;
                    qa = qa.next;
                    break;
                case 0:
                    double sub = a.coef - b.coef;
                    if (sub > 0) {
                        a.coef = sub;
                        ha.next = qa;
                        ha = qa;
                        qa = qa.next;
                        qb = qb.next;
                    } else if (sub == 0) {
                        qa = qa.next;
                        qb = qb.next;
                    } else {
                        a.coef = (-1) * sub;
                        ha.next = qa;
                        ha = qa;
                        qa = qa.next;
                        qb = qb.next;
                    }
                    break;
                case 1:
                    ha.next = qb;
                    ha = qb;
                    qb = qb.next;
                    break;
            }
        }
        return LA;
    }

    public double evaluation(double x) throws Exception {
        double value = 0;
        for (int i = 0; i < length(); i++) {
            PolynNode e = (PolynNode) get(i);
            value += e.coef * x + e.expn * x;
        }
        return value;
    }

    public void display02() {
        for (int i = 0; i < length(); i++) {
            try {
                PolynNode e = (PolynNode) get(i);
                System.out.println("系数为" + (e.coef * e.expn) + "指数为" + (e.expn - 1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("1.多项式相加");
        System.out.println("2.多项式相减");
        System.out.println("3.计算多项式在X处的值");
        System.out.println("4.对多项式进行求导");
        System.out.println("请输入你想要的服务编号:");
        Scanner a = new Scanner(System.in);
        int choose = a.nextInt();
        switch (choose) {
            case 1:
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入A多项式的项数:");
                int m = sc.nextInt();
                System.out.println("请分别输入多项式A各项的系数和指数:");
                PolynList LA = new PolynList(m);
                System.out.println("请输入B多项式的项数:");
                int n = sc.nextInt();
                System.out.println("请分别输入多项式B各项的系数和指数:");
                PolynList LB = new PolynList(n);
                LA = LA.addPolyn(LA, LB);
                System.out.println("求和后的多项式各项为:");
                LA.display();
            case 2:
                Scanner in = new Scanner(System.in);
                System.out.println("请输入A多项式的项数:");
                int o = in.nextInt();
                System.out.println("请分别输入多项式A各项的系数和指数:");
                PolynList A = new PolynList(o);
                System.out.println("请输入B多项式的项数:");
                int p = in.nextInt();
                System.out.println("请分别输入多项式B各项的系数和指数:");
                PolynList B = new PolynList(p);
                A = A.subtraction(A, B);
                System.out.println("求差后的多项式各项为:");
                A.display();
            case 3:
                Scanner aa = new Scanner(System.in);
                System.out.println("请输入A多项式的项数:");
                int r = aa.nextInt();
                System.out.println("请分别输入多项式A各项的系数和指数:");
                PolynList AA = new PolynList(r);
                System.out.println("请输入X的值:");
                int x = aa.nextInt();
                System.out.println("多项式A在x=" + x + "处的值为:" + AA.evaluation(x));
            case 4:
                Scanner bb = new Scanner(System.in);
                System.out.println("请输入A多项式的项数:");
                int e = bb.nextInt();
                System.out.println("请分别输入多项式A各项的系数和指数:");
                PolynList BB = new PolynList(e);
                System.out.println("求导后的多项式为:");
                BB.display02();
        }
    }

    public void display() {
        for (int i = 0; i < length(); i++) {
            try {
                PolynNode e = (PolynNode) get(i);
                System.out.println("系数为" + e.coef + "指数为" + e.expn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
