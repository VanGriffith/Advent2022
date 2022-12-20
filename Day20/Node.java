package Day20;

public class Node {
    public long data;
    public Node previous, next;
    
    public Node(long data) {
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
        if (Day20.list.head == this) {
            Day20.list.head = this.next;
        }

        long positionsToMove = Math.abs(data) % (Day20.arraylist.size() - 1);

        
        Node current = this;
        if (positionsToMove == 0) {
            System.out.println(this.data);
        }
        else if (this.data < 0) {
            this.previous.setNext(this.next);
            this.next.setPrevious(this.previous);

            for (long i = 0; i > positionsToMove * -1; i--) {
                current = current.previous;
            }
            this.setNext(current);
            this.setPrevious(current.previous);
        }
        else if (this.data > 0) {
            this.previous.setNext(this.next);
            this.next.setPrevious(this.previous);

            for (long i = 0; i < positionsToMove; i++) {
                current = current.next;
            }
            this.setPrevious(current);
            this.setNext(current.next);
        }

        this.previous.setNext(this);
        this.next.setPrevious(this);
    }
}