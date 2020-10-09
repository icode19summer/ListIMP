package experments_01;

import java.util.Scanner;

public class Test_02 {
    public static void main(String[] args) throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList(100);
        Scanner input = new Scanner((System.in));
        System.out.println("请输入链式元素个数：");
        int num = input.nextInt();
        for(int i = 0,j = 0; i < num; i++, j++)
        {
            myLinkedList.insert(i, j);
        }
        myLinkedList.display();
        System.out.println("判断链表是否为空"+myLinkedList.isEmpty());
        myLinkedList.remove(4);
        System.out.println("删除链表中的第5个元素之后");
        myLinkedList.display();
        myLinkedList.insert(4,3);
        System.out.println("在第四个位置上加上数字3后：" );
        myLinkedList.display();
        System.out.println("查找元素为3的位置是"+myLinkedList.indexOf(3));
        System.out.println("此时链表的长度："+myLinkedList.length());
        myLinkedList.clear();
        myLinkedList.display();
        System.out.println("置空链表后的长度是"+myLinkedList.length());

    }
}
