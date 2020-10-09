package experments_01;

import java.util.Scanner;

public class test_01 {
    public static void main(String[] args) throws Exception {
        MyArrayList myArrayList = new MyArrayList(100);
        Scanner input = new Scanner(System.in);
        System.out.println("请输入链表长度：");
        int numbers = input.nextInt();
        for (int i = 0;i < numbers;i++){
            myArrayList.insert(i,2);
        }
        myArrayList.display();
        System.out.println("判断链表是否为空"+myArrayList.isEmpty());
        myArrayList.remove(4);
        System.out.println("删除链表中的第4个元素之后");
        myArrayList.display();
        myArrayList.insert(4,3);
        System.out.println("在第四个位置上加上数字3后：" );
        myArrayList.display();
        System.out.println("此时链表的长度："+myArrayList.length());
        System.out.println("查找元素为3的位置"+myArrayList.indexOf(3));
        myArrayList.clear();
        System.out.println("置空链表后的长度是"+myArrayList.length());
    }
}
