package Day20;

public class CircularList {

    Node head;
    Node tail;

    public CircularList() {
        this.head = null;
        this.tail = null;
    }

    public void addToEnd(Node newNode) {
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
        }
        else {
            newNode.setNext(head);
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            head.setPrevious(newNode);

            tail = newNode;
        }
    }

    public void print() {
        if (head == null) return;

        Node current = head;
        do {
            System.out.println(current.data);
            current = current.next;
        } while (current != head);
    }

    public long coordinatesSum() {
        if (head == null) return  0;

        Node current = head;
        while (current.data != 0) {
            current = current.next;
        }
        current = current.next;

        long sum = 0;
        for (int i = 1; i <= 3000; i++) {
            if (i % 1000 == 0) {
                sum += current.data;
            }
            current = current.next;
        }
        return sum;
    }
}

