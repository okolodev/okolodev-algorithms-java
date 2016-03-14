package meetup_25_graph_cycle_detection;

import meetup_23_celebrity_problem_and_undirected_graph_representation.UndirectedGraph;
import stack1.adt.LinkedStack;
import stack1.adt.Stack;

public class UndirectedGraphCycleDetector {

    public boolean hasCycle(UndirectedGraph graph) {
        boolean[] visited = new boolean[graph.vertices()];
        Stack<Integer> stack = new LinkedStack<>();
        Stack<Integer> parentStack = new LinkedStack<>();

        for (int startVertex = 0; startVertex < graph.vertices(); startVertex++) {
            if (visited[startVertex]) {
                continue;
            }

            stack.push(startVertex);
            parentStack.push(startVertex);

            while (!stack.isEmpty()) {
                int v = stack.pop();
                int parentV = parentStack.pop();

                if (visited[v]) {
                    continue;
                }

                visited[v] = true;

                for (int u : graph.adjacentVerticesTo(v)) {
                    if (visited[u] && parentV != u) {
                        return true;
                    }

                    stack.push(u);
                    parentStack.push(v);
                }
            }
        }

        return false;
    }

}
