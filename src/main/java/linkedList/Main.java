package linkedList;

public class Main {
    public static void main(String[] args) {

//        CustomList list = new SinglyLinkedList();
//        CustomList list1 = new SinglyLinkedList();
//        list.add(2);
//        list.add(4);
//        list.add(6);
//        list.add(8);
//
//        list.print(); // вывод на печать заполненной коллекции
//        list1.print(); // вывод на печать пустой коллекции
//        System.out.println();
//
//        Command command1 = () -> System.out.println(list1.listEmpty());
//        SinglyLinkedList.callCommand(command1);
//
//        Command command2 = () -> System.out.println(list.getFirst());
//        SinglyLinkedList.callCommand(command2);
//
//        Command command3 = () -> ((SinglyLinkedList) list).incrementAll(2);
//        SinglyLinkedList.callCommand(command3);
//        list.print();
//        SinglyLinkedList.callCommand(command3);
//        list.print();

        CustomList doublyList = new DoublyLinkedList();
        doublyList.add(1);
        doublyList.add(3);
        doublyList.add(5);
        doublyList.add(7);

        doublyList.print();
        doublyList.insert(2);
        doublyList.print();
        doublyList.insert(4);
        doublyList.print();
        doublyList.remove(1);
        doublyList.print();
    }
}
