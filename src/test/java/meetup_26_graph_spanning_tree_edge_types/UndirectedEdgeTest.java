package meetup_26_graph_spanning_tree_edge_types;

import junitparams.Parameters;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class UndirectedEdgeTest extends EdgeTest {

    @Override
    protected UndirectedEdge createEdge(int v, int u, EdgeType type) {
        return new UndirectedEdge(v, u, type);
    }

    @Test
    @Parameters({
            "FORWARD_EDGE",
            "CROSS_EDGE"
    })
    public void itShouldNotAllowCreatingUndirectedForwardOrCrossEdge(EdgeType type) {
        thrownException.expect(EdgeException.class);
        thrownException.expectMessage(
                "Cannot create an undirected edge of type " + type);

        createEdge(2, 7, type);
    }

    @Test
    @Parameters(method = "edgesWithSameVerticesDirectionAndType")
    public void edgesShouldBeEqual(UndirectedEdge a, UndirectedEdge b) {
        assertThat(a, is(b));
    }

    @Test
    @Parameters(method = "edgesWithSameVerticesDirectionAndType,"
            + "edgesWithDifferentVerticesDirectionButSameType")
    public void edgesShouldHaveSameHashCode(UndirectedEdge a, UndirectedEdge b) {
        assertThat(a.hashCode(), is(b.hashCode()));
    }

    private Object[][] edgesWithSameVerticesDirectionAndType() {
        return new Object[][]{
                {createEdge(1, 0, EdgeType.TREE_EDGE), createEdge(1, 0, EdgeType.TREE_EDGE)},
                {createEdge(5, 2, EdgeType.BACK_EDGE), createEdge(5, 2, EdgeType.BACK_EDGE)}
        };
    }

    private Object[][] edgesWithDifferentVerticesDirectionButSameType() {
        return new Object[][]{
                {createEdge(1, 0, EdgeType.TREE_EDGE), createEdge(0, 1, EdgeType.TREE_EDGE)},
                {createEdge(5, 2, EdgeType.BACK_EDGE), createEdge(2, 5, EdgeType.BACK_EDGE)}
        };
    }

    @Test
    @Parameters(method = "edgesWithSameVerticesDirectionButDifferentType,"
            + "edgesWithDifferentVerticesButSameType,"
            + "nullEdges")
    public void edgesShouldNotBeEqual(UndirectedEdge a, UndirectedEdge b) {
        assertThat(a, is(not(b)));
    }

    private Object[][] edgesWithSameVerticesDirectionButDifferentType() {
        return new Object[][]{
                {createEdge(1, 0, EdgeType.TREE_EDGE), createEdge(1, 0, EdgeType.BACK_EDGE)},
                {createEdge(5, 2, EdgeType.BACK_EDGE), createEdge(5, 2, EdgeType.TREE_EDGE)}
        };
    }

    private Object[][] edgesWithDifferentVerticesButSameType() {
        return new Object[][]{
                {createEdge(1, 0, EdgeType.TREE_EDGE), createEdge(1, 3, EdgeType.TREE_EDGE)},
                {createEdge(1, 0, EdgeType.TREE_EDGE), createEdge(2, 0, EdgeType.TREE_EDGE)},
                {createEdge(5, 2, EdgeType.BACK_EDGE), createEdge(4, 2, EdgeType.BACK_EDGE)},
                {createEdge(5, 2, EdgeType.BACK_EDGE), createEdge(5, 7, EdgeType.BACK_EDGE)}
        };
    }

    private Object[][] nullEdges() {
        return new Object[][]{
                {createEdge(1, 0, EdgeType.TREE_EDGE), null},
                {null, createEdge(4, 2, EdgeType.BACK_EDGE)}
        };
    }

}
