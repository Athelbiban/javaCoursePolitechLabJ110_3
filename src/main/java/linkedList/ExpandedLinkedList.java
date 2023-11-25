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
        if (head != null) {
            Node tempHead = head;
            Node previous = null;

            while (tempHead != null) {
                Remover.remover(tempHead, data);
                Remover.placeholder(tempHead, previous, Remover.getFirstIndexNull(previous));
                Remover.stacker(tempHead, previous);

                if (tempHead.data[0] != null) {
                    previous = tempHead;
                }
                else if (tempHead == head) {
                    head = head.next;
                }

                tempHead = tempHead.next;
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

    private static void dataVerification(Node data) {
        if (data == null) {
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

    private abstract static class Remover {

//        Node headNode;
//        Integer data;

//        public Remover(Node headNode, Integer data) {
//            this.headNode = headNode;
//            this.data = data;
//        }

        static void remover(Node node, Integer data) {
            dataVerification(node);
            for (int i = 0; i < node.data.length; i++) {
                if (node.data[i] != null && node.data[i].equals(data)) {
                    node.data[i] = null;
                }
            }
        }

        static void stacker(Node node, Node previousNode) {
            dataVerification(node);
            for (int i = 0; i < node.data.length; i++) {
                if (node.data[i] == null) {
                    for (int j = i; j < node.data.length; j++) {
                        if (node.data[j] != null) {
                            node.data[i] = node.data[j];
                            node.data[j] = null;
                            break;
                        }
                    }
                }
            }

            if (node.data[0] == null && previousNode != null) {
                previousNode.next = node.next;
            }
//            else if (node.data[0] == null) {
//                node.next = null;
//            }
        }

        void mover() {

        }

        static Integer getFirstIndexNull(Node node) {
            if (node != null) {
                for (int i = 0; i < node.data.length; i++) {
                    if (node.data[i] == null) {
                        return i;
                    }
                }
            }
            return null;
        }

        static void placeholder(Node node, Node previousNode, Integer index) {
            dataVerification(node);

            for (int i = 0; i < node.data.length; i++) {
                if (index != null && index < SIZE && node.data[i] != null) {
                    previousNode.data[index] = node.data[i];
                    node.data[i] = null;
                    index++;
                }
            }
        }
    }
}
