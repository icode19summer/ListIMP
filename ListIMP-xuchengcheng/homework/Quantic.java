

public class Quantic {

    transient Term head;
    transient int size=0;

    public Quantic(){
        head = new Term(0,0,null);
    }


    public Term get(int index){
        Term p=head;
        int i=0;
        while (i<index&&p.next!=null){
            p=p.next;
        }
        return p;
    }

    public void remove(int index){
        get(index-1).next=get(index).next;
        size--;
    }

    public void add(Term x){
        if (head.next==null){
            head.next = x;
            size++;
        }
        else {
            Term p = head.next;
            int i = 1;
            while (p!=null){
                if (x.term>p.term){
                    get(i-1).next = x;
                    x.next = p;
                    size++;
                    return;
                }
                if (x.term == p.term){
                    p.coe+=x.coe;
                    return;
                }
                p = p.next;
                i++;
            }
            if (i == size && size !=1){
                get(size).next = x;
                size++;
            }
//            get(size).next = x;
//            size++;
        }
        removeZero();
    }

    public Quantic derivation(){
        Term p = head;
        while (p!=null){
            p.coe*=p.term;
            p.term--;
            p = p.next;
        }
        return this;
    }

    public void removeZero(){
        Term p = head.next;
        int i = 1;
        while (p.next!=null){
            if (p.coe == 0){
                remove(i);
            }
            i++;
        }
    }

    public void display(){
        head.coe = size;
        Term p = head;
        while (p!=null){
            if (p == head){
                System.out.print(p.coe+" ");
            }
            else if (p.coe == 0){
                p = p.next;
                continue;
            }
            else {
                System.out.print(p.coe+"x^"+p.term+"+");
            }
            p = p.next;
        }
    }


    public static class Term{
        transient float coe;
        transient float term;
        transient Term next;

        public Term(float coe, float term, Term next) {
            this.coe = coe;
            this.term = term;
            this.next = next;
        }
    }


}
