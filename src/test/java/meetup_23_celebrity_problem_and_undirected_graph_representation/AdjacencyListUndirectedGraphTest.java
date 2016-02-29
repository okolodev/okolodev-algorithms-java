package meetup_23_celebrity_problem_and_undirected_graph_representation;

public class AdjacencyListUndirectedGraphTest extends AbstractUndirectedGraphTest {

    @Override
    protected AdjacencyListUndirectedGraph createUndirectedGraph(int vertices) {
        return new AdjacencyListUndirectedGraph(vertices);
    }

}
