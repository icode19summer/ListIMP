package ArrayList;

import IList.IList;

//Object是所有类的父类，所以也可以理解为一个泛型
public class ArrayList implements IList {
    private Object[] elements;//线性表存储空间
    private int size;//线性表的当前长度
    private int capacity;//数组容量大小
    public ArrayList(int capacity){
        this.capacity = capacity;
        size = 0;
        elements = new Object[capacity];
    }
   @Override
    public void clear(){
       size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int length(){
        return size;
    }
    public Object get(int i){
        if(size != 0)
        {
            if(i < 0 || i > size - 1)
            {
                System.out.println("位置不合法！");//快捷键sout+Enter
                return null;
            }
        }
        return elements[i];
    }
    public void insertAt(int i, Object x){
       if(size != 0)
       {
           if((i < 0) || (i > size ))
           {
               System.out.println("输入位置不合法！");
               return;
           }
       }
        if(size == capacity)
        {
            System.out.println("线性表存储空间已满");
        }
        for(int j = size-1;j >= i; j--)
        {
            elements[j+1] = elements[j];
        }
        elements[i] = x;
        size++;
    }
//    public void expandSpace(){
//       Object[] a = new Object[elements.length*2];
//       for(){
//
//       }
//    }
    public void remove(int i){
        if(i < 0 || i > size) {
            System.out.println("移除位置非法！");
            return;
        }
        for(int j = i; j < size-1; j++)
        {
            elements[j] = elements[j+1];
        }
        size--;
        return;
    }
    public int indexOf(Object x){
        for(int i = 0 ; i < size;i++)
        {
            if(elements[i].equals(x))
            {
                return i;
            }
        }
        return -1;//不存在
    }
    public void display(){
        for(int i = 0 ; i < size ; i++)
        {
            System.out.print(elements[i]+" ");
        }
        System.out.println();
    }
}
