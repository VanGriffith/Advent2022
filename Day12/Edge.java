package Day12;

public class Edge {
    Vertex destination;
    int weight;

    public Edge(Vertex destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public int weight() {
        return weight;
    }
}
