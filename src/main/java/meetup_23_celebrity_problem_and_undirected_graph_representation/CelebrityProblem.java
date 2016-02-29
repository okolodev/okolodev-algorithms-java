package meetup_23_celebrity_problem_and_undirected_graph_representation;

import meetup_22_graph_representation.DirectedGraph;

import java.util.Optional;

/**
 * <p>The Celebrity Problem</p>
 *
 * @see <a href="http://www.geeksforgeeks.org/the-celebrity-problem/">The Celebrity Problem</a>
 */
public class CelebrityProblem {
    private final DirectedGraph people;
    private final int peopleNumber;

    public CelebrityProblem(DirectedGraph people) {
        this.people = people;
        peopleNumber = people.vertices();
    }

    public Optional<Integer> findCelebrity() {
        throw new UnsupportedOperationException("Implement me!");
    }

    private boolean knows(int v, int u) {
        return people.adjacent(v, u);
    }

}
