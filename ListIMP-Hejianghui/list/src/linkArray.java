public class linkArray<T> implements list {


    //链式表的位置从1开始


    private node headArray;
    //头节点


    public linkArray() {

        //初始化链表
        headArray = new node();
    }

    public linkArray(Object data, node next) {

        //初始化链表
        headArray = new node(data, next);
    }

    public linkArray(Object data) {

        //初始化链表
        headArray = new node(data);
    }




    @Override
    public void clear() {
        headArray.setNext(null);
    }

    @Override
    public boolean isEmpty() {
        return headArray.getNext() == null;
    }

    @Override
    public int length() {
        node p = headArray;
        int size = 0;
        while (p.getNext() != null) {
            size++;
            p = p.getNext();
        }
        return size;
    }

    @Override
    public Object get(int i) {
        if (i > length()) {
            System.out.println("error location!!");
            return null;
        } else {
            for (int k = 0; k <= i; k++) {
                headArray = headArray.getNext();
            }
            return headArray.getData();
        }
    }

    @Override
    public void insert(int location, Object value) {


        if (location >= 0 && location <= length()) {
            node newArray = new node();
            newArray.setData(value);

            node change = headArray;
            int locationJudge = 0;
            while (locationJudge < location) {

                change = change.getNext();

                locationJudge++;
            }
            newArray.setNext(change.getNext());
            change.setNext(newArray);
        } else System.out.println("error location ! !");
    }

    @Override
    public void remove(int location) {
        node change = headArray;

        if (location >= 0 && location <= length()) {
            int locationJudge = 0;
            while (locationJudge < location - 1) {
                change = change.getNext();
                locationJudge++;
            }
            change.setNext(change.getNext().getNext());

        } else System.out.println("error location!!");
    }

    @Override
    public int indexOf(Object x) {
        node find = headArray;
        for (int i = 0; i < length(); i++) {
            find = find.getNext();
            if (find.getData() == x) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void display() {
        node find = headArray;
        for (int i = 0; i < length(); i++) {
            find = find.getNext();
            System.out.print(find.getData() + "  ");
        }
    }
}
