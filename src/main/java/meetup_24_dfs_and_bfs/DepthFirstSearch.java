package meetup_24_dfs_and_bfs;

import meetup_22_graph_representation.Graph;
import stack1.adt.LinkedStack;
import stack1.adt.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Depth-first search</p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Depth-first_search">Depth-first search</a>
 */
public class DepthFirstSearch {

    public List<Integer> dfs(Graph graph) {
        List<Integer> traversal = new ArrayList<>(graph.vertices());

        if (graph.vertices() == 0) {
            return traversal;
        }

        Stack<Integer> stack = new LinkedStack<>();
        boolean[] visited = new boolean[graph.vertices()];

        for (int root = 0; root < graph.vertices(); root++) {
            if (visited[root]) {
                continue;
            }

            stack.push(root);

            while (!stack.isEmpty()) {
                int v = stack.pop();

                if (visited[v]) {
                    continue;
                }

                traversal.add(v);
                visited[v] = true;

                for (int u : graph.adjacentVerticesTo(v)) {
                    if (!visited[u]) {
                        stack.push(u);
                    }
                }
            }
        }

        return traversal;
    }

}
