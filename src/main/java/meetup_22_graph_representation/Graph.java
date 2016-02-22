package meetup_22_graph_representation;

import java.util.Collection;

/**
 * <p>Graph</p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Graph_(discrete_mathematics)">Graph</a>
 */
public interface Graph {

    /**
     * Add an edge from the vertex <code>v</code> to the vertex <code>u</code>.
     *
     * @param v vertex
     * @param u vertex
     */
    void addEdge(int v, int u);

    /**
     * Remove an edge from the vertex <code>v</code> to the vertex <code>u</code>.
     *
     * @param v vertex
     * @param u vertex
     */
    void removeEdge(int v, int u);

    /**
     * Check if the vertex <code>v</code> is adjacent to the vertex <code>u</code>.
     *
     * @param v vertex
     * @param u vertex
     * @return <code>true</code> if adjacent, <code>false</code> otherwise.
     */
    boolean adjacent(int v, int u);

    /**
     * Number of vertices adjacent to the vertex <code>v</code>.
     *
     * @param v vertex
     * @return number of vertices adjacent to the vertex <code>v</code>.
     */
    int degreeOf(int v);

    /**
     * Collection of vertices adjacent to the vertex <code>v</code>.
     *
     * @param v vertex
     * @return a collection of vertices adjacent to the vertex <code>v</code>.
     */
    Collection<Integer> adjacentVerticesTo(int v);

    /**
     * Number of vertices.
     *
     * @return number of vertices.
     */
    int vertices();

    /**
     * Number of edges.
     *
     * @return number of edges.
     */
    int edges();

}
