public interface list {
     void clear();//置空操作
     boolean isEmpty();//判空操作
     int length();//求表长度
     Object get(int i);//读取线性表中第i个数据元素的值
     void insert(int i,Object x);//插入操作，其中0<=i<=length()
     void remove(int i);//删除操作，其中0<=i<=length()-1
     int indexOf(Object x);//查找值为x的数据元素操作
     void display();//输出线性表中各个数据元素值的操作

}
