package linear;

public class Node {
	    public Node next;
	    public float coefficient;
	    public float index;
	    public Node(float coefficient,float index){
	        this.coefficient=coefficient;
	        this.index=index;
	    }
		public float getCoefficient() {
			return coefficient;
		}
		public void setCoefficient(float coefficient) {
			this.coefficient = coefficient;
		}
		public float getIndex() {
			return index;
		}
		public void setIndex(float index) {
			this.index = index;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	    
	}

