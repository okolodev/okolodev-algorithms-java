package meetup_25_graph_cycle_detection;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_22_graph_representation.AdjacencyListDirectedGraph;
import meetup_22_graph_representation.AdjacencyMatrixDirectedGraph;
import meetup_22_graph_representation.DirectedGraph;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class DirectedGraphCycleDetectorTest {
    private DirectedGraphCycleDetector cycleDetector;

    @Test
    @Parameters(method = "digraphsWithoutCycle")
    public void itShouldNotDetectCycle(DirectedGraph digraph) {
        cycleDetector = new DirectedGraphCycleDetector(digraph);

        assertThat(cycleDetector.hasCycle(), is(false));
    }

    private Object[][] digraphsWithoutCycle() {
        DirectedGraph emptyGraph = new AdjacencyMatrixDirectedGraph(0);
        DirectedGraph singleGraph = new AdjacencyListDirectedGraph(1);

        DirectedGraph twoGraphA = new AdjacencyMatrixDirectedGraph(2);
        twoGraphA.addEdge(0, 1);

        DirectedGraph twoGraphB = new AdjacencyMatrixDirectedGraph(2);
        twoGraphB.addEdge(1, 0);

        DirectedGraph threeGraphA = new AdjacencyListDirectedGraph(3);
        threeGraphA.addEdge(0, 1);
        threeGraphA.addEdge(0, 2);
        threeGraphA.addEdge(1, 2);

        DirectedGraph threeGraphB = new AdjacencyListDirectedGraph(3);
        threeGraphB.addEdge(0, 1);
        threeGraphB.addEdge(0, 2);
        threeGraphB.addEdge(2, 1);

        DirectedGraph threeGraphC = new AdjacencyListDirectedGraph(3);
        threeGraphC.addEdge(1, 0);
        threeGraphC.addEdge(1, 2);
        threeGraphC.addEdge(2, 0);

        DirectedGraph fourGraph = new AdjacencyMatrixDirectedGraph(4);

        DirectedGraph fiveGraph = new AdjacencyListDirectedGraph(5);
        fiveGraph.addEdge(0, 1);
        fiveGraph.addEdge(0, 2);
        fiveGraph.addEdge(0, 3);
        fiveGraph.addEdge(1, 2);
        fiveGraph.addEdge(1, 4);
        fiveGraph.addEdge(2, 3);
        fiveGraph.addEdge(3, 4);

        return new Object[][]{
                {emptyGraph},
                {singleGraph},

                {twoGraphA},
                {twoGraphB},

                {threeGraphA},
                {threeGraphB},
                {threeGraphC},

                {fourGraph},
                {fiveGraph}
        };
    }

    @Test
    @Parameters(method = "digraphsWithCycles")
    public void itShouldDetectCycle(DirectedGraph digraph) {
        cycleDetector = new DirectedGraphCycleDetector(digraph);

        assertThat(cycleDetector.hasCycle(), is(true));
    }

    private Object[][] digraphsWithCycles() {
        DirectedGraph twoGraph = new AdjacencyMatrixDirectedGraph(2);
        twoGraph.addEdge(0, 1);
        twoGraph.addEdge(1, 0);

        DirectedGraph threeGraph = new AdjacencyListDirectedGraph(3);
        threeGraph.addEdge(0, 1);
        threeGraph.addEdge(1, 2);
        threeGraph.addEdge(2, 0);

        DirectedGraph fourGraph = new AdjacencyMatrixDirectedGraph(4);
        fourGraph.addEdge(0, 1);
        fourGraph.addEdge(0, 3);
        fourGraph.addEdge(1, 2);
        fourGraph.addEdge(2, 0);
        fourGraph.addEdge(2, 3);
        fourGraph.addEdge(3, 1);

        DirectedGraph fiveGraph = new AdjacencyListDirectedGraph(5);
        fiveGraph.addEdge(0, 2);
        fiveGraph.addEdge(2, 4);
        fiveGraph.addEdge(4, 0);

        fiveGraph.addEdge(1, 3);
        fiveGraph.addEdge(3, 4);
        fiveGraph.addEdge(4, 1);

        return new Object[][]{
                {twoGraph},
                {threeGraph},
                {fourGraph},
                {fiveGraph}
        };
    }

}
