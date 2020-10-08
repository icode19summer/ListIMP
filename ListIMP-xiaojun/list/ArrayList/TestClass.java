package ArrayList;


public class TestClass {
    public static void main(String[] args)
    {
        ArrayList myArray = new ArrayList(10);

        for (int i = 0,j = 0; i < 10 ; i++,j++)
        {
            myArray.insertAt(i,j);
        }

        myArray.display();//0 1 2 3 4 5 6 7 8 9

        if(myArray.isEmpty())
        {
            System.out.println("空表");
        }
        else
            System.out.println("非空表");//非空表

        System.out.println("此顺序表的长度为"+myArray.length());//此顺序表的长度为10

        System.out.println(myArray.get(5));//5

        myArray.remove(1);
        myArray.display();//0 2 3 4 5 6 7 8 9

        System.out.println("索引为: "+myArray.indexOf(4));//3

        myArray.clear();

        myArray.display();//空
    }
}
