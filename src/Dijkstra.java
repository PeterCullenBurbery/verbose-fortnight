// Dijkstra's Algorithm in Java

import java.util.Arrays;

public class Dijkstra {

    public static void dijkstra(int[][] graph, int source) {
        int count = graph.length;
        System.out.println("There are "+count+" vertices.");
// Create a boolean array to track the visited vertices.
// Initially, all vertices are unvisited, so the default value for all elements is 'false'.
        boolean[] visitedVertex = new boolean[count];
System.out.println("The initial visited vertex array is "+ Arrays.toString(visitedVertex)+".");
// Create an integer array to hold the shortest distance from the source to each vertex.
// The default value is '0', but we'll immediately set all distances to 'Integer.MAX_VALUE' (representing infinity)
// because we haven't found any paths yet.
        int[] distance = new int[count];
        System.out.println("The initial distance array is "+ Arrays.toString(distance)+".");
        for (int index1 = 0; index1 < count; index1++) {
            visitedVertex[index1] = false;
            distance[index1] = Integer.MAX_VALUE;
        }
        System.out.println("The updated distance array is "+ Arrays.toString(distance)+".");
        // Distance of self loop is zero
        distance[source] = 0;
        for (int index1 = 0; index1 < count; index1++) {

            // Update the distance between neighbouring vertex and source vertex
            int updatedDistance = findMinDistance(distance, visitedVertex);
            visitedVertex[updatedDistance] = true;

            // Update all the neighbouring vertex distances
            for (int vertex = 0; vertex < count; vertex++) {
                if (!visitedVertex[vertex] && graph[updatedDistance][vertex] != 0 && (distance[updatedDistance] + graph[updatedDistance][vertex] < distance[vertex])) {
                    distance[vertex] = distance[updatedDistance] + graph[updatedDistance][vertex];
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.printf("Distance from %s to %s is %s%n", source, i, distance[i]);
        }

    }

    // Finding the minimum distance
    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int index1 = 0; index1 < distance.length; index1++) {
            if (!visitedVertex[index1] && distance[index1] < minDistance) {
                minDistance = distance[index1];
                minDistanceVertex = index1;
            }
        }
        return minDistanceVertex;
    }

    public static void main(String[] args) {
        int[][] graph1 = new int[][] { { 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 2, 0, 0, 3, 0 }, { 1, 2, 0, 1, 3, 0, 0 },
                { 2, 0, 1, 0, 0, 0, 1 }, { 0, 0, 3, 0, 0, 2, 0 }, { 0, 3, 0, 0, 2, 0, 1 }, { 0, 0, 0, 1, 0, 1, 0 } };
        dijkstra(graph1, 0);
        int[][] graph2 = new int[][] {{0, 4, 2, 0, 0, 0}, {4, 0, 4, 0, 0, 0}, {2, 4, 0, 3, 1, 6}, {0, 0, 3,
                0, 0, 2}, {0, 0, 1, 0, 0, 3}, {0, 0, 6, 2, 3, 0}};
        dijkstra(graph2, 1);
    }
}