public abstract class MyAbstractList<T> implements MyList<T>{
    protected int size;
    protected Object[] element;

    public int getSize() {
        return size;
    }

    public void clear(){
        element=null;
        size=0;
    }

    abstract public boolean isEmpty();

    abstract public T get(int index);

    abstract public void insert(int index ,T x);

    abstract public void remove(int index);

    abstract public int indexOf(T x);

    abstract public void display();
}
