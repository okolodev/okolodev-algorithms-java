package meetup_26_graph_spanning_tree_edge_types;

import meetup_22_graph_representation.DirectedGraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DirectedGraphEdgeClassifier {
    private final DirectedGraph digraph;
    private boolean[] visited;
    private final int[] startTime;
    private final int[] finishTime;

    private Collection<DirectedEdge> treeEdges = new ArrayList<>();
    private Collection<DirectedEdge> backEdges = new ArrayList<>();
    private Collection<DirectedEdge> forwardEdges = new ArrayList<>();
    private Collection<DirectedEdge> crossEdges = new ArrayList<>();

    public DirectedGraphEdgeClassifier(DirectedGraph digraph) {
        this.digraph = digraph;
        visited = new boolean[digraph.vertices()];
        startTime = new int[digraph.vertices()];
        finishTime = new int[digraph.vertices()];

        dfs();
    }

    private void dfs() {
        int time = 0;

        for (int startVertex = 0; startVertex < digraph.vertices(); startVertex++) {
            time = dfs(startVertex, time);
        }
    }

    private int dfs(int vertex, int time) {
        if (visited[vertex]) {
            return time;
        }

        visited[vertex] = true;
        startTime[vertex] = ++time;

        for (int u : digraph.adjacentVerticesTo(vertex)) {
            if (visited[u]) {
                if (isBackEdge(vertex, u)) {
                    backEdges.add(new DirectedEdge(vertex, u, EdgeType.BACK_EDGE));
                } else if (isForwardEdge(vertex, u)) {
                    forwardEdges.add(new DirectedEdge(vertex, u, EdgeType.FORWARD_EDGE));
                } else {
                    crossEdges.add(new DirectedEdge(vertex, u, EdgeType.CROSS_EDGE));
                }
            } else {
                treeEdges.add(new DirectedEdge(vertex, u, EdgeType.TREE_EDGE));
                time = dfs(u, time);
            }
        }

        finishTime[vertex] = ++time;

        return time;
    }

    private boolean isBackEdge(int v, int u) {
        return startTime[v] > 0 && finishTime[u] == 0;
    }

    private boolean isForwardEdge(int v, int u) {
        return startTime[v] < startTime[u] && finishTime[u] > 0;
    }

    public Collection<DirectedEdge> getTreeEdges() {
        return Collections.unmodifiableCollection(treeEdges);
    }

    public Collection<DirectedEdge> getBackEdges() {
        return Collections.unmodifiableCollection(backEdges);
    }

    public Collection<DirectedEdge> getForwardEdges() {
        return Collections.unmodifiableCollection(forwardEdges);
    }

    public Collection<DirectedEdge> getCrossEdges() {
        return Collections.unmodifiableCollection(crossEdges);
    }

}

