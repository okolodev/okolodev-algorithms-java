package meetup_22_graph_representation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Adjacency_list">Adjacency list</a>
 */
public class AdjacencyListDirectedGraph implements DirectedGraph {
    private final int vertices;
    private final Map<Integer, Set<Integer>> adjacencyList;

    private int edges;

    public AdjacencyListDirectedGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new HashMap<>();
    }

    @Override
    public void addEdge(int v, int u) {
        if (v == u) {
            return;
        }
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new TreeSet<>());
        }

        Set<Integer> vSet = adjacencyList.get(v);

        if (vSet.add(u)) {
            edges++;
        }
    }

    @Override
    public void removeEdge(int v, int u) {
        if (!adjacencyList.containsKey(v)) {
            return;
        }

        Set<Integer> vSet = adjacencyList.get(v);

        if (vSet.remove(u)) {
            edges--;

            if (vSet.isEmpty()) {
                adjacencyList.remove(v);
            }
        }
    }

    @Override
    public boolean adjacent(int v, int u) {
        Set<Integer> emptySet = Collections.emptySet();

        return v == u || adjacencyList.getOrDefault(v, emptySet).contains(u);
    }

    @Override
    public int degreeOf(int v) {
        Set<Integer> emptySet = Collections.emptySet();

        return adjacencyList.getOrDefault(v, emptySet).size();
    }

    @Override
    public Collection<Integer> adjacentVerticesTo(int v) {
        Set<Integer> emptySet = Collections.emptySet();
        Set<Integer> adjacentVertices = adjacencyList.getOrDefault(v, emptySet);

        return Collections.unmodifiableCollection(adjacentVertices);
    }

    @Override
    public int vertices() {
        return vertices;
    }

    @Override
    public int edges() {
        return edges;
    }

    @Override
    public AdjacencyListDirectedGraph reverse() {
        AdjacencyListDirectedGraph reversed =
                new AdjacencyListDirectedGraph(vertices);

        for (Entry<Integer, Set<Integer>> e : adjacencyList.entrySet()) {
            Integer v = e.getKey();
            for (Integer u : e.getValue()) {
                reversed.addEdge(u, v);
            }
        }

        return reversed;
    }

}
