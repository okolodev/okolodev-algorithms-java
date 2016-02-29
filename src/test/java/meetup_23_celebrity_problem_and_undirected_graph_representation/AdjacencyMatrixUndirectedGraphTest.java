package meetup_23_celebrity_problem_and_undirected_graph_representation;

public class AdjacencyMatrixUndirectedGraphTest extends AbstractUndirectedGraphTest {

    @Override
    protected AdjacencyMatrixUndirectedGraph createUndirectedGraph(int vertices) {
        return new AdjacencyMatrixUndirectedGraph(vertices);
    }

}
