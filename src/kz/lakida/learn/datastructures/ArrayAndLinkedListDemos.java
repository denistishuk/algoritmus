package kz.lakida.learn.datastructures;

public class ArrayAndLinkedListDemos {

    public static void main(String[] args) {
        MyList list = new MyArrayList();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");
        list.add("eleven");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println(list.size());

        list.remove(5);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}

interface MyList {

    void add(String item);

    String get(int index);

    int size();

    void remove(int index);
}

class MyArrayList implements MyList {

    String[] contents = new String[10];

    int size = 0;

    @Override
    public void add(String item) {
        if (size >= contents.length) {
            copyArrayToSize(size * 2);
        }
        contents[size] = item;
        size++;
    }

    private void copyArrayToSize(int newArrayLength) {
        String[] newArray = new String[newArrayLength];
        for (int i = 0; i < size; i++) {
            newArray[i] = contents[i];
        }
        contents = newArray;
    }

    @Override
    public String get(int index) {
        return contents[index];
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Реализовать функцию удаления элемента из списка по индексу
     *
     * @param index
     */
    @Override
    public void remove(int index) {
        for (int i = index; i < contents.length - 1; i++) {
            contents[i] = contents[i + 1];
        }
        size--;

        if (size < contents.length / 2) {
            copyArrayToSize(contents.length / 2);
        }
    }
}

class MyLinkedList implements MyList {

    Node head = null;

    Node tail = null;

    int size = 0;

    @Override
    public void add(String item) {
        if (this.head == null) {
            this.head = new Node(item, null, null);
            this.tail = head;
        } else {
            Node newNode = new Node(item, this.head, null);
            this.head.next = newNode;
            this.head = newNode;
        }
        size++;
    }

    @Override
    public String get(int index) {
        Node currentElement = tail;
        int counter = 0;
        while (counter < index) {
            counter++;
            if (currentElement == null) {
                return null;
            } else {
                currentElement = currentElement.next;
            }
        }
        return currentElement.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {

    }

    private static class Node {

        String value;

        Node previous;

        Node next;

        Node(String value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
}


