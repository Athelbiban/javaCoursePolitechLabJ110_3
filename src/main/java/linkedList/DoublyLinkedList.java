package linkedList;

import java.util.Collections;
import java.util.List;

public class DoublyLinkedList implements CustomList {
    private Node head;
    private Node tail;

    @Override
    public void insert(Integer data) {
        Node temp = new Node(data, head, null);
        if (!listEmpty()) {
            head = tail = temp;
        }
        else {
            head = temp;
        }
    }

    @Override
    public void add(Integer data) {
        Node temp = new Node(data, null, tail);
        if (listEmpty()) {
            head = tail = temp;
        }
        else {
            tail.next = temp;
            tail = temp;
        }
    }

    @Override
    public void remove(Integer data) {
        if (!listEmpty()) {
            Node tempHead = head;
            while (head != null) {
                if (head.data.equals(data)) {
                    if (head == tempHead) {
                        tempHead = head.next;
                        tempHead.previous = null;
                    }
                    else if (head != tail) {
                        head.previous.next = head.next;
                        head.next.previous = head.previous;
                    }
                    else {
                        tail = tail.previous;
                        tail.next = null;
                    }
                }
                head = head.next;
            }
            head = tempHead;
        }
    }

    @Override
    public Integer getLast() { return tail.data; }

    @Override
    public Integer getFirst() { return head.data; }

    @Override
    public Integer getFirstAndDel() {
        if (!listEmpty()) {
            int result = head.data;
            head = head.next;
            head.previous = null;
            return result;
        }
        return null;
    }

    @Override
    public Integer getLastAndDel() {
        if (!listEmpty()) {
            int result = tail.data;
            tail = tail.previous;
            tail.next = null;
            return result;
        }
        return null;
    }

    @Override
    public Boolean isExist(Integer data) {
        if (!listEmpty()) {
            Node tempHead = head;
            while (head != null) {
                if (head.data.equals(data)) {
                    head = tempHead;
                    return true;
                }
                head = head.next;
            }
            head = tempHead;
        }
        return false;
    }

    @Override
    public Boolean listEmpty() { return head == null; }

    @Override
    public void print() { System.out.println(this); }

    // добавление всех значений заданного массива в начало списка
    public static void insertArray(DoublyLinkedList list, Integer[] data) {
        if (data != null) {
            for (int i = 0; i < data.length / 2; i++) {
                int temp = data[i];
                data[i] = data[data.length - i - 1];
                data[data.length - i - 1] = temp;
            }
            for (Integer i : data) {
                list.insert(i);
            }
        }
    }

    // добавление всех значений заданной коллекции в начало списка
    public static void insertCollection(DoublyLinkedList list, Iterable<Integer> collection) {
        if (list != null && collection != null) {
            Collections.reverse((List<Integer>) collection);
            for (int i : collection) {
                list.insert(i);
            }
            Collections.reverse((List<Integer>) collection);
        }
    }

    // добавление всех значений заданного массива/коллекции в конец списка
    public static void addArray(DoublyLinkedList list, Integer[] data) {
        if (data != null) {
            for (Integer i : data) {
                list.add(i);
            }
        }
    }

    public static void addCollection(DoublyLinkedList list, Iterable<Integer> collection) {
        if (collection != null) {
            for (Integer i : collection) {
                list.add(i);
            }
        }
    }

    // поглощение одного списка другим с добавлением второго в начало/конец и очисткой второго
    public static void takeoverAndInsert(DoublyLinkedList list, List<Integer> data) {
        if (data != null) {
            Collections.reverse(data);
            for (Integer i : data) {
                list.insert(i);
            }
            data.clear();
        }
    }

    public static void takeoverAndAdd(DoublyLinkedList list, List<Integer> data) {
        if (data != null) {
            for (Integer i : data) {
                list.add(i);
            }
            data.clear();
        }
    }
    // печать всех значений списка в прямом/обратном порядке
    public static void printInDirectOrder(DoublyLinkedList list) { list.print(); }

    public static void printInReverseOrder(DoublyLinkedList list) {
        if (list != null) {
            Node tempHead = list.head;
            DoublyLinkedList copyList = new DoublyLinkedList();
            while (tempHead != null) {
                copyList.insert(tempHead.data);
                tempHead = tempHead.next;
            }
            copyList.print();
        }
    }

    // выполнение действия заданного в параметре метода
    // для каждого значения списка в прямом/обратном порядке
    public void forEach(Command command) {
        command.execute();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node tempHead = head;
        while (tempHead != null) {
            sb.append(tempHead.data);
            sb.append(tempHead.next != null ? ", " : "");
            tempHead = tempHead.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node {
        Integer data;
        Node next;
        Node previous;

        public Node(Integer data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }
}
