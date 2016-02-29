package meetup_23_celebrity_problem_and_undirected_graph_representation;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_22_graph_representation.AdjacencyListDirectedGraph;
import meetup_22_graph_representation.AdjacencyMatrixDirectedGraph;
import meetup_22_graph_representation.DirectedGraph;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CelebrityProblemTest {

    @Test
    @Parameters(method = "graphWithCelebrity")
    public void itShouldFindCelebrity(DirectedGraph people, int celebrity) {
        CelebrityProblem celebrityFinder = new CelebrityProblem(people);

        Optional<Integer> foundCelebrity = celebrityFinder.findCelebrity();

        assertThat(foundCelebrity.isPresent(), is(true));
        assertThat(foundCelebrity.get(), is(celebrity));
    }

    @Test
    @Parameters(method = "graphWithoutCelebrity")
    public void itShouldNotFindCelebrity(DirectedGraph people) {
        CelebrityProblem celebrityFinder = new CelebrityProblem(people);

        Optional<Integer> foundCelebrity = celebrityFinder.findCelebrity();

        assertThat(foundCelebrity.isPresent(), is(false));
    }

    private Object[][] graphWithCelebrity() {
        DirectedGraph twoGraphA = new AdjacencyListDirectedGraph(2);
        twoGraphA.addEdge(1, 0);

        DirectedGraph twoGraphB = new AdjacencyMatrixDirectedGraph(2);
        twoGraphB.addEdge(0, 1);


        DirectedGraph threeGraphA = new AdjacencyMatrixDirectedGraph(3);
        threeGraphA.addEdge(1, 0);
        threeGraphA.addEdge(2, 0);
        threeGraphA.addEdge(1, 2);

        DirectedGraph threeGraphB = new AdjacencyListDirectedGraph(3);
        threeGraphB.addEdge(2, 1);
        threeGraphB.addEdge(2, 0);
        threeGraphB.addEdge(0, 1);

        DirectedGraph threeGraphC = new AdjacencyMatrixDirectedGraph(3);
        threeGraphC.addEdge(0, 1);
        threeGraphC.addEdge(1, 0);
        threeGraphC.addEdge(0, 2);
        threeGraphC.addEdge(1, 2);

        DirectedGraph fourGraph = new AdjacencyListDirectedGraph(4);
        fourGraph.addEdge(0, 1);
        fourGraph.addEdge(0, 2);
        fourGraph.addEdge(2, 1);
        fourGraph.addEdge(2, 3);
        fourGraph.addEdge(3, 0);
        fourGraph.addEdge(3, 1);

        DirectedGraph fiveGraph = new AdjacencyMatrixDirectedGraph(5);
        fiveGraph.addEdge(0, 3);
        fiveGraph.addEdge(0, 1);
        fiveGraph.addEdge(0, 4);
        fiveGraph.addEdge(1, 3);
        fiveGraph.addEdge(1, 4);
        fiveGraph.addEdge(2, 1);
        fiveGraph.addEdge(2, 3);
        fiveGraph.addEdge(4, 0);
        fiveGraph.addEdge(4, 1);
        fiveGraph.addEdge(4, 2);
        fiveGraph.addEdge(4, 3);

        return new Object[][]{
                {twoGraphA, 0},
                {twoGraphB, 1},

                {threeGraphA, 0},
                {threeGraphB, 1},
                {threeGraphC, 2},

                {fourGraph, 1},

                {fiveGraph, 3}
        };
    }

    private Object[][] graphWithoutCelebrity() {
        DirectedGraph zeroGraph = new AdjacencyMatrixDirectedGraph(0);

        DirectedGraph oneGraph = new AdjacencyMatrixDirectedGraph(1);

        DirectedGraph twoGraphA = new AdjacencyMatrixDirectedGraph(2);

        DirectedGraph twoGraphB = new AdjacencyMatrixDirectedGraph(2);
        twoGraphB.addEdge(0, 1);
        twoGraphB.addEdge(1, 0);

        DirectedGraph threeGraphA = new AdjacencyMatrixDirectedGraph(3);

        DirectedGraph threeGraphB = new AdjacencyMatrixDirectedGraph(3);
        threeGraphB.addEdge(1, 0);
        threeGraphB.addEdge(0, 2);

        DirectedGraph threeGraphC = new AdjacencyListDirectedGraph(3);
        threeGraphC.addEdge(2, 1);
        threeGraphC.addEdge(2, 0);
        threeGraphC.addEdge(0, 1);
        threeGraphC.addEdge(1, 0);

        DirectedGraph threeGraphD = new AdjacencyMatrixDirectedGraph(3);
        threeGraphD.addEdge(0, 1);
        threeGraphD.addEdge(1, 0);
        threeGraphD.addEdge(0, 2);
        threeGraphD.addEdge(1, 2);
        threeGraphD.addEdge(2, 0);

        DirectedGraph fourGraph = new AdjacencyMatrixDirectedGraph(4);
        fourGraph.addEdge(0, 1);
        fourGraph.addEdge(0, 2);
        fourGraph.addEdge(2, 1);
        fourGraph.addEdge(2, 3);
        fourGraph.addEdge(3, 0);
        fourGraph.addEdge(3, 1);
        fourGraph.addEdge(1, 0);

        DirectedGraph fiveGraph = new AdjacencyListDirectedGraph(5);
        fiveGraph.addEdge(0, 3);
        fiveGraph.addEdge(0, 1);
        fiveGraph.addEdge(0, 4);
        fiveGraph.addEdge(1, 3);
        fiveGraph.addEdge(1, 4);
        fiveGraph.addEdge(2, 1);
        fiveGraph.addEdge(2, 3);
        fiveGraph.addEdge(4, 0);
        fiveGraph.addEdge(4, 1);
        fiveGraph.addEdge(4, 2);
        fiveGraph.addEdge(4, 3);
        fiveGraph.addEdge(3, 4);

        DirectedGraph sixGraph = new AdjacencyMatrixDirectedGraph(6);
        sixGraph.addEdge(0, 1);
        sixGraph.addEdge(1, 2);
        sixGraph.addEdge(2, 3);
        sixGraph.addEdge(3, 4);
        sixGraph.addEdge(4, 5);

        return new Object[][]{
                {zeroGraph},

                {oneGraph},

                {twoGraphA},
                {twoGraphB},

                {threeGraphA},
                {threeGraphB},
                {threeGraphC},
                {threeGraphD},

                {fourGraph},

                {fiveGraph},

                {sixGraph}
        };
    }

}
