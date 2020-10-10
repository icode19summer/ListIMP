public class node {
    private double n;
    private double c_n;
    private node next;


    public Double getN() {
        return n;
    }

    public void setN(Double n) {
        this.n = n;
    }

    public Double getC_n() {
        return c_n;
    }

    public void setC_n(Double c_n) {
        this.c_n = c_n;
    }

    public node getNext() {
        return next;
    }

    public void setNext(node next) {
        this.next = next;
    }


    public node(Double n, Double c_n, node next) {
        this.n = n;
        this.c_n = c_n;
        this.next = next;
    }

    public node(Double n, Double c_n) {
        this(n, c_n, null);
    }

    public node() {
        this(0.0, 0.0, null);
    }

    public void insert(){

    }
}
