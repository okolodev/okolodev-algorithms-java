package meetup_27_connected_components_and_strong_components;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_22_graph_representation.AdjacencyListDirectedGraph;
import meetup_22_graph_representation.AdjacencyMatrixDirectedGraph;
import meetup_22_graph_representation.DirectedGraph;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class StronglyConnectedComponentsTest {

    @Test
    @Parameters(method = "componentNumber")
    public void itShouldFindStronglyConnectedComponentsNumber(
            DirectedGraph digraph, int componentNumber) {
        StronglyConnectedComponents scc =
                new StronglyConnectedComponents(digraph);
        assertThat(scc.componentNumber(), is(componentNumber));
    }

    private Object[][] componentNumber() {
        return new Object[][]{
                {threeDigraph(), 1},
                {fourDisconnectedDigraph(), 4},
                {wikipediaEightDigraph(), 3},
                {thirteenDigraph(), 5}
        };
    }

    @Test
    @Parameters(method = "components")
    public void itShouldFindStronglyConnectedComponents(
            DirectedGraph digraph, Integer[][] expectedComponents) {
        StronglyConnectedComponents scc =
                new StronglyConnectedComponents(digraph);

        List<Collection<Integer>> components = scc.components();

        IntConsumer assertion = i -> {
            Integer[] expectedComponent = expectedComponents[i];
            Collection<Integer> actualComponent = components.get(i);
            String message = String.format("Expected %d-th %s but was %s",
                    i, Arrays.toString(expectedComponent), actualComponent);

            assertThat(message, actualComponent, containsInAnyOrder(expectedComponent));
        };

        IntStream.range(0, expectedComponents.length).forEach(assertion);
    }

    private Object[][] components() {
        return new Object[][]{
                {threeDigraph(), new Integer[][]{{0, 1, 2}}},
                {fourDisconnectedDigraph(), new Integer[][]{{3}, {2}, {1}, {0}}},
                {wikipediaEightDigraph(), new Integer[][]{{5, 6}, {2, 3, 7}, {0, 1, 4}}},
                {thirteenDigraph(), new Integer[][]{{1}, {0, 2, 3, 4, 5}, {9, 10, 11, 12}, {6, 8}, {7}}}
        };
    }

    private DirectedGraph threeDigraph() {
        DirectedGraph eightDigraph =
                new AdjacencyListDirectedGraph(3);

        eightDigraph.addEdge(0, 1);
        eightDigraph.addEdge(1, 2);
        eightDigraph.addEdge(2, 0);

        return eightDigraph;
    }

    private DirectedGraph fourDisconnectedDigraph() {
        return new AdjacencyListDirectedGraph(4);
    }

    private DirectedGraph wikipediaEightDigraph() {
        DirectedGraph wikipediaEightDigraph =
                new AdjacencyMatrixDirectedGraph(8);

        wikipediaEightDigraph.addEdge(0, 1);
        wikipediaEightDigraph.addEdge(1, 2);
        wikipediaEightDigraph.addEdge(1, 4);
        wikipediaEightDigraph.addEdge(1, 5);
        wikipediaEightDigraph.addEdge(2, 3);
        wikipediaEightDigraph.addEdge(2, 6);
        wikipediaEightDigraph.addEdge(3, 2);
        wikipediaEightDigraph.addEdge(3, 7);
        wikipediaEightDigraph.addEdge(4, 0);
        wikipediaEightDigraph.addEdge(4, 5);
        wikipediaEightDigraph.addEdge(5, 6);
        wikipediaEightDigraph.addEdge(6, 5);
        wikipediaEightDigraph.addEdge(7, 3);
        wikipediaEightDigraph.addEdge(7, 6);

        return wikipediaEightDigraph;
    }

    private DirectedGraph thirteenDigraph() {
        DirectedGraph thirteenDigraph =
                new AdjacencyListDirectedGraph(13);

        thirteenDigraph.addEdge(0, 1);
        thirteenDigraph.addEdge(0, 5);
        thirteenDigraph.addEdge(2, 0);
        thirteenDigraph.addEdge(2, 3);
        thirteenDigraph.addEdge(3, 2);
        thirteenDigraph.addEdge(3, 5);
        thirteenDigraph.addEdge(4, 2);
        thirteenDigraph.addEdge(4, 3);
        thirteenDigraph.addEdge(5, 4);
        thirteenDigraph.addEdge(6, 0);
        thirteenDigraph.addEdge(6, 4);
        thirteenDigraph.addEdge(6, 8);
        thirteenDigraph.addEdge(6, 9);
        thirteenDigraph.addEdge(7, 6);
        thirteenDigraph.addEdge(7, 9);
        thirteenDigraph.addEdge(8, 6);
        thirteenDigraph.addEdge(9, 10);
        thirteenDigraph.addEdge(9, 11);
        thirteenDigraph.addEdge(10, 12);
        thirteenDigraph.addEdge(11, 4);
        thirteenDigraph.addEdge(11, 12);
        thirteenDigraph.addEdge(12, 9);

        return thirteenDigraph;
    }

}
