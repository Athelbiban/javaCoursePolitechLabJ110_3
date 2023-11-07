package singlyLinkedList;

public interface CustomList {

    void add(Integer data);
    void insert(Integer data);
    void remove(Integer data);
    Integer getLast();
    Integer getFirst();
    Integer getFirstAndDel();
    Integer getLastAndDel();
    void print();
}
