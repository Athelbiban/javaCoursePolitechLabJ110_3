package singlyLinkedList;

public interface CustomList {

    void add(Integer data);
    void insert(Integer data);
    void remove(Integer data);
    Integer getLast();
    Integer getFirst();
    Integer getFirstAndDel();
    Integer getLastAndDel();
    Boolean isExist(Integer data);
    Boolean listEmpty();
//    void execute();
    void print();
}
