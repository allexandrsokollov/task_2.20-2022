package vsu.cs.sokolov;

public class MyList  {

    private class Node {
        private Integer value;
        private Node nextElem;

        Node(Integer value) {
            this.value = value;
            nextElem = null;
        }

        Node getNextElem() {
            return nextElem;
        }

        Integer getValue() {
            return value;
        }

        void setValue(Integer value) {
            this.value = value;
        }

        void setNextElem(Node nextElem) {
            this.nextElem = nextElem;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
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

    public void add(Integer value) {
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

    public Integer getElem(int i) {
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

    public void printList() {
        Node current = head;
        System.out.println();
        while (current.nextElem != null) {
            System.out.print(current.value + "  ");
            current = current.nextElem;
        }
        System.out.print(current.value + "  ");

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
        Node current;

        current = head;
        while (current.nextElem != null) {
            if (isElemSimpleNumber(current.value) && !isElemSimpleNumber(current.nextElem.value)) {
                current.nextElem = current.nextElem.nextElem;
                length--;
            }
            if (current.nextElem.nextElem != null) {
                if (!isElemSimpleNumber(current.nextElem.value) &&
                        isElemSimpleNumber(current.nextElem.nextElem.value)) {
                    current.nextElem = current.nextElem.nextElem;
                    length--;
                }
            }

            current = current.nextElem;
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
