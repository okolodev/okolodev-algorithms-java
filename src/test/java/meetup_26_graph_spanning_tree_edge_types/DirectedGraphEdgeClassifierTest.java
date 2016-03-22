package meetup_26_graph_spanning_tree_edge_types;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_22_graph_representation.AdjacencyListDirectedGraph;
import meetup_22_graph_representation.AdjacencyMatrixDirectedGraph;
import meetup_22_graph_representation.DirectedGraph;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class DirectedGraphEdgeClassifierTest {

    @Test
    @Parameters(method = "data")
    public void itShouldClassifyTreeEdges(DirectedGraph graph,
                                          DirectedEdge[] treeEdges,
                                          DirectedEdge[] ignoredBackEdges,
                                          DirectedEdge[] ignoredForwardEdges,
                                          DirectedEdge[] ignoredCrossEdges) {
        DirectedGraphEdgeClassifier classifier = new DirectedGraphEdgeClassifier(graph);

        assertThat(classifier.getTreeEdges(), containsInAnyOrder(treeEdges));
    }

    @Test
    @Parameters(method = "data")
    public void itShouldClassifyBackEdges(DirectedGraph graph,
                                          DirectedEdge[] ignoredTreeEdges,
                                          DirectedEdge[] backEdges,
                                          DirectedEdge[] ignoredForwardEdges,
                                          DirectedEdge[] ignoredCrossEdges) {
        DirectedGraphEdgeClassifier classifier = new DirectedGraphEdgeClassifier(graph);

        assertThat(classifier.getBackEdges(), hasSize(backEdges.length));
        assertThat(classifier.getBackEdges(), containsInAnyOrder(backEdges));
    }

    @Test
    @Parameters(method = "data")
    public void itShouldClassifyForwardEdges(DirectedGraph graph,
                                             DirectedEdge[] ignoredTreeEdges,
                                             DirectedEdge[] ignoredBackEdges,
                                             DirectedEdge[] forwardEdges,
                                             DirectedEdge[] ignoredCrossEdges) {
        DirectedGraphEdgeClassifier classifier = new DirectedGraphEdgeClassifier(graph);

        assertThat(classifier.getForwardEdges(), hasSize(forwardEdges.length));
        assertThat(classifier.getForwardEdges(), containsInAnyOrder(forwardEdges));
    }

    @Test
    @Parameters(method = "data")
    public void itShouldClassifyCrossEdges(DirectedGraph graph,
                                           DirectedEdge[] ignoredTreeEdges,
                                           DirectedEdge[] ignoredBackEdges,
                                           DirectedEdge[] ignoredForwardEdges,
                                           DirectedEdge[] crossEdges) {
        DirectedGraphEdgeClassifier classifier = new DirectedGraphEdgeClassifier(graph);

        assertThat(classifier.getCrossEdges(), hasSize(crossEdges.length));
        assertThat(classifier.getCrossEdges(), containsInAnyOrder(crossEdges));
    }

    @Test
    @Parameters(method = "data")
    public void itShouldVerifyTotalSumOfClassifiedEdges(DirectedGraph graph,
                                                        DirectedEdge[] ignoredTreeEdges,
                                                        DirectedEdge[] ignoredBackEdges,
                                                        DirectedEdge[] ignoredForwardEdges,
                                                        DirectedEdge[] ignoredCrossEdges) {
        DirectedGraphEdgeClassifier classifier = new DirectedGraphEdgeClassifier(graph);

        assertThat(classifier.getTreeEdges().size() + classifier.getBackEdges().size()
                + classifier.getForwardEdges().size() + classifier.getCrossEdges().size(), is(graph.edges()));
    }

    @Test
    @Parameters(method = "data")
    public void treeEdgesShouldBeOfTypeTreeEdge(DirectedGraph graph,
                                                DirectedEdge[] ignoredTreeEdges,
                                                DirectedEdge[] ignoredBackEdges,
                                                DirectedEdge[] ignoredForwardEdges,
                                                DirectedEdge[] ignoredCrossEdges) {
        DirectedGraphEdgeClassifier classifier = new DirectedGraphEdgeClassifier(graph);

        classifier.getTreeEdges()
                .forEach(edge -> assertThat(edge.getType(), is(EdgeType.TREE_EDGE)));
    }

    @Test
    @Parameters(method = "data")
    public void backEdgesShouldBeOfTypeBackEdge(DirectedGraph graph,
                                                DirectedEdge[] ignoredTreeEdges,
                                                DirectedEdge[] ignoredBackEdges,
                                                DirectedEdge[] ignoredForwardEdges,
                                                DirectedEdge[] ignoredCrossEdges) {
        DirectedGraphEdgeClassifier classifier = new DirectedGraphEdgeClassifier(graph);

        classifier.getBackEdges()
                .forEach(edge -> assertThat(edge.getType(), is(EdgeType.BACK_EDGE)));
    }

    @Test
    @Parameters(method = "data")
    public void forwardEdgesShouldBeOfTypeForwardEdge(DirectedGraph graph,
                                                      DirectedEdge[] ignoredTreeEdges,
                                                      DirectedEdge[] ignoredBackEdges,
                                                      DirectedEdge[] ignoredForwardEdges,
                                                      DirectedEdge[] ignoredCrossEdges) {
        DirectedGraphEdgeClassifier classifier = new DirectedGraphEdgeClassifier(graph);

        classifier.getForwardEdges()
                .forEach(edge -> assertThat(edge.getType(), is(EdgeType.FORWARD_EDGE)));
    }

    @Test
    @Parameters(method = "data")
    public void crossEdgesShouldBeOfTypeCrossEdge(DirectedGraph graph,
                                                  DirectedEdge[] ignoredTreeEdges,
                                                  DirectedEdge[] ignoredBackEdges,
                                                  DirectedEdge[] ignoredForwardEdges,
                                                  DirectedEdge[] ignoredCrossEdges) {
        DirectedGraphEdgeClassifier classifier = new DirectedGraphEdgeClassifier(graph);

        classifier.getCrossEdges()
                .forEach(edge -> assertThat(edge.getType(), is(EdgeType.CROSS_EDGE)));
    }

    private Object[][] data() {
        DirectedGraph emptyDigraph = new AdjacencyMatrixDirectedGraph(0);

        DirectedGraph singleDigraph = new AdjacencyListDirectedGraph(1);

        DirectedGraph cyclicFourDigraph = new AdjacencyMatrixDirectedGraph(5);
        cyclicFourDigraph.addEdge(0, 1);
        cyclicFourDigraph.addEdge(0, 4);
        cyclicFourDigraph.addEdge(1, 2);
        cyclicFourDigraph.addEdge(1, 3);
        cyclicFourDigraph.addEdge(2, 3);
        cyclicFourDigraph.addEdge(3, 0);
        cyclicFourDigraph.addEdge(4, 3);

        DirectedGraph cyclicNineDigraph = new AdjacencyListDirectedGraph(9);
        cyclicNineDigraph.addEdge(1, 2);
        cyclicNineDigraph.addEdge(1, 5);
        cyclicNineDigraph.addEdge(1, 8);
        cyclicNineDigraph.addEdge(2, 3);
        cyclicNineDigraph.addEdge(3, 4);
        cyclicNineDigraph.addEdge(4, 2);
        cyclicNineDigraph.addEdge(5, 6);
        cyclicNineDigraph.addEdge(6, 3);
        cyclicNineDigraph.addEdge(6, 7);
        cyclicNineDigraph.addEdge(6, 8);

        return new Object[][]{
                {emptyDigraph,
                        new DirectedEdge[]{},
                        new DirectedEdge[]{},
                        new DirectedEdge[]{},
                        new DirectedEdge[]{}},
                {singleDigraph,
                        new DirectedEdge[]{},
                        new DirectedEdge[]{},
                        new DirectedEdge[]{},
                        new DirectedEdge[]{}},

                {cyclicFourDigraph,
                        new DirectedEdge[]{treeEdge(0, 1), treeEdge(1, 2), treeEdge(2, 3), treeEdge(0, 4)},
                        new DirectedEdge[]{backEdge(3, 0)},
                        new DirectedEdge[]{forwardEdge(1, 3)},
                        new DirectedEdge[]{crossEdge(4, 3)}},
                {cyclicNineDigraph,
                        new DirectedEdge[]{treeEdge(1, 2), treeEdge(2, 3), treeEdge(3, 4), treeEdge(1, 5), treeEdge(5, 6), treeEdge(6, 7), treeEdge(6, 8)},
                        new DirectedEdge[]{backEdge(4, 2)},
                        new DirectedEdge[]{forwardEdge(1, 8)},
                        new DirectedEdge[]{crossEdge(6, 3)}}
        };
    }

    private DirectedEdge treeEdge(int v, int u) {
        return new DirectedEdge(v, u, EdgeType.TREE_EDGE);
    }

    private DirectedEdge backEdge(int v, int u) {
        return new DirectedEdge(v, u, EdgeType.BACK_EDGE);
    }

    private DirectedEdge forwardEdge(int v, int u) {
        return new DirectedEdge(v, u, EdgeType.FORWARD_EDGE);
    }

    private DirectedEdge crossEdge(int v, int u) {
        return new DirectedEdge(v, u, EdgeType.CROSS_EDGE);
    }

}
