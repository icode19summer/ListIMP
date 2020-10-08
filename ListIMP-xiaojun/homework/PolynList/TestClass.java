package PolynList;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class TestClass{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入A多项式的项数: ");
        int m = sc.nextInt();
        System.out.println("请分别输入多项式A各项的系数和指数: ");
        PolynList LA = new PolynList(m);
        System.out.println("请输入多项式B的项数: ");
        int n = sc.nextInt();
        System.out.println("请分别输入多项式B各项的系数和指数: ");
        PolynList LB = new PolynList(n);    //创建多项式LB
        LA = LA.addPolyn(LA,LB);
        System.out.println("求和后多项式各项为: ");
        LA.display();
    }
}
