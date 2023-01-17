package kz.lakida.learn.datastructures;

public class HashMapDemos {

    public static void main(String[] args) {
        MyMap map = new MyHashMap();

        map.put("Anton", "Lakida");

        System.out.println(map.get("Anton"));
    }

}

interface MyMap {

    void put(String key, String value);

    String get(String key);
}

class MyHashMap implements MyMap {

    Entry[] mas = new Entry[10]; // null

    @Override
    public void put(String key, String value) {
        int buckets = key.hashCode() % mas.length;
        Entry entry = new Entry(key, value);
        mas[buckets] = entry;
    }

    @Override
    public String get(String key) {
        int buckets = key.hashCode() % mas.length;

        Entry entry = mas[buckets];

        if (entry != null) {
            return entry.value;
        } else {
            return null;
        }
    }

    private static class Entry {

        final String key;

        final String value;

        private Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
