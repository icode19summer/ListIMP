package ArryList;

public class SequenceList<T> {
	private T[] eles;
	private int N;
	public SequenceList(int capacity) {
		this.eles=(T[])new Object[capacity];
		this.N=0;
	}
	//将线性表置为空表
	public void clear() {
		this.N=0;
	}
	//判断线性表是否为空表
	public boolean isEmpty(){
		return N==0;
	}
	//获取线性表长度
	public int length(){
		return N;
	}
	//获取指定位置的元素
	public T get(int i){
		return eles[i];
	}
	//在i索引处添加t
	public void insert(int i,T t){
		for(int index=N-1;index>i;index--) {
			eles[index]=eles[index-1];
		}
		eles[i]=t;
	}
	//删除i索引处的元素，并返回该元素
	public T remove(int i){
		T current=eles[i];
		for(int index=i;index<N-1;index++) {
			eles[index]=eles[index+1];
		}
		N--;
		return current;
	}
	//查找t元素的位置
	public int indexof(T t){
		for(int i=0;i<N;i++) {
			if (eles[i].equals(t)) {
				return i;
			}
		}
		return -1;
	}

}
