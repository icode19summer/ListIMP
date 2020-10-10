import java.util.Scanner;

public class homework {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入第一个多项式的项数：");
        double a_data = input.nextDouble();
        double i = 0;
        System.out.print("请输入");
        node a_head = new node(a_data);
        node a_node = new node();
        a_head.setNext(a_node);
        while (i < a_data){

        }


        System.out.print("请输入第二个多项式的项数：");
        double b_data = input.nextDouble();
        node b = new node(b_data);
        node b_node = new node();


        input.close();

    }
}
