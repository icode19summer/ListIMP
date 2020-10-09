package experments_02;

import java.util.Scanner;

public class test {
    public static void main(String [] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入A多项式项数：");
        int m = sc.nextInt();
        System.out.println("请分别输入多项式A各项的系数和指数");
        PolynList LA = new PolynList(m);
//        System.out.println("请输入B多项式项数：");
//        int n = sc.nextInt();
//        System.out.println("请分别输入多项式A各项的系数和指数");
//        PolynList LB = new PolynList(n);
////        LA = LA.addPolyn(LA,LB);
////        System.out.println("求和后的多项式各项为：");
////        LA.display();
//        LA = LA.SubPolyn(LA,LB);
//        System.out.println("相减之后的多项式各项为：");
//        LA.display();
//        System.out.println("代入x后多项式的值是："+ LA.Evaluation(LA,2));
        LA.Derivative(LA);
        System.out.println("求导后的多项式：");
        LA.display();

    }
}
