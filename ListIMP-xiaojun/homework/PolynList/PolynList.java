package PolynList;

import LinkedList.LinkList;
import LinkedList.Node;
import PolynNode.PolynNode;

import java.util.Scanner;

//多项式链表
public class PolynList extends LinkList {
    //创建多项式有序链表
    public PolynList(int n) throws Exception{
        head.data = new PolynNode(0,-1);//初始化头节点
        Scanner sc = new Scanner(System.in);
        for (int i = 1 ; i <= n; i++)
        {
            double coef = sc.nextDouble();//系数值
            int expn = sc.nextInt();//指数值
            insert(new PolynNode(coef,expn));
        }
    }
    //按指数递增顺序插入到多项式有序链表
    public void insert(PolynNode e) throws  Exception{
        int j = 0;
        while (j < length())//与有序链表中的已有项进行指数比较
        {
           PolynNode t = (PolynNode)get(j);
           if( e.expn < t.expn)
           {
               break;
           }
           j++;
        }
        insertAt(j, e);   //调用父类的插入函数
    }
    //判定函数，比较多项式中两项的指数，按a的指数值小于，等于和大于b的指数值，分别返回 -1 0 和 +1
    public int cmp(PolynNode a, PolynNode b)
    {
        if(a.expn > b.expn)
        {
            return 1;
        }
        else if(a.expn == b.expn)
        {
            return 0;
        }
        else
            return -1;
    }
    //多项式加法：Pa = Pa + Pb,利用两个多项式的结点构成"和多项式",并返回LA
    public PolynList addPolyn(PolynList LA,PolynList LB)
    {
        Node ha = LA.head; //ha指向新形成的链表的尾部
        Node qa = LA.head.next;   //qa指向LA需要计算的当前项
        Node qb = LB.head.next;   //qb指向LB需要计算的当前项
        while (qa != null && qb != null)
        {
            PolynNode a = (PolynNode) qa.data;
            PolynNode b = (PolynNode) qb.data;
            switch (cmp(a,b)){
                case -1://a < b
                    ha.next = qa;
                    ha = qa;
                    qa = qa.next;
                    break;
                case 0://a = b
                    double sum = a.coef + b .coef;
                    if(sum != 0.0)
                    {
                        a.coef = sum;
                        ha.next = qa;
                        ha = qa;
                        qa = qa.next;
                        qb = qb.next;
                    }
                    else
                    {
                        qa = qa.next;
                        qb = qb.next;
                    }
                    break;
                case 1://b < a
                    ha.next = qb;
                    ha = qb ;
                    qb = qb.next;
                    break;
            }

        }
        ha.next = (qa != null ? qa : qb); //插入剩余结点
        return LA;
    }
    //重载父类 display()方法
    public void display(){
        for (int i = 0 ; i < length(); i++)
        {
            try {
                PolynNode e = (PolynNode) get(i);
                System.out.println("系数为: "+e.coef+",指数为: "+e.expn);
            }
            catch (Exception e)
            {
                e.printStackTrace();//在命令行打印异常信息在程序中出错的位置及原因。
            }
        }
    }
}
