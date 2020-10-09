package homework;

public class Node {
    //系数
    private double coefficient;
    private int exponent;
    Node next;

    public Node(double coefficient, int exponent, Node next) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = next;
    }

    public Node(double coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Node() {
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

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "coefficient=" + coefficient +
                ", exponent=" + exponent +
                ", next=" + next +
                '}';
    }
}
