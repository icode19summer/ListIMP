package LinkedList;
import ArryList.SequenceList;
public class sequenceListTest {
	public static void main(String[]args) {
		//创建顺序表对象
		SequenceList<String>sl=new SequenceList<>(10);
		//测试插入
		sl.insert(0,"张三");
		sl.insert(1,"牛二");
		sl.insert(2,"赵六");
		sl.insert(3,"王五");
		sl.insert(4,"李四");
		//测试获取
		String getResult=sl.get(1);
		System.out.println("获取索引i处的结果是："+getResult);
		//测试删除
		String removeResult=sl.remove(0);
		System.out.println("删除的元素是："+removeResult);
		//测试清空
		sl.clear();
		System.out.println("清空后的线性表中的元素个数为："+sl.length());
	}

}
