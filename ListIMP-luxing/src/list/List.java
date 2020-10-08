package list;

public interface List<E> {
	static final int ELEMENT_NOT_FOUND = -1;
	/**
	 * 清除所有元素
	 */
	void clear();

	/**
	 * 元素的数量
	 * @return
	 */
	int length();

	/**
	 * 是否为空
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 添加元素到尾部
	 * @param element
	 */
	void insert(E element);

	/**
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	E get(int index);

	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	void insert(int index, E element);

	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	E remove(int index);

	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	int indexOf(E element);

	/**
	 * 输出线性表中各个数据元素值的操作
	 */
	void display();
}
