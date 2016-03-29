package meetup_27_connected_components_and_strong_components;

import meetup_22_graph_representation.DirectedGraph;
import stack1.adt.LinkedStack;
import stack1.adt.Stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * Strongly connected component
 * </p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Strongly_connected_component">Strongly connected component</a>
 */
public class StronglyConnectedComponents {
    private final DirectedGraph digraph;
    private final boolean[] visited;
    private final List<Collection<Integer>> strongComponents;

    private final boolean[] postOrderVisited;

    public StronglyConnectedComponents(DirectedGraph digraph) {
        this.digraph = digraph;
        visited = new boolean[digraph.vertices()];
        strongComponents = new ArrayList<>();

        postOrderVisited = new boolean[digraph.vertices()];

        Stack<Integer> postOrder = dfsPostOrder(digraph.reverse());

        while (!postOrder.isEmpty()) {
            int startVertex = postOrder.pop();

            if (!visited[startVertex]) {
                strongComponents.add(new ArrayList<>());
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
                strongComponents.get(strongComponents.size() - 1);
        currentComponent.add(vertex);

        for (int u : digraph.adjacentVerticesTo(vertex)) {
            dfs(u);
        }
    }

    private Stack<Integer> dfsPostOrder(DirectedGraph reversed) {
        Stack<Integer> postOrder = new LinkedStack<>();

        for (int startVertex = 0; startVertex < reversed.vertices(); startVertex++) {
            dfsPostOrder(reversed, startVertex, postOrder);
        }

        return postOrder;
    }

    private void dfsPostOrder(DirectedGraph reversed,
                              int vertex,
                              Stack<Integer> postOrder) {
        if (postOrderVisited[vertex]) {
            return;
        }

        postOrderVisited[vertex] = true;

        for (int u : reversed.adjacentVerticesTo(vertex)) {
            dfsPostOrder(reversed, u, postOrder);
        }

        postOrder.push(vertex);
    }

    public int componentNumber() {
        return strongComponents.size();
    }

    public List<Collection<Integer>> components() {
        // WARNING: Leaking encapsulation
        return strongComponents;
    }

}
