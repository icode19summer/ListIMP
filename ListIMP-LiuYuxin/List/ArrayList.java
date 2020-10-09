package evlic.DataStructure.List;

public class ArrayList<T> implements List<T>{
    private int length;
    private int size;
    private Object elements[];

    public ArrayList(int length) {
        this.length = length;
        elements=new Object[length];
    }

    @Override
    public void clear() {
        while(size!=0){
            elements[size-1]=null;
            size--;
        }
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public T get(int i) {
        if((i<0)||(i>size-1)){
            System.out.println("位置不合法！");
            return null;
        }
        return (T)elements[i];
    }

    @Override
    public void insert(int i, T x) {
        if((i<0)||(i>size)){
            System.out.println("位置不合法！");
            return ;
        }

        if(size == length)
            expandSpace();
        for (int j = size-1; j >= i ; j--) {
            elements[j+1]=elements[j];
        }
        elements[i]=x;
        size++;
    }
    //扩容 每次倍增
    private void expandSpace(){
        Object[] a = new Object[elements.length*2];
        for (int i = 0; i < size; i++)
            a[i]=elements[i];
        elements=a;
    }

    @Override
    public void remove(int i) {
        if((i<0)||(i>size-1)){
            System.out.println("位置不合法！");
            return ;
        }
        for (int k = i; k < size; k++) {
            elements[k]=elements[k+1];
        }
        size--;
    }

    @Override
    public int indexOf(Object x) {
        int index=0;
        while ((index<size)&&(elements[index]!=x))
            index++;
        if (index == size){
            System.out.println("未找到");
            return -1;
        }else
            return index;
    }

    @Override
    public void display() {
        for (int p = 0; p < size; p++) {
            System.out.println(elements[p]);
        }
    }
}