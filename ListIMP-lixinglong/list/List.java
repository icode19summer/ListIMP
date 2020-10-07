public interface List<Item> {
    public void clear();
    public boolean isEmpty();
    public int length();
    public Item get(int i) throws Exception;
    public void insert(int i,Item x) throws Exception;
    public void remove(int i) throws Exception;
    public int indexOf(Item x);
    public void display();
}
