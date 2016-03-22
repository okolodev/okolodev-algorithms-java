package meetup_26_graph_spanning_tree_edge_types;

import junitparams.Parameters;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class DirectedEdgeTest extends EdgeTest {

    @Override
    protected DirectedEdge createEdge(int v, int u, EdgeType type) {
        return new DirectedEdge(v, u, type);
    }

    @Test
    @Parameters(method = "allTypes")
    public void itShouldCreateEdgeOfAllTypes(EdgeType type) {
        Edge edge = createEdge(0, 1, type);

        assertThat(edge.getType(), is(type));
    }

    private Collection<Object[]> allTypes() {
        return Arrays.stream(EdgeType.values())
                .map(type -> new Object[]{type})
                .collect(Collectors.toList());
    }

    @Test
    @Parameters(method = "edgesWithSameVerticesDirectionAndType")
    public void edgesShouldBeEqual(DirectedEdge a, DirectedEdge b) {
        assertThat(a, is(b));
    }

    @Test
    @Parameters(method = "edgesWithSameVerticesDirectionAndType")
    public void edgesShouldHaveSameHashCode(DirectedEdge a, DirectedEdge b) {
        assertThat(a.hashCode(), is(b.hashCode()));
    }

    private Object[][] edgesWithSameVerticesDirectionAndType() {
        return new Object[][]{
                {createEdge(1, 0, EdgeType.TREE_EDGE), createEdge(1, 0, EdgeType.TREE_EDGE)},
                {createEdge(5, 2, EdgeType.BACK_EDGE), createEdge(5, 2, EdgeType.BACK_EDGE)},
                {createEdge(3, 0, EdgeType.FORWARD_EDGE), createEdge(3, 0, EdgeType.FORWARD_EDGE)},
                {createEdge(0, 4, EdgeType.CROSS_EDGE), createEdge(0, 4, EdgeType.CROSS_EDGE)}
        };
    }

    @Test
    @Parameters(method = "edgesWithSameVerticesDirectionButDifferentType,"
            + "edgesWithDifferentVerticesDirectionButSameType,"
            + "edgesWithDifferentVerticesButSameType,"
            + "nullEdges")
    public void edgesShouldNotBeEqual(DirectedEdge a, DirectedEdge b) {
        assertThat(a, is(not(b)));
    }

    private Object[][] edgesWithSameVerticesDirectionButDifferentType() {
        return new Object[][]{
                {createEdge(1, 0, EdgeType.TREE_EDGE), createEdge(1, 0, EdgeType.BACK_EDGE)},
                {createEdge(5, 2, EdgeType.FORWARD_EDGE), createEdge(5, 2, EdgeType.TREE_EDGE)},
                {createEdge(3, 0, EdgeType.CROSS_EDGE), createEdge(3, 0, EdgeType.FORWARD_EDGE)},
                {createEdge(0, 4, EdgeType.BACK_EDGE), createEdge(0, 4, EdgeType.CROSS_EDGE)}
        };
    }

    private Object[][] edgesWithDifferentVerticesDirectionButSameType() {
        return new Object[][]{
                {createEdge(1, 0, EdgeType.TREE_EDGE), createEdge(0, 1, EdgeType.TREE_EDGE)},
                {createEdge(5, 2, EdgeType.BACK_EDGE), createEdge(2, 5, EdgeType.BACK_EDGE)},
                {createEdge(3, 0, EdgeType.FORWARD_EDGE), createEdge(0, 3, EdgeType.FORWARD_EDGE)},
                {createEdge(0, 4, EdgeType.CROSS_EDGE), createEdge(4, 0, EdgeType.CROSS_EDGE)}
        };
    }

    private Object[][] edgesWithDifferentVerticesButSameType() {
        return new Object[][]{
                {createEdge(1, 0, EdgeType.TREE_EDGE), createEdge(1, 3, EdgeType.TREE_EDGE)},
                {createEdge(5, 2, EdgeType.BACK_EDGE), createEdge(4, 2, EdgeType.BACK_EDGE)},
                {createEdge(3, 0, EdgeType.FORWARD_EDGE), createEdge(2, 0, EdgeType.FORWARD_EDGE)},
                {createEdge(0, 4, EdgeType.CROSS_EDGE), createEdge(0, 8, EdgeType.CROSS_EDGE)}
        };
    }

    private Object[][] nullEdges() {
        return new Object[][]{
                {createEdge(1, 0, EdgeType.TREE_EDGE), null},
                {null, createEdge(4, 2, EdgeType.BACK_EDGE)}
        };
    }

}
