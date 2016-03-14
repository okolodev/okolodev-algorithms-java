package meetup_25_graph_cycle_detection;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_23_celebrity_problem_and_undirected_graph_representation.AdjacencyListUndirectedGraph;
import meetup_23_celebrity_problem_and_undirected_graph_representation.AdjacencyMatrixUndirectedGraph;
import meetup_23_celebrity_problem_and_undirected_graph_representation.UndirectedGraph;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class UndirectedGraphCycleDetectorTest {
    private UndirectedGraphCycleDetector cycleDetector
            = new UndirectedGraphCycleDetector();

    @Test
    @Parameters(method = "graphsWithoutCycle")
    public void itShouldNotDetectCycle(UndirectedGraph graph) {
        assertThat(cycleDetector.hasCycle(graph), is(false));
    }

    private Object[][] graphsWithoutCycle() {
        UndirectedGraph emptyGraph = new AdjacencyMatrixUndirectedGraph(0);
        UndirectedGraph singleGraph = new AdjacencyListUndirectedGraph(1);

        UndirectedGraph twoGraph = new AdjacencyMatrixUndirectedGraph(2);
        twoGraph.addEdge(1, 0);

        UndirectedGraph threeGraph = new AdjacencyListUndirectedGraph(3);
        threeGraph.addEdge(0, 1);
        threeGraph.addEdge(0, 2);

        UndirectedGraph fourGraph = new AdjacencyListUndirectedGraph(4);
        fourGraph.addEdge(0, 1);
        fourGraph.addEdge(1, 2);
        fourGraph.addEdge(2, 3);

        UndirectedGraph fiveGraph = new AdjacencyListUndirectedGraph(5);

        return new Object[][]{
                {emptyGraph},
                {singleGraph},
                {twoGraph},
                {threeGraph},
                {fourGraph},
                {fiveGraph}
        };
    }

    @Test
    @Parameters(method = "graphsWithCycles")
    public void itShouldDetectCycle(UndirectedGraph graph) {
        assertThat(cycleDetector.hasCycle(graph), is(true));
    }

    private Object[][] graphsWithCycles() {
        UndirectedGraph threeGraph = new AdjacencyListUndirectedGraph(3);
        threeGraph.addEdge(0, 1);
        threeGraph.addEdge(0, 2);
        threeGraph.addEdge(1, 2);

        UndirectedGraph fourGraph = new AdjacencyMatrixUndirectedGraph(4);
        fourGraph.addEdge(0, 1);
        fourGraph.addEdge(1, 2);
        fourGraph.addEdge(2, 3);
        fourGraph.addEdge(3, 0);

        UndirectedGraph fiveGraph = new AdjacencyListUndirectedGraph(5);
        fiveGraph.addEdge(0, 1);
        fiveGraph.addEdge(1, 2);
        fiveGraph.addEdge(2, 0);

        fiveGraph.addEdge(1, 3);
        fiveGraph.addEdge(3, 4);
        fiveGraph.addEdge(0, 4);

        return new Object[][]{
                {threeGraph},
                {fourGraph},
                {fiveGraph}
        };
    }

}
