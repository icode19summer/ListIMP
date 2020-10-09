package experments_01;

import java.util.Scanner;

class MyArrayList<T> implements List<T> {
        private int capacity;//数组容量大小
        private int size; //数组元素的个数
        private Object elements[]; //元素数组

    public MyArrayList() {
//		this.capacity = capacity;
//		size = 0;
//		elements = new Object[capacity];
    }

    public MyArrayList(int initialCapacity) {
        super();
        if (initialCapacity < 0)    //判断如果自定义大小的容量小于0，则报下面这个非法数据异常
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        this.elements = new Object[initialCapacity]; //将自定义的容量大小当成初始化elementData的大小

    }


    @Override
        public void clear() {
            for (int i = 0; i < size; i++)
                elements[i] = null;
            size = 0;

        }


        @Override
        public boolean isEmpty() {
            if (size == 0) {
                return true;
            }
            return false;
        }

        @Override
        public int length() {
            return size;
        }

        @Override
        public T get(int i) throws Exception {
            if (i < 0 || i > size - 1)
                throw new Exception("位置不合法");

            return (T) elements[i]; // 返回顺序表中第i个数据元素
        }

        @Override
        public void insert(int i, Object x) {
            if (size == elements.length) // 判断顺序表是否已满
              System.out.println("顺序表已满");

            if (i < 0 || i > size)
               System.out.println("插入位置不合理");

            for (int j = size; j > i; j--) {
                elements[j] = elements[j - 1];// 插入位置及之后的元素后移
            }

            elements[i] = x; // 插入x
            size++;// 表长度增1
        }

        @Override
        public void remove(int i) throws Exception {
            if (i < 0 || i > size - 1)
                throw new Exception("插入位置不合理");
            for (int j = i; j < size - 1; j++) {
                elements[j] = elements[j + 1];
            }
            size--;
        }

        @Override
        public int indexOf(Object x) {
            int j = 0;// j为计数器
            while (j < size && !elements[j].equals(x)) {
                // 从顺序表中的首结点开始查找，直到elements[j]指向元素x或到达顺序表的表尾
                j++;
            }

                if (j < size)// 判断j的位置是否位于表中
                    return j; // 返回x元素在顺序表中的位置
                else
                    return -1;// x元素不在顺序表中
        }

        @Override
        public void display() {
            for (int j = 0; j < size; j++)
                System.out.print(elements[j] + " ");

        }



    }
    