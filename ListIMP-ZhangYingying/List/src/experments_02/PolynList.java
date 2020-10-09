package experments_02;

import experments_01.MyLinkedList;
import experments_01.Node;

import java.util.Scanner;


public class PolynList extends MyLinkedList {

    public PolynList(int n) throws Exception {
        super(n);
        head.data = new PolynNode(0,-1);
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= n;i++){
            double coef = sc.nextDouble();
            int expn = sc.nextInt();
            insert(new PolynNode(coef,expn));
    }
}

    private void insert(PolynNode e) throws Exception {
        int j = 0;
        while(j < length()){
            PolynNode t = (PolynNode)get(j);
            if (t.expn>e.expn)
                break;
                j++;
        }
        insert(j,e);
    }
    public int cmp(PolynNode a,PolynNode b){
        if(a.expn<b.expn)
            return -1;
        else if (a.expn == b.expn)
            return  0;
        else
            return 1;
    }

    public PolynList addPolyn(PolynList LA,PolynList LB){//加法
        Node ha = LA.head;
        Node qa = LA.head.next;
        Node qb = LB.head.next;
        while(qa != null && qb != null){
            PolynNode a = (PolynNode)qa.data;
            PolynNode b = (PolynNode)qb.data;
            switch (cmp(a,b)){
                case -1:
                    ha.next = qa;
                    ha = qa;
                    qa = qa.next;
                    break;
                case 0:
                    double sum = a.coef + b.coef;
                    if(sum != 0.0){
                        a.coef = sum;
                        ha.next = qa;
                        ha = qa;
                        qa = qa.next;
                        qb = qb.next;

                    }
                    else {
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
        ha.next = (qa != null ? qa:qb);
        return LA;
    }
    public PolynList SubPolyn(PolynList LA,PolynList LB){//减法
        Node ha = LA.head;
        Node qa = LA.head.next;
        Node qb = LB.head.next;
        while(qa != null && qb != null){
            PolynNode a = (PolynNode)qa.data;
            PolynNode b = (PolynNode)qb.data;
            switch (cmp(a,b)){
                case -1:
                    ha.next = qa;
                    ha = qa;
                    qa = qa.next;
//                    ((PolynNode) qb.data).coef = -((PolynNode) qb.data).coef;
                    break;
                case 0:
                    double sum = a.coef - b.coef;

                    if(sum != 0.0){
                        a.coef = sum;
                        ha.next = qa;
                        ha = qa;
                        qa = qa.next;
                        qb = qb.next;

                    }

                    else {
                        qa = qa.next;
                        qb = qb.next;
                    }
                    break;
                case 1:
                    ha.next = qb;
                    ha = qb;
                    qb = qb.next;
                    ((PolynNode) qb.data).coef = -((PolynNode) qb.data).coef;
                    break;
            }

        }
        ha.next = (qa != null ? qa:qb);
        return LA;
    }
    public double Evaluation(PolynList LA,int x){//求x代入的值

        Node ha = LA.head;
        Node qa = LA.head.next;
        double sum = 0;
        for(int i = 0;i < LA.length();i++){
            PolynNode a = (PolynNode)qa.data;
             sum +=a.coef * Math.pow(x,a.expn);
             qa = qa.next;
        }
        return sum;
    }
    public  void Derivative(PolynList LA){
        Node ha = LA.head;
        Node qa = LA.head.next;
        for(int i = 0;i < LA.length();i++){
            PolynNode b = (PolynNode)qa.data;
            b.coef = b.coef *b.expn;
            b.expn = b.expn - 1;
            qa = qa.next;
        }

    }
    public void display(){
        for(int i = 0; i < length();i++){
            try{
                PolynNode e = (PolynNode)get(i);
                System.out.println("系数为："+e.coef+"指数为："+e.expn);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

