public class MyLinkedList<Type> {
    private int size=0;
    private Node<Type> head;
    private Node<Type> tail;

    private boolean isEmpty(){
        return head==null;
    }
    public void printAll(){
        Node nodeForIteration = head;
        while (nodeForIteration!=null){
            System.out.println(nodeForIteration.value);
            nodeForIteration=nodeForIteration.next;
        }
    }
    public void printSize(){
        System.out.println(size);
    }
    public void addFirst(Type value){
        Node<Type> fistNode=new Node<>(value);
        if (isEmpty()){
            tail=fistNode;
        }
        else {
            head.prev=fistNode;
        }
        fistNode.next=head;
        head=fistNode;
        size++;
    }
    public void addLast(Type value){
        Node<Type> lastNode=new Node<>(value);
        if (isEmpty()){
            head=lastNode;
        }
        else {
            tail.next=lastNode;
        }
        lastNode.prev=tail;
        tail=lastNode;
        size++;
    }
    public void addByIndex(Type value, int index) {
        if (index < 0)
            throw new IllegalArgumentException("Индекс не может быть отрицательным: " + index);

        Node<Type> newNode = new Node<>(value);

        if (index == 0) {
            // Вставка в начало списка
            newNode.next = head;
            head = newNode;
        } else {
            Node<Type> prevNode = getNodeAtIndex(index - 1);

            if (prevNode == null) {
                throw new IndexOutOfBoundsException("Индекс выходит за пределы списка: " + index);
            }

            newNode.next = prevNode.next;
            newNode.prev = prevNode;
            prevNode.next = newNode;

            if (newNode.next != null) {
                newNode.next.prev = newNode;
            }

        }
        size++;
    }
    private Node<Type> getNodeAtIndex(int index) {
        Node<Type> nodeForIteration = head;
        int currentIndex = 0;

        while (nodeForIteration != null && currentIndex < index) {
            nodeForIteration = nodeForIteration.next;
            currentIndex++;
        }

        return nodeForIteration;
    }



    public void deleteFirst(){
        if (isEmpty()){}
        else {
            head=head.next;
            head.prev=null;
            size--;
        }
    }
    public void deleteLast(){
        if (isEmpty()){}
        else {
            tail=tail.prev;
            tail.next=null;
            size--;
        }
    }
    public void deleteByIndex(int index) {
        Node<Type> nodeForIteration = head;
        int number = 0;

        if (isEmpty()) {
            return; // Если список пуст, нечего удалять
        }

        while (nodeForIteration != null) {
            if (number == index) {
                size--;
                if (nodeForIteration.prev != null) {
                    nodeForIteration.prev.next = nodeForIteration.next;
                } else {
                    head = nodeForIteration.next;
                }

                if (nodeForIteration.next != null) {
                    nodeForIteration.next.prev = nodeForIteration.prev;
                } else {
                    tail = nodeForIteration.prev;
                }

                return;
            }
            nodeForIteration = nodeForIteration.next;
            number += 1;
        }
    }

    public void updateAllDuplicates(Type prevValue, Type newValue){
        Node<Type> nodeForIteration=head;
        if (isEmpty()){
        }
        else {
            while (nodeForIteration.next!=null){
                if(nodeForIteration.value==prevValue){
                    nodeForIteration.value=newValue;
                }
                nodeForIteration=nodeForIteration.next;
            }
        }
    }
    public void updateByIndex(int index, Type newValue){
        Node<Type> nodeForIteration=head;
        int number=0;
        if (isEmpty()){}
        else {
            while (nodeForIteration!=null){
                if(number==index){
                    nodeForIteration.value=newValue;
                }
                nodeForIteration=nodeForIteration.next;
                number++;
            }
        }
    }

    private static class Node<Type>{
        private Type value;

        private Node<Type> next;

        private Node<Type> prev;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }

        private Node(Type value) {
            this.value = value;
        }
    }

}
