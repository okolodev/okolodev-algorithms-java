package meetup_22_graph_representation;

import java.util.Collection;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Adjacency_list">Adjacency list</a>
 */
public class AdjacencyListDirectedGraph implements DirectedGraph {

    public AdjacencyListDirectedGraph(int capacity) {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public void addEdge(int v, int u) {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public void removeEdge(int v, int u) {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public boolean adjacent(int v, int u) {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public int degreeOf(int v) {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public Collection<Integer> adjacentVerticesTo(int v) {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public int vertices() {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public int edges() {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public AdjacencyListDirectedGraph reverse() {
        throw new UnsupportedOperationException("Implement me!");
    }

}
