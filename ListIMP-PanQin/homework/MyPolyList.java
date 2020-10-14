package homework;

public class MyPolyList {
    private int length;
    Pnode head;

    public class Pnode {
        public float coef;
        public int expo;
        public Pnode next;

        public Pnode getNext() {
            return next;
        }

        public void setNext(Pnode next) {
            this.next = next;
        }

        public int getExpo() {
            return expo;
        }

        public void setExpo(int expo) {
            this.expo = expo;
        }

        public float getCoef() {
            return coef;
        }

        public void setCoef(float coef) {
            this.coef = coef;
        }

        public Pnode(float coef, int expo, Pnode next) {
            this.expo = expo;
            this.coef = coef;
            this.next = next;
        }
    }

    public MyPolyList(int length) {
        head = null;
        this.length = length;
    }

    public MyPolyList() {
        head = null;
        length = 0;
    }

    //获取链表的长度
    public int size() {
        Pnode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    //向链表中插入系数和指数
    public void insert(float coef, int expo) {
        Pnode p = head, s;
        s = new Pnode(coef, expo, null);
        if (head == null) {
            head = s;
            s.next = null;
        } else {
            while (p.next != null) {
                p = p.next;
            }
            p.next = s;
            s.next = null;
        }
    }

    //向链表中插入系数
    public void insert(float coef) {
        Pnode p = head, s;
        s = new Pnode(coef, 0, null);
        if (head == null) {
            head = s;
            s.next = null;
        } else {
            while (p.next != null) {
                p = p.next;
            }
            p.next = s;
            s.next = null;
        }
    }

    //对多项式进行降序排列
    public void sort() {
        Pnode p, q;
        int i, j, m;
        float n;
        for (i = 0, p = head; i < this.size() - 1; i++, p = p.next)
            for (j = i + 1, q = p.next; j < this.size(); j++, q = q.next)
                if (p.expo < q.expo) {
                    m = p.expo;
                    p.expo = q.expo;
                    q.expo = m;
                    n = p.coef;
                    p.coef = q.coef;
                    q.coef = n;
                }
    }

    //对多项式进行合并同类项
    public void union() {
        Pnode p, q, r;
        sort();
        p = head;
        q = p.next;
        while (p != null && q != null) {
            if (p.expo == q.expo) {
                r = q;
                p.coef = p.coef + q.coef;
                remove(q.coef, q.expo);
                p = r;
                q = r.next;
            } else {
                p = q;
                q = q.next;
            }
        }
    }

    //删除链表当中的某一个节点
    public void remove(float coef, int expo) {
        Pnode p = head, q = p;
        for (q = p; q != null; q = q.next)
            if (q.next.coef == coef && q.next.expo == expo) {
                break;
            }
        q.next = q.next.next;
    }

    //将链表转化为一个字符串输出
    public String toString() {
        String s = "";
        Pnode p = head;
        sort();
        union();
        while (p != null) {
            if (p.coef == 0) {
                s = s + "+";
            } else if (p.expo == 0) {
                s = s + p.coef + "+";
            } else if (p.expo == 1) {
                s = s + p.coef + "x" + "+";
            } else {
                s = s + p.coef + "x^" + p.expo + "+";
            }
            p = p.next;
        }
        return s.substring(0, s.length() - 1);
    }

    //加法
    public void addPol(MyPolyList p2) {
        this.sort();
        p2.sort();
        Pnode p = this.head, q = p2.head;
        while (p != null || q != null) {
            if (p != null && q != null) {
                if (p.expo == q.expo) {
                    p.coef += q.coef;
                    p = p.next;
                    q = q.next;
                } else if (p.expo < q.expo) {
                    this.insert(q.coef, q.expo);
                    q = q.next;
                } else {
                    this.insert(q.coef, q.expo);
                    q = q.next;
                }
            } else if (p == null && q != null) {
                this.insert(q.coef, q.expo);
            } else if (p != null && q == null) {
                p = p.next;
            }
        }
    }

    //减法
    public MyPolyList subPol(MyPolyList p3) {
        this.sort();
        p3.sort();
        Pnode p = this.head;
        while (p != null) {
            p.setCoef(-p.getCoef());
            p = p.next;
        }
        this.addPol(p3);
        return this;
    }

    //求导
    public MyPolyList derPol() {
        Pnode p = head;
        while (p != null) {
            if (p.getExpo() > 0) {
                p.setCoef(p.getCoef() * p.getExpo());
                p.setExpo(p.getExpo() - 1);
            } else {
                p.setCoef(0);
            }
            p = p.getNext();
        }
        return this;
    }

    //x的系数
    public double xCoef() {
        Pnode p = head.getNext();
        while (p != null) {
            if (p.getExpo() == 1) {
                return p.getCoef();
            }
            p = p.getNext();
        }
        return 0;
    }
}
