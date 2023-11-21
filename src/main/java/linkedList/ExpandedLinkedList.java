package linkedList;

public class ExpandedLinkedList implements CustomList{
    private Node head;
    private Node tail;

    @Override
    public void add(Integer data) {
        dataVerification(data);
        Node temp = new Node(new Integer[]{data}, null);
        if (!listEmpty()) {
            tail.next = temp;
            tail = temp;
        }
        else {
            head = tail = temp;
        }
    }

    @Override
    public void insert(Integer data) {

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
            sb.append(temp.data);
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
        Integer[] data = new Integer[10];
        Node next;

        public Node(Integer[] data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
