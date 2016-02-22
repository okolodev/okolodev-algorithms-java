package meetup_22_graph_representation;

public class AdjacencyMatrixDirectedGraphTest extends AbstractDirectedGraphTest {

    @Override
    protected AdjacencyMatrixDirectedGraph createDirectedGraph(int capacity) {
        return new AdjacencyMatrixDirectedGraph(capacity);
    }

}
