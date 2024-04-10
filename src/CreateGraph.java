// Bellman Ford Algorithm in Java

import java.util.Arrays;

class CreateGraph {

    // CreateGraph - it consists of edges
    static class CreateEdge {
        int start, destination, weight;

        CreateEdge() {
            start = destination = weight = 0;
        }
    }

    int vertices, edges;
    CreateEdge[] edge;

    // Creates a graph with V vertices and E edges
    CreateGraph(int verticesInput, int edgesInput) {
        vertices = verticesInput;
        edges = edgesInput;
        edge = new CreateEdge[edgesInput];
        for (int index1 = 0; index1 < edgesInput; ++index1)
            edge[index1] = new CreateEdge();
    }

    void BellmanFord(CreateGraph graph) {
        int vertices = graph.vertices, E = graph.edges;
        int[] distances = new int[vertices];

        // Step 1: fill the distance array and predecessor array
        Arrays.fill(distances, Integer.MAX_VALUE);

        // Mark the source vertex
        distances[0] = 0;

        // Step 2: relax edges |V| - 1 times
        for (int index1 = 1; index1 < vertices; ++index1) {
            for (int index2 = 0; index2 < E; ++index2) {
                // Get the edge data
                int u = graph.edge[index2].start;
                int v = graph.edge[index2].destination;
                int w = graph.edge[index2].weight;
                if (distances[u] != Integer.MAX_VALUE && distances[u] + w < distances[v])
                    distances[v] = distances[u] + w;
            }
        }

        // Step 3: detect negative cycle
        // if value changes then we have a negative cycle in the graph,
        // and we cannot find the shortest distances
        for (int index2 = 0; index2 < E; ++index2) {
            int u = graph.edge[index2].start;
            int v = graph.edge[index2].destination;
            int w = graph.edge[index2].weight;

            if (distances[u] != Integer.MAX_VALUE && distances[u] + w < distances[v]) {
                System.out.println("The graph contains a negative cycle with start vertex " + u + " and destination vertex " + v + " and weight " + w + ". Edge "+index2+" is part of this negative cycle.");
                return;
            }
        }

        // No negative w cycle found!
        // Print the distance and predecessor array
        printSolution(distances, vertices);
    }

    // Print the solution
    void printSolution(int[] distances, int verticesVariable) {
        System.out.println("Vertex Distance from Source");
        for (int index1 = 0; index1 < verticesVariable; ++index1)
            System.out.println(index1 + "\t\t" + distances[index1]);
    }

    public static void main(String[] args) {
        int vertices = 5; // Total vertices
        int edges = 8; // Total Edges

        CreateGraph graph = new CreateGraph(vertices, edges);

        // edge from vertex 0 to vertex 1 with weight 5
        graph.edge[0].start = 0;
        graph.edge[0].destination = 1;
        graph.edge[0].weight = 5;

        // edge 0 --> 2
        graph.edge[1].start = 0;
        graph.edge[1].destination = 2;
        graph.edge[1].weight = 4;

        // edge 1 --> 3
        graph.edge[2].start = 1;
        graph.edge[2].destination = 3;
        graph.edge[2].weight = 3;

        // edge 2 --> 1
        graph.edge[3].start = 2;
        graph.edge[3].destination = 1;
        graph.edge[3].weight = 6;

        // edge 3 --> 2
        graph.edge[4].start = 3;
        graph.edge[4].destination = 2;
        graph.edge[4].weight = 2;

        graph.BellmanFord(graph); // 0 is the source vertex

        /*This is based on the example on Programiz.*/
        int vertices1 = 5; // Total vertices
        int edges1 = 9; // Total Edges

        CreateGraph graph1 = new CreateGraph(vertices1, edges1);

        // edge 0 --> 1
        graph1.edge[0].start = 0;
        graph1.edge[0].destination = 1;
        graph1.edge[0].weight = 4;
        // edge 0 --> 2
        graph1.edge[1].start = 0;
        graph1.edge[1].destination = 2;
        graph1.edge[1].weight = 2;
        // edge 1 --> 3
        graph1.edge[2].start = 1;
        graph1.edge[2].destination = 3;
        graph1.edge[2].weight = 2;
        // edge 2 --> 4
        graph1.edge[3].start = 2;
        graph1.edge[3].destination = 4;
        graph1.edge[3].weight = 5;
        // edge 2 --> 1
        graph1.edge[4].start = 2;
        graph1.edge[4].destination = 1;
        graph1.edge[4].weight = 1;

        // edge 1 to 3 with weight 2
        graph1.edge[5].start = 1;
        graph1.edge[5].destination = 3;
        graph1.edge[5].weight = 2;
        // edge 1 to 4 with weight 3
        graph1.edge[6].start = 1;
        graph1.edge[6].destination = 4;
        graph1.edge[6].weight = 3;
        // edge 2 --> 3
        graph1.edge[7].start = 2;
        graph1.edge[7].destination = 3;
        graph1.edge[7].weight = 4;
        /*This is the edge with the negative edge weight.*/
        // edge from 4 to 3
        graph1.edge[8].start = 4;
        graph1.edge[8].destination = 3;
        graph1.edge[8].weight = -5;
        graph1.BellmanFord(graph1); // 0 is the source vertex








        /*This is based on the example on Programiz. I am adding a negative cycle.*/
        int vertices2 = 6; // Total vertices
        int edges2 = 11; // Total Edges

        CreateGraph graph2 = new CreateGraph(vertices2, edges2);

        // edge 0 --> 1
        graph2.edge[0].start = 0;
        graph2.edge[0].destination = 1;
        graph2.edge[0].weight = 4;
        // edge 0 --> 2
        graph2.edge[1].start = 0;
        graph2.edge[1].destination = 2;
        graph2.edge[1].weight = 2;
        // edge 1 --> 3
        graph2.edge[2].start = 1;
        graph2.edge[2].destination = 3;
        graph2.edge[2].weight = 2;
        // edge 2 --> 4
        graph2.edge[3].start = 2;
        graph2.edge[3].destination = 4;
        graph2.edge[3].weight = 5;
        // edge 2 --> 1
        graph2.edge[4].start = 2;
        graph2.edge[4].destination = 1;
        graph2.edge[4].weight = 1;

        // edge 1 to 3 with weight 2
        graph2.edge[5].start = 1;
        graph2.edge[5].destination = 3;
        graph2.edge[5].weight = 2;
        // edge 1 to 4 with weight 3
        graph2.edge[6].start = 1;
        graph2.edge[6].destination = 4;
        graph2.edge[6].weight = 3;
        // edge 2 --> 3
        graph2.edge[7].start = 2;
        graph2.edge[7].destination = 3;
        graph2.edge[7].weight = 4;
        /*This is the edge with the negative edge weight.*/
        // edge from 4 to 3
        graph2.edge[8].start = 4;
        graph2.edge[8].destination = 3;
        graph2.edge[8].weight = -5;

        // edge 3--> 5
        graph2.edge[9].start = 3;
        graph2.edge[9].destination = 5;
        graph2.edge[9].weight = -4;
        // edge 5 --> 4
        graph2.edge[10].start = 5;
        graph2.edge[10].destination = 4;
        graph2.edge[10].weight = -10;
        graph2.BellmanFord(graph2); // 0 is the source vertex

    }
}