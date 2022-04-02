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

    public int getLength() {
        return length;
    }

    public void add(T value) {
        Node temp;

        if (head == null) {
            head = new Node(value);
        } else {
            temp = head;
            while (temp.nextElem != null) {
                temp  = temp.getNextElem();
            }
            temp.setNextElem(new Node(value));
        }
        length++;
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
        return temp.getValue();
    }

    public void replace(int index) {
        Node currentNode = head;

        if (index == 0) {
            head = head.nextElem;
        } else {

            for (int i = 0; currentNode != null; i++) {
                if (i == index - 1) {
                    currentNode.setNextElem(currentNode.getNextElem().getNextElem());
                    break;
                }
                currentNode = currentNode.nextElem;
            }
        }
        length--;
    }

    public void fixList() {
        Node temp;

        temp = head;
        int count = 0;
        while (count != length) {

            if (count + 2 < length) {
                if (!isElemSimpleNumber((Integer) temp.nextElem.value) &&
                        isElemSimpleNumber((Integer) temp.nextElem.nextElem.value)) {
                    temp.nextElem = temp.nextElem.nextElem;
                    length--;
                }
            }

            if (count + 1 < length) {
                if (isElemSimpleNumber((Integer) temp.value) && !isElemSimpleNumber((Integer) temp.nextElem.value)) {
                    if (count + 2 == length) {
                        temp.nextElem = null;
                    } else {
                        temp.nextElem = temp.nextElem.nextElem;
                    }
                    length--;
                }
            }
            temp = temp.getNextElem();
            count++;
        }

    }

    private boolean isElemSimpleNumber(int value) {
        for (int i = 2; i <= Math.abs(value) / 2; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}

