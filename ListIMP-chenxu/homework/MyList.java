import java.util.Scanner;

public class MyList {
    private MyNode head;
    public MyList(){
        head=new MyNode();
        head.setNext(null);
    }
    
    public void addNode(MyNode node){
        if(head.getNext()==null){
            head.setNext(node);
            return;
        }
        MyNode priorNode=head;
        MyNode p=head.getNext() ;   //头插法改变节点
        MyNode nextNode;
        while (p!=null){
            nextNode=p.getNext();
            if(node.getExponent()==p.getExponent()){
                double xishu=node.getCoefficient()+p.getCoefficient();
                if(xishu==0.0){
                    priorNode.setNext(nextNode);
                }else{
                    p.setCoefficient(xishu);
                }
                break;
            }else {
                if(node.getExponent()<p.getExponent()){
                    if(p.getNext()!=null) {
                        priorNode = priorNode.getNext();
                        p = p.getNext();
                    }else {
                        p.setNext(node);
                        break;
                    }
                }else{
                    priorNode.setNext(node);
                    node.setNext(p);
                    break;
                }
            }
        }
    }
    public void removeNode(MyNode node){ }

    //相加模块
    public MyList addMyList( MyList list) {
        MyNode priorNode = head;
        MyNode p = priorNode.getNext();
        MyNode q = list.head.getNext();
        MyNode tempNode = null;
        while (p != null && q != null) {
            if (p.getExponent() > q.getExponent()) {
                p = p.getNext();
                priorNode = priorNode.getNext();
            } else if (p.getExponent() < q.getExponent()) {
                MyNode newNode = new MyNode();
                newNode.setCoefficient(q.getCoefficient());
                newNode.setExponent(q.getExponent());
                newNode.setNext(p);
                priorNode.setNext(newNode);
                priorNode = priorNode.getNext();
                q = q.getNext();
            } else {
                double newXishu = p.getCoefficient() + q.getCoefficient();
                if (newXishu == 0) {
                    priorNode.setNext(p.getNext());
                    p = p.getNext();
                    q = q.getNext();
                } else {
                    p.setCoefficient(newXishu);
                    priorNode = p;
                    p = p.getNext();
                    q = q.getNext();
                }
            }
        }
        if (q != null) {
            priorNode.setNext(q);
        }

//若两个多项式完全相消则为0
        try {
            if (head.getNext() == null) {
                head.getNext().setCoefficient(0);
            }
        }
        catch (Exception e)
        {
            System.out.println(0);
        }

        return this;
    }

    public MyList qiudao(){
        MyNode priorNode=head;
        MyNode p=priorNode.getNext();
        while (p!=null){
            if(p.getExponent()==0){
                priorNode.setNext(p.getNext());
                p = p.getNext();
            }
            p.setCoefficient(p.getCoefficient()*p.getExponent());
            p.setExponent(p.getExponent()-1);
            priorNode=priorNode.getNext();
            p=p.getNext();
        }
        return this;
    }


    public void display(){
        MyNode p=head.getNext();
        while (p!=null){
            if(head.getNext()!=p && p.getCoefficient()>0){
                System.out.print("+");
            }
            if(p.getExponent()==0){
                System.out.print(p.getCoefficient());
            }
            else{
                System.out.print(p.getCoefficient()+"x^"+p.getExponent());
            }
            p=p.getNext();
        }
    }
    public static void main(String[] args) {
        MyList x1=new MyList();
        MyList x2=new MyList();
        Scanner scanner=new Scanner(System.in);
        System.out.println("**************多项式相加减测试****************");
//        int length=scanner.nextInt();
//        System.out.println("请输入第一个多项式 :（格式：指数 系数 回车到下一子项)。");
//        for(int i=0;i<length;i++){
//            x1.addNode(new MyNode(scanner.nextInt(),scanner.nextDouble()));
//        }
        x1.addNode(new MyNode(11,-3.1));
        x1.addNode(new MyNode(8,5));
        x1.addNode(new MyNode(1,2));
        System.out.print("x1=");
        x1.display();
        System.out.println();
//        System.out.println("请输入第二个多项式的长度");
//        int length1=scanner.nextInt();
//        System.out.println("请输入第二个多项式 :（格式：指数 系数 回车到下一子项)。");
//        for(int i=0;i<length1;i++){
//            x2.addNode(new MyNode(scanner.nextInt(),scanner.nextDouble()));
//        }
        x2.addNode(new MyNode(9,11));
        x2.addNode(new MyNode(8,-5));
        x2.addNode(new MyNode(0,7));
        System.out.print("x2=");
        x2.display();
        System.out.println();
        System.out.print("x1+x2=");
        x1.addMyList(x2);
        x1.display();
        System.out.println();
        MyList x3=new MyList();
        MyList x4=new MyList();
        System.out.println("**************多项式相加减测试****************");
        x3.addNode(new MyNode(3,1));
        x3.addNode(new MyNode(1,1));
        System.out.print("x3=");
        x3.display();
        System.out.println();
        x4.addNode(new MyNode(3,-1));
        x4.addNode(new MyNode(1,-1));
        System.out.print("x4=");
        x4.display();
        System.out.println();
        System.out.print("x3+x4=");
        x3.addMyList(x4);
        x3.display();
        System.out.println();

        System.out.println("**************多项式求导测试****************");
        MyList qiudaoList=new MyList();
        qiudaoList.addNode(new MyNode(3,1));
        qiudaoList.addNode(new MyNode(2,1));
        qiudaoList.addNode(new MyNode(1,1));
        System.out.print("d(");
        qiudaoList.display();
        System.out.print(")=");
        qiudaoList.qiudao();
        qiudaoList.display();
        System.out.println();
    }
    public static class MyNode<T> {

        private int exponent=-1;   //指数
        private  double coefficient=0;    //系数
        private MyNode next=null;

        public MyNode() {
            this.setNext(null);
        }

        public MyNode(int exponent, double coefficient) {
            this.exponent = exponent;
            this.coefficient=coefficient;
        }

        public double getCoefficient() {
            return coefficient;
        }

        public void setCoefficient(double coefficient) {
            this.coefficient = coefficient;
        }

        public int getExponent() {
            return exponent;
        }

        public void setExponent(int exponent) {
            this.exponent = exponent;
        }

        public void setNext(MyNode<T> next) {
            this.next = next;
        }

        public MyNode<T> getNext() {
            return next;
        }

    }

}
