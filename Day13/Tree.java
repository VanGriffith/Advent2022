package Day13;

public class Tree implements Comparable<Tree>{
    
    Node root;
    Node currentNode;
    
    public Tree() {
        this.root = null;
        this.currentNode = null;
    }

    public static boolean compare(Tree first, Tree second) {
        boolean answer = first.root.compare(second.root) < 0;
        first.reset();
        second.reset();
        return answer;
    }

    public Tree(String inputString) {
        char[] input = inputString.toCharArray();
        int index = 0;
        while (index < input.length) {
            if (input[index] == '[') {
                this.addNode(-1);
            }
            else if (input[index] == ']') {
                this.currentNode = this.currentNode.parent;
            }
            else if (input [index] == ',') {

            }
            else {
                String intString = "";
                while (input[index] >= '0' && input[index] <= '9') {
                    intString += input[index];
                    index++;
                }
                index--;
                int newInt = Integer.parseInt(intString);
                this.addNode(newInt);
            }
            index++;
        }

    }

    public void addNode(int nodeValue) {
        Node addedNode = new Node(nodeValue);
        
        if (this.currentNode == null) {
            this.root = addedNode;
            this.currentNode = this.root;
        }
        else {
            this.currentNode.addChild(addedNode);
        }

        if (addedNode.isList) this.currentNode = addedNode;

    }

    public void printTree() {
        this.root.print();
        System.out.println();
    }

    @Override
    public int compareTo(Tree o) {
        int answer = this.root.compare(o.root);
        this.reset();
        o.reset();
        return answer;
    }

    public void reset() {
        this.root.reset();
    }

}
