package meetup_24_dfs_and_bfs;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_22_graph_representation.AdjacencyListDirectedGraph;
import meetup_22_graph_representation.Graph;
import meetup_23_celebrity_problem_and_undirected_graph_representation.AdjacencyListUndirectedGraph;
import meetup_23_celebrity_problem_and_undirected_graph_representation.AdjacencyMatrixUndirectedGraph;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BreadthFistSearchTest {
    private BreadthFistSearch bfs = new BreadthFistSearch();

    @Test
    public void bfsShouldBeEmptyForEmptyGraph() {
        Graph graph = new AdjacencyListDirectedGraph(0);

        assertThat(bfs.bfs(graph), is(emptyIterable()));
    }

    @Test
    @Parameters({
            "1",
            "2",
            "3",
            "4",
            "5"
    })
    public void bfsShouldTraverseVerticesInStraightOrderForDisjointGraph(int vertices) {
        Graph graph = new AdjacencyMatrixUndirectedGraph(vertices);

        assertThat(bfs.bfs(graph),
                contains(IntStream.range(0, vertices).boxed().toArray()));
    }

    @Test
    @Parameters(method = "directedGraphs,undirectedGraphs")
    public void bfsShouldTravers(Graph graph, List<Integer> traversal) {
        assertThat(bfs.bfs(graph), is(traversal));
    }

    private Object[][] directedGraphs() {
        Graph digraphOfTwo = new AdjacencyListDirectedGraph(2);
        digraphOfTwo.addEdge(1, 0);

        Graph digraphOfThree = new AdjacencyListDirectedGraph(3);
        digraphOfThree.addEdge(0, 2);
        digraphOfThree.addEdge(1, 2);
        digraphOfThree.addEdge(2, 0);

        Graph digraphOfFour = new AdjacencyListDirectedGraph(4);
        digraphOfFour.addEdge(0, 1);
        digraphOfFour.addEdge(0, 3);

        Graph digraphOfSeven = new AdjacencyListDirectedGraph(7);
        digraphOfSeven.addEdge(0, 3);
        digraphOfSeven.addEdge(0, 6);
        digraphOfSeven.addEdge(0, 5);
        digraphOfSeven.addEdge(3, 1);
        digraphOfSeven.addEdge(3, 5);
        digraphOfSeven.addEdge(3, 2);
        digraphOfSeven.addEdge(6, 4);
        digraphOfSeven.addEdge(4, 5);
        digraphOfSeven.addEdge(4, 3);

        return new Object[][]{
                {digraphOfTwo, Arrays.asList(0, 1)},
                {digraphOfThree, Arrays.asList(0, 2, 1)},
                {digraphOfFour, Arrays.asList(0, 1, 3, 2)},
                {digraphOfSeven, Arrays.asList(0, 3, 5, 6, 1, 2, 4)}
        };
    }

    private Object[][] undirectedGraphs() {
        Graph graphOfTwo = new AdjacencyListDirectedGraph(2);
        graphOfTwo.addEdge(1, 0);

        Graph graphOfSeven = new AdjacencyListUndirectedGraph(7);
        graphOfSeven.addEdge(0, 5);
        graphOfSeven.addEdge(5, 3);
        graphOfSeven.addEdge(5, 2);
        graphOfSeven.addEdge(2, 1);
        graphOfSeven.addEdge(2, 6);
        graphOfSeven.addEdge(2, 4);
        graphOfSeven.addEdge(4, 1);
        graphOfSeven.addEdge(4, 6);

        return new Object[][]{
                {graphOfTwo, Arrays.asList(0, 1)},
                {graphOfSeven, Arrays.asList(0, 5, 2, 3, 1, 4, 6)}
        };
    }

}
