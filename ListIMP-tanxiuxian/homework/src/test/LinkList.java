package test;
import java.util.Scanner;
import static java.lang.System.out;
import linear.Node;
public class LinkList {
	 private static Node headA;
	    private static Node headB;
	    private static Node headC;
	    static LinkList linkList = new LinkList();

	    public static void main(String[] args) {
	        String Str;
	        Scanner scanner = new Scanner(System.in);
	        out.println("请输入第一个多项式，输入格式：系数（空格）指数 输入0 0结束");
	        while (true) {
	            Str = scanner.nextLine();
	            String[] s1 = Str.split(" ");
	            float a = Float.parseFloat(s1[0]);
	            float b = Float.parseFloat(s1[1]);
	            if (a == 0 && b == 0) {
	                break;
	            }
	            linkList.addA(a, b);
	        }
	        out.println("请输入第二个多项式，输入格式：系数（空格）指数 输入0 0结束");
	        while (true) {
	            Str = scanner.nextLine();
	            String[] s2 = Str.split(" ");
	            float c = Float.parseFloat(s2[0]);
	            float d = Float.parseFloat(s2[1]);
	            if (c == 0 && d == 0) {
	                break;
	            }
	            linkList.addB(c, d);
	        }
	        out.println("请选择运算方式");
	        out.println("1. +");
	        out.println("2. -");
	        int choose = scanner.nextInt();
	        switch (choose) {
	            case 1:
	                out.print("第一个多项式为：");
	                linkList.show(headA);
	                linkList.sort(headA);
	                linkList.eliminate(headA);
	                out.println();
	                out.print("第二个多项式为：");
	                linkList.show(headB);
	                linkList.sort(headB);
	                linkList.eliminate(headB);
	                out.println();
	                out.print("相加后多项式为：");
	                linkList.addition();
	                if (headA != null && headB != null)
	                    linkList.show(headC);
	                break;
	            case 2:
	                out.print("第一个多项式为：");
	                linkList.show(headA);
	                linkList.sort(headA);
	                linkList.eliminate(headA);
	                out.println();
	                out.print("第二个多项式为：");
	                linkList.show(headB);
	                linkList.sort(headB);
	                linkList.negative();
	                linkList.eliminate(headB);
	                out.println();
	                out.print("相减后多项式为：");
	                linkList.addition();
	                if (headA != null && headB != null)
	                    linkList.show(headC);
	                break;
	        }
	    }

	    private void addA(float dataA, float dataa) {
	        Node tNode = new Node(dataA, dataa);
	        if (headA == null) {
	            headA = tNode;
	            return;
	        }
	        Node temp = headA;
	        while (temp.next != null) {
	            temp = temp.next;
	        }
	        temp.next = tNode;
	    }

	    private void addB(float dataB, float datab) {
	        Node tNode = new Node(dataB, datab);
	        if (headB == null) {
	            headB = tNode;
	            return;
	        }
	        Node temp = headB;
	        while (temp.next != null) {
	            temp = temp.next;
	        }
	        temp.next = tNode;
	    }

	    private void addC(float dataC, float datac) {
	        Node tNode = new Node(dataC, datac);
	        if (headC == null) {
	            headC = tNode;
	            return;
	        }
	        Node temp = headC;
	        while (temp.next != null) {
	            temp = temp.next;
	        }
	        temp.next = tNode;
	    }

	    private void show(Node head) {
	        if (head == null) {
	            out.print(0 + " ");
	            return;
	        }
	        Node temp = head;
	        if (temp.coefficient == 0) {
	        } else {
	            if (temp.index == 0) {
	                out.print(temp.coefficient + " ");
	            } else {
	                if (temp.index == 1 && temp.coefficient != 1 && temp.coefficient != -1) {
	                    out.print(temp.coefficient + "X" + " ");
	                } else {
	                    if (temp.coefficient == 1 && temp.index != 1) {
	                        out.print("X^" + temp.index + " ");
	                    } else {
	                        if (temp.coefficient == -1 && temp.index != 1) {
	                            out.print("-X^" + temp.index + " ");
	                        } else {
	                            if (temp.coefficient == 1 && temp.index == 1) {
	                                out.print("X" + " ");
	                            } else {
	                                if (temp.coefficient == -1 && temp.index == 1) {
	                                    out.print("-X" + " ");
	                                } else {
	                                    System.out.print(temp.coefficient + "X^" + temp.index + " ");
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        while (temp.next != null) {
	            if (temp.next.coefficient == 0) {
	            } else {
	                if (temp.next.coefficient > 0) {
	                    System.out.print("+");
	                }
	            }
	            if (temp.next.coefficient == 0) {
	            } else {
	                if (temp.next.index == 0) {
	                    out.print(temp.next.coefficient + " ");
	                } else {
	                    if (temp.next.index == 1 && temp.next.coefficient != 1 && temp.next.coefficient != -1) {
	                        out.print(temp.next.coefficient + "X" + " ");
	                    } else {
	                        if (temp.next.coefficient == 1 && temp.next.index != 1) {
	                            out.print("X^" + temp.next.index + " ");
	                        } else {
	                            if (temp.next.coefficient == -1 && temp.next.index != 1) {
	                                out.print("-X^" + temp.next.index + " ");
	                            } else {
	                                if (temp.next.coefficient == 1 && temp.next.index == 1) {
	                                    out.print("X" + " ");
	                                } else {
	                                    if (temp.next.coefficient == -1 && temp.next.index == 1) {
	                                        out.print("-X" + " ");
	                                    } else {
	                                        System.out.print(temp.next.coefficient + "X^" + temp.next.index + " ");
	                                    }
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	            temp = temp.next;
	        }
	    }

	    private void eliminate(Node head) {
	        Node temp = head;
	        while (temp != null) {
	            Node tNode = head;
	            while (tNode.next != temp && tNode.next != null) {
	                if (tNode.next.index == temp.index) {
	                    temp.coefficient = tNode.next.coefficient + temp.coefficient;
	                    tNode.next = tNode.next.next;
	                } else {
	                    tNode = tNode.next;
	                }
	            }
	            temp = temp.next;
	        }
	    }

	    private void sort(Node head) {
	        Node temp = head;
	        while (temp != null) {
	            Node tNode = temp.next;
	            while (tNode != null) {
	                if (temp.index > tNode.index) {
	                    float da = tNode.index;
	                    float dA = tNode.coefficient;
	                    tNode.index = temp.index;
	                    tNode.coefficient = temp.coefficient;
	                    temp.index = da;
	                    temp.coefficient = dA;
	                }
	                tNode = tNode.next;
	            }
	            temp = temp.next;
	        }
	    }

	    private void negative() {
	        if (headB == null) return;
	        Node temp = headB;
	        temp.coefficient = 0 - temp.coefficient;
	        while (temp.next != null) {
	            temp.next.coefficient = 0 - temp.next.coefficient;
	            temp = temp.next;
	        }
	    }
	//加法以及减法运算的方法
	    private void addition() {
	        int i = 0, j = 0;
	        Node tempA = headA;
	        Node tempB = headB;
	        if (headA != null && headB == null) {
	            show(headA);
	            return;
	        }
	        if (headB != null && headA == null) {
	            show(headB);
	            return;
	        }
	        while (tempA.next != null && tempB.next != null || tempA.next == null && tempB.next == null && i == 0 && j == 0 || i == 1 || j == 1 || tempA.next == null && tempB.next != null || tempA.next != null && tempB.next == null) {
	            if (tempA.index == tempB.index && i == 0 && j == 0) {
	                if (tempA.coefficient + tempB.coefficient == 0 && i == 0 && j == 0) {
	                    if (tempA.next != null) tempA = tempA.next;
	                    else i = 1;
	                    if (tempB.next != null) tempB = tempB.next;
	                    else j = 1;
	                    if (i == 1 && j == 1) {
	                        i = 2;
	                        j = 2;
	                    }
	                } else {
	                    float a = tempA.coefficient + tempB.coefficient;
	                    linkList.addC(a, tempA.index);
	                    if (tempA.next != null) tempA = tempA.next;
	                    else i = 1;
	                    if (tempB.next != null) tempB = tempB.next;
	                    else j = 1;
	                    if (i == 1 && j == 1) {
	                        i = 2;
	                        j = 2;
	                    }
	                }
	            } else {
	                if (i == 1) {
	                    linkList.addC(tempB.coefficient, tempB.index);
	                    while (tempB.next != null) {
	                        if (tempB.next != null) tempB = tempB.next;
	                        linkList.addC(tempB.coefficient, tempB.index);
	                    }
	                    i = 2;
	                }
	                if (j == 1) {
	                    linkList.addC(tempA.coefficient, tempA.index);
	                    while (tempA.next != null){
	                        if (tempA.next != null) tempA = tempA.next;
	                        linkList.addC(tempA.coefficient, tempA.index);
	                    }
	                    j = 2;
	                } else {
	                    if (tempA.index < tempB.index && i == 0 && j == 0) {
	                        linkList.addC(tempA.coefficient, tempA.index);
	                        if (tempA.next != null) tempA = tempA.next;
	                        else i = 1;
	                    }
	                    if (tempA.index > tempB.index && i == 0 && j == 0) {
	                        linkList.addC(tempB.coefficient, tempB.index);
	                        if (tempB.next != null) tempB = tempB.next;
	                        else j = 1;
	                    }
	                }
	            }
	        }
	    }
	    
}
