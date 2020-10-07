public class ArrayList<Item> implements  List<Item> {
    private Item[] array;
    private int length;
    public ArrayList(){
        array=(Item[]) new Object[4];
        length=0;
    }
    public void clear(){
        for(int i=0;i<length;i++)
            array[i]=null;
        length=0;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public int length(){
        return length;
    }
    public Item get(int i) throws Exception{
        if(i<0||i>=length)
            throw new Exception("i overflow.");
        return array[i];

    }
    public void set(int i,Item item) throws Exception{
        if(i<0||i>=length)
            throw new Exception("i overflow.");
        array[i]=item;
    }
    public void insert(int i,Item x) throws Exception{
        if(this.isEmpty()&&i==0) {
            array[0] = x;
            length++;
            return;
        }

        if(i<0||i>=length)
            throw new Exception("i overflow.");
        for(int j=length;j>i;j--)
            array[j]=array[j-1];
        array[i]=x;
        length++;
        if(length==array.length/2)
            resize(array.length*2);
    }
    public void add(Item x){
        array[length++]=x;
        if(length==array.length/2)
            resize(array.length*2);
    }
    public void remove(int i) throws Exception{
        if(i<0||i>=length)
            throw new Exception("i overflow.");
        while(i<length) {
            array[i] = array[i + 1];
            i++;
        }
        array[length]=null;
        length--;
        if(length==array.length/4)
            resize(array.length/2);
    }
    public int indexOf(Item x){
        for(int i=0;i<length;i++){
            if(array[i].equals(x))
                return i;
        }
        return -1;
    }
    public void display(){
        for(int i=0;i<length;i++)
            System.out.print(array[i]+" ");
        System.out.println();
    }
    private void resize(int capacity){
        Item[] temp=(Item[]) new Object[capacity];
        for(int i=0;i<length;i++)
            temp[i]=array[i];
        array=temp;
    }
}
