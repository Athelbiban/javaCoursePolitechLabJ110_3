package singlyLinkedList;

public class Main {
    public static void main(String[] args) {
        CustomList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.toString());
    }
}
