package meetup_27_connected_components_and_strong_components;

import meetup_23_celebrity_problem_and_undirected_graph_representation.UndirectedGraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * Connected component (graph_theory)
 * </p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Connected_component_(graph_theory)">Connected component (graph_theory)</a>
 */
public class ConnectedComponents {
    private final UndirectedGraph graph;
    private final boolean[] visited;
    private final List<Collection<Integer>> components;

    public ConnectedComponents(UndirectedGraph graph) {
        this.graph = graph;
        visited = new boolean[graph.vertices()];
        components = new ArrayList<>();

        dfs();
    }

    private void dfs() {
        for (int startVertex = 0; startVertex < graph.vertices(); startVertex++) {
            if (!visited[startVertex]) {
                components.add(new ArrayList<>());
                dfs(startVertex);
            }
        }
    }

    private void dfs(int vertex) {
        if (visited[vertex]) {
            return;
        }

        visited[vertex] = true;
        Collection<Integer> currentComponent =
                components.get(components.size() - 1);
        currentComponent.add(vertex);

        for (int u : graph.adjacentVerticesTo(vertex)) {
            dfs(u);
        }
    }

    public int componentNumber() {
        return components.size();
    }

    public List<Collection<Integer>> components() {
        // WARNING: Leaking encapsulation.
        return components;
    }

}
