package kz.lakida.learn.datastructures;

public class StackAndQueueDemos {

}

interface MyStack {

    void push(String item);

    String pop();

    int size();
}

class MyLinkedStack implements MyStack {

    @Override
    public void push(String item) {

    }

    @Override
    public String pop() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}

interface MyQueue {

    void add(String item);

    String poll();

    int size();
}

class MyLinkedQueue implements MyQueue {

    @Override
    public void add(String item) {

    }

    @Override
    public String poll() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
