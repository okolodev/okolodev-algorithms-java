package meetup_22_graph_representation;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.stream.IntStream;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public abstract class AbstractDirectedGraphTest {
    private DirectedGraph digraph = createDirectedGraph(5);

    protected abstract DirectedGraph createDirectedGraph(int capacity);

    @Test
    public void itShouldHaveNoEdgesWhenCreated() {
        DirectedGraph digraph = createDirectedGraph(5);

        assertThat(digraph.edges(), is(0));
    }

    @Test
    @Parameters({
            "0",
            "1",
            "2",
            "3",
            "4",
            "10"
    })
    public void itShouldHaveNumberOfVerticesSpecifiedAsCapacityAtCreationTime(int capacity) {
        DirectedGraph digraph = createDirectedGraph(capacity);

        assertThat(digraph.vertices(), is(capacity));
    }

    @Test
    @Parameters({
            "0",
            "1",
            "2",
            "3",
            "4",
            "10"
    })
    public void eachVertexShouldHaveZeroDegreeWhenCreated(int capacity) {
        DirectedGraph digraph = createDirectedGraph(capacity);

        IntStream.range(0, 0).forEach(v -> assertThat(digraph.degreeOf(v), is(0)));
    }

    @Test
    @Parameters({
            "0",
            "1",
            "2",
            "3",
            "4"
    })
    public void itShouldNotIncreaseDegreeWhenLoopEdgeIsAdded(int v) {
        digraph.addEdge(v, v);

        assertThat(digraph.degreeOf(v), is(0));
    }

    @Test
    @Parameters({
            "0",
            "1",
            "2",
            "3",
            "4"
    })
    public void edgeShouldBeAdjacentToItself(int v) {
        assertThat(digraph.adjacent(v, v), is(true));
    }

    @Test
    @Parameters({
            "0, 1",
            "1, 2",
            "1, 3",
            "2, 3",
            "2, 4",
            "3, 4"
    })
    public void verticesShouldNotBeAdjacentWhenCreated(int v, int u) {
        assertThat(digraph.adjacent(v, u), is(false));
        assertThat(digraph.adjacent(u, v), is(false));
    }

    @Test
    @Parameters({
            "0, 1",
            "1, 2",
            "1, 3",
            "2, 3",
            "2, 4",
            "3, 4"
    })
    public void addedEdgeShouldHaveSingleDirectionOnly(int v, int u) {
        digraph.addEdge(v, u);

        assertThat(digraph.adjacent(v, u), is(true));

        assertThat(digraph.adjacent(u, v), is(false));
    }

    @Test
    @Parameters({
            "0, 1",
            "1, 2",
            "1, 3",
            "2, 3",
            "2, 4",
            "3, 4"
    })
    public void addingEdgeShouldIncreaseDegreeOnlyOnce(int v, int u) {
        digraph.addEdge(v, u);
        digraph.addEdge(v, u);

        assertThat(digraph.degreeOf(v), is(1));
    }

    @Test
    @Parameters({
            "0, 1",
            "1, 2",
            "1, 3",
            "2, 3",
            "2, 4",
            "3, 4"
    })
    public void itShouldRemoveOnlySingleDirectionWhenAddedEdgeIsRemoved(int v, int u) {
        digraph.addEdge(v, u);
        digraph.addEdge(u, v);

        digraph.removeEdge(v, u);

        assertThat(digraph.adjacent(v, u), is(false));

        assertThat(digraph.adjacent(u, v), is(true));
    }

    @Test
    public void itShouldIncreaseNumberOfEdgesWhileAddingDistinctEdges() {
        digraph.addEdge(0, 2);
        assertThat(digraph.edges(), is(1));

        digraph.addEdge(2, 0);
        assertThat(digraph.edges(), is(2));

        digraph.addEdge(1, 4);
        assertThat(digraph.edges(), is(3));

        digraph.addEdge(3, 1);
        assertThat(digraph.edges(), is(4));
    }

    @Test
    public void itShouldNotIncreaseNumberOfEdgesWhileAddingDuplicatingEdges() {
        digraph.addEdge(1, 2);
        assertThat(digraph.edges(), is(1));

        digraph.addEdge(1, 2);
        assertThat(digraph.edges(), is(1));
    }

    @Test
    public void itShouldDecreaseNumberOfEdgesWhileRemovingDistinctEdges() {
        digraph.addEdge(0, 2);
        digraph.addEdge(2, 0);
        digraph.addEdge(1, 4);
        digraph.addEdge(3, 1);

        assertThat(digraph.edges(), is(4));

        digraph.removeEdge(1, 4);
        assertThat(digraph.edges(), is(3));

        digraph.removeEdge(0, 2);
        assertThat(digraph.edges(), is(2));

        digraph.removeEdge(3, 1);
        assertThat(digraph.edges(), is(1));

        digraph.removeEdge(2, 0);
        assertThat(digraph.edges(), is(0));
    }

    @Test
    public void itShouldReverse() {
        digraph.addEdge(0, 3);
        digraph.addEdge(2, 4);
        digraph.addEdge(3, 4);
        digraph.addEdge(2, 1);

        DirectedGraph reversed = digraph.reverse();

        assertThat(reversed.adjacent(0, 3), is(false));
        assertThat(reversed.adjacent(3, 0), is(true));

        assertThat(reversed.adjacent(2, 4), is(false));
        assertThat(reversed.adjacent(4, 2), is(true));

        assertThat(reversed.adjacent(3, 4), is(false));
        assertThat(reversed.adjacent(4, 3), is(true));

        assertThat(reversed.adjacent(2, 1), is(false));
        assertThat(reversed.adjacent(1, 2), is(true));

        assertThat(reversed.edges(), is(reversed.edges()));
    }

    @Test
    @Parameters({
            "0",
            "1",
            "2",
            "3",
            "4",
            "10"
    })
    public void eachVertexShouldHaveEmptyAdjacentVerticesToItWhenCreated(int capacity) {
        DirectedGraph digraph = createDirectedGraph(capacity);

        IntStream.range(0, 0)
                .forEach(v -> assertThat(digraph.adjacentVerticesTo(v), is(emptyIterable())));
    }

    @Test
    public void itShouldReturnVerticesAdjacentToVertex() {
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 4);
        digraph.addEdge(0, 3);
        digraph.addEdge(2, 0);

        assertThat(digraph.adjacentVerticesTo(0), containsInAnyOrder(1, 3, 4));
    }

    @Test
    public void itShouldNotDecreseEdgesNumberWhenRemovesEdgeToInself() {
        digraph.removeEdge(1, 1);

        assertThat(digraph.edges(), is(0));
    }

    @Test
    public void itShouldPreserveNotRemovedEdgesToAdjacentVertices() {
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 2);

        digraph.removeEdge(0, 1);
        assertThat(digraph.adjacentVerticesTo(0), containsInAnyOrder(2));
    }

}
