package experments_01;
public interface List<T> {
    public void clear();//置空操作
    public boolean isEmpty();//判空操作
    public int length();//求表长度
    public Object get(int i) throws Exception;//读取线性表中第i个数据元素的值
    public void insert(int i,Object x) throws Exception;//插入操作，其中0<=i<=length()
    public void remove(int i) throws Exception;//删除操作，其中0<=i<=length()-1
    public int indexOf(Object x);//查找值为x的数据元素操作
    public void display();//输出线性表中各个数据元素值的操作
}
