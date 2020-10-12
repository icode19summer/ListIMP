import java.util.LinkedList;

public class MyArrayList<T> extends MyAbstractList<T> implements MyList<T>{
    public MyArrayList(){
        this.size=0;
        this.element=new Object[0];
    }

    public MyArrayList(int size,Object[] element){
        this.size=size;
        this.element=element;
    }

    @Override
    public T get(int index) {
        return (T) element[index];
    }

    @Override
    public void insert(int index, T x) {
        for (int i=size;i>index;i--){
            element[i]=element[i-1];
        }
        element[index]=x;
        size=size+1;
    }

    @Override
    public void remove(int index) {
        for (int i=index;i<size-1;i++){
            element[i]=element[i+1];
        }
        size=size-1;
    }

    @Override
    public void display() {
        for (int i=0;i<size;i++){
            System.out.println(element[i]);
        }
    }

    @Override
    public int indexOf(T x) {
        for (int i=0;i<size;i++){
            if (element[i]==x){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return element==null;
    }
}
