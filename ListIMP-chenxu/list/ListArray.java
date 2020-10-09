import com.sun.deploy.security.SelectableSecurityManager;

public class ListArray<T> implements List<T> {
    private int capacity;
    private int size;
    private Object elements[];

    public ListArray(int capacity){
        this.capacity=capacity;
        size=0;
        elements=new Object[capacity];
    }

    @Override
    public int length(){
        return size;
    }

    @Override
    public  void clear(){
      for(int i=0;i<size;i++){
          elements[i]=null;
      }
      size=0;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public Object get(int i){
        if((i<0)||(i>size-1)){
            System.out.println("位置不合法！");
            return null;
        }
        return (T)elements[i];
    }//读取线性表中第i个数据元素的值

    @Override
    public boolean insert(int i,Object x){
        int j;
        if((i<0||i>size)){
            System.out.println("插入位置不合法！");
            return false;
        }
        if(size==capacity){
            expandSpace();
        }
        for(j=size-1;j>=i;j--){
            elements[j+1]=elements[j];
        }
        elements[i]=x;
        size++;
        return true;
    }//插入操作，其中0<=i<=length()

    public void expandSpace(){
     Object a[]=new Object[elements.length*2];
     for(int i=0;i<size;i++){
         a[i]=elements[i];
     }
     elements=a;
    }

    @Override
    public boolean remove(int i){
        int j;
        if((i<0)||(i>size -1)){
            System.out.println("删除位置不合法");
            return false;
        }
        for(j=i+1;j>=size-1;j++){
            elements[j-1]=elements[j];
        }
        size=size-1;
        return  true;
    }//删除操作，其中0<=i<=length()-1

    @Override
    public int indexOf(Object x){
     int i=0;
     while ((i<size)&&(elements[i]!=x))
         i++;
     if(i==size){
         return (-1);
     }
     else
         return(i);
    }//查找值为x的数据元素操作
    public void display(){
        if(isEmpty()){
            System.out.println("该线性表为空");
        }
        else {
            for(int i=0;i<size;i++){
                System.out.println(elements[i]);
            }
        }
    }
}//输出线性表中各个数据元素值的操作

