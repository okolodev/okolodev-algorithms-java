package meetup_25_graph_cycle_detection;

import meetup_22_graph_representation.DirectedGraph;

public class DirectedGraphCycleDetector {
    private static final byte WHITE = 0;
    private static final byte GREY = 1;
    private static final byte BLACK = 2;

    private final DirectedGraph digraph;
    private final byte[] colors;

    private boolean hasCycle;

    public DirectedGraphCycleDetector(DirectedGraph digraph) {
        this.digraph = digraph;
        colors = new byte[digraph.vertices()];

        dfs();
    }

    private void dfs() {
        for (int starVertex = 0; starVertex < digraph.vertices(); starVertex++) {
            dfs(starVertex);
        }
    }

    private void dfs(int vertex) {
        if (hasCycle || colors[vertex] != WHITE) {
            return;
        }

        colors[vertex] = GREY;

        for (int u : digraph.adjacentVerticesTo(vertex)) {
            if (colors[u] == GREY) {
                hasCycle = true;
                return;
            }

            if (colors[u] == WHITE) {
                dfs(u);
            }
        }

        colors[vertex] = BLACK;
    }

    public boolean hasCycle() {
        return hasCycle;
    }


}
