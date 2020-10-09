package evlic.DataStructure.homework;

import evlic.DataStructure.List.ListLink;

import java.util.Scanner;

public class ListMP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("创建多项式a，请依次输入（浮点数形式的）各项系数、对应指数，\n连续输入两个0.0 0.0后结束");

        PolyList a = new PolyList();
        while (true) {
            float c=scanner.nextFloat();
            float e=scanner.nextFloat();

            if (c==0&&e==0)
                break;

            a.addNode(new PolyList.PolyNode(c,e));
        }

        a.display(1);

        System.out.println("创建多项式b 格式要求不变");
        PolyList b = new PolyList();
        while (true) {
            float c=scanner.nextFloat();
            float e=scanner.nextFloat();

            if (c==0&&e==0)
                break;

            b.addNode(new PolyList.PolyNode(c,e));
        }

        b.display(2);

        System.out.println("请进行下一步操作\n\n当前可执行 a+b a-b 操作\n 输入对应指令可进行操作");
        String req=scanner.next();

        if(req.equals("a+b")) {
            PolyList.PolyNode p=b.getHead();
            for (int i = 1; i < b.length() + 1; i++) {
                p=p.getNextNode();
                a.addNode(p);
            }
            System.out.println("a+b执行成功 结果为：");
            a.display(1);
        }else if (req.equals("a-b")){
            PolyList.PolyNode p=b.getHead();
            for (int i = 1; i < b.length() + 1; i++) {
                p=p.getNextNode();
                p.setC(-1* p.getC());
                a.addNode(p);
            }
            System.out.println("a-b执行成功 结果为：");
            a.display(1);
        }else
            System.out.println("指令有误");
    }
}
