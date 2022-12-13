package Day12;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Vertex implements Comparable<Vertex> {
    int x;
    int y;
    char height;
    ArrayList<Edge> edges;
    int distanceFromStart;

    public Vertex(int x, int y, char height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.edges = new ArrayList<Edge>();
        distanceFromStart = Integer.MAX_VALUE;
    }

    public void setDistance(int distanceFromStart) {
        this.distanceFromStart = distanceFromStart;
    }

    public int distance() {
        return this.distanceFromStart;
    }

    public Edge addEdge(Edge edge) {
        this.edges.add(edge);
        return edge;
    }

    public Edge addEdge(Vertex other, int weight) {
        Edge newEdge = new Edge(other, weight);
        this.edges.add(newEdge);
        return newEdge;
    }

    public static int calculateWeightBetween(Vertex v1, Vertex v2) {
        return v1.height - v2.height;
    }

    @Override
    public int compareTo(Vertex o) {
        return this.distanceFromStart - o.distanceFromStart;
    }

    public void setNeighborDistances(PriorityQueue<Vertex> distances) {
        for (Edge edge: this.edges) {
            Vertex other = edge.destination;
            int alternate = this.distanceFromStart + edge.weight;
            
            if (alternate < other.distance()) {
                distances.remove(other);
                other.setDistance(alternate);
                distances.add(other);
            }
        }
    }

    public static void createEdges(Vertex v1, Vertex v2) {
        int weight = calculateWeightBetween(v1, v2);
        if (Math.abs(weight) <= 1) {
            v1.addEdge(v2, 1);
            v2.addEdge(v1, 1);
        }
        else if (weight > 0) {
            v1.addEdge(v2, 1);
        }
        else {
            v2.addEdge(v1, 1);
        }
    }

}
