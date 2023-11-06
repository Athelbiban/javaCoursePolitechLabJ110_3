package singlyLinkedList;

public class SinglyLinkedList implements CustomList{
    private Node head;
    private Node tail;

    @Override
    public void add(Integer data) {
        Node temp = new Node(data, null);
        if (head == null) {
            head = tail = temp;
        }
        else {
            tail.next = temp;
            tail = temp;
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
    public void print() {

    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }

    private static class Node {
        Integer data;
        Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
