package linkedList;

import java.util.*;

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
        if (collection != null) {
            Collections.reverse((List<Integer>) collection);
            for (int i : collection) {
                list.insert(i);
            }
        }
    }

    // добавление всех значений заданной массива/коллекции в конец списка
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

    // поглощение одного списка другим с добавлением второго в начало/конец
    public static void listTakeoverAndInsert(DoublyLinkedList list, List<Integer> data) {
        if (data != null) {
            List<Integer> dataCopy = new LinkedList<>(data);
//            Collections.copy(dataCopy, data);
            Collections.reverse(dataCopy);
            for (Integer i : dataCopy) {
                list.insert(i);
            }
        }
    }

    public static void listTakeoverAndAdd(DoublyLinkedList list, List<Integer> data) {

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
