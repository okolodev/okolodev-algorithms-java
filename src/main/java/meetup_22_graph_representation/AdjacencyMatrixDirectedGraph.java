package meetup_22_graph_representation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Adjacency_matrix">Adjacency matrix</a>
 */
public class AdjacencyMatrixDirectedGraph implements DirectedGraph {
    private final boolean[][] matrix;
    private int edges;

    public AdjacencyMatrixDirectedGraph(int capacity) {
        matrix = new boolean[capacity][capacity];
    }

    @Override
    public void addEdge(int v, int u) {
        if (!adjacent(v, u)) {
            matrix[v][u] = true;
            edges++;
        }
    }

    @Override
    public void removeEdge(int v, int u) {
        if (v != u && adjacent(v, u)) {
            matrix[v][u] = false;
            edges--;
        }
    }

    @Override
    public boolean adjacent(int v, int u) {
        return v == u || matrix[v][u];
    }

    @Override
    public int degreeOf(int v) {
        int degree = 0;

        for (boolean adjacent : matrix[v]) {
            if (adjacent) {
                degree++;
            }
        }

        return degree;
    }

    @Override
    public Collection<Integer> adjacentVerticesTo(int v) {
        List<Integer> adjacentVertices = new ArrayList<>();

        for (int u = 0; u < vertices(); u++) {
            if (matrix[v][u]) {
                adjacentVertices.add(u);
            }
        }

        return adjacentVertices;
    }

    @Override
    public int vertices() {
        return matrix.length;
    }

    @Override
    public int edges() {
        return edges;
    }

    @Override
    public AdjacencyMatrixDirectedGraph reverse() {
        AdjacencyMatrixDirectedGraph reversed =
                new AdjacencyMatrixDirectedGraph(vertices());

        for (int v = 0; v < vertices(); v++) {
            for (int u = 0; u < vertices(); u++) {
                if (adjacent(v, u)) {
                    reversed.addEdge(u, v);
                }
            }
        }

        return reversed;
    }

}
