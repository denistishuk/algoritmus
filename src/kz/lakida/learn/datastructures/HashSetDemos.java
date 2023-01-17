package kz.lakida.learn.datastructures;

import java.util.LinkedList;

import static kz.lakida.learn.Assertions.assertFalse;
import static kz.lakida.learn.Assertions.assertTrue;

public class HashSetDemos {

    public static void main(String[] args) {
        shouldContainElement();
        shouldNotContainElement();
    }

    static void shouldContainElement() {
        MySet mySet = new MyHashSet();
        mySet.add("one");
        mySet.add("two");
        mySet.add("three");

        assertTrue(mySet.contains("two"));
    }

    static void shouldNotContainElement() {
        MySet mySet = new MyHashSet();
        mySet.add("one");
        mySet.add("two");
        mySet.add("three");

        assertFalse(mySet.contains("four"));
    }
}

interface MySet {

    void add(String item);

    int size();

    boolean contains(String item);
}

class MyHashSet implements MySet {

    final LinkedList<String>[] array;

    public MyHashSet() {
        array = new LinkedList[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = new LinkedList<>();
        }
    }

    @Override
    public void add(String item) {
        int bucket = item.hashCode() % array.length;

        LinkedList<String> bucketList = array[bucket];

        bucketList.add(item);
    }

    @Override
    public int size() {
        return 0;
    }

    /*
    Реализовать метод contains, который должен работать за константное время.
    Дополнительная задача - придумать, что делать когда значение хеш сумм у разных элементов будут одинаковыми.
     */
    @Override
    public boolean contains(String item) {
        int bucket = item.hashCode() % array.length;

        LinkedList<String> strings = array[bucket];

        for (String element : strings) {
            if (element.equals(item)) {
                return true;
            }
        }

        return false;
    }
}