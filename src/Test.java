
public class Test {
    public static void main(String[] args) {
        MyLinkedList<Minions> minionsList = new MyLinkedList();
        Minions minion1=new Minions(199,"SomeName");
        //minionsList.addFirst(new Minions(1,"Noname"));
        //minionsList.addFirst(new Minions(2,"A"));
        //minionsList.addFirst(new Minions(3,"B"));
        minionsList.addFirst(minion1);
        minionsList.addFirst(new Minions(4,"C"));
        minionsList.addLast(new Minions(4,"D"));
        minionsList.addLast(new Minions(4,"D"));
        minionsList.addLast(new Minions(4,"D"));
        minionsList.printAll();
        minionsList.printSize();
        minionsList.addByIndex(new Minions(11111,"Dssdsfa"),2);
        minionsList.printAll();
        minionsList.printSize();
        minionsList.deleteFirst();
        minionsList.deleteLast();
        minionsList.printAll();
        minionsList.printSize();
        minionsList.updateAllDuplicates(minion1, new Minions(5,"E"));
        minionsList.printAll();
        minionsList.printSize();
        minionsList.deleteByIndex(2);
        minionsList.printAll();
        minionsList.printSize();
    }
}
