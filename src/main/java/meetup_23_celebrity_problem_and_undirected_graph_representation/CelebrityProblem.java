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
        if (peopleNumber < 2) {
            return Optional.empty();
        }

        int candidate = 0;

        for (int next = 1; next < peopleNumber; next++) {
            if (knows(candidate, next)) {
                candidate = next;
            }
        }

        for (int i = 0; i < peopleNumber; i++) {
            if (i == candidate) {
                continue;
            }

            if (knows(candidate, i) || !knows(i, candidate)) {
                return Optional.empty();
            }
        }

        return Optional.of(candidate);
    }

    private boolean knows(int v, int u) {
        return people.adjacent(v, u);
    }

}
