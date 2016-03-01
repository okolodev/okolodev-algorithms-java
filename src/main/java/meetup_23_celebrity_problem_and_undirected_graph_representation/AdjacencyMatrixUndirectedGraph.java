package meetup_23_celebrity_problem_and_undirected_graph_representation;

import meetup_22_graph_representation.AdjacencyMatrixDirectedGraph;
import meetup_22_graph_representation.DirectedGraph;

import java.util.Collection;

public class AdjacencyMatrixUndirectedGraph implements UndirectedGraph {
    private final DirectedGraph digraph;

    public AdjacencyMatrixUndirectedGraph(int vertices) {
        digraph = new AdjacencyMatrixDirectedGraph(vertices);
    }

    @Override
    public void addEdge(int v, int u) {
        digraph.addEdge(v, u);
        digraph.addEdge(u, v);
    }

    @Override
    public void removeEdge(int v, int u) {
        digraph.removeEdge(v, u);
        digraph.removeEdge(u, v);
    }

    @Override
    public boolean adjacent(int v, int u) {
        return digraph.adjacent(v, u);
    }

    @Override
    public int degreeOf(int v) {
        return digraph.degreeOf(v);
    }

    @Override
    public Collection<Integer> adjacentVerticesTo(int v) {
        return digraph.adjacentVerticesTo(v);
    }

    @Override
    public int vertices() {
        return digraph.vertices();
    }

    @Override
    public int edges() {
        return digraph.edges() / 2;
    }

}
