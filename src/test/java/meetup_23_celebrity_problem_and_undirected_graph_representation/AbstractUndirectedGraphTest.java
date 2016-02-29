package meetup_23_celebrity_problem_and_undirected_graph_representation;

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
public abstract class AbstractUndirectedGraphTest {
    private UndirectedGraph graph = createUndirectedGraph(5);

    protected abstract UndirectedGraph createUndirectedGraph(int vertices);

    @Test
    public void itShouldHaveNoEdgesWhenCreated() {
        UndirectedGraph graph = createUndirectedGraph(5);

        assertThat(graph.edges(), is(0));
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
    public void itShouldHaveNumberOfVerticesSpecifiedAsCapacityAtCreationTime(int vertices) {
        UndirectedGraph graph = createUndirectedGraph(vertices);

        assertThat(graph.vertices(), is(vertices));
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
        UndirectedGraph graph = createUndirectedGraph(capacity);

        IntStream.range(0, 0).forEach(v -> assertThat(graph.degreeOf(v), is(0)));
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
        graph.addEdge(v, v);

        assertThat(graph.degreeOf(v), is(0));
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
        assertThat(graph.adjacent(v, v), is(true));
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
        assertThat(graph.adjacent(v, u), is(false));
        assertThat(graph.adjacent(u, v), is(false));
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
    public void addedEdgeShouldHaveBothDirectionOnly(int v, int u) {
        graph.addEdge(v, u);

        assertThat(graph.adjacent(v, u), is(true));
        assertThat(graph.adjacent(u, v), is(true));
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
        graph.addEdge(v, u);
        graph.addEdge(v, u);
        graph.addEdge(u, v);
        graph.addEdge(u, v);

        assertThat(graph.degreeOf(v), is(1));
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
    public void itShouldRemoveOnlyBothDirectionWhenAddedEdgeIsRemoved(int v, int u) {
        graph.addEdge(v, u);

        graph.removeEdge(u, v);

        assertThat(graph.adjacent(v, u), is(false));
        assertThat(graph.adjacent(u, v), is(false));
    }

    @Test
    public void itShouldIncreaseNumberOfEdgesWhileAddingDistinctEdges() {
        graph.addEdge(0, 2);
        assertThat(graph.edges(), is(1));

        graph.addEdge(1, 4);
        assertThat(graph.edges(), is(2));

        graph.addEdge(3, 1);
        assertThat(graph.edges(), is(3));
    }

    @Test
    public void itShouldNotIncreaseNumberOfEdgesWhileAddingDuplicatingEdges() {
        graph.addEdge(1, 2);
        assertThat(graph.edges(), is(1));

        graph.addEdge(1, 2);
        assertThat(graph.edges(), is(1));

        graph.addEdge(2, 1);
        assertThat(graph.edges(), is(1));

        graph.addEdge(2, 1);
        assertThat(graph.edges(), is(1));
    }

    @Test
    public void itShouldDecreaseNumberOfEdgesWhileRemovingDistinctEdges() {
        graph.addEdge(0, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 1);

        assertThat(graph.edges(), is(3));

        graph.removeEdge(1, 4);
        assertThat(graph.edges(), is(2));

        graph.removeEdge(0, 2);
        assertThat(graph.edges(), is(1));

        graph.removeEdge(3, 1);
        assertThat(graph.edges(), is(0));
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
    public void eachVertexShouldHaveEmptyAdjacentVerticesToItWhenCreated(int vertices) {
        UndirectedGraph graph = createUndirectedGraph(vertices);

        IntStream.range(0, 0)
                .forEach(v -> assertThat(graph.adjacentVerticesTo(v), is(emptyIterable())));
    }

    @Test
    public void itShouldReturnVerticesAdjacentToVertex() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 3);
        graph.addEdge(2, 0);

        assertThat(graph.adjacentVerticesTo(0), containsInAnyOrder(1, 3, 4, 2));
    }

    @Test
    public void itShouldNotDecreseEdgesNumberWhenRemovesEdgeToInself() {
        graph.removeEdge(1, 1);

        assertThat(graph.edges(), is(0));
    }

    @Test
    public void itShouldPreserveNotRemovedEdgesToAdjacentVertices() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);

        graph.removeEdge(0, 1);
        assertThat(graph.adjacentVerticesTo(0), containsInAnyOrder(2));
    }


}
