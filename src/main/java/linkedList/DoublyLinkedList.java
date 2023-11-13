package linkedList;

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
                    }
                    else {
                        head.previous = head.next;
                    }
                }
                head.previous = head;
                head = head.next;
            }
            head = tempHead;
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
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = head;
        while (temp != null) {
            sb.append(temp.data);
            sb.append(temp.next != null ? ", " : "");
            temp = temp.next;
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
