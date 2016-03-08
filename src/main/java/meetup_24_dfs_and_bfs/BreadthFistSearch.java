package meetup_24_dfs_and_bfs;

import meetup_05_stack_and_queue.adt.LinkedQueue;
import meetup_05_stack_and_queue.adt.Queue;
import meetup_22_graph_representation.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Breadth-first search</p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Breadth-first_search">Breadth-first search</a>
 */
public class BreadthFistSearch {

    public List<Integer> bfs(Graph graph) {
        List<Integer> traversal = new ArrayList<>(graph.vertices());

        if (graph.vertices() == 0) {
            return traversal;
        }

        Queue<Integer> queue = new LinkedQueue<>();
        boolean[] visited = new boolean[graph.vertices()];

        for (int root = 0; root < graph.vertices(); root++) {
            if (visited[root]) {
                continue;
            }

            queue.enqueue(root);
            traversal.add(root);
            visited[root] = true;

            while (!queue.isEmpty()) {
                int v = queue.dequeue();

                for (int u : graph.adjacentVerticesTo(v)) {
                    if (!visited[u]) {
                        queue.enqueue(u);
                        traversal.add(u);
                        visited[u] = true;
                    }
                }
            }
        }

        return traversal;
    }

}
