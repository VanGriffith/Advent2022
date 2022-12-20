package Day20;

public class Node {
    public int data;
    public Node previous, next;
    
    public Node(int data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this.next;
    }

    public Node setPrevious(Node previous) {
        this.previous = previous;
        return this.previous;
    }

    public void shift() {
        if (this.data == 0) return;
        this.previous.setNext(this.next);
        this.next.setPrevious(this.previous);
        if (Day20.list.head == this) {
            Day20.list.head = this.next;
        }
        
        Node current = this;
        if (this.data < 0) {
            for (int i = 0; i > this.data; i--) {
                current = current.previous;
            }
            this.setNext(current);
            this.setPrevious(current.previous);
        }
        else if (this.data > 0) {
            for (int i = 0; i < this.data; i++) {
                current = current.next;
            }
            this.setPrevious(current);
            this.setNext(current.next);
        }

        this.previous.setNext(this);
        this.next.setPrevious(this);
    }
}