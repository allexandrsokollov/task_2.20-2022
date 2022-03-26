package vsu.cs.sokolov;

public class MyList <T> {

    private class Node {
        private T value;
        private Node nextElem;

        Node(T value) {
            this.value = value;
            nextElem = null;
        }

        Node getNextElem() {
            return nextElem;
        }

        T getValue() {
            return value;
        }

        void setValue(T value) {
            this.value = value;
        }

        void setNextElem(Node nextElem) {
            this.nextElem = nextElem;
        }
    }

    private Node head;
    private int length;

    public MyList () {
        head = null;
        length = 0;
    }

    public void add(T value) {
        Node temp;

        if (head == null) {
           head = new Node(value);
           length++;
        } else {
            temp = head;
            while (temp.nextElem != null) {
                temp  = temp.getNextElem();
            }
            temp.setNextElem(new Node(value));
            length++;
        }
    }

    public T getElem(int i) {
        if (i >= length) {
            throw new IndexOutOfBoundsException();
        }

        Node temp;
        if (i == 0) {
            return head.getValue();
        } else {
            temp = head;
            int count = 0;
            while (count != i) {
                temp = temp.getNextElem();
                count++;
            }
        }
        int counter = 0;

        return temp.getValue();
    }
}

