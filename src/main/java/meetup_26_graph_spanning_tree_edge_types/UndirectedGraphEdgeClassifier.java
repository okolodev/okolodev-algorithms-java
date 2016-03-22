package meetup_26_graph_spanning_tree_edge_types;

import meetup_23_celebrity_problem_and_undirected_graph_representation.UndirectedGraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class UndirectedGraphEdgeClassifier {
    private final UndirectedGraph graph;
    private final boolean[] visited;
    private final Collection<UndirectedEdge> treeEdges = new ArrayList<>();
    private final Collection<UndirectedEdge> backEdges = new HashSet<>();

    public UndirectedGraphEdgeClassifier(UndirectedGraph graph) {
        this.graph = graph;
        visited = new boolean[graph.vertices()];

        dfs();
    }

    private void dfs() {
        for (int startVertex = 0; startVertex < graph.vertices(); startVertex++) {
            dfs(startVertex, startVertex);
        }
    }

    private void dfs(int vertex, int parent) {
        if (visited[vertex]) {
            return;
        }

        visited[vertex] = true;

        for (int u : graph.adjacentVerticesTo(vertex)) {
            if (!visited[u]) {
                treeEdges.add(new UndirectedEdge(vertex, u, EdgeType.TREE_EDGE));
                dfs(u, vertex);
            } else if (u != parent) {
                backEdges.add(new UndirectedEdge(vertex, u, EdgeType.BACK_EDGE));
            }
        }
    }

    public Collection<UndirectedEdge> getTreeEdges() {
        return Collections.unmodifiableCollection(treeEdges);
    }

    public Collection<UndirectedEdge> getBackEdges() {
        return Collections.unmodifiableCollection(backEdges);
    }

}

