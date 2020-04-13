package src;

/**
 * GraphT module using predictSalary's algorithm shortest path algorithm of SALARIES will be used with the to 
 * determine the sectors that have similar salaries where the nodes will be sector and paths between 
 * nodes will be the AVERAGE salary difference
 */

import java.util.*;

public class GraphT {
    private static final Graph.Salaries[] GRAPH = {
    };
    private static final String START = "a";
    private static final String END = "e";

    /**
     * STARTS THE GRAPH ABOVE
     */
    public static void main(String[] args) {
        Graph g = new Graph(GRAPH);
        g.predictSalary(START);
        g.printPath(END);
    }
}

class Graph {
    // mapping of vertex names to Vertex objects, built from a set of Salaries
    private final Map<String, Vertex> graph;

    /**
     * One Salaries of the graph
     */
    public static class Salaries {
        public final String v1, v2;
        public final int dist;

        public Salaries(String v1, String v2, int dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }
    }

    /**
     * One vertex of the graph, complete with mappings using a Hash Table to neighbouring vertices
     */
    public static class Vertex implements Comparable<Vertex> {
        public final String name;
        // MAX_VALUE assumed to be infinity
        public int dist = Integer.MAX_VALUE;
        public Vertex previous = null;
        public final Map<Vertex, Integer> neighbours = new HashMap<>();

        public Vertex(String name) {
            this.name = name;
        }

        /**
        * Method that prints path from the source the currently made paths
        */
        private void printPath() {
            if (this == this.previous) {
                System.out.printf("%s", this.name);
            } else if (this.previous == null) {
                System.out.printf("%s(unreached)", this.name);
            } else {
                this.previous.printPath();
                System.out.printf(" -> %s(%d)", this.name, this.dist);
            }
        }
        
        /**
        * Simple compareTo function for checking statement
        */
        public int compareTo(Vertex other) {
            if (dist == other.dist)
                return name.compareTo(other.name);

            return Integer.compare(dist, other.dist);
        }

        @Override
        public String toString() {
            return "(" + name + ", " + dist + ")";
        }
    }

    /**
     * Creates graph from a set of Salaries
     */
    public Graph(Salaries[] Salaries) {
        graph = new HashMap<>(Salaries.length);

        // one pass to find all vertices
        for (Salaries e : Salaries) {
            if (!graph.containsKey(e.v1)) graph.put(e.v1, new Vertex(e.v1));
            if (!graph.containsKey(e.v2)) graph.put(e.v2, new Vertex(e.v2));
        }

        // set the adjacent vertices with extra path
        for (Salaries e : Salaries) {
            graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
            // graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist); // also do this for an undirected graph
        }
    }

    /**
     * Prints a path from the source to the specified vertex
     */
    public void printPath(String endName) {
        if (!graph.containsKey(endName)) {
            System.err.printf("Graph doesn't contain end vertex \"%s\"\n", endName);
            return;
        }

        graph.get(endName).printPath();
        System.out.println();
    }

    /**
     * Implementation of predictSalary's algorithm using a binary heap data structure
     */
    private void predictSalary(final NavigableSet<Vertex> q) {
        Vertex u, v;
        while (!q.isEmpty()) {
            // vertex with shortest distance (first iteration will return source)
            u = q.pollFirst();
            if (u.dist == Integer.MAX_VALUE)
                break; // ignore u since it is unreachable

            // look at distances to each adjacent vertex
            for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
                v = a.getKey(); // the neighbour in this iteration

                final int alternateDist = u.dist + a.getValue();
                if (alternateDist < v.dist) { // shorter path to adjacent vertex found
                    q.remove(v);
                    v.dist = alternateDist;
                    v.previous = u;
                    q.add(v);
                }
            }
        }
    }

    /**
     * Runs predictSalary's algorithm using a specified source vertex
     */
    public void predictSalary(String startName) {
        if (!graph.containsKey(startName)) {
            System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startName);
            return;
        }
        final Vertex source = graph.get(startName);
        NavigableSet<Vertex> q = new TreeSet<>();

        // set-up vertices
        for (Vertex v : graph.values()) {
            v.previous = v == source ? source : null;
            v.dist = v == source ? 0 : Integer.MAX_VALUE;
            q.add(v);
        }

        predictSalary(q);
    }

    /**
     * Prints the path from the source to every vertex
     */
    public void printAllPaths() {
        for (Vertex v : graph.values()) {
            v.printPath();
            System.out.println();
        }
    }
}