package singlyLinkedList;

public class SinglyLinkedList implements CustomList{
    private Node head;
    private Node tail;

    // добавление значения в конец списка
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
    public void insert(Integer data) {
        Node temp = new Node(data, head);
        if (head == null) {
            head = tail = temp;
        }
        else {
            head = temp;
        }
    }

    @Override
    public void remove(Integer data) {

    }

    // извлечение значения из конца списка без его удаления
    @Override
    public Integer getLast() {
        return tail != null ? tail.data : null;
    }

    // извлечение значения из начала списка без его удаления
    @Override
    public Integer getFirst() {
        return head != null ? head.data : null;
    }

    // печать всех значений списка
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

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
