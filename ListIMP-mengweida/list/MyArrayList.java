package list;

public class MyArrayList<T> implements IList {
    private T[] eleData; //存储元素的数组
    private int size; //记录当前顺序表中的元素个数

    //    构造方法
    public MyArrayList(int capacity){
        this.eleData = (T[])new Object[capacity]; //初始化数组
        this.size = 0; //初始化长度
    }

    @Override
    public void clear() {
        this.size = 0;
        System.out.println("清空后的线性表元素个数为：" + size);
    }

    @Override
    public boolean isEmpty() {
        if(size == 0) {
            System.out.println("空表");
        } else {
            System.out.println("非空表");
        }
        return size == 0;
    }

    @Override
    public int length() {
        System.out.println("此顺序表的长度为"+ size);
        return size;
    }

    @Override
    public Object get(int i) {
        System.out.println("获取索引" + i + "处的元素为：" + eleData[i]);
        return eleData[i];
    }

    @Override
    public void insert(int i, Object x) {
        if (size == eleData.length){ //扩容2倍
            resize(2 * eleData.length);
        }
        //先把i索引处的元素及其后面的元素向后移动一位
        for (int index = size - 1; index > i; index--){ //size - 1为最后一位元素的索引
            eleData[index] = eleData[index - 1];
        }
        //把t放到i索引处
        eleData[i] = (T) x;
        size++;
    }

    @Override
    public void remove(int i) {
        //记录索引i处的值
        T current = eleData[i];
        //让索引i后面元素向前移动一位
        for (int index = i; index < size - 1; index++){
            eleData[index] = eleData[index + 1];
        }
        //元素个数 - 1
        size--;
        System.out.println("删除的元素是：" + eleData[i]);

        if (size < eleData.length / 4){ //缩容
            resize(eleData.length / 2);
        }
    }

    @Override
    public int indexOf(Object x) {
        for (int i = 0; i < size; i++){
            if (eleData[i].equals(x)){
                System.out.println(x + "的索引为: "+ i);
                return i;
            }
        }
        System.out.println("表中没有该元素");
        return -1;
    }

    @Override
    public void display() {
        for (int i = 0; i < size; i++){
            System.out.print(eleData[i] + " ");
        }
        System.out.println();
    }

    public void resize(int newSize){ //重置数组大小
        //定义临时数组，指向原数组
        T[] temp = eleData;
        //创建新数组
        eleData = (T[]) new Object[newSize];
        //原数组数据拷贝到新数组
        for (int i = 0; i < size; i++){
            eleData[i] = temp[i];
        }
    }
}
