package meetup_28_topological_sort;

import meetup_22_graph_representation.DirectedGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * Topological sorting
 * </p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Topological_sorting">Topological sorting</a>
 */
public class JobScheduleBuilder {
    private static final byte WHITE = 0;
    private static final byte GREY = 1;
    private static final byte BLACK = 2;

    private final DirectedGraph digraph;
    private final ArrayList<Integer> schedule;
    private final byte[] colours;

    public JobScheduleBuilder(DirectedGraph digraph) {
        this.digraph = digraph;
        schedule = new ArrayList<>();
        colours = new byte[digraph.vertices()];

        dfs();
    }

    private void dfs() {
        for (int vertex = 0; vertex < digraph.vertices(); vertex++) {
            dfs(vertex);
        }
    }

    private void dfs(int vertex) {
        if (colours[vertex] == BLACK) {
            return;
        }

        colours[vertex] = GREY;

        for (int u : digraph.adjacentVerticesTo(vertex)) {
            if (colours[u] == GREY) {
                throw new CycleDetectedException("A cycle was detected!");
            }

            if (colours[u] == WHITE) {
                dfs(u);
            }
        }

        schedule.add(vertex);
        colours[vertex] = BLACK;
    }

    public List<Integer> getSchedule() {
        return Collections.unmodifiableList(schedule);
    }

}

