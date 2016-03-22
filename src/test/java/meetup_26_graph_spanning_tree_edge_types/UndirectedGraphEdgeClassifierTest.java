package meetup_26_graph_spanning_tree_edge_types;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_23_celebrity_problem_and_undirected_graph_representation.AdjacencyListUndirectedGraph;
import meetup_23_celebrity_problem_and_undirected_graph_representation.AdjacencyMatrixUndirectedGraph;
import meetup_23_celebrity_problem_and_undirected_graph_representation.UndirectedGraph;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class UndirectedGraphEdgeClassifierTest {

    @Test
    @Parameters(method = "data")
    public void itShouldClassifyTreeEdges(UndirectedGraph graph,
                                          UndirectedEdge[] treeEdges,
                                          UndirectedEdge[] ignoredBackEdges) {
        UndirectedGraphEdgeClassifier classifier = new UndirectedGraphEdgeClassifier(graph);

        assertThat(classifier.getTreeEdges(), hasSize(treeEdges.length));
        assertThat(classifier.getTreeEdges(), containsInAnyOrder(treeEdges));
    }

    @Test
    @Parameters(method = "data")
    public void itShouldClassifyBackEdges(UndirectedGraph graph,
                                          UndirectedEdge[] ignoredTreeEdges,
                                          UndirectedEdge[] backEdges) {
        UndirectedGraphEdgeClassifier classifier = new UndirectedGraphEdgeClassifier(graph);

        assertThat(String.valueOf(classifier.getBackEdges()), classifier.getBackEdges(), hasSize(backEdges.length));
        assertThat(classifier.getBackEdges(), containsInAnyOrder(backEdges));
    }

    @Test
    @Parameters(method = "data")
    public void itShouldVerifyTotalSumOfClassifiedEdges(UndirectedGraph graph,
                                                        UndirectedEdge[] ignoredTreeEdges,
                                                        UndirectedEdge[] ignoredBackEdges) {
        UndirectedGraphEdgeClassifier classifier = new UndirectedGraphEdgeClassifier(graph);

        assertThat(classifier.getTreeEdges().size() + classifier.getBackEdges().size(), is(graph.edges()));
    }

    @Test
    @Parameters(method = "data")
    public void treeEdgesShouldBeOfTypeTreeEdge(UndirectedGraph graph,
                                                UndirectedEdge[] ignoredTreeEdges,
                                                UndirectedEdge[] ignoredBackEdges) {
        UndirectedGraphEdgeClassifier classifier = new UndirectedGraphEdgeClassifier(graph);

        classifier.getTreeEdges()
                .forEach(edge -> assertThat(edge.getType(), is(EdgeType.TREE_EDGE)));
    }

    @Test
    @Parameters(method = "data")
    public void backEdgesShouldBeOfTypeBackEdge(UndirectedGraph graph,
                                                UndirectedEdge[] ignoredTreeEdges,
                                                UndirectedEdge[] ignoredBackEdges) {
        UndirectedGraphEdgeClassifier classifier = new UndirectedGraphEdgeClassifier(graph);

        classifier.getBackEdges()
                .forEach(edge -> assertThat(edge.getType(), is(EdgeType.BACK_EDGE)));
    }

    private Object[][] data() {
        UndirectedGraph emptyGraph = new AdjacencyMatrixUndirectedGraph(0);

        UndirectedGraph singleGraph = new AdjacencyListUndirectedGraph(1);

        UndirectedGraph twoGraph = new AdjacencyListUndirectedGraph(2);
        twoGraph.addEdge(0, 1);

        UndirectedGraph acyclicFourGraph = new AdjacencyListUndirectedGraph(4);
        acyclicFourGraph.addEdge(0, 1);
        acyclicFourGraph.addEdge(1, 2);
        acyclicFourGraph.addEdge(2, 3);

        UndirectedGraph cyclicFourGraph = new AdjacencyMatrixUndirectedGraph(4);
        cyclicFourGraph.addEdge(0, 1);
        cyclicFourGraph.addEdge(1, 2);
        cyclicFourGraph.addEdge(2, 3);
        cyclicFourGraph.addEdge(3, 0);

        UndirectedGraph cyclicFiveGraph = new AdjacencyListUndirectedGraph(5);
        cyclicFiveGraph.addEdge(0, 1);
        cyclicFiveGraph.addEdge(1, 2);
        cyclicFiveGraph.addEdge(2, 0);

        cyclicFiveGraph.addEdge(1, 3);
        cyclicFiveGraph.addEdge(3, 4);
        cyclicFiveGraph.addEdge(2, 4);

        return new Object[][]{
                {emptyGraph,
                        new UndirectedEdge[]{},
                        new UndirectedEdge[]{}},
                {singleGraph,
                        new UndirectedEdge[]{},
                        new UndirectedEdge[]{}},
                {twoGraph,
                        new UndirectedEdge[]{treeEdge(0, 1)},
                        new UndirectedEdge[]{}},
                {acyclicFourGraph,
                        new UndirectedEdge[]{treeEdge(0, 1), treeEdge(1, 2), treeEdge(2, 3)},
                        new UndirectedEdge[]{}},

                {cyclicFourGraph,
                        new UndirectedEdge[]{treeEdge(0, 1), treeEdge(1, 2), treeEdge(2, 3)},
                        new UndirectedEdge[]{backEdge(3, 0)}},
                {cyclicFiveGraph,
                        new UndirectedEdge[]{treeEdge(0, 1), treeEdge(1, 2), treeEdge(2, 4), treeEdge(3, 4)},
                        new UndirectedEdge[]{backEdge(2, 0), backEdge(1, 3)}}
        };
    }

    private UndirectedEdge treeEdge(int v, int u) {
        return new UndirectedEdge(v, u, EdgeType.TREE_EDGE);
    }

    private UndirectedEdge backEdge(int v, int u) {
        return new UndirectedEdge(v, u, EdgeType.BACK_EDGE);
    }

}
