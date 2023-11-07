package singlyLinkedList;

public class SinglyLinkedList implements CustomList{
    private Node head;
    private Node tail;

    // добавление значения в начало списка
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

    // извлечение значения из начала списка без его удаления
    @Override
    public Integer getFirst() {
        return head != null ? head.data : null;
    }

    // извлечение значения из начала списка с удалением
    @Override
    public Integer getFirstAndDel() {
        if (head != null) {
            Integer temp = head.data;
            head = head.next;
            return temp;
        }
        else {
            return null;
        }
    }

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

    // извлечение значения из конца списка без его удаления
    @Override
    public Integer getLast() {
        return tail != null ? tail.data : null;
    }

    // извлечение значения из конца списка с удалением
    @Override
    public Integer getLastAndDel() {
        if (tail != null) {
            Integer tempTailData = tail.data;
            Node tempHead = head;
//            Node tempTail = tail;
            while (head.next != tail) {
                head = head.next;
            }
            head.next = null;
            tail = head;
            head = tempHead;
            return tempTailData;
        }
        else {
            return null;
        }
    }

    // определение, содержит ли заданное значение

    // определение, является ли пустым

    // печать всех значений списка
    @Override
    public void print() {
        System.out.println(this);
    }

    // *удаление заданного значения из списка
    @Override
    public void remove(Integer data) {
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
