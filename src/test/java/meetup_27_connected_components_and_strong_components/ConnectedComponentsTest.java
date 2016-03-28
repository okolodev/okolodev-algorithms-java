package meetup_27_connected_components_and_strong_components;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_23_celebrity_problem_and_undirected_graph_representation.AdjacencyListUndirectedGraph;
import meetup_23_celebrity_problem_and_undirected_graph_representation.UndirectedGraph;
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
public class ConnectedComponentsTest {

    @Test
    @Parameters(method = "componentNumber")
    public void itShouldFindConnectedComponentsNumber(
            UndirectedGraph graph, int componentNumber) {
        ConnectedComponents cc = new ConnectedComponents(graph);

        assertThat(cc.componentNumber(), is(componentNumber));
    }

    private Object[][] componentNumber() {
        return new Object[][]{
                {threeDisconnectedGraph(), 3},
                {fiveGraph(), 1},
                {thirteenGraph(), 3}
        };
    }

    @Test
    @Parameters(method = "components")
    public void itShouldFindConnectedComponents(
            UndirectedGraph graph, Integer[][] expectedComponents) {
        ConnectedComponents cc = new ConnectedComponents(graph);

        List<Collection<Integer>> components = cc.components();

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
                {threeDisconnectedGraph(), new Integer[][]{{0}, {1}, {2}}},
                {fiveGraph(), new Integer[][]{{0, 1, 2, 3, 4}}},
                {thirteenGraph(), new Integer[][]{{0, 1, 2, 3, 4, 5, 6}, {7, 8}, {9, 10, 11, 12}}}
        };
    }

    private UndirectedGraph threeDisconnectedGraph() {
        return new AdjacencyListUndirectedGraph(3);
    }

    private UndirectedGraph fiveGraph() {
        UndirectedGraph graph = new AdjacencyListUndirectedGraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 4);
        graph.addEdge(4, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        return graph;
    }

    private UndirectedGraph thirteenGraph() {
        UndirectedGraph graph = new AdjacencyListUndirectedGraph(13);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        graph.addEdge(7, 8);

        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        return graph;
    }

}
