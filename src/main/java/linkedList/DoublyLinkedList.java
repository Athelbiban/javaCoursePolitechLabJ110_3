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
    public void print() {
        System.out.println(this);
    }

    // добавление всех значений массива в начало списка
    public void insertArray(Integer data) {

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
