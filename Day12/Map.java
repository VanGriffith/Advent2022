package Day12;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Map {
    int rowCount;
    int columnCount;
    char[][] heights;

    Vertex start;
    int startX;
    int startY;

    Vertex end;
    int endX;
    int endY;

    ArrayList<Vertex> verteces;
    ArrayList<Edge> edges;

    public Map(Queue<String> inputStrings) {
        rowCount = inputStrings.size();
        columnCount = inputStrings.peek().length();
        heights = new char[rowCount][columnCount];
        verteces = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();

        for (int row = 0; row < rowCount; row++) {
            heights[row] = inputStrings.remove().toCharArray();
        }

        //Find S and E
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                
                switch (heights[row][column]) {
                    case 'S':
                        startX = column;
                        startY = row;
                        heights[row][column] = 'a';
                        break;
                    case 'E':
                        endX = column;
                        endY = row;
                        heights[row][column] = 'z';
                        break;
                    default:
                        break;
                }
            }
        }
        this.populateMap();
    }

    public void printHeightMap() {
        for (char[] row: heights) {
            for (char column: row) {
                System.out.print(column);
            }
            System.out.println();
        }
        System.out.printf("Start: (%3d, %2d)\n", startX, startY);
        System.out.printf("End:   (%3d, %2d)\n", endX, endY);
    }

    public void populateMap() {
        // Offsets for findind the top and left neighbors in the arraylist
        int rowOffset = -1 * columnCount;
        int columnOffset = -1;

        // Iterate through all heights
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                // Create new vertex at given position
                Vertex current = new Vertex(row, column, heights[row][column]);

                // Only create link the left neighbor if not in the first column
                if (column != 0) {
                    Vertex leftNeighbor = verteces.get(verteces.size() + columnOffset);
                    Vertex.createEdges(current, leftNeighbor);
                }

                // Only create link the top neighbor if not in the first row
                if (row != 0) {
                    Vertex topNeighbor = verteces.get(verteces.size() + rowOffset);
                    Vertex.createEdges(current, topNeighbor);
                }

                // If we found the start or end position, track it
                if (row == startY && column == startX) start = current;
                if (row == endY && column == endX) end = current;

                // Add the current vertex to the arraylist of verteces
                verteces.add(current);
            }
        }
    }

    public void findShortestPath(Vertex start, Vertex end) {
        PriorityQueue<Vertex> distances = new PriorityQueue<Vertex>();

        for (Vertex v : verteces) {
            v.setDistance(Integer.MAX_VALUE);
        }
        start.setDistance(0);
        distances.add(start);

        while (!distances.isEmpty()) {
            Vertex current = distances.remove();
            current.setNeighborDistances(distances);
        }
        
        System.out.println(end.distance());
    }

    public void printEdgeWeights() {
        for (Edge edge: this.edges) {
            System.out.println(edge.weight());
        }
    }

    public void verifyEdges() {
        int sumEdges = 0;
        for (Vertex vertex: verteces) {
            sumEdges += vertex.edges.size();
        }

        System.out.println("Edge count: " + (this.edges.size() == sumEdges ? "Correct":"Incorrect"));

    }

    public void printDistances() {
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                System.err.printf("%06d ", this.verteces.get(row * columnCount + column).distance());
            }
            System.out.println();
        }
    }
}
