package LinkedList;
import ArryList.SequenceList;
public class sequenceListTest {
	public static void main(String[]args) {
		//����˳������
		SequenceList<String>sl=new SequenceList<>(10);
		//���Բ���
		sl.insert(0,"����");
		sl.insert(1,"ţ��");
		sl.insert(2,"����");
		sl.insert(3,"����");
		sl.insert(4,"����");
		//���Ի�ȡ
		String getResult=sl.get(1);
		System.out.println("��ȡ����i���Ľ���ǣ�"+getResult);
		//����ɾ��
		String removeResult=sl.remove(0);
		System.out.println("ɾ����Ԫ���ǣ�"+removeResult);
		//�������
		sl.clear();
		System.out.println("��պ�����Ա��е�Ԫ�ظ���Ϊ��"+sl.length());
	}

}
