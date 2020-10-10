public class node {

    private node next;

    public node getNext() {
        return next;
    }

    public void setNext(node next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;


    public node() {
        this(null, null);
    }

    public node(Object data, node next) {
        this.data = data;
        this.next = next;
    }

    public node(Object data) {
        this(data, null);
    }
}
