package singlyLinkedList;

public class PrintCommand implements Command {
    @Override
    public void execute(CustomList list) {
        System.out.println(list.getLastAndDel());
    }
}

