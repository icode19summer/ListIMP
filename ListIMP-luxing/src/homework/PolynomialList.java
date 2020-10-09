package homework;

public class PolynomialList {
    private Node head;

    public PolynomialList() {
        head = new Node();
        head.setNext(null);
    }

    public void addNode(Node node) {
        if (head.getNext() == null) {
            head.setNext(node);
            return;
        }

        Node prev = head;
        Node p = head.getNext();
        Node nextNode;
        while (p != null) {
            nextNode = p.getNext();
            //1.判断结点的指数是否相等
            if (node.getExponent() == p.getExponent()) {
                double sumCoefficient = node.getCoefficient() + p.getCoefficient();
                if (sumCoefficient == 0) {
                    prev.setNext(nextNode);
                } else {
                    p.setCoefficient(sumCoefficient);
                }

                break;
            } else {
                //比较指数的大小
                if (node.getExponent() < p.getExponent()) {
                    if (p.getNext() != null) {
                        prev = prev.getNext();
                        p = p.getNext();
                    } else {
                        p.setNext(node);
                        break;
                    }
                } else {//待添加结点的指数小于的情况
                    prev.setNext(node);
                    node.setNext(p);
                    break;
                }
            }
        }
    }

    public PolynomialList addPolynomialList(PolynomialList list) {
        Node prev = head;
        Node p = prev.getNext();
        //指向待添加的元素
        Node q = list.head.getNext();

        while (p != null && q != null) {
            if (p.getExponent() > q.getExponent()) {
                p = p.getNext();
                prev = prev.getNext();
            } else if (p.getExponent() < q.getExponent()) {
                Node newNode = new Node(q.getCoefficient(), q.getExponent(), p);
                prev.setNext(newNode);
                q = q.getNext();
                p = prev.getNext();
            } else {
                double sumCoefficient = p.getCoefficient() + q.getCoefficient();
                if (sumCoefficient == 0) {
                    prev.setNext(p.getNext());
                } else {
                    p.setCoefficient(sumCoefficient);
                    prev = p;
                }
                p = p.getNext();
                q = q.getNext();
            }
        }
        if (q != null) {
            prev.setNext(q);
        }
        return this;
    }

    public PolynomialList subtractionPolynomialList(PolynomialList list) {
        Node p = list.head.getNext();
        while (p != null) {
            p.setCoefficient(-p.getCoefficient());
            p = p.getNext();
        }

        this.addPolynomialList(list);
        return this;
    }

    public double xValue(){
        Node p = head.getNext();
        while (p!=null){
            if (p.getExponent()==1){
                return p.getCoefficient();
            }
            p = p.getNext();
        }
        return 0;
    }

    public void  derivation(){
        Node p = head.getNext();
        while (p!=null){
            if (p.getExponent()>0){
                p.setCoefficient(p.getCoefficient()*p.getExponent());
                p.setExponent(p.getExponent()-1);
            }else {
                p.setCoefficient(0);
            }
            p = p.getNext();
        }
    }

    public void display() {
        Node p = head.getNext();
        while (p != null) {
            if (head.getNext() != p && p.getCoefficient() > 0) {
                System.out.print("+");
            }
            if (p.getExponent() == 0) {
                if (p.getCoefficient()!=0){
                    System.out.print(p.getCoefficient());
                }
            } else {
                if (p.getExponent() > 1) {
                    System.out.print(p.getCoefficient() + "x^" + p.getExponent());
                } else {
                    System.out.print(p.getCoefficient() + "x");
                }

            }
            p = p.getNext();
        }
        System.out.println();
    }
}
