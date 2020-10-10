

public class listArray<T> implements list {
    //顺序表的位置从0开始
    private int size;

    private final int capacity;

    private final Object[] arrayCreate;

    public listArray(int capacity) {
        size = 0;
        this.capacity = capacity;
        arrayCreate = new Object[capacity];
    }

    public int getCapacity() {
        //获得容量
        return capacity;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arrayCreate[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public Object get(int i) {
        if (i >= 0 || i < size) {
            return arrayCreate[i];
        } else {
            System.out.println("error location !!");
            return null;
        }
    }

    @Override
    public void insert(int i, Object x) {
        if (size + 1 <= capacity) {
            //判断数组是否已经容纳满
            if (i >= 0 && i <= size) {
                size++;
                if (i < size) {
                    //所有数据往后移一位
                    if (size - 1 != i) System.arraycopy(arrayCreate, i, arrayCreate, i + 1, size - i - 1);
                    arrayCreate[i] = x;
                }

            } else {
                //位置不符合规范
                System.out.println("error location!!");
            }
        } else System.out.println("The arrayList is full and cannot be added ");
    }


    @Override
    public void remove(int i) {
        if (i > 0 || i < size) {
            System.arraycopy(arrayCreate, i, arrayCreate, i - 1, size - 1 - i);
        } else {
            System.out.println("error location!!");
        }
    }

    @Override
    public int indexOf(Object x) {
        for (int i = 0; i < size; i++) {
            if (arrayCreate[i] == x) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(arrayCreate[i] + "  ");
        }
    }

}