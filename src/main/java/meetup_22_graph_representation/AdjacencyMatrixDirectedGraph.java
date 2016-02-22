package meetup_22_graph_representation;

import java.util.Collection;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Adjacency_matrix">Adjacency matrix</a>
 */
public class AdjacencyMatrixDirectedGraph implements DirectedGraph {

    public AdjacencyMatrixDirectedGraph(int capacity) {
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
    public AdjacencyMatrixDirectedGraph reverse() {
        throw new UnsupportedOperationException("Implement me!");
    }

}
