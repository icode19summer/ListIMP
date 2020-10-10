public class test {
    public static void main(String[] args) {
        listArray array = new listArray(10);
//        array.insert(0, 1);
//        array.insert(0, "a");
//        array.insert(0, false);
//        array.insert(0, 1);
//        array.insert(0, 1);
//        array.insert(0, 1);
//        array.insert(0, 1);
//        array.insert(0, 1);
//
//        System.out.println(array.isEmpty());
//        System.out.println(array.length());
//        array.display();
//        array.clear();
//        System.out.println(array.length());


        linkArray<Integer> testLink = new linkArray<>();
        System.out.println(testLink.isEmpty());

        testLink.insert(0, 1);
        testLink.insert(0, 2);
        testLink.insert(0, 3);

        System.out.println(testLink.length());

        System.out.println(testLink.isEmpty());

        testLink.display();
        testLink.remove(1);

        System.out.println(testLink.length());

        System.out.println(testLink.isEmpty());

        testLink.display();


        testLink.clear();
        testLink.display();
    }
}
