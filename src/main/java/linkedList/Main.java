package linkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

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

        CustomList doublyListEmpty = new DoublyLinkedList();
        CustomList doublyList1 = new DoublyLinkedList(), doublyList2 = new DoublyLinkedList();
        doublyList1.add(1);
        doublyList1.add(3);
        doublyList1.add(5);
        doublyList1.add(3);
        doublyList1.add(7);
        doublyList1.add(3);
        doublyList2.add(6);
        doublyList2.add(4);
        doublyList2.add(2);

//        doublyList1.print();
//        doublyList2.print();
//        System.out.println();

        Integer[] intArr = new Integer[4];
        intArr[0] = 0;
        intArr[1] = 2;
        intArr[2] = 4;
        intArr[3] = 6;

//        System.out.println(Arrays.toString(intArr));

        LinkedList<Integer> intList = new LinkedList<>();
        ArrayList<Integer> intArrList = new ArrayList<>();
        intArrList.add(11);
        intArrList.add(12);
        intArrList.add(13);
        intList.add(21);
        intList.add(22);
        intList.add(23);
//        System.out.println(intList);

//        doublyList1.print();
//        Command command4 = () -> ((DoublyLinkedList) doublyList1).incrementReverseOrder( 10);
//        DoublyLinkedList.callCommand(command4);
//        doublyList1.print();

        CustomList expandedLinkedList1 = new ExpandedLinkedList();
//        expandedLinkedList1.print();
//        expandedLinkedList1.add(4);
//        expandedLinkedList1.add(1);
//        expandedLinkedList1.add(2);
//        expandedLinkedList1.add(3);
//        expandedLinkedList1.add(4);
//        expandedLinkedList1.add(5);
//        expandedLinkedList1.add(6);
//        expandedLinkedList1.add(7);
//        expandedLinkedList1.add(8);
//        expandedLinkedList1.add(4);

//        expandedLinkedList1.add(0);
//        expandedLinkedList1.add(1);
//        expandedLinkedList1.add(2);
//        expandedLinkedList1.add(3);
//        expandedLinkedList1.add(4);
//        expandedLinkedList1.add(5);
//        expandedLinkedList1.add(6);
//        expandedLinkedList1.add(7);
//        expandedLinkedList1.add(8);
        expandedLinkedList1.add(9);
//        expandedLinkedList1.add(0);
//        expandedLinkedList1.add(1);
//        expandedLinkedList1.add(2);
//        expandedLinkedList1.add(3);
//        expandedLinkedList1.add(4);
//        expandedLinkedList1.add(5);
//        expandedLinkedList1.add(6);
//        expandedLinkedList1.add(7);
//        expandedLinkedList1.add(8);
//        expandedLinkedList1.add(9);
//        expandedLinkedList1.add(8);
//        expandedLinkedList1.print();

//        expandedLinkedList1.insert(7);
//        expandedLinkedList1.print();
//        expandedLinkedList1.insert(5);
//        expandedLinkedList1.print();
//        expandedLinkedList1.insert(5);
//        expandedLinkedList1.print();

//        expandedLinkedList1.remove(7);
//        expandedLinkedList1.print();
//        expandedLinkedList1.remove(3);
//        expandedLinkedList1.print();
//        expandedLinkedList1.remove(3);
//        expandedLinkedList1.print();
//        expandedLinkedList1.remove(3);
//        expandedLinkedList1.print();

//        expandedLinkedList1.remove(9);
//        expandedLinkedList1.print();
//        expandedLinkedList1.remove(0);
//        expandedLinkedList1.print();

//        expandedLinkedList1.add(2);
//        expandedLinkedList1.add(2);
//        expandedLinkedList1.add(2);
//        expandedLinkedList1.add(2);
//        expandedLinkedList1.add(2);
//        expandedLinkedList1.add(2);
//        expandedLinkedList1.add(2);
//        expandedLinkedList1.add(2);
//        expandedLinkedList1.add(2);
//        expandedLinkedList1.add(2);
//        expandedLinkedList1.add(2);
        expandedLinkedList1.add(3);
//        expandedLinkedList1.add(9);
        expandedLinkedList1.print();
//        expandedLinkedList1.remove(2);
//        expandedLinkedList1.print();
//        System.out.println(expandedLinkedList1.getLastAndDel());
//        expandedLinkedList1.print();
//        System.out.println(expandedLinkedList1.getLastAndDel());
//        expandedLinkedList1.print();
        System.out.println(expandedLinkedList1.getFirstAndDel());
        expandedLinkedList1.print();
    }
}
