package meetup_28_topological_sort;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_22_graph_representation.AdjacencyListDirectedGraph;
import meetup_22_graph_representation.AdjacencyMatrixDirectedGraph;
import meetup_22_graph_representation.DirectedGraph;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class JobScheduleBuilderTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    @Parameters(method = "acyclicDigraphs")
    public void itShouldBuildScheduler(DirectedGraph digraph,
                                       List<Integer> schedules) {
        JobScheduleBuilder builder = new JobScheduleBuilder(digraph);

        assertThat(builder.getSchedule(), is(schedules));
    }

    private Object[][] acyclicDigraphs() {
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

        DirectedGraph fourGraphA = new AdjacencyMatrixDirectedGraph(4);

        DirectedGraph fourGraphB = new AdjacencyMatrixDirectedGraph(4);
        fourGraphB.addEdge(0, 1);
        fourGraphB.addEdge(2, 3);

        DirectedGraph fiveGraphA = new AdjacencyListDirectedGraph(5);
        fiveGraphA.addEdge(0, 1);
        fiveGraphA.addEdge(0, 3);
        fiveGraphA.addEdge(0, 4);
        fiveGraphA.addEdge(1, 2);
        fiveGraphA.addEdge(1, 3);
        fiveGraphA.addEdge(2, 3);
        fiveGraphA.addEdge(4, 1);
        fiveGraphA.addEdge(4, 2);

        return new Object[][]{
                {emptyGraph, asList()},
                {singleGraph, asList(0)},

                {twoGraphA, asList(1, 0)},
                {twoGraphB, asList(0, 1)},

                {threeGraphA, asList(2, 1, 0)},
                {threeGraphB, asList(1, 2, 0)},
                {threeGraphC, asList(0, 2, 1)},

                {fourGraphA, asList(0, 1, 2, 3)},
                {fourGraphB, asList(1, 0, 3, 2)},

                {fiveGraphA, asList(3, 2, 1, 4, 0)}
        };
    }

    @Test
    @Parameters(method = "cyclicDigraphs")
    public void itShouldComplainOnCycles(DirectedGraph digraph) {
        expectedException.expect(CycleDetectedException.class);
        expectedException.expectMessage("A cycle was detected!");

        new JobScheduleBuilder(digraph);
    }

    private Object[][] cyclicDigraphs() {
        DirectedGraph twoGraph = new AdjacencyListDirectedGraph(2);
        twoGraph.addEdge(0, 1);
        twoGraph.addEdge(1, 0);

        DirectedGraph threeGraph = new AdjacencyListDirectedGraph(3);
        threeGraph.addEdge(2, 1);
        threeGraph.addEdge(1, 0);
        threeGraph.addEdge(1, 2);

        DirectedGraph fourGraph = new AdjacencyListDirectedGraph(4);
        fourGraph.addEdge(0, 1);
        fourGraph.addEdge(1, 2);
        fourGraph.addEdge(2, 3);
        fourGraph.addEdge(3, 0);

        return new Object[][]{
                {twoGraph},
                {threeGraph},
                {fourGraph}
        };
    }

}
