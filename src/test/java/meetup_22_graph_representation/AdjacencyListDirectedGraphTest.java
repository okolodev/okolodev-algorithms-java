package meetup_22_graph_representation;

public class AdjacencyListDirectedGraphTest extends AbstractDirectedGraphTest {

    @Override
    protected AdjacencyListDirectedGraph createDirectedGraph(int capacity) {
        return new AdjacencyListDirectedGraph(capacity);
    }

}
