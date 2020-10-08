package ArryList;

public class SequenceList<T> {
	private T[] eles;
	private int N;
	public SequenceList(int capacity) {
		this.eles=(T[])new Object[capacity];
		this.N=0;
	}
	//�����Ա���Ϊ�ձ�
	public void clear() {
		this.N=0;
	}
	//�ж����Ա��Ƿ�Ϊ�ձ�
	public boolean isEmpty(){
		return N==0;
	}
	//��ȡ���Ա���
	public int length(){
		return N;
	}
	//��ȡָ��λ�õ�Ԫ��
	public T get(int i){
		return eles[i];
	}
	//��i���������t
	public void insert(int i,T t){
		for(int index=N-1;index>i;index--) {
			eles[index]=eles[index-1];
		}
		eles[i]=t;
	}
	//ɾ��i��������Ԫ�أ������ظ�Ԫ��
	public T remove(int i){
		T current=eles[i];
		for(int index=i;index<N-1;index++) {
			eles[index]=eles[index+1];
		}
		N--;
		return current;
	}
	//����tԪ�ص�λ��
	public int indexof(T t){
		for(int i=0;i<N;i++) {
			if (eles[i].equals(t)) {
				return i;
			}
		}
		return -1;
	}

}
