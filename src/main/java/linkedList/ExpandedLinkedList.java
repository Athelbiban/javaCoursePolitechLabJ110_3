package linkedList;

import java.util.Arrays;

public class ExpandedLinkedList implements CustomList{
    private static final int SIZE = 10;
    private Node head;
    private Node tail;

    @Override
    public void add(Integer data) {
        dataVerification(data);
        if (!listEmpty()) {
            if (tail.data[SIZE - 1] != null) {
                Integer[] tempArr = new Integer[SIZE];
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
            Integer[] tempArr = new Integer[SIZE];
            tempArr[0] = data;
            Node tempNode = new Node(tempArr, null);
            head = tail = tempNode;
        }
    }

    @Override
    public void insert(Integer data) {
        dataVerification(data);

        if (!listEmpty()) {
            Node tempHead = head;
            Node tempTail = tail;
            Node previous = head;

            if (tail.data[SIZE - 1] != null) {
                Integer[] tempArr = new Integer[SIZE];
                tempArr[0] = tail.data[SIZE - 1];
                tail.next = new Node(tempArr, null);
                tail = tail.next;
            }

            while (true) {
                for (int i = SIZE - 2; i >= 0; i--) {
                    tempTail.data[i + 1] = tempTail.data[i];
                }

                if (head == tempTail) {
                    head.data[0] = data;
                    break;
                }

                while (tempHead != tempTail) {
                    previous = tempHead;
                    tempHead = tempHead.next;
                }

                tempTail.data[0] = previous.data[SIZE - 1];
                tempTail = previous;
                tempHead = head;
            }
        }

        else {
            Integer[] newArr = new Integer[SIZE];
            newArr[0] = data;
            Node newNode = new Node(newArr, null);
            head = tail = newNode;
        }
    }

    @Override
    public void remove(Integer data) {
        dataVerification(data);

        if (!listEmpty()) {
            boolean flag = true;
            while (flag) {
                Node tempHead = head;
                Node previous = head;
                Integer target = null;

                while (tempHead != null) {
                    for (int i = 0; i < SIZE; i++) {
                        if (tempHead != previous && i == 0 && target != null) {
                            previous.data[SIZE - 1] = tempHead.data[i];
                            target = i;
                        }

                        if (target != null && i != 0) {
                            if (tempHead.data[i] != null && tempHead.data[i].equals(data)) {
                                tempHead.data[i] = null;
                            }
                            tempHead.data[i - 1] = tempHead.data[i];
                            target = i;
                        }

                        if (tempHead.data[i] != null && tempHead.data[i].equals(data)) {
                            target = i;
                        }
                    }

                    if (tempHead.data[0] == null) {
                        tail = previous;
                        tail.next = null;
                    }

                    if (target != null) {
                        tempHead.data[SIZE - 1] = null;
                        flag = true;
                    }
                    else {
                        flag = false;
                    }

                    previous = tempHead;
                    tempHead = tempHead.next;
                }
            }
        }
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
