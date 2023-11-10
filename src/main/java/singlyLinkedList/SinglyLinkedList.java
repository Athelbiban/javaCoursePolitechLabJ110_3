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

            if (head == tail) {
                head = null;
                tail = null;
                return tempTailData;
            }

            Node tempHead = head;
            while (head.next != tail) {
                head = head.next;
            }

            tail = head;
            tail.next = null;
            head = tempHead;
            return tempTailData;
        }
        else {
            return null;
        }
    }

    // определение, содержит ли заданное значение
    @Override
    public Boolean isExist(Integer data) {
        Node tempHead = head;

        while (head != null) {
            if (head.data.equals(data)) {
                head = tempHead;
                return true;
            }
            head = head.next;
        }

        head = tempHead;
        return false;
    }

    // определение, является ли пустым
    @Override
    public Boolean listEmpty() { return head == null; }
    // печать всех значений списка
    @Override
    public void print() {
        System.out.println(this);
    }

    // *удаление заданного значения из списка
    @Override
    public void remove(Integer data) {
        if (!listEmpty()) {
            Node tempHead = head;
            Node previousNode = null;
            while (head != null) {
                if (head.data.equals(data)) {
                    if (head == tempHead) {
                        tempHead = head.next;
                    }
                    else {
                        previousNode.next = head.next;
                    }
                }
                previousNode = head;
                head = head.next;
            }
            head = tempHead;
        }
    }

    // *выполнение действия, заданного в параметре метода
    public static void callCommand(Command command, CustomList list) {
        command.execute(list);
    }

    // переопределенный toString()
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
