package linkedList;

import java.util.Arrays;

public class ExpandedLinkedList implements CustomList{
    private static final int size = 10;
    private Node head;
    private Node tail;

    @Override
    public void add(Integer data) {
        dataVerification(data);
        if (!listEmpty()) {
            if (tail.data[size - 1] != null) {
                Integer[] tempArr = new Integer[size];
                tempArr[0] = data;
                Node newNode = new Node(tempArr, null);
                tail.next = newNode;
                tail = newNode;
            }
            else {
                for (int i = 0; i < tail.data.length; i++) {
                    if (tail.data[i] == null) {
                        tail.data[i] = data;
                        break;
                    }
                }
            }
        }
        else {
            Integer[] tempArr = new Integer[size];
            tempArr[0] = data;
            Node tempNode = new Node(tempArr, null);
            head = tail = tempNode;
        }
    }

    @Override
    public void insert(Integer data) {
        dataVerification(data);
        if (!listEmpty()) {

            Node previousTail = tail;
            Node tempTail = tail;
            while (previousTail != head) {
                if (tail.data[size - 1] != null) {
                    Integer[] tempArr = new Integer[size];
                    tempArr[0] = tail.data[size - 1];
                    Node newNode = new Node(tempArr, null);
                    for (int i = size - 2; i >= 0; i--) {
                        tail.data[i + 1] = tail.data[i];
                    }

                    Node tempHead = head;
                    while (tempHead != tail) {
                        previousTail = tempHead;
                        tempHead = tempHead.next;
                    }
                    if (previousTail == null) {
                        head.data[0] = data;
                        break;
                    }
                    tail.next = newNode;
                    tail = newNode;
                }
                else {

                }
                tempTail = tempTail.next;
            }
        }
        else {
            Integer[] newArr = new Integer[size];
            newArr[0] = data;
            Node newNode = new Node(newArr, null);
            head = tail = newNode;
        }
    }

    @Override
    public void remove(Integer data) {

    }

    @Override
    public Integer getLast() {
        return null;
    }

    @Override
    public Integer getFirst() {
        return null;
    }

    @Override
    public Integer getFirstAndDel() {
        return null;
    }

    @Override
    public Integer getLastAndDel() {
        return null;
    }

    @Override
    public Boolean isExist(Integer data) {
        return null;
    }

    @Override
    public Boolean listEmpty() { return head == null; }

    @Override
    public void print() { System.out.println(this); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = head;
        while (temp != null) {
            sb.append(Arrays.toString(temp.data));
            sb.append(temp.next != null ? ", " : "");
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private static void dataVerification(Integer data) {
        if (data == null) {
            throw new IllegalArgumentException("IllegalArgumentException: Empty link. Integer not be null");
        }
    }

    private static void dataVerification(Integer[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("IllegalArgumentException: array must not be empty");
        }
    }

    private static class Node {
        Integer[] data;
        Node next;

        public Node(Integer[] data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
