package meetup_26_graph_spanning_tree_edge_types;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmytro Chyzhykov.
 */
@RunWith(JUnitParamsRunner.class)
public abstract class EdgeTest {
    @Rule
    public ExpectedException thrownException = ExpectedException.none();

    protected abstract Edge createEdge(int v, int u, EdgeType type);

    @Test
    public void itShouldNotAllowToCreateEdgeWithNullType() {
        thrownException.expect(EdgeException.class);
        thrownException.expectMessage("Null edge type is not allowed");

        createEdge(0, 1, null);
    }

    @Test
    @Parameters({
            "0, 0",
            "1, 1",
            "2, 2"
    })
    public void itShouldNotAllowCreatingEdgeWithTheSameVAndUVertices(int v, int u) {
        thrownException.expect(EdgeException.class);
        thrownException.expectMessage("Edge cannot come from and point to the same vertex");

        createEdge(v, u, EdgeType.TREE_EDGE);
    }

    @Test
    @Parameters({
            "-1, 0",
            "1, -2",
            "-4, 7",
            "5, -9",
            "-3, -2"
    })
    public void itShouldNotAllowCreatingEdgeWithNegativeVorUVertices(int v, int u) {
        thrownException.expect(EdgeException.class);
        thrownException.expectMessage(
                "Edge cannot come from or point to a negative vertex: v=" + v + ", u=" + u);

        createEdge(v, u, EdgeType.BACK_EDGE);
    }

    @Test
    @Parameters({
            "0, 1, TREE_EDGE",
            "1, 0, TREE_EDGE",
            "3, 7, TREE_EDGE",

            "2, 5, BACK_EDGE",
            "5, 2, BACK_EDGE",
            "0, 9, BACK_EDGE"
    })
    public void itShouldAllowCreatingTreeAndBackEdgeWithNonNegativeDistinctVertices(
            int v, int u, EdgeType type
    ) {
        Edge edge = createEdge(v, u, type);

        assertThat("unexpected v vertex", edge.getV(), is(v));
        assertThat("unexpected u vertex", edge.getU(), is(u));
        assertThat("unexpected type", edge.getType(), is(type));
    }

}
