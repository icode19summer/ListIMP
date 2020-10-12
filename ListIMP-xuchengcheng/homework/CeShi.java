import sun.font.TrueTypeFont;

import java.util.Scanner;

public class CeShi {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (true){
            float coe;
            int i=0;
            System.out.print("请输入第一个多项式");
            Quantic One = new Quantic();
            while (true){
                System.out.print("请输入：");
                coe = input.nextFloat();
                float term = input.nextFloat();
                if (coe == 0){
                    break;
                }
                Quantic.Term one = new Quantic.Term(coe,term,null);
                One.add(one);
            }
            System.out.print("请选择你要进行的操作（1.加；2.减；3.求导；");
            int select = input.nextInt();
            switch (select){
                case 1:System.out.print("请输入第二个多项式");
                    coe = 1;
                    while (true){
                        System.out.print("请输入：");
                        coe = input.nextFloat();
                        float term = input.nextFloat();
                        if (coe == 0){
                            break;
                        }
                        Quantic.Term one = new Quantic.Term(coe,term,null);
                        One.add(one);
                    }
                    One.display();
                    break;
                case 2:System.out.print("请输入第二个多项式");
                    coe = 1;
                    while (true){
                        System.out.print("请输入：");
                        coe = input.nextFloat();
                        float term = input.nextFloat();
                        if (coe == 0){
                            break;
                        }
                        Quantic.Term one = new Quantic.Term(-coe,term,null);
                        One.add(one);
                    }
                    One.display();
                    break;
                case 3: Quantic Two = One.derivation();
                        Two.display();
                        break;
            }
        }

    }
}
