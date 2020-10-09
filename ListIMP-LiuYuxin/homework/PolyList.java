package evlic.DataStructure.homework;

public class PolyList{
    private PolyNode head;

    public PolyNode getHead() {
        return head;
    }

    //新建一个 多项式
    public PolyList() {
        head=new PolyNode();
        head.setE((float) 9999999999999999999999.9);
        head.setNextNode(null);
    }

    public void addNode(PolyNode n){

        float c=n.getC();
        float e=n.getE();

        if(c==0){//保证项数不为零 及数据是有效的
            return;
        }

        //如果从头结点开始则直接插入有效数据
        if (head.getNextNode()==null ){
            head.setNextNode(n);
            head.setC(head.getC()+1);
            return;
        }

        PolyNode prior = head;
        PolyNode p = head.getNextNode();

        //中间插入
        while(p.getNextNode()!=null){
            if (e>p.getE()||e<prior.getE()){
                prior.setNextNode(n);
                n.setNextNode(p);
                head.setC(head.getC()+1);
                return;
            }else if(e==p.getE()){
                p.setC(p.getC()+c);
                if (p.getC()==0)
                    head.setC(head.getC()-1);
                return;
            }
            else {//如果e<p.e 则p、prior向后跳
                p=p.getNextNode();
                prior=prior.getNextNode();
            }
        }
        //尾部插入
        if(e==p.getE()) {
            p.setNextNode(n);
            p.setC(p.getC()+c);
            if (p.getC()==0)
                head.setC(head.getC()-1);
        }
        else if (e<p.getE()){
            p.setNextNode(n);
        }
        else{
            prior.setNextNode(n);
            n.setNextNode(p);
        }
    }

    public int length(){
        int index=0;
        PolyNode p =this.head;
        while (p.getNextNode()!=null){
            p=p.getNextNode();
            index++;
        }
        return index;
    }
                        //链表 a，xi
    public void display(int i) {
        System.out.print("x" + i + " = ");

        PolyNode p = this.head.getNextNode();

        if (this.head.getC()==0){
            System.out.print(0);
            return;
        }

        while (p.getNextNode() != null) {
            if (p.getC()==0){}
            else {
                System.out.print(p.getC() + "x");
                System.out.print("^" + p.getE());
                System.out.print(" + ");
            }
            p = p.getNextNode();
        }
        System.out.print(p.getC() + "x");
        System.out.print("^" + p.getE() + "\n");

        System.out.println("这是有" + this.head.getC() + "项的多项式\n");
    }

    //静态内部类 Node
    public static class PolyNode{
        private float c;
        private float e;
        private PolyNode nextNode;

        public PolyNode() {
            this.c=0;
            this.e=0;
            nextNode=null;
        }

        public PolyNode(float c, float e) {
            this.c = c;
            this.e = e;
        }

        //get set
        public float getC() {
            return c;
        }

        public void setC(float c) {
            this.c = c;
        }

        public float getE() {
            return e;
        }

        public void setE(float e) {
            this.e = e;
        }

        public PolyNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(PolyNode nextNode) {
            this.nextNode = nextNode;
        }
    }
}
