package Day13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Node {
    boolean isList;
    Node parent;
    Queue<Node> children;
    ArrayList<Node> resetList;
    int intValue;

    public Node(int value) {
        this.isList = value < 0;
        this.intValue = value;
        this.children = new LinkedList<Node>();
        this.resetList = new ArrayList<Node>();
    }

    public void addChild(Node child) {
        child.parent = this;
        this.children.offer(child);
        this.resetList.add(child);
    }

    public void print() {
        if (this.isList) {
            System.out.print("[");
            Queue<Node> temp = new LinkedList<Node>();
            while (!this.children.isEmpty()) {
                Node nextNode = this.children.poll();
                temp.offer(nextNode);
                nextNode.print();
                System.out.print(this.children.isEmpty() ? "" : ",");
            }
            System.out.print("]");
            this.children = temp;
        }
        else {
            System.out.print(this.intValue);
        }
    }

    public int compare(Node second) {
        if (this.isList && second.isList) {
            
            if (!this.children.isEmpty() && !second.children.isEmpty()) {
                int testNum = this.children.poll().compare(second.children.poll());
                if (testNum == 0) return this.compare(second);
                else return testNum;
            }
            else {
                return this.children.size() - second.children.size();
            }
        }
        else if (!this.isList && !second.isList) {
            return this.intValue - second.intValue;
        }
        else if (this.isList) {
            second.makeList();
            return this.compare(second);
        }
        else {
            this.makeList();
            return this.compare(second);
        }
    }

    public void makeList() {
        this.children.offer(new Node(this.intValue));
        this.isList = true;
    }

    public void reset() {
        this.isList = this.intValue == -1;
        Queue<Node> temp = new LinkedList<Node>();
        for (Node child: resetList) {
            temp.offer(child);
            child.reset();
        }
        this.children = temp;
    }


}
