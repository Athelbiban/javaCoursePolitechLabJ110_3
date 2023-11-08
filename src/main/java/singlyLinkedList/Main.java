package singlyLinkedList;

public class Main {
    public static void main(String[] args) {
        CustomList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        CustomList list1 = new SinglyLinkedList();

        list.print();
        list1.print();
        System.out.println();

        System.out.println(list.listEmpty());
        System.out.println(list1.listEmpty());
    }
}
