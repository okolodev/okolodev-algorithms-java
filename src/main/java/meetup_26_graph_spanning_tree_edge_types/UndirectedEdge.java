package meetup_26_graph_spanning_tree_edge_types;

import java.util.Objects;

public class UndirectedEdge implements Edge {
    private final int v;
    private final int u;
    private final EdgeType type;

    public UndirectedEdge(int v, int u, EdgeType type) {
        checkVertices(v, u);
        checkType(type);

        this.v = v;
        this.u = u;
        this.type = type;
    }

    private void checkVertices(int v, int u) {
        if (v < 0 || u < 0) {
            throw new EdgeException(
                    "Edge cannot come from or point to a negative vertex: v=" + v + ", u=" + u);
        }

        if (v == u) {
            throw new EdgeException("Edge cannot come from and point to the same vertex");
        }
    }

    private void checkType(EdgeType type) {
        if (type == null) {
            throw new EdgeException("Null edge type is not allowed");
        }

        if (type != EdgeType.TREE_EDGE && type != EdgeType.BACK_EDGE) {
            throw new EdgeException("Cannot create an undirected edge of type " + type);
        }
    }

    @Override
    public EdgeType getType() {
        return type;
    }

    @Override
    public int getV() {
        return v;
    }

    @Override
    public int getU() {
        return u;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UndirectedEdge)) {
            return false;
        }

        UndirectedEdge other = (UndirectedEdge) o;

        return ((v == other.v && u == other.u) || (v == other.u && u == other.v))
                && type == other.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v + u, v * u, type);
    }

    @Override
    public String toString() {
        return String.format("{%d, %d, %s}", v, u, type);
    }

}
